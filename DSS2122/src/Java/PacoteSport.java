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




public class PacoteSport {
    
    private float custo;
    private String jantesSport;
    private String pneuSport;
    private String paraChoquesSport;
    private String escapeSport;
    private int ref;
    private int id_Sport;
    private boolean tipo;

    
    
    public PacoteSport (float custo, String jantesSport, String pneuSport, String paraChoquesSport, String escapeSport, int ref, int id_Sport, boolean tipo){
        this.custo = custo;
        this.jantesSport = jantesSport;
        this.pneuSport = pneuSport;
        this.paraChoquesSport = paraChoquesSport;
        this.escapeSport = escapeSport;
        
        this.ref = ref;
        this.id_Sport=id_Sport;
        this.tipo = tipo;
    }
    
    public PacoteSport (){
        this.custo = (float) 0.0;
        this.jantesSport = "";
        this.pneuSport = "";
        this.paraChoquesSport = "";
        this.escapeSport = "";
        this.id_Sport = 0;
        this.ref = 0;
        this.tipo = false;
    }
    
    public PacoteSport (PacoteSport c){
        this.custo = c.getCusto();
         this.jantesSport = c.getJantesSport();
        this.pneuSport = c.getPneuSport();
        this.paraChoquesSport = c.getParaChoquesSport();
        this.escapeSport = c.getEscapeSport();
         this.ref = c.getRef();
         this.id_Sport=id_Sport;
         this.tipo = isTipo();
}

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setJantesSport(String jantesSport) {
        this.jantesSport = jantesSport;
    }

    public void setPneuSport(String pneuSport) {
        this.pneuSport = pneuSport;
    }

    public void setParaChoquesSport(String paraChoquesSport) {
        this.paraChoquesSport = paraChoquesSport;
    }

    public void setEscapeSport(String escapeSport) {
        this.escapeSport = escapeSport;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setId_Sport(int id_Sport) {
        this.id_Sport = id_Sport;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public float getCusto() {
        return custo;
    }

    public String getJantesSport() {
        return jantesSport;
    }

    public String getPneuSport() {
        return pneuSport;
    }

    public String getParaChoquesSport() {
        return paraChoquesSport;
    }

    public String getEscapeSport() {
        return escapeSport;
    }

    public int getRef() {
        return ref;
    }

    public int getId_Sport() {
        return id_Sport;
    }

    public boolean isTipo() {
        return tipo;
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
        final PacoteSport other = (PacoteSport) obj;
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
    