package DataBaseConnect;

import java.sql.*;
import java.util.Vector;

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
    public static void main(String[] args) {
        DataBase companyDB = new DataBase();
        Vector<User> allUsers = companyDB.selectAll("employee_info");
//        Vector<Object> usersObj = companyDB.selectAll("employee_info");
//        Vector<User> users = new Vector<User>();
//        for (Object obj : usersObj)
//        {
//            users.add((User) obj);
//        }
//        System.out.println("i");
    }
}
