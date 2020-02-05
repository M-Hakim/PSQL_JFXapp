package DataBaseConnect;

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
    public void insert(){

    }
    public void update(){}
    public void delete(){}

    public static void main(String [] args){
        Vector<User> users = User.selectAll();
    }





}
