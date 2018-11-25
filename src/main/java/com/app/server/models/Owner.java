package com.app.server.models;

public class Owner {

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getPrefGender() {
        return prefGender;
    }

    public String getPrefJob() {
        return prefJob;
    }

    public int getPrefNum() {
        return prefNum;
    }

    public String getPrefCook() { return prefCook; }

    public String getEmailAddress() { return emailAddress; }

    public String getPassword() { return password; }


    String id =null;
    String userName;
    String firstName;
    String lastName;
    String prefGender;
    String prefJob;
    int prefNum;
    String prefCook;
    String emailAddress;
    String password;

    public Owner(
            String userName,
            String firstName,
            String lastName,
            String prefGender,
            String prefJob,
            int prefNum,
            String prefCook,
            String emailAddress,
            String password
    ) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefGender = prefGender;
        this.prefJob = prefJob;
        this.prefNum = prefNum;
        this.prefCook = prefCook;
        this.emailAddress = emailAddress;
        this.password = password;

    }
    public void setId(String ownerid) {
        this.id = ownerid;
    }
}
