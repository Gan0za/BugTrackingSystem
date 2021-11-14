
public class Task {
    private long idTask;
    private String topicTask;
    private String projectId;
    private String typeId;
    private String priorityId;
    private String userId;
    private String descriptionTask;

    public Task (long id, String topic, String project, String type, String priority, String user, String description) {
        this.idTask = id;
        this.topicTask = topic;
        this.projectId = project;
        this.typeId = type;
        this.priorityId = priority;
        this.userId = user;
        this.descriptionTask = description;
    }

    public Task (long id, String topic, String project, String type, String priority, String user) {
        this.idTask = id;
        this.topicTask = topic;
        this.projectId = project;
        this.typeId = type;
        this.priorityId = priority;
        this.userId = user;
        this.descriptionTask = "NULL";
    }

    public long getIdTask () {
        return this.idTask;
    }

    public String getTopicTask () {
        return this.topicTask;
    }

    public String getProjectId () {
        return this.projectId;
    }

    public String getTypeId () {
        return this.typeId;
    }

    public String getPriorityId () {
        return this.priorityId;
    }

    public String getUserId () {
        return this.userId;
    }

    public String getDescriptionTask () {
        return this.descriptionTask;
    }

    public void setIdTask (long id) {
        this.idTask = id;
    }

    public void setTopicTask (String topic) {
        this.topicTask = topic;
    }

    public void setProjectId (String project) {
        this.projectId = project;
    }

    public void setTypeId (String type) {
        this.typeId = type;
    }

    public void setPriorityId (String priority) {
        this.priorityId = priority;
    }

    public void setUserId (String user) {
        this.userId = user;
    }

    public void setDescriptionTask (String description) {
        this.descriptionTask = description;
    }

    @Override
    public String toString(){
        return "Задача #: " + idTask +
                "; Тема: " + topicTask + "; Проект: " + projectId +
                "; Тип: " + typeId + "; Приоритет: " +
                priorityId + "; Исполнитель : " + userId +
                "; Описание: " + descriptionTask + "; ";
    }
}
