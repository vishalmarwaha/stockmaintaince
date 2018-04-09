/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.maintaince.and.billing.system;
import java.sql.*;
import javax.swing.*;

public class StockMaintainceAndBillingSystem implements globalvariables {

    public static void main(String[] args)
    {
       try
        {
Connection myconnection;


myconnection=DriverManager.getConnection(PATH+PLACE,USERNAME,PASSWORD);
try
{
String a="select * from logintable";
PreparedStatement mystatement=myconnection.prepareStatement(a);

ResultSet myresult=mystatement.executeQuery();

if(myresult.next())
{
login obj=new login();
obj.setVisible(true);

}
else
{
    JOptionPane.showMessageDialog(null, "Create admin account first");
    admin obj=new admin();
    obj.setVisible(true);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null, "Error in Query " + e.getMessage());
}
finally
{
myconnection.close();
}



}
catch(Exception e)
{
JOptionPane.showMessageDialog(null, "Error in Connection " + e.getMessage());
}
    }
    
}
