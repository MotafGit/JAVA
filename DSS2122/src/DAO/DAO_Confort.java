/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Java.PacoteConfort;
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
public class DAO_Confort implements Map<Integer, PacoteConfort>{

    Connection conn;
    
    @Override
    public int size() {
        int size = -1;
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT COUNT(*) FROM PacoteConfort WHERE ref = 40");
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
            PreparedStatement stm = conn.prepareStatement("SELECT id_Confort FROM PacoteConfort WHERE id_Confort= ? and ref = 40");
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
        
        if(value.getClass().getName().equals("DSS2122.Java.PacoteConfort")){
            PacoteConfort d = (PacoteConfort)value;
            int id = d.getId_Confort();
            PacoteConfort dp = this.get(id);
            if(dp.getId_Confort() == id && dp.isTipo()){
                r=true;
            }
        }
        return r;
    }

    
    @Override
    public PacoteConfort get(Object key) {
        PacoteConfort d = null;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM PacoteConfort WHERE id_Confort=? and ref = 40");
            stm.setInt(1, (Integer)key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                 d = new PacoteConfort (rs.getFloat("custo"), rs.getString("bancoElectrico"), rs.getString("luzesInt"), rs.getString("arCondicionado4Z"), rs.getString("espelho"),rs.getInt("ref"), rs.getInt("id_Confort"),  rs.getBoolean("tipo"), rs.getInt("stock"));
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
    public PacoteConfort remove(Object key) {
        PacoteConfort d = this.get(key);
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM PacoteConfort WHERE id_Confort = ? and ref = 40");
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
    public void putAll(Map<? extends Integer, ? extends PacoteConfort> dp) {
        for(PacoteConfort d: dp.values()){
            if(d.isTipo())
                put(d.getId_Confort(), d);
        }
    }

    @Override
    public void clear() {
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM PacoteConfort WHERE ref = 30");
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
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM PacoteConfort WHERE ref = 40");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                s.add(rs.getInt("id_Confort"));
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
    public Collection<PacoteConfort> values() {
        Set<PacoteConfort> configura = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(int s : keys){
            configura.add(this.get(s));
        }
        return configura;
    }

    @Override
    public Set<Map.Entry<Integer, PacoteConfort>> entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        HashMap<Integer,PacoteConfort> map = new HashMap<>();
        for(int key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }

    @Override
    public PacoteConfort put(Integer key, PacoteConfort value) {
        PacoteConfort d;
        
        if(this.containsKey(key)){
            d = this.get(key);
        }
        else d = value;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM PacoteConfort WHERE id_Confort = ? and ref = 40");
            stm.setInt(1, key);
            stm.executeUpdate();
            if(value.isTipo()){
                stm = conn.prepareStatement("INSERT INTO PacoteConfort (ref, custo, tipo, bancoElectrico, luzesInt, arCondicionado4Z,espelho, id_Confort, stock) VALUES (?,?,?,?,?,?,?, ?, ?)");
                stm.setInt(1, value.getRef());
                stm.setFloat(2, value.getCusto());
                stm.setBoolean(3, value.isTipo());
                stm.setString(4,value.getBancoElectrico());
                stm.setString(5,value.getLuzesInt());
                stm.setString(6,value.getArCondicionado4Z());
                 stm.setString(7,value.getEspelho());
                stm.setInt(8, value.getId_Confort());
                stm.setInt(9, value.getStock());
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
