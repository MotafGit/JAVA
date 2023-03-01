/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import DAO.DAO_Confort;
import java.util.Date;
import Java.Carro;
import DAO.DAO_configura;
import DAO.DAO_basico;
import DAO.DAO_detalhesExt;
import DAO.DAO_detalhesInt;

/**
 *
 * @author filip
 */
public class Utilizador extends Carro  {
    private String username;
    private String email;
    private float conta;
    private DAO_detalhesExt listaExteriores;
    private DAO_basico listaBasica;
     private DAO_detalhesInt listaInteriores;
     private DAO_Confort listaConfort;
    
    
    public Utilizador (){
        this.username = "";
        this.email = "";
        this.conta = (float) 0.0;
        this.listaExteriores = new DAO_detalhesExt();
        this.listaBasica = new DAO_basico();
        this.listaInteriores = new DAO_detalhesInt();
        this.listaConfort = new DAO_Confort();
    }
    
    public Utilizador(String username, String email, float conta) {

        this.username = username;
        this.email = email;
        this.conta = conta;
        this.listaExteriores = new DAO_detalhesExt();
        this.listaBasica = new DAO_basico();
        this.listaInteriores = new DAO_detalhesInt();
        this.listaConfort= new DAO_Confort();
    }
    
    public Utilizador(Utilizador m) {
        this.username = m.getUsername();
        this.email = m.getEmail();
        this.conta = m.getConta();
        this.listaExteriores = m.getListaExteriores();
        this.listaBasica = m.getListaBasica();
        this.listaInteriores = m.getListaInteriores();
        this.listaConfort = m.getListaConfort();
        
    }

    public DAO_configura getListaConfig() {
        return ListaConfig;
    }

    public DAO_Confort getListaConfort() {
        return listaConfort;
    }

    public void setListaInteriores(DAO_detalhesInt listaInteriores) {
        this.listaInteriores = listaInteriores;
    }

    public DAO_detalhesInt getListaInteriores() {
        return listaInteriores;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConta(float conta) {
        this.conta = conta;
    }

    public void setListaExteriores(DAO_detalhesExt listaExteriores) {
        this.listaExteriores = listaExteriores;
    }

  

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public float getConta() {
        return conta;
    }

    public DAO_detalhesExt getListaExteriores() {
        return listaExteriores;
    }

    public DAO_basico getListaBasica() {
        return listaBasica;
    }

    public void setListaBasica(DAO_basico listaBasica) {
        this.listaBasica = listaBasica;
    }

 
    
    
    public void adicionaConfig (Configuração a) {
      //if (a.isTipo()) listaRec.put(a.getId_despesa(), a);
     // ListaExteriores.put(a.getId_configura(), a);
      if (a.getRef() == 10 && a.isTipo()) listaBasica.put(a.getId_configura(), a);
    //  if (a.getRef() == 20) listaExteriores.put(a.getId_configuraExt(), a); 
      this.conta += a.getCusto();
      }
    
    public void adicionaConfigExt (ConfigDetalhesExteriores a) {
      //if (a.isTipo()) listaRec.put(a.getId_despesa(), a);
     // ListaExteriores.put(a.getId_configura(), a);
      if (a.getRef() == 20 && a.isTipo()) listaExteriores.put(a.getId_configuraExt(), a);
    //  if (a.getRef() == 20) listaExteriores.put(a.getId_configuraExt(), a); 
      this.conta += a.getCusto();
      }
    
     public void adicionaConfigInt (ConfigDetalhesInteriores a) {
      //if (a.isTipo()) listaRec.put(a.getId_despesa(), a);
     // ListaExteriores.put(a.getId_configura(), a);
      if (a.getRef() == 30 && a.isTipo()) listaInteriores.put(a.getId_configuraInt(), a);
    //  if (a.getRef() == 20) listaExteriores.put(a.getId_configuraExt(), a); 
      this.conta += a.getCusto();
      }
     
     public void adicionaPacoteC (PacoteConfort a) {
      //if (a.isTipo()) listaRec.put(a.getId_despesa(), a);
     // ListaExteriores.put(a.getId_configura(), a);
      if (a.getRef() == 40 && a.isTipo()) listaConfort.put(a.getId_Confort(), a);
    //  if (a.getRef() == 20) listaExteriores.put(a.getId_configuraExt(), a); 
      this.conta += a.getCusto();
      }
    
    @Override
    public String toString() {
        return "Utilzador{" + " username=" + username + ", email=" + email + ", conta=" + conta + ", listaExteriores=" + listaExteriores + '}';
    }
    
}






    
    
   