/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Java.ConfigDetalhesInteriores;
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
public class DAO_detalhesInt implements Map<Integer, ConfigDetalhesInteriores>{

    Connection conn;
    
    @Override
    public int size() {
        int size = -1;
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT COUNT(*) FROM configuracaoint WHERE ref = 30");
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
            PreparedStatement stm = conn.prepareStatement("SELECT id_configuraInt FROM configuracaoint WHERE id_configuraInt= ? and ref = 30");
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
        
        if(value.getClass().getName().equals("DSS2122.Java.ConfigDetalhesInteriores")){
            ConfigDetalhesInteriores d = (ConfigDetalhesInteriores)value;
            int id = d.getId_configuraInt();
            ConfigDetalhesInteriores dp = this.get(id);
            if(dp.getId_configuraInt() == id && dp.isTipo()){
                r=true;
            }
        }
        return r;
    }

    
    @Override
    public ConfigDetalhesInteriores get(Object key) {
        ConfigDetalhesInteriores d = null;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM configuracaoint WHERE id_configuraInt=? and ref = 30");
            stm.setInt(1, (Integer)key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                 d = new ConfigDetalhesInteriores (rs.getFloat("custo"), rs.getString("estofos"), rs.getString("luzes"), rs.getString("arCondicionado"),rs.getInt("ref"), rs.getInt("id_configuraInt"),  rs.getBoolean("tipo"), rs.getInt("stock"));
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
    public ConfigDetalhesInteriores remove(Object key) {
        ConfigDetalhesInteriores d = this.get(key);
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM configuracaoint WHERE id_configuraInt = ? and ref = 30");
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
    public void putAll(Map<? extends Integer, ? extends ConfigDetalhesInteriores> dp) {
        for(ConfigDetalhesInteriores d: dp.values()){
            if(d.isTipo())
                put(d.getId_configuraInt(), d);
        }
    }

    @Override
    public void clear() {
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM configuracaoint WHERE ref = 30");
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
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM configuracaoint WHERE ref = 30");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                s.add(rs.getInt("id_configuraInt"));
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
    public Collection<ConfigDetalhesInteriores> values() {
        Set<ConfigDetalhesInteriores> configura = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(int s : keys){
            configura.add(this.get(s));
        }
        return configura;
    }

    @Override
    public Set<Map.Entry<Integer, ConfigDetalhesInteriores>> entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        HashMap<Integer,ConfigDetalhesInteriores> map = new HashMap<>();
        for(int key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }

    @Override
    public ConfigDetalhesInteriores put(Integer key, ConfigDetalhesInteriores value) {
        ConfigDetalhesInteriores d;
        
        if(this.containsKey(key)){
            d = this.get(key);
        }
        else d = value;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM configuracaoint WHERE id_configuraInt = ? and ref = 30");
            stm.setInt(1, key);
            stm.executeUpdate();
            if(value.isTipo()){
                stm = conn.prepareStatement("INSERT INTO ConfiguracaoInt (ref, custo, tipo, estofos, luzes, arCondicionado, id_configuraInt, stock) VALUES (?,?,?,?,?, ?,?, ?)");
                stm.setInt(1, value.getRef());
                stm.setFloat(2, value.getCusto());
                stm.setBoolean(3, value.isTipo());
                stm.setString(4,value.getEstofos());
                stm.setString(5,value.getLuzes());
                stm.setString(6,value.getArCondicionado());
                stm.setInt(7, value.getId_configuraInt());
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
