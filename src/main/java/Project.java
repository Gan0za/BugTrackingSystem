public class Project {
    private long idProject;
    private String nameProject;

    public Project (long id, String name) {
        this.idProject = id;
        this.nameProject = name;
    }

    public long getIdProject () {
        return this.idProject;
    }

    public void setIdProject (long id) {
        this.idProject = id;
    }

    public String getNameProject () {
        return this.nameProject;
    }

    public void setNameProject (String name) {
        this.nameProject = name;
    }

    @Override
    public String toString(){
        return "Проект #: " + idProject +
                "; Название: " + nameProject  + "; ";
    }
}