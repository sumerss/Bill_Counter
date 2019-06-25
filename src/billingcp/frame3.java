/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingcp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sumer
 */
public class frame3 extends javax.swing.JFrame {

     Calendar cal = Calendar.getInstance();
     SimpleDateFormat ft = new SimpleDateFormat( "yyyy/MM//dd");       
        
        
    public frame3() {
        initComponents();
        T55.setText(ft.format(cal.getTime()));
        T67.setEditable(false);
        T66.setEditable(false);
        T65.setEditable(false);
    }
    public frame3(int hsn,Queue NAME,Queue qnt,Queue kg,Queue rate){
         initComponents();
//          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//          frame3.setSize(screenSize.width, screenSize.height);

       setExtendedState(frame3.MAXIMIZED_BOTH);
        T67.setEditable(false);
        T66.setEditable(false);
        T65.setEditable(false); 
        T56.setEditable(false); 
        T57.setEditable(false);     
        T58.setEditable(false);  
        T59.setEditable(false);  
        T60.setEditable(false); 
        T61.setEditable(false);  
        
        T55.setText(ft.format(cal.getTime()));
        T56.setText(""+hsn);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biling","root","root");
            Statement stmt=con.createStatement();
            String str="select * from customer where hsn="+hsn+";";
            ResultSet rs=stmt.executeQuery(str);        
            while(rs.next()){
            String name=rs.getString("customer_name");
            T57.setText(name);
            int gst=rs.getInt("gst");
            T59.setText(""+gst);
            String state=rs.getString("state");
            T60.setText(state);
            int sc=rs.getInt("state_code");
            T61.setText(""+sc);
            String add=rs.getString("cust_add");
            T58.append(add);
            }            

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        DefaultTableModel model=(DefaultTableModel)table.getModel();
         int sno=1;
        while(!NAME.isEmpty()){
            
        String Name=(String) NAME.peek();   NAME.remove();
        String nop=(String)qnt.peek();      qnt.remove();
        double qt=(Double)kg.peek();          kg.remove();
        double rt=(Double)rate.peek();        rate.remove();
        double amt=qt*rt;                    
        model.addRow(new Object[]{sno,Name,nop,qt,rt,amt});    
        sno++;
        }
        
        double total=0;
        for(int i=0;i<table.getRowCount();i++){
            double amount=(double) table.getValueAt(i, 5);
            total+=amount;
        }
        T65.setText(""+total*0.09);
        T66.setText(""+total*0.09);
        double total1=total+2*(total*0.09); 
        T67.setText(""+total1);
           
               
        
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        T54 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        T55 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        T56 = new javax.swing.JTextField();
        T57 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        T58 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        T59 = new javax.swing.JTextField();
        T60 = new javax.swing.JTextField();
        T61 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        T62 = new javax.swing.JTextField();
        T63 = new javax.swing.JTextField();
        T64 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        T66 = new javax.swing.JTextField();
        T65 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        T67 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame3"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jPanel3.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAX INVOICE/INVOICE FOR SUPPLY OF GOODS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("XYZ PACKAGING PVT. LTD.");
        jLabel2.setAutoscrolls(true);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 30, 1060, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("(GRAVURE PRINTING & LAMINATOR)");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 60, 1070, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Plot No.199-200,Patparganj Industrial Area,Delhi-110092,Phone:011-22159440 ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 80, 1060, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("E-mail.cpp111@rediffmail.com.C.I.N.:U74899DL1993PTC054233");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 100, 1060, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("GSTIN/UNIQUE ID:07AAACC5335P1ZF");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 120, 1060, 17);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Invoice NO. :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(41, 36, 101, 25);

