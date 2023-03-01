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




public class ConfigDetalhesExteriores {
    
    private float custo;
    private String tectodeAbrir;
    private String vidrosEscurecidos;
    private String paraChoques;
    private int ref;
    private int id_configuraExt;
    private boolean tipo;
    private int stock;

    
    
    public ConfigDetalhesExteriores (float custo, String tectodeAbrir, String vidrosEscurecidos, String paraChoques, int ref, int id_configuraExt, boolean tipo, int stock){
        this.custo = custo;
        this.tectodeAbrir = tectodeAbrir;
        this.vidrosEscurecidos = vidrosEscurecidos;
        this.paraChoques = paraChoques;        
        this.ref = ref;
        this.id_configuraExt=id_configuraExt;
        this.tipo = tipo;
        this.stock = stock;
    }
    
    public ConfigDetalhesExteriores (){
        this.custo = (float) 0.0;
        this.tectodeAbrir = "";
        this.vidrosEscurecidos = "";
        this.paraChoques = "";
        this.id_configuraExt = 0;
        this.ref = 0;
        this.tipo = false;
        this.stock = 0;
    }
    
    public ConfigDetalhesExteriores (ConfigDetalhesExteriores c){
        this.custo = c.getCusto();
         this.tectodeAbrir = c.getTectodeAbrir();
        this.vidrosEscurecidos = c.getVidrosEscurecidos();
        this.paraChoques = c.getParaChoques();
         this.ref = c.getRef();
         this.id_configuraExt=id_configuraExt;
         this.tipo = c.isTipo();
         this.stock = c.getStock();
}

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

  

   

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getCusto() {
        return custo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setId_configuraExt(int id_configuraExt) {
        this.id_configuraExt = id_configuraExt;
    }

    public int getId_configuraExt() {
        return id_configuraExt;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getRef() {
        return ref;
    }

    public String getTectodeAbrir() {
        return tectodeAbrir;
    }

 

    public String getVidrosEscurecidos() {
        return vidrosEscurecidos;
    }

    public String getParaChoques() {
        return paraChoques;
    }

    public void setTectodeAbrir(String tectodeAbrir) {
        this.tectodeAbrir = tectodeAbrir;
    }

   

    public void setVidrosEscurecidos(String vidrosEscurecidos) {
        this.vidrosEscurecidos = vidrosEscurecidos;
    }

    public void setParaChoques(String paraChoques) {
        this.paraChoques = paraChoques;
    }
    
    @Override
    public String toString() {
        return "Configuração{" + "custo=" + custo + "tectodeabrir" + tectodeAbrir + '}';
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
        final ConfigDetalhesExteriores other = (ConfigDetalhesExteriores) obj;
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
    