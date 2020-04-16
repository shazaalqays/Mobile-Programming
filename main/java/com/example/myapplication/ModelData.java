package com.example.myapplication;


public class ModelData {

    private String name;
    private int userImage;
    private  String password;


    public ModelData(String name, String password, int userImage ) {

        this.name = name;
        this.password = password;
        this.userImage = userImage;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getUserImage() {
        return userImage;
    }
}
