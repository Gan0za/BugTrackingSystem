import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListMenu {
    private final PrintStream sysOut = new PrintStream(System.out);

    public void getStartMenu() { //Главное меню
        sysOut.println("==================================Стартовое меню==================================");
        sysOut.println("Выберите действие:");
        sysOut.println("1. Вывод общей информации");
        sysOut.println("2. Поиск по ключевому значению");
        sysOut.println("3. Добавить новую запись");
        sysOut.println("4. Обновить информацию");
        sysOut.println("5. Удаление");
        sysOut.println("6. Настройки");
        sysOut.println("7. Выход из программы");
        sysOut.println("===================================================================================");
        sysOut.print("Введите номер действия:> ");
    }

    public void getEntitySelectionMenu() { //Меню выбора сущностей
        sysOut.println("===============================Меню выбора сущностей===============================");
        sysOut.println("Выберите сущность:");
        sysOut.println("1. Пользователи");
        sysOut.println("2. Проекты");
        sysOut.println("3. Задачи");
        sysOut.println("4. Назад");
        sysOut.println("===================================================================================");
        sysOut.print("Введите номер сущности:> ");
    }

    public void getFilterSelectionProjectMenu() { //Фильтры для Проектам
        sysOut.println("================================Меню выбора фильтра================================");
        sysOut.println("Выберите фильтр:");
        sysOut.println("1. Поиск по номеру");
        sysOut.println("2. Поиск по имени");
        sysOut.println("3. Назад");
        sysOut.println("===================================================================================");
        sysOut.print("Введите номер фильтра:> ");
    }
    public void getFilterSelectionUserMenu() { //Фильтры для Пользователей
        sysOut.println("================================Меню выбора фильтра================================");
        sysOut.println("Выберите фильтр:");
        sysOut.println("1. Поиск по номеру");
        sysOut.println("2. Поиск по фамилии");
        sysOut.println("3. Поиск по имени");
        sysOut.println("4. Поиск по отчеству");
        sysOut.println("5. Поиск по должности");
        sysOut.println("6. Назад");
        sysOut.println("===================================================================================");
        sysOut.print("Введите номер фильтра:> ");
    }
    public void getFilterSelectionTaskMenu() {  //Фильтры для Задач
        sysOut.println("================================Меню выбора фильтра================================");
        sysOut.println("Выберите фильтр:");
        sysOut.println("1. Поиск по номеру");
        sysOut.println("2. Поиск по теме");
        sysOut.println("3. Поиск по проекту");
        sysOut.println("4. Поиск по типу");
        sysOut.println("5. Поиск по приоритету");
        sysOut.println("6. Поиск по исполнителю");
        sysOut.println("7. Поиск по описанию");
        sysOut.println("8. Назад");
        sysOut.println("===================================================================================");
        sysOut.print("Введите номер фильтра:> ");
    }

    public void getProjectValueSelectionMenu() { //Меню обновлений для Проектов
        sysOut.println("=============================Меню изменения атрибутов=============================");
        sysOut.println("Выберите атрибут:");
        sysOut.println("1. Изменить название проекта");
        sysOut.println("2. Изменить активность проекта");
        sysOut.println("3. Назад");
        sysOut.println("==================================================================================");
        sysOut.print("Введите номер атрибут:> ");
    }
    public void getUserValueSelectionMenu() { //Меню обновлений для Пользователей
        sysOut.println("=============================Меню изменения атрибутов=============================");
        sysOut.println("Выберите атрибут:");
        sysOut.println("1. Изменить фамилию пользователя");
        sysOut.println("2. Изменить имя пользователя");
        sysOut.println("3. Изменить отчество пользователя");
        sysOut.println("4. Изменить должность пользователя");
        sysOut.println("5. Изменить активность пользователя");
        sysOut.println("6. Назад");
        sysOut.println("===================================================================================");
        sysOut.print("Введите номер атрибут:> ");
    }
    public void getTaskValueSelectionMenu() { //Меню обновления Задач
        sysOut.println("=============================Меню изменения атрибутов=============================");
        sysOut.println("Выберите атрибут:");
        sysOut.println("1. Изменить тему задачи");
        sysOut.println("2. Изменить проект задачи");
        sysOut.println("3. Изменить тип задачи");
        sysOut.println("4. Изменить приоритет задачи");
        sysOut.println("5. Изменить исполнителя задачи");
        sysOut.println("6. Изменить описание задачи");
        sysOut.println("7. Назад");
        sysOut.println("==================================================================================");
        sysOut.print("Введите номер атрибут:> ");
    }
    public void getSettingsMenu() { //Меню настроек
        sysOut.println("=============================Меню настроек=============================");
        sysOut.println("Выберите пункт меню:");
        sysOut.println("1. Изменить название базы данных");
        sysOut.println("2. Инициализировать базу данных");
        sysOut.println("3. Назад");
        sysOut.println("=======================================================================");
        sysOut.print("Введите номер атрибут:> ");
    }

    public String getSelectAllTasks () { //Запрос выводящий все активные задачи
        return ("SELECT " +
                "Task.IdTask, " +
                "Task.TopicTask, " +
                "Project.NameProject, " +
                "Type.NameType, " +
                "Priority.NamePriority, " +
                "User.SurnameUser, " +
                "Task.DescriptionTask " +
                "FROM Task " +
                "JOIN Project ON Task.ProjectId = Project.IdProject " +
                "JOIN Type ON Task.TypeId = Type.TypeId " +
                "JOIN Priority ON Task.PriorityId = Priority.PriorityId " +
                "JOIN User ON Task.UserId = User.IdUser " +
                "WHERE Task.TypeId <> 4 " +
                "ORDER BY Task.IdTask;");
    }

    //Запрос выводящий всех активных Пользователей
    public String getSelectAllUser () {
        return ("SELECT * FROM user WHERE ActivUser <> 0;");
    }

    //Запрос выводящий все активные Проекты
    public String getSelectAllProject () {
        return ("SELECT * FROM project WHERE ActivProject <> 0;");
    }

    //Выборка для Проектов
    public String getSelectFilterProject (String NameProject, String Filter) {
        return ("SELECT * FROM Project WHERE Project."+ Filter + " LIKE '%" + NameProject + "%';");
    }

    //Выборка для Пользователей
    public String getSelectFilterUser (String user, String Filter) {
        return ("SELECT * FROM User WHERE User."+ Filter + " LIKE '%" + user + "%';");
    }

    //Выборка для Задач
    public String getSelectFilterTask (String task, String Filter) {
        return ("SELECT " +
                "Task.IdTask, " +
                "Task.TopicTask, " +
                "Project.NameProject, " +
                "Type.NameType, " +
                "Priority.NamePriority, " +
                "User.SurnameUser, " +
                "Task.DescriptionTask " +
                "FROM Task " +
                "JOIN Project ON Task.ProjectId = Project.IdProject " +
                "JOIN Type ON Task.TypeId = Type.TypeId " +
                "JOIN Priority ON Task.PriorityId = Priority.PriorityId " +
                "JOIN User ON Task.UserId = User.IdUser " +
                "WHERE Task."+ Filter +" LIKE '%" + task + "%' " +
                "ORDER BY Task.IdTask;");
    }

    //Добавить новый проект
    public String getInsertProject () {
        return ("INSERT INTO Project (NameProject) VALUES(?);");
    }

    //Добавить нового Пользователя
    public String getInsertUser () {
        return ("INSERT INTO User (SurnameUser, NameUser, MiddleNameUser, PostUser) VALUES(?, ?, ?, ?);");
    }

    //Добавить новую Задачу
    public String getInsertTask () {
        return ("INSERT INTO Task (TopicTask, ProjectId, TypeId, PriorityId, UserId, DescriptionTask) VALUES(?, ?, ?, ?, ?, ?);");
    }

    //Обновление  на все варианты
    public String getUpdate (String table, String column, String value, String condition, String value2) {
        return ("UPDATE `"+ table +"` SET `"+ column +"` = "+ value +" WHERE `"+ condition +"` = "+ value2 +";");
    }

    //Запрос считающий сумму при условии что задача не закрыта
    public String getCount (String table, String parameter, String id) {
        return ("SELECT COUNT("+table+"."+ parameter +") FROM "+table+" WHERE "+table+"."+ parameter +" = "+ id +
                " AND Task.TypeId <> 4;");
    }

    //Запрос считающий сумму
    public String getCountNotAnd (String table, String parameter, String id) {
        return ("SELECT COUNT("+table+"."+ parameter +") FROM "+table+" WHERE "+table+"."+ parameter +" = "+ id +";");
    }

    //Отрисовка Пользователей
    public void getWheleUser(ResultSet resultSet) throws SQLException{
        while (resultSet.next()) {
            User user = new User(resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
            sysOut.println(user);
        }
    }

    //Отрисовка Проектов
    public void getWheleProject(ResultSet resultSet) throws SQLException{
        while (resultSet.next()) {
            Project project = new Project(resultSet.getLong(1), resultSet.getString(2));
            sysOut.println(project);
        }
    }

    //Отрисовка Задач
    public void getWheleTask(ResultSet resultSet) throws SQLException{
        while (resultSet.next()) {
            Task task = new Task(resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
            sysOut.println(task);
        }
    }

    //Обработка сумм (для проверок)
    public String getWheleCount(ResultSet resultSet) throws SQLException{
        var testing = "";
        while (resultSet.next()) {
            testing = resultSet.getString(1);
        }
        return testing;
    }

    //Запись в Лог
    public void setLog (String massange){
        try(FileWriter writer = new FileWriter("log.log", true))
        {
            Date date = new Date();
            writer.write(date + " " + massange);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException e){
            System.out.println("Error write log: \n"+e.getMessage());
        }
    }

    //Запись настроек
    public void setSettings (String massange){
        try(FileWriter writer = new FileWriter("settings.txt", false))
        {
            writer.write(massange);
            writer.flush();
        }
        catch(IOException e){
            System.out.println("Error read settings file: \n"+e.getMessage());
        }
    }
}
