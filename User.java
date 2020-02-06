package DataBaseConnect;

import java.nio.file.Files;
import java.util.Vector;

public class User {
    public static DataBase companyDB = new DataBase();
    public static Vector<User> selectAll(){
        Vector<User> allUsers = new Vector<>();
        allUsers = companyDB.selectAll("employee_info");
        return  allUsers;
    }
    public int id;
    public String firstName, middleName, lastName, email, phone;
    public User(){}
    public User(int _id, String _firstName, String _middleName, String _lastName, String _email, String _phone){
        id = _id;
        firstName = _firstName;
        middleName = _middleName;
        lastName = _lastName;
        email = _email;
        phone = _phone;
    }
    public void insert(){};
    public static void delete(String tableName,int id){
        companyDB.delete(tableName,id);
    };
    public void update(){
        companyDB.update("employee_info",this);
    };

    public static void main(String [] args){
        Vector<User> users = User.selectAll();
//         delete("employee_info",5);
//        User modifiedUser = new User(2, "May", "Turky", "hello", "dgjdchkdc@ovjojvjbijg.com", "07775000");
//        modifiedUser.update();
//         for(User u:users){
//             System.out.println(u.email);
//         }
//          delete("employee_info",5);
//        for(User u:users){
//             System.out.println(u.email);
//         }
       
    }





}
