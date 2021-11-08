package com.app;

public class Task {
    private long IdTask;
    private String TopicTask;
    private String ProjectId;
    private String TypeId;
    private String PriorityId;
    private String UserId;
    private String DescriptionTask;

    public Task (long id, String Topic, String Project, String Type, String Priority, String User, String Description) {
        this.IdTask = id;
        this.TopicTask = Topic;
        this.ProjectId = Project;
        this.TypeId = Type;
        this.PriorityId = Priority;
        this.UserId = User;
        this.DescriptionTask = Description;
    }

    public Task (long id, String Topic, String Project, String Type, String Priority, String User) {
        this.IdTask = id;
        this.TopicTask = Topic;
        this.ProjectId = Project;
        this.TypeId = Type;
        this.PriorityId = Priority;
        this.UserId = User;
        this.DescriptionTask = "NULL";
    }

    public long getIdTask () {
        return this.IdTask;
    }

    public String getTopicTask () {
        return this.TopicTask;
    }

    public String getProjectId () {
        return this.ProjectId;
    }

    public String getTypeId () {
        return this.TypeId;
    }

    public String getPriorityId () {
        return this.PriorityId;
    }

    public String getUserId () {
        return this.UserId;
    }

    public String getDescriptionTask () {
        return this.DescriptionTask;
    }

    public void setIdTask (long Id) {
        this.IdTask = Id;
    }

    public void setTopicTask (String TopicTask) {
        this.TopicTask = TopicTask;
    }

    public void setProjectId (String ProjectId) {
        this.ProjectId = ProjectId;
    }

    public void setTypeId (String TypeId) {
        this.TypeId = TypeId;
    }

    public void setPriorityId (String PriorityId) {
        this.PriorityId = PriorityId;
    }

    public void setUserId (String UserId) {
        this.UserId = UserId;
    }

    public void setDescriptionTask (String DescriptionTask) {
        this.DescriptionTask = DescriptionTask;
    }

    @Override
    public String toString(){
        return "Задача #: " + IdTask +
        "; Тема: " + TopicTask + "; Проект: " + ProjectId + 
        "; Тип: " + TypeId + "; Приоритет: " + 
        PriorityId + "; Исполнитель : " + UserId + 
        "; Описание: " + DescriptionTask + "; ";
    }
}
