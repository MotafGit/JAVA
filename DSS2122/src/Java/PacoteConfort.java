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




public class PacoteConfort {
    
    private float custo;
    private String bancoElectrico;
    private String luzesInt;
    private String arCondicionado4Z;
    private String espelho;
    private int ref;
    private int id_Confort;
    private boolean tipo;
    private int stock;

    
    
    public PacoteConfort (float custo, String bancoElectrico, String luzesInt, String arCondicionado4Z,String espelho, int ref, int id_Confort, boolean tipo, int stock){
        this.custo = custo;
        this.bancoElectrico = bancoElectrico;
        this.luzesInt = luzesInt;
        this.arCondicionado4Z = arCondicionado4Z;
        this.espelho=espelho;
        this.ref = ref;
        this.id_Confort=id_Confort;
        this.tipo = tipo;
        this.stock = stock;
    }
    
    public PacoteConfort (){
        this.custo = (float) 0.0;
        this.bancoElectrico = "";
        this.luzesInt = "";
        this.arCondicionado4Z = "";
        this.espelho="";
        this.id_Confort = 0;
        this.ref = 0;
        this.tipo = false;
        this.stock = 0;
    }
    
    public PacoteConfort (PacoteConfort c){
        this.custo = c.getCusto();
         this.bancoElectrico = c.getBancoElectrico();
        this.luzesInt = c.getLuzesInt();
        this.arCondicionado4Z = c.getArCondicionado4Z();
        this.espelho = c.getEspelho();
         this.ref = c.getRef();
         this.id_Confort=id_Confort;
         this.tipo = c.isTipo();
         this.stock = c.getStock();
}

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setArCondicionado4Z(String arCondicionado4Z) {
        this.arCondicionado4Z = arCondicionado4Z;
    }

    public void setEspelho(String espelho) {
        this.espelho = espelho;
    }

    public String getEspelho() {
        return espelho;
    }

    public float getCusto() {
        return custo;
    }

    public String getBancoElectrico() {
        return bancoElectrico;
    }

    public String getLuzesInt() {
        return luzesInt;
    }

    public String getArCondicionado4Z() {
        return arCondicionado4Z;
    }

    public int getRef() {
        return ref;
    }

    public int getId_Confort() {
        return id_Confort;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setBancoElectrico(String bancoElectrico) {
        this.bancoElectrico = bancoElectrico;
    }

    public void setLuzesInt(String luzesInt) {
        this.luzesInt = luzesInt;
    }

    public void setArCondicionado4Z4Z(String arCondicionado4Z) {
        this.arCondicionado4Z = arCondicionado4Z;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setId_Confort(int id_Confort) {
        this.id_Confort = id_Confort;
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
        final PacoteConfort other = (PacoteConfort) obj;
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
    