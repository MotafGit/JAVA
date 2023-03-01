/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Java.ConfigDetalhesExteriores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Houdini
 */
public class DAO_detalhesExt implements Map<Integer, ConfigDetalhesExteriores>{

    Connection conn;
    
    @Override
    public int size() {
        int size = -1;
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT COUNT(*) FROM configuracaoExt WHERE ref = 20");
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                size = rs.getInt(1);
            }
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connector.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size()== 0;
    }

    @Override
    public boolean containsKey(Object key) throws NullPointerException{
        boolean r = false;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT id_configuraExt FROM configuracaoExt WHERE id_configuraExt= ? and ref = 20");
            stm.setInt(1, (Integer) key);
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        } finally {
            Connector.close(conn);
        }
        return r;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean r = false;
        
        if(value.getClass().getName().equals("DSS2122.Java.ConfigDetalhesExteriores")){
            ConfigDetalhesExteriores d = (ConfigDetalhesExteriores)value;
            int id = d.getId_configuraExt();
            ConfigDetalhesExteriores dp = this.get(id);
            if(dp.getId_configuraExt() == id && dp.isTipo()){
                r=true;
            }
        }
        return r;
    }

    
    @Override
    public ConfigDetalhesExteriores get(Object key) {
        ConfigDetalhesExteriores d = null;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM configuracaoExt WHERE id_configuraExt=? and ref = 20");
            stm.setInt(1, (Integer)key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                 d = new ConfigDetalhesExteriores (rs.getFloat("custo"), rs.getString("tectodeAbrir"), rs.getString("vidrosEscurecidos"), rs.getString("paraChoques"),rs.getInt("ref"), rs.getInt("id_configuraExt"),  rs.getBoolean("tipo"), rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        } finally {
            try{
                Connector.close(conn);
            }catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return d;
    }
    
    

    @Override
    public ConfigDetalhesExteriores remove(Object key) {
        ConfigDetalhesExteriores d = this.get(key);
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM configuracaoExt WHERE id_configuraExt = ? and ref = 20");
            stm.setInt(1,(Integer) key);
            stm.executeUpdate();
        } catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connector.close(conn);
            } catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return d;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends ConfigDetalhesExteriores> dp) {
        for(ConfigDetalhesExteriores d: dp.values()){
            if(d.isTipo())
                put(d.getId_configuraExt(), d);
        }
    }

    @Override
    public void clear() {
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM configuracaoExt WHERE ref = 20");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        } finally {
            try{
                Connector.close(conn);
            }catch(Exception e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> s = null;
        
        try{
            conn = Connector.connectDB();
            s = new HashSet<>();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM configuracaoExt WHERE ref = 20");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                s.add(rs.getInt("id_configuraExt"));
            }
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }finally{
                try{
                    Connector.close(conn);
                }catch(Exception e){
                    System.out.printf(e.getMessage());
                }
        }
        return s;
    }

    @Override
    public Collection<ConfigDetalhesExteriores> values() {
        Set<ConfigDetalhesExteriores> configuraDetalhesExt = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(int s : keys){
            configuraDetalhesExt.add(this.get(s));
        }
        return configuraDetalhesExt;
    }

    @Override
    public Set<Map.Entry<Integer, ConfigDetalhesExteriores>> entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        HashMap<Integer,ConfigDetalhesExteriores> map = new HashMap<>();
        for(int key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }

    @Override
    public ConfigDetalhesExteriores put(Integer key, ConfigDetalhesExteriores value) {
        ConfigDetalhesExteriores d;
        
        if(this.containsKey(key)){
            d = this.get(key);
        }
        else d = value;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM configuracaoExt WHERE id_configuraExt = ? and ref = 20");
            stm.setInt(1, key);
            stm.executeUpdate();
            if(value.isTipo()){
                stm = conn.prepareStatement("INSERT INTO ConfiguracaoExt (ref, custo, tipo, vidrosEscurecidos, paraChoques, tectodeAbrir, id_configuraExt, stock) VALUES (?,?,?,?,?, ?, ?,?)");
                stm.setInt(1, value.getRef());
                stm.setFloat(2, value.getCusto());
                stm.setBoolean(3, value.isTipo());
                stm.setString(4,value.getVidrosEscurecidos());
                stm.setString(5,value.getParaChoques());
                stm.setString(6,value.getTectodeAbrir());
                stm.setInt(7, value.getId_configuraExt());
                stm.setInt(8, value.getStock());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        } finally {
            try{
                Connector.close(conn);
            }catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return d;
    }
    
}
