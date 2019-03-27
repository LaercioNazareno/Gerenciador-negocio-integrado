package com.gerenciador_negocios_integrado.app.model;

public class User {

    private String email, name, lastName, password;

    public User() {
    }

    public User(String email, String name, String lastName, String password){

        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
