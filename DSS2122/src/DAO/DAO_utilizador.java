/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Java.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author filip
 */
public class DAO_utilizador implements Map<String, Utilizador> {
    
    Connection conn;
    
    @Override
    public int size() {
        int size = -1;
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT COUNT(*) FROM Utilizador");
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
            PreparedStatement stm = conn.prepareStatement("SELECT username FROM utilizador WHERE username= ?");
            stm.setString(1, (String) key);
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
        
        if(value.getClass().getName().equals("DSS2122.Java.Utilizador")){
            Utilizador mr = (Utilizador)value;
            String username = mr.getUsername();
            Utilizador m = this.get(username);
            if(m.equals(mr)){
                r=true;
            }
        }
        return r;
    }

    @Override
    public Utilizador get(Object key) {
        Utilizador mr = null;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM utilizador WHERE username=?");
            stm.setString(1, (String)key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                mr = new Utilizador(rs.getString("username"),rs.getString("email"), rs.getFloat("conta"));
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
        return mr;
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        Utilizador m;
        
        if(this.containsKey(key)){
            m = this.get(key);
        }
        else m = value;
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM utilizador WHERE username = ?");
            stm.setString(1,key);
            stm.executeUpdate();
            
            stm = conn.prepareStatement("INSERT INTO utilizador (username, email, Conta) VALUES (?,?,?)");
            stm.setString(1, key);
            stm.setString(2, value.getEmail());
            stm.setFloat(3, value.getConta());
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
        return m;
    }

    @Override
    public Utilizador remove(Object key) {
        Utilizador m = this.get((String) key);
        try{
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM utilizador WHERE username = ?");
            stm.setString(1, (String) key);
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
        return m;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        for(Utilizador mr: m.values()){
            put(mr.getUsername(), mr);
        }
    }

    @Override
    public void clear() {
        try {
            conn = Connector.connectDB();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM utilizador");
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
    public Set<String> keySet() {
        Set<String> s = null;
        
        try{
            conn = Connector.connectDB();
            s = new HashSet<>();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM utilizador");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                s.add(rs.getString("Username"));
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
    public Collection<Utilizador> values() {
        Set<Utilizador> utilizadores = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String s : keys){
            utilizadores.add(this.get(s));
        }
        return utilizadores;
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        HashMap<String,Utilizador> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
    
    public GregorianCalendar DateChange(Date d) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal;
    }
    
    public Date ChangeCal(Calendar g) {
        Date d = (Date) g.getTime();
        return d;
    }
}
