package com.client.Models;

public class User {
    private int id;
    private String login="";
    private String password="";
    private String email="";
    private String firstName="";
    private String lastName="";
    private String type="";
    private String token="";

    public User(){
        login="";
        password="";
        email="";
        firstName="";
        lastName="";
        type="";
        token="";
    }
    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String email) {
        super();
        this.login = login;
        this.password = password;
        this.email = email;
        this.type = "USER";
    }

    public User(String login, String password, String email, String firstName, String lastName) {
        super();
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
