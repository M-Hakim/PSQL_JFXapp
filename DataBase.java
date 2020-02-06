package DataBaseConnect;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javafx.application.Application;
//import javafx.stage.Stage;
public class DataBase {
//    public DataBase() throws ClassNotFoundException {
//
//    }
    public Vector<User> selectAll(String tableName){
        Vector<User> allUsers = new Vector<>();
        try {
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company", "postgres","postgres");
                Statement stmt= con.createStatement() ;
                String queryString= new String("select * from " + tableName);
                ResultSet rs= stmt.executeQuery(queryString) ;
                
                while(rs.next()) {
//                    System.out.println(rs.getString(1) + ' ' + rs.getString(2));
                    User user = new User();
                    user.id = rs.getInt(1);
                    user.firstName = rs.getString(2);
                    user.middleName = rs.getString(3);
                    user.lastName = rs.getString(4);
                    user.email = rs.getString(5);
                    user.phone = rs.getString(6);
                    allUsers.add(user);
                }
                stmt.close();
                con.close();
        } catch(SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return allUsers;
    }
    public void delete(String tableName,int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company", "postgres","postgres");
            PreparedStatement pst= con.prepareStatement("DELETE FROM employee_info WHERE emp_id= ?");
            pst.setInt(1, id);
            int rs= pst.executeUpdate();
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }  
    };
    public void update(String tableName,User user){             
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company",
                    "postgres","postgres");
                 
//            PreparedStatement pst= con.prepareStatement("UPDATE employee_info SET middle_name=? WHERE emp_id=?");
            
            PreparedStatement pst= con.prepareStatement("UPDATE employee_info SET first_name=?,middle_name=?,"
                    + "last_name=?,email=?,phone=? WHERE emp_id=?");
            
//              pst.setString(1,fieldEdited);            
//              pst.setInt(2,id);  
            pst.setString(1,user.firstName);
            pst.setString(2,user.middleName); 
            pst.setString(3,user.lastName);
            pst.setString(4,user.email);
            pst.setString(5,user.phone);
            pst.setInt(6,user.id); 

//            int rs= pst.executeUpdate();
            pst.executeUpdate();
//            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    public static void main(String[] args) {
        DataBase companyDB = new DataBase();
        User modifiedUser = new User(2, "May", "Turky", "ay 7aga", "dhvcd@vbfh.com", "07775000");
        companyDB.update("employee_info",modifiedUser);
                
//        Vector<User> allUsers = companyDB.selectAll("employee_info");
//        companyDB.delete("employee_info",1);
//        Vector<Object> usersObj = companyDB.selectAll("employee_info");
//        Vector<User> users = new Vector<User>();
//        for (Object obj : usersObj)
//        {
//            users.add((User) obj);
//        }
//        System.out.println("i");
    }
}