        T54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T54ActionPerformed(evt);
            }
        });
        jPanel1.add(T54);
        T54.setBounds(160, 40, 130, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Date & Time of Issuing Invoice : ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(419, 40, 248, 17);

        T55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T55ActionPerformed(evt);
            }
        });
        jPanel1.add(T55);
        T55.setBounds(672, 38, 260, 22);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 140, 1030, 80);

        jLabel9.setText("HSN/ACS CODE :");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 240, 110, 20);

        jLabel10.setText("DESCRIPTION :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(500, 240, 100, 20);

        T56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T56ActionPerformed(evt);
            }
        });
        jPanel3.add(T56);
        T56.setBounds(140, 240, 250, 22);

        T57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T57ActionPerformed(evt);
            }
        });
        jPanel3.add(T57);
        T57.setBounds(630, 240, 250, 22);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Reciepent Details :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(13, 9, 138, 30);

        T58.setColumns(20);
        T58.setRows(5);
        jScrollPane1.setViewportView(T58);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(35, 48, 287, 80);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("STATE :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(567, 59, 121, 27);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("STATE CODE :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(567, 93, 121, 27);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("GSTIN :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(567, 25, 121, 27);
        jPanel2.add(T59);
        T59.setBounds(700, 28, 177, 22);
        jPanel2.add(T60);
        T60.setBounds(700, 62, 177, 22);
        jPanel2.add(T61);
        T61.setBounds(700, 96, 177, 22);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 280, 1030, 130);

        jLabel15.setText("TRANSPORTER NAME  :");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(0, 490, 150, 20);

        jLabel16.setText("PURCHASE ORDER NO.:");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(0, 430, 160, 20);

        jLabel17.setText("MODE OF DISPATCH    :");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(0, 460, 150, 20);
        jPanel3.add(T62);
        T62.setBounds(210, 430, 90, 22);
        jPanel3.add(T63);
        T63.setBounds(210, 460, 90, 22);
        jPanel3.add(T64);
        T64.setBounds(210, 490, 90, 22);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Description of goods", "No. of Packages", "Quantity(kg)", "Rate", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(25);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(800);
            table.getColumnModel().getColumn(2).setMaxWidth(600);
            table.getColumnModel().getColumn(3).setMaxWidth(400);
            table.getColumnModel().getColumn(4).setMinWidth(40);
            table.getColumnModel().getColumn(4).setMaxWidth(200);
            table.getColumnModel().getColumn(5).setMaxWidth(400);
        }

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(0, 530, 1030, 170);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("S.G.S.T.@9%");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(670, 740, 120, 40);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("C.G.S.T.@9%");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(670, 700, 120, 40);

        T66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T66ActionPerformed(evt);
            }
        });
        jPanel3.add(T66);
        T66.setBounds(810, 750, 100, 22);

        T65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T65ActionPerformed(evt);
            }
        });
        jPanel3.add(T65);
        T65.setBounds(810, 710, 100, 22);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("TOTAL");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(670, 780, 120, 40);

        T67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T67ActionPerformed(evt);
            }
        });
        jPanel3.add(T67);
        T67.setBounds(810, 790, 100, 22);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1040, 870);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1050, 760, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T54ActionPerformed

    private void T55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T55ActionPerformed

    private void T56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T56ActionPerformed

    private void T57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T57ActionPerformed

    private void T66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T66ActionPerformed

    private void T65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T65ActionPerformed

    private void T67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T67ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        int inv=Integer.parseInt(T54.getText());
        
        int n=table.getRowCount();
        for(int i=0;i<n;i++){
         try{
             String good=(String)table.getValueAt(i, 1);
             String pac=(String)table.getValueAt(i, 2);
             double Qt=(Double)table.getValueAt(i, 3);
             double Rt=(Double)table.getValueAt(i, 4); 
             double amt=(Double)table.getValueAt(i, 5); 
             int Cd=Integer.parseInt(T56.getText());
             
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biling","root","root");
            Statement stmt=con.createStatement();  
            String str="insert into invoice values("+inv+",'"+good+"','"+pac+"',"+Qt+","+Rt+","+amt+","+Cd+",'"+T55.getText()+"');";
            stmt.executeUpdate(str);   
            con.close();
                      
             }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
              }
        }
        
       PrinterJob job = PrinterJob.getPrinterJob();
       job.setJobName("Print Data.");
       
       job.setPrintable(new Printable() {
           @Override
           public int print(Graphics pg, PageFormat pf, int pageNum){
               
               if(pageNum>0){
                   return Printable.NO_SUCH_PAGE;
               }
               Graphics2D gd=(Graphics2D)pg;
               gd.translate(pf.getImageableX(), pf.getImageableY());
               gd.scale(0.65, 0.45);
               jPanel3.paint(pg);                            
               return Printable.PAGE_EXISTS;
           }           
       });
       job.printDialog();
         try {
             job.print();
         } catch (PrinterException ex) {
             Logger.getLogger(frame3.class.getName()).log(Level.SEVERE, null, ex);
         }       
         
         frame2 ob=new frame2();
         ob.setVisible(true);
         dispose();
                
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField T54;
    private javax.swing.JTextField T55;
    private javax.swing.JTextField T56;
    private javax.swing.JTextField T57;
    private javax.swing.JTextArea T58;
    private javax.swing.JTextField T59;
    private javax.swing.JTextField T60;
    private javax.swing.JTextField T61;
    private javax.swing.JTextField T62;
    private javax.swing.JTextField T63;
    private javax.swing.JTextField T64;
    private javax.swing.JTextField T65;
    private javax.swing.JTextField T66;
    private javax.swing.JTextField T67;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
