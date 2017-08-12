package org.passinhos.passinhos.Models;

public class User {
    private static User instance;

    private String Username;
    private String FullName;
    private String CPF;
    private String State;
    private String Birthday;

    private String ChildFullname;
    private String ChildCPF;
    private String ChildState;
    private String ChildBirthday;

    private User() {}

    public static User instance() {
        if(User.instance == null) {
            User.instance = new User();

            User.instance.setUsername("dona.maria");
            User.instance.setFullName("Maria Lúcia da Conceição");
            User.instance.setCPF("123.456.789-01");
            User.instance.setState("PE");
            User.instance.setBirthday("12323123");

            instance.setChildFullname("José Roberto da Silva");
            instance.setChildCPF("123.456.789-01");
            instance.setChildState("BA");
            instance.setChildBirthday("12323123");
        }

        return instance;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getChildFullname() {
        return ChildFullname;
    }

    public void setChildFullname(String childFullname) {
        ChildFullname = childFullname;
    }

    public String getChildCPF() {
        return ChildCPF;
    }

    public void setChildCPF(String childCPF) {
        ChildCPF = childCPF;
    }

    public String getChildState() {
        return ChildState;
    }

    public void setChildState(String childState) {
        ChildState = childState;
    }

    public String getChildBirthday() {
        return ChildBirthday;
    }

    public void setChildBirthday(String childBirthday) {
        ChildBirthday = childBirthday;
    }
}

