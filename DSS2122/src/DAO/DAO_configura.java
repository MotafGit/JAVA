/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Java.Configuração;
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
public class DAO_configura implements Map<Integer, Configuração>{

    Connection conn;
    
    @Override
    public int size() {
        int size = -1;
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT COUNT(*) FROM Configuracao");
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
            PreparedStatement stm = conn.prepareStatement("SELECT id_configura FROM Configuracao WHERE id_configura= ?");
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
        
        if(value.getClass().getName().equals("DSS2122.Java.Configura")){
            Configuração d = (Configuração)value;
            int id = d.getId_configura();
            Configuração dp = this.get(id);
            if(dp.getId_configura() == id){
                r=true;
            }
        }
        return r;
    }

    @Override
    public Configuração get(Object key) {
        Configuração d = null;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Configuracao WHERE id_configura=?");
            stm.setInt(1, (Integer)key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                d = new Configuração (rs.getFloat("custo"), rs.getString("pintura"), rs.getString("jantesPneus"), rs.getString("motor"), rs.getInt("id_configura"), rs.getInt("ref"), rs.getBoolean("tipo"), rs.getInt("stock"));
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
    public Configuração remove(Object key) {
        Configuração d = this.get((String) key);
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Configuracao WHERE id_configura = ?");
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
    public void putAll(Map<? extends Integer, ? extends Configuração> dp) {
        for(Configuração d: dp.values()){
            put(d.getId_configura(), d);
        }
    }
    

    @Override
    public void clear() {
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Configuracao");
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
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Configuracao");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                s.add(rs.getInt("getId_configura"));
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
    public Collection<Configuração> values() {
        Set<Configuração> configuraçoes = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(int s : keys){
            configuraçoes.add(this.get(s));
        }
        return configuraçoes;
    }

    @Override
    public Set<Map.Entry<Integer, Configuração>> entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        HashMap<Integer,Configuração> map = new HashMap<>();
        for(int key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }

    @Override
    public Configuração put(Integer key, Configuração value) {
        Configuração d;
        
        if(this.containsKey(key)){
            d = this.get(key);
        }
        else d = value;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Configuracao WHERE id_configura = ?");
            stm.setInt(1, key);
            stm.executeUpdate();
            
            stm = conn.prepareStatement("INSERT INTO Configuracao (ref, custo,tipo, pintura, jantesPneus, motor, id_configura, stock) VALUES (?,?,?,?,?, ?, ?,?)");
            stm.setInt(1, value.getRef());
            stm.setFloat(2, value.getCusto());
            stm.setBoolean(3, value.isTipo());

            stm.setString(4, value.getPintura());
            stm.setString(5, value.getJantesPneus());
            stm.setString(6, value.getMotor());
            
            stm.setInt(7, value.getId_configura());
            stm.setInt(8, value.getStock());
            stm.executeUpdate();
            
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
