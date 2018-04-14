package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 13-04-2018.
 */

public class User {

    static String address="",collegeid="",email="",mobileno="",name="",password="",studentid="",instructoeid="";

    public static void reset(){
        address="";
        collegeid="";
        email="";
        mobileno="";
        name="";
        password="";
        studentid="";
        instructoeid="";
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        User.address = address;
    }

    public static String getCollegeid() {
        return collegeid;
    }

    public static void setCollegeid(String collegeid) {
        User.collegeid = collegeid;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getMobileno() {
        return mobileno;
    }

    public static void setMobileno(String mobileno) {
        User.mobileno = mobileno;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getStudentid() {
        return studentid;
    }

    public static void setStudentid(String studentid) {
        User.studentid = studentid;
    }

    public static String getInstructoeid() {
        return instructoeid;
    }

    public static void setInstructoeid(String instructoeid) {
        User.instructoeid = instructoeid;
    }

    public static int checkUser(){
        if (!studentid.equals(""))
            return 0;
        if (!instructoeid.equals(""))
            return 1;
        if (!collegeid.equals(""))
            return 3;
        return 2;
    }
}
