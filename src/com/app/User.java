package com.app;

public class User {
    private long idUser;
    private String surnameUser;
    private String nameUser;
    private String middleNameUser;
    private String postUser;

    public User (long id, String surname, String name, String post) {
        this.idUser = id;
        this.surnameUser = surname;
        this.nameUser = name;
        this.middleNameUser = "NULL";
        this.postUser = post;
    }

    public User (long id, String surname, String name, String middleName, String post) {
        this.idUser = id;
        this.surnameUser = surname;
        this.nameUser = name;
        this.middleNameUser = middleName;
        this.postUser = post;
    }

    public long getIdUser () {
        return this.idUser;
    }

    public String getSurnameUser () {
        return this.surnameUser;
    }

    public String getNameUser () {
        return this.nameUser;
    }

    public String getMiddleNameUser () {
        return this.middleNameUser;
    }

    public String getPostUser () {
        return this.postUser;
    }

    public void setIdUser (long id) {
        this.idUser = id;
    }

    public void setSurnameUser (String surname) {
        this.surnameUser = surname;
    }

    public void setNameUser (String name) {
        this.nameUser = name;
    }

    public void setMiddleNameUser (String middleName) {
        this.middleNameUser = middleName;
    }

    public void setPostUser (String post) {
        this.postUser = post;
    }

    @Override
    public String toString(){
        return "Пользователь #: " + idUser +
        "; ФИО: " + surnameUser + " " + nameUser + 
        " " + middleNameUser + "; Должность: " + 
        postUser + "; ";
    }
}
