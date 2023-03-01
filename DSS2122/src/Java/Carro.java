/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import DAO.DAO_Confort;
import DAO.DAO_configura;
import DAO.DAO_utilizador;
import DAO.DAO_detalhesExt;
import DAO.DAO_detalhesInt;
import java.util.ArrayList;

/**
 *
 * @author filip
 */
public class Carro {
    
    public DAO_configura ListaConfig;
    public DAO_utilizador ListaUtilizadores;
    public DAO_detalhesExt listaExteriores;
    public DAO_detalhesInt listaInteriores;
    public DAO_Confort listaConfort;
    
    public Carro (ArrayList<Configuração> ListaConfig, ArrayList <ConfigDetalhesExteriores> listaExteriores, ArrayList <ConfigDetalhesInteriores> listaInteriores, ArrayList <PacoteConfort> listaConfort){
   
    this.ListaConfig = new DAO_configura();
    this.ListaUtilizadores = new DAO_utilizador();
    this.listaExteriores = new DAO_detalhesExt();
    this.listaInteriores = new DAO_detalhesInt();
    this.listaConfort = new DAO_Confort();
}
        public Carro (){
        this.ListaConfig = new DAO_configura();
        this.ListaUtilizadores = new DAO_utilizador();
        this.listaExteriores = new DAO_detalhesExt();
        this.listaInteriores = new DAO_detalhesInt();
        this.listaConfort = new DAO_Confort();
        }
   
        
        public Carro (Carro c)
        {
            this.ListaConfig = c.getListaConfig();
            this.ListaUtilizadores = c.getListaUtilizadores();
            this.listaExteriores = c.getListaExteriores();
            this.listaInteriores = c.getListaInteriores();
            this.listaConfort = c.getListaConfort();
        }

    public void setListaConfort(DAO_Confort listaConfort) {
        this.listaConfort = listaConfort;
    }

    public DAO_Confort getListaConfort() {
        return listaConfort;
    }

    public void setListaExteriores(DAO_detalhesExt listaExteriores) {
        this.listaExteriores = listaExteriores;
    }

    public void setListaInteriores(DAO_detalhesInt listaInteriores) {
        this.listaInteriores = listaInteriores;
    }

    public DAO_detalhesInt getListaInteriores() {
        return listaInteriores;
    }

        
     public DAO_detalhesExt getListaExteriores() {
        return listaExteriores;
    }

    public void setListaConfigExterior(DAO_detalhesExt ListaExteriores) {
        this.listaExteriores = listaExteriores;
    }        
    public DAO_configura getListaConfig() {
        return ListaConfig;
    }

    public void setListaConfig(DAO_configura ListaConfig) {
        this.ListaConfig = ListaConfig;
    }
              
    public DAO_utilizador getListaUtilizadores() {
        return ListaUtilizadores;
    }


    public void setListaUtilizadores(DAO_utilizador ListaUtilizadores) {
        this.ListaUtilizadores = ListaUtilizadores;
    }
    
   

   

     public void adicionarUtilizador(Utilizador m) {
        String key = m.getUsername();
        ListaUtilizadores.put(key, m);
    }
     
       public void removerMorador(String username) {
        for(Utilizador o: ListaUtilizadores.values()){
            if(o.getUsername().equals(username))
                ListaUtilizadores.remove(username);
        }
    }
       
       public void adicionarConfig(Configuração d) {
        int i = ListaConfig.size();
        int j = ListaUtilizadores.size();
        ListaConfig.put(i, d);
        Configuração dp = new Configuração(d.getCusto(), d.getPintura(), d.getJantesPneus(), d.getMotor(), d.getId_configura(), d.getRef(), d.isTipo(), d.getStock());
        
        for(Utilizador m: ListaUtilizadores.values()){
            m.adicionaConfig(dp);
            ListaUtilizadores.put(m.getUsername(), m);
        }
        
       }
        
        public void adicionarConfigExt(ConfigDetalhesExteriores d) {
        int i = listaExteriores.size();
        int j = ListaUtilizadores.size();
        listaExteriores.put(i, d);
        ConfigDetalhesExteriores dp = new ConfigDetalhesExteriores(d.getCusto(), d.getTectodeAbrir(), d.getVidrosEscurecidos(), d.getParaChoques(), d.getId_configuraExt(), d.getRef(), d.isTipo(), d.getStock());
        
        for(Utilizador m: ListaUtilizadores.values()){
            m.adicionaConfigExt(dp);
            ListaUtilizadores.put(m.getUsername(), m);
        }
        }
        
         public void adicionarConfigInt(ConfigDetalhesInteriores d) {
        int i = listaInteriores.size();
        int j = ListaUtilizadores.size();
        listaInteriores.put(i, d);
        ConfigDetalhesInteriores dp = new ConfigDetalhesInteriores(d.getCusto(), d.getEstofos(), d.getLuzes(), d.getArCondicionado(), d.getId_configuraInt(), d.getRef(), d.isTipo(), d.getStock());
        
        for(Utilizador m: ListaUtilizadores.values()){
            m.adicionaConfigInt(dp);
            ListaUtilizadores.put(m.getUsername(), m);
        }
    
    }
         
        public void adicionaPacoteConfort (PacoteConfort d)
        {
            int i = listaConfort.size();
            int j = ListaUtilizadores.size();
            listaConfort.put(i, d);
            PacoteConfort dp = new PacoteConfort(d.getCusto(), d.getBancoElectrico(), d.getLuzesInt(), d.getArCondicionado4Z(), d.getEspelho(),d.getId_Confort(), d.getRef(), d.isTipo(), d.getStock());
 
            for(Utilizador m: ListaUtilizadores.values()){
                m.adicionaPacoteC(dp);
                ListaUtilizadores.put(m.getUsername(), m);
        }
        }
         
         
}



