/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

/**
 *
 * @author filip
 */

import DAO.DAO_utilizador;
import DAO.DAO_configura;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Configuração {
    private float custo;
    private String pintura;
    private String jantesPneus;
    private String motor;
    private int id_configura;
    private int ref;
    private boolean tipo;
    private int stock;
    
    
    public Configuração (float custo,String pintura, String jantesPneus, String motor, int id_configura, int ref, boolean tipo, int stock){
        this.custo = custo;
        this.pintura = pintura;
        this.jantesPneus = jantesPneus;
        this.motor = motor;
        this.id_configura = id_configura;
        this.ref = ref;
        this.tipo = tipo;
        this.stock = stock;
    }
    
    public Configuração (){
        this.custo = (float) 0.0;
        this.pintura = "";
        this.jantesPneus = "";
        this.motor = "";
        this.id_configura = 0;
        this.ref = 0;
        this.tipo = false;
        this.stock = 0;
    }
    
    public Configuração (Configuração c){
        this.custo = c.getCusto();
        this.pintura = c.getPintura();
        this.jantesPneus = c.getJantesPneus();
        this.motor = c.getMotor();
        this.id_configura = id_configura;
        this.ref = c.getRef();    
        this.tipo = c.isTipo();
        this.stock= c.getStock();
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setJantesPneus(String jantesPneus) {
        this.jantesPneus = jantesPneus;
    }

    public void setId_configura(int id_configura) {
        this.id_configura = id_configura;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getMotor() {
        return motor;
    }

 
    

    public void setPintura(String pintura) {
        this.pintura = pintura;
    }

   

  
    
    
    public boolean isTipo() {
        return tipo;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    
    public float getCusto() {
        return custo;
    }
    
   
    
    
    public String getPintura()
    {
        return pintura;
    }
    
     public String getPneusjantes()
    {
        return jantesPneus;
    }
    
    
    
    public String getJantesPneus() {
        return jantesPneus;
    }

 

    public int getId_configura() {
        return id_configura;
    }

 

   
    
  

  
  
    @Override
    public String toString() {
        return "Configuração{" + "custo=" + custo + "pintura" + pintura + '}';
    }

 /*   @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Float.floatToIntBits(this.custo);
        hash = 53 * hash + Objects.hashCode(this.ListaDespesa);
        hash = 53 * hash + Objects.hashCode(this.ListaUtilizadores);
        return hash;
    }*/

  
  

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Configuração other = (Configuração) obj;
        if (Float.floatToIntBits(this.custo) != Float.floatToIntBits(other.custo)) {
            return false;
        }
     //   if (!Objects.equals(this.ListaDespesa, other.ListaDespesa)) {
       //     return false;
        //}
      //  if (!Objects.equals(this.ListaUtilizadores, other.ListaUtilizadores)) {
       //     return false;
        //}
        return true;
    }

}

   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

