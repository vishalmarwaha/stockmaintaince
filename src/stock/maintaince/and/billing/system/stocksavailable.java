/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.maintaince.and.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static stock.maintaince.and.billing.system.globalvariables.PASSWORD;
import static stock.maintaince.and.billing.system.globalvariables.PATH;
import static stock.maintaince.and.billing.system.globalvariables.PLACE;
import static stock.maintaince.and.billing.system.globalvariables.USERNAME;

/**
 *
 * @author vishal
 */
public class stocksavailable extends javax.swing.JInternalFrame {

    /**
     * Creates new form lessstock
     */
    public stocksavailable() {
        initComponents();
        try
{
Connection myconn = DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
try
{
String q="select * from productinfo ";
PreparedStatement myst = myconn.prepareStatement(q);
ResultSet res = myst.executeQuery();
if(res.next()==true)
{
DefaultTableModel mymodel = (DefaultTableModel)jTable1.getModel();
mymodel.setRowCount(0);
do
{
String n=res.getString("productname");
String qt=res.getString("quantity");
String pr=res.getString("price");

Object myrow[] = {n,qt,pr};
mymodel.addRow(myrow);

}
while(res.next()==true);
} 
}
catch(Exception e)
{
JOptionPane.showMessageDialog(rootPane, e.getMessage());
}
finally
{
myconn.close();
}
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(rootPane, "Error in connection" + se.getMessage());
} 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("TOTAL STOCK AVAILABLE");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("             STOCKS AVAILABLE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT NAME", "QUANTITY AVAILABLE", "PRICE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}