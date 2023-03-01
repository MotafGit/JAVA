/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Java.Carro;


import java.awt.Toolkit;
import java.awt.event.WindowEvent;


public class ConfiguracaoFinal extends javax.swing.JFrame {

   private Carro carro;
    private String username;
    private int stock;
    private Menu_Inicial menuIni;
    private  int id_configura;
    private int id_configuraExt;
    private int id_configuraInt;
    private int id_Confort;

   public ConfiguracaoFinal(Carro a, String username, int id_configuraInt, int id_configura, int id_configuraExt) {
        initComponents();
        this.carro = a;
        this.username = username;
        this.menuIni = menuIni;
        this.id_configura=id_configura;
        this.id_configuraExt=id_configuraExt;
        this.id_configuraInt=id_configuraInt;
        this.stock=20;
                System.out.println ("entrou na 1ª");

        Final();
   }
   
    public ConfiguracaoFinal(Carro a, String username, int id_configuraExt, int id_configura, int id_Confort, Menu_Inicial menuIni) {
        initComponents();
        this.carro = a;
        this.username = username;
        this.id_configuraExt=id_configuraExt;
        this.id_configura=id_configura;
        this.id_Confort=id_Confort;
        this.stock=20;
                System.out.println ("entrou na 2ª");

        Final1();
   }
    
    public ConfiguracaoFinal(Carro a, int id_configuraInt) {
        initComponents();
        this.carro = a;
        this.menuIni = menuIni;
        this.id_configuraInt=id_configuraInt;
        this.stock=20;
        Final();
        
   }
   
    public void close() {
        WindowEvent winClosingEvent =  new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
 
   
   public void Final (){
       
    
     
   

      String pintura = carro.getListaConfig().get(id_configura).getPintura();
       labellPintura.setText (pintura);
       String jantes = carro.getListaConfig().get(id_configura).getJantesPneus();
       labelJantes.setText (jantes);
       String motor = carro.getListaConfig().get(id_configura).getMotor();
       labelMotor.setText (motor);
       String vidro = carro.getListaExteriores().get(id_configuraExt).getVidrosEscurecidos();
       labelVidros.setText (vidro);
       String tes = carro.getListaInteriores().get(id_configuraInt).getEstofos();
       labelEstofos.setText (tes);
       String ar = carro.getListaInteriores().get(id_configuraInt).getArCondicionado();
       LabelAr.setText (ar);
       String tecto = carro.getListaExteriores().get(id_configuraExt).getTectodeAbrir();
       labelTecto.setText (tecto);
       String para = carro.getListaExteriores().get(id_configuraInt).getParaChoques();
       LabelPara.setText (para);
        String luz = carro.getListaInteriores().get(id_configuraInt).getLuzes();
       labelLuz.setText (luz);
        float x = carro.getListaConfig().get(id_configura).getCusto() + carro.getListaExteriores().get(id_configuraExt).getCusto() + carro.getListaInteriores().get(id_configuraInt).getCusto();
        jLabel21.setText(Float.toString(x)+ " €");
       
   }
   
   public void Final1 (){
       
    

      String pintura = carro.getListaConfig().get(id_configura).getPintura();
       labellPintura.setText (pintura);
       String jantes = carro.getListaConfig().get(id_configura).getJantesPneus();
       labelJantes.setText (jantes);
       String motor = carro.getListaConfig().get(id_configura).getMotor();
       labelMotor.setText (motor);
       String vidro = carro.getListaExteriores().get(id_configuraExt).getVidrosEscurecidos();
       labelVidros.setText (vidro);
       String tes = carro.getListaConfort().get(id_Confort).getArCondicionado4Z();
       jLabel17.setText (tes);
       String ar = carro.getListaConfort().get(id_Confort).getBancoElectrico();
       jLabel18.setText (ar);
       String tecto = carro.getListaExteriores().get(id_configuraExt).getTectodeAbrir();
       labelTecto.setText (tecto);
       String para = carro.getListaExteriores().get(id_configuraExt).getParaChoques();
       LabelPara.setText (para);
        String luz = carro.getListaConfort().get(id_Confort).getEspelho();
       jLabel20.setText (luz);
       String luzC = carro.getListaConfort().get(id_Confort).getLuzesInt();
       jLabel19.setText (luzC);
       float x = carro.getListaConfort().get(id_Confort).getCusto() + carro.getListaConfig().get(id_configura).getCusto() + carro.getListaExteriores().get(id_configuraExt).getCusto();
               jLabel21.setText(Float.toString(x)+ " €");

   }
   
 
 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelPintura = new javax.swing.JLabel();
        labellPintura = new javax.swing.JLabel();
        labelJantes = new javax.swing.JLabel();
        labelMotor = new javax.swing.JLabel();
        labelTecto = new javax.swing.JLabel();
        labelVidros = new javax.swing.JLabel();
        LabelPara = new javax.swing.JLabel();
        LabelAr = new javax.swing.JLabel();
        labelEstofos = new javax.swing.JLabel();
        labelLuz = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("jantes e pneus");

        jLabel8.setText("motor");

        jLabel9.setText("tecto");

        jLabel10.setText("vidros");

        jLabel11.setText("parachoques");

        jLabel12.setText("estofos");

        jLabel13.setText("luzes inteiores");

        jLabel14.setText("ar condicionado");

        jLabel6.setText("pintura");

        labellPintura.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        labelJantes.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        labelMotor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        labelTecto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        labelVidros.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        LabelPara.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        LabelAr.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        labelEstofos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        labelLuz.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel15.setText("Preço final");

        jButton1.setText("Avançar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Pacote Confort");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("jLabel21");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPintura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labellPintura, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTecto)))
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelMotor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(76, 76, 76)
                                    .addComponent(labelVidros))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel5)
                                    .addGap(99, 99, 99)
                                    .addComponent(jLabel16)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelJantes)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelEstofos)
                                    .addComponent(labelLuz))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelAr)
                                    .addComponent(LabelPara)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(labelPintura)
                        .addComponent(labellPintura)
                        .addComponent(jLabel14)
                        .addComponent(LabelAr)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(LabelPara)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelJantes))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(labelMotor)
                            .addComponent(jLabel12)
                            .addComponent(labelEstofos))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(labelTecto))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(labelLuz)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVidros)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Menu_Inicial s = new Menu_Inicial(carro, username);
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAr;
    private javax.swing.JLabel LabelPara;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelEstofos;
    private javax.swing.JLabel labelJantes;
    private javax.swing.JLabel labelLuz;
    private javax.swing.JLabel labelMotor;
    private javax.swing.JLabel labelPintura;
    private javax.swing.JLabel labelTecto;
    private javax.swing.JLabel labelVidros;
    private javax.swing.JLabel labellPintura;
    // End of variables declaration//GEN-END:variables


}
