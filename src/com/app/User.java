package com.app;

public class User {
    private long IdUser;
    private String SurnameUser;
    private String NameUser;
    private String MiddleNameUser;
    private String PostUser;

    public User (long id, String Surname, String Name, String Post) {
        this.IdUser = id;
        this.SurnameUser = Surname;
        this.NameUser = Name;
        this.MiddleNameUser = "NULL";
        this.PostUser = Post;
    }

    public User (long id, String Surname, String Name, String MiddleName, String Post) {
        this.IdUser = id;
        this.SurnameUser = Surname;
        this.NameUser = Name;
        this.MiddleNameUser = MiddleName;
        this.PostUser = Post;
    }

    public long getIdUser () {
        return this.IdUser;
    }

    public String getSurnameUser () {
        return this.SurnameUser;
    }

    public String getNameUser () {
        return this.NameUser;
    }

    public String getMiddleNameUser () {
        return this.MiddleNameUser;
    }

    public String getPostUser () {
        return this.PostUser;
    }

    public void setIdUser (long Id) {
        this.IdUser = Id;
    }

    public void setSurnameUser (String SurnameUser) {
        this.SurnameUser = SurnameUser;
    }

    public void setNameUser (String NameUser) {
        this.NameUser = NameUser;
    }

    public void setMiddleNameUser (String MiddleName) {
        this.MiddleNameUser = MiddleName;
    }

    public void setPostUser (String Post) {
        this.PostUser = Post;
    }

    @Override
    public String toString(){
        return "Пользователь #: " + IdUser +
        "; ФИО: " + SurnameUser + " " + NameUser + 
        " " + MiddleNameUser + "; Должность: " + 
        PostUser + "; ";
    }
}
