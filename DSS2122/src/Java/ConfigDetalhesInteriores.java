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




public class ConfigDetalhesInteriores {
    
    private float custo;
    private String estofos;
    private String luzes;
    private String arCondicionado;
    private int ref;
    private int id_configuraInt;
    private boolean tipo;
    private int stock;

    
    
    public ConfigDetalhesInteriores (float custo, String estofos, String luzes, String arCondicionado, int ref, int id_configuraInt, boolean tipo, int stock){
        this.custo = custo;
        this.estofos = estofos;
        this.luzes = luzes;
        this.arCondicionado = arCondicionado;        
        this.ref = ref;
        this.id_configuraInt=id_configuraInt;
        this.tipo = tipo;
        this.stock = stock;
    }
    
    public ConfigDetalhesInteriores (){
        this.custo = (float) 0.0;
        this.estofos = "";
        this.luzes = "";
        this.arCondicionado = "";
        this.id_configuraInt = 0;
        this.ref = 0;
        this.tipo = false;
        this.stock = 0;
    }
    
    public ConfigDetalhesInteriores (ConfigDetalhesInteriores c){
        this.custo = c.getCusto();
         this.estofos = c.getEstofos();
        this.luzes = c.getLuzes();
        this.arCondicionado = c.getArCondicionado();
         this.ref = c.getRef();
         this.id_configuraInt=id_configuraInt;
         this.tipo = c.isTipo();
         this.stock = c.getStock();
}

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public float getCusto() {
        return custo;
    }

    public String getEstofos() {
        return estofos;
    }

    public String getLuzes() {
        return luzes;
    }

    public String getArCondicionado() {
        return arCondicionado;
    }

    public int getRef() {
        return ref;
    }

  

    public boolean isTipo() {
        return tipo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setEstofos(String estofos) {
        this.estofos = estofos;
    }

    public void setLuzes(String luzes) {
        this.luzes = luzes;
    }

    public void setArCondicionado(String arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setId_configuraInt(int id_configuraInt) {
        this.id_configuraInt = id_configuraInt;
    }

    public int getId_configuraInt() {
        return id_configuraInt;
    }

  

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

        
   

    
    
    @Override
    public String toString() {
        return "Configuração{" + "custo=" + custo + '}';
    }
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
        final ConfigDetalhesInteriores other = (ConfigDetalhesInteriores) obj;
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
    