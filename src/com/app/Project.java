package com.app;

public class Project {
    private long IdProject;
    private String NameProject;

    public Project (long id, String Name) {
        this.IdProject = id;
        this.NameProject = Name;
    }

    public long getIdProject () {
        return this.IdProject;
    }

    public void setIdProject (long Id) {
        this.IdProject = Id;
    }

    public String getNameProject () {
        return this.NameProject;
    }

    public void setNameProject (String Name) {
        this.NameProject = Name;
    }

    @Override
    public String toString(){
        return "Проект #: " + IdProject +
        "; Название: " + NameProject  + "; ";
    }
}
