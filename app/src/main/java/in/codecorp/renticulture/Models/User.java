package in.codecorp.renticulture.Models;

public class User {
   String uid;
   String fname;
   String lname;
   String uname;
   String phone;
   String pwd;
   String email;

    public User(String uid, String fname, String lname, String uname, String phone, String pwd, String email) {
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.phone = phone;
        this.pwd = pwd;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
