package com.app;

import java.util.Scanner;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {
    public static Statement statement;
    public static Connection connection;
    public static PreparedStatement prepareStatement;
    public static void main(String[] args) throws Throwable, SQLException {
        String USER_NAME;
        String PASSWORD;
        String URL;

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("Settings.xml");
            Node root = document.getDocumentElement();
            NodeList Settings = root.getChildNodes();

            Node Setting = Settings.item(1);
            USER_NAME = Setting.getChildNodes().item(0).getTextContent();

            Setting = Settings.item(3);
            PASSWORD = Setting.getChildNodes().item(0).getTextContent();

            Setting = Settings.item(5);
            String host = Setting.getChildNodes().item(0).getTextContent();

            Setting = Settings.item(7);
            String port = Setting.getChildNodes().item(0).getTextContent();

            Setting = Settings.item(9);
            String DataBase = Setting.getChildNodes().item(0).getTextContent();

            URL = "jdbc:mysql://"+ host +":"+ port +"/"+ DataBase +"";

            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
            statement = connection.createStatement(); 
        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (SAXException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner scan = new Scanner(System.in);
        PrintStream sysOut = new PrintStream(System.out);
        ListMenu menu = new ListMenu();

        boolean run = true;
        while (run == true) {
            menu.getStartMenu();
            String task = scan.nextLine();
            switch (task) {
                case "1": {
                    menu.getEntitySelectionMenu();
                    String SelectAllEntity = scan.nextLine();
                    switch (SelectAllEntity) {
                        case "1": {
                            try {
                                menu.setLog("Вывод на экран всех пользователей.");
                                ResultSet resultSet = statement.executeQuery(menu.getSelectAllUser());
                                menu.getWheleUser(resultSet);
                            } catch (SQLException e){
                                menu.setLog("Error: " + e);
                            }
                            break;
                        }
                        case "2": {
                            try {
                                menu.setLog("Вывод на экран всех проектов.");
                                ResultSet resultSet = statement.executeQuery(menu.getSelectAllProject());
                                menu.getWheleProject(resultSet);
                            } catch (SQLException e){
                                menu.setLog("Error: " + e);
                            }
                            break;
                        }
                        case "3": {
                            try {
                                menu.setLog("Вывод на экран всех задач.");
                                ResultSet resultSet = statement.executeQuery(menu.getSelectAllTasks());
                                menu.getWheleTask(resultSet);
                            } catch (SQLException e){
                                menu.setLog("Error:\n" + e);
                            }
                            break;
                        }
                        case "4": {
                            break;
                        }
                        default: {
                            sysOut.println("Введите корректный номер сущности!");
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    menu.getEntitySelectionMenu();
                    String DeleteEntity = scan.nextLine();
                    switch (DeleteEntity) {
                        case "1": {
                            menu.getFilterSelectionUserМenu();
                            String FilterSelectionUserМenu = scan.nextLine();
                            switch (FilterSelectionUserМenu) {
                                case "1": {
                                    try {
                                        sysOut.print("Введите номер пользователя:> ");
                                        String user = scan.nextLine();
                                        menu.setLog("Вывод на экран пользователя под номером "+user+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterUser(user, "IdUser"));
                                        menu.getWheleUser(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "2": {
                                    try {
                                        sysOut.print("Введите фамилию пользователя:> ");
                                        String user = scan.nextLine();
                                        menu.setLog("Вывод на экран пользователя по фамилии "+user+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterUser(user, "SurnameUser"));
                                        menu.getWheleUser(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "3": {
                                    try {
                                        sysOut.print("Введите имя пользователя:> ");
                                        String user = scan.nextLine();
                                        menu.setLog("Вывод на экран пользователя по имени "+user+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterUser(user, "NameUser"));
                                        menu.getWheleUser(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error:\n" + e);
                                    }
                                    break;
                                } 
                                case "4": {
                                    try {
                                        sysOut.print("Введите отчество пользователя:> ");
                                        String user = scan.nextLine();
                                        menu.setLog("Вывод на экран пользователя по отчеству "+user+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterUser(user, "MiddleNameUser"));
                                        menu.getWheleUser(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "5": {
                                    try {
                                        sysOut.print("Введите должность пользователя:> ");
                                        String user = scan.nextLine();
                                        menu.setLog("Вывод на экран пользователя по должности "+user+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterUser(user, "PostUser"));
                                        menu.getWheleUser(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "6": {
                                    break;
                                } 
                                default: {
                                    sysOut.println("Введите корректный номер сущности!");
                                    break;
                                }
                            }
                            break;
                        }
                        case "2": {
                            menu.getFilterSelectionProjectМenu();
                            String FilterSelectionProjectМenu = scan.nextLine();
                            switch (FilterSelectionProjectМenu) {
                                case "1": {
                                    try {
                                        sysOut.print("Введите номер проекта:> ");
                                        String NambeProject = scan.nextLine();
                                        menu.setLog("Вывод на экран проектов с номерами "+NambeProject+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterProject(NambeProject, "IdProject"));
                                        menu.getWheleProject(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "2": {
                                    try {
                                        sysOut.print("Введите имя проекта:> ");
                                        String NameProject = scan.nextLine();
                                        menu.setLog("Вывод на экран проектов с именами "+NameProject+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterProject(NameProject, "NameProject"));
                                        menu.getWheleProject(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "3": {
                                    break;
                                } 
                                default: {
                                    sysOut.println("Введите корректный номер сущности!");
                                    break;
                                }
                            }
                            break;
                        }
                        case "3": {
                            menu.getFilterSelectionTaskМenu();
                            String FilterSelectionTaskМenu = scan.nextLine();
                            switch (FilterSelectionTaskМenu) {
                                case "1": {
                                    try{
                                        sysOut.print("Введите номер задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с номерами "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "IdTask"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "2": {
                                    try{
                                        sysOut.print("Введите тему задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с темой "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "TopicTask"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "3": {
                                    try{
                                        sysOut.print("Введите проект задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с проектом "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "ProjectId"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "4": {
                                    try{
                                        sysOut.print("Введите тип задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с типом "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "TypeId"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "5": {
                                    try{
                                        sysOut.print("Введите приоритет задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с приоритетом "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "PriorityId"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "6": {
                                    try{
                                        sysOut.print("Введите пользователя задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с пользователем "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "UserId"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "7": {
                                    try{
                                        sysOut.print("Введите описание задачи:> ");
                                        String Task = scan.nextLine();
                                        menu.setLog("Вывод на экран задач с описанием "+Task+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getSelectFilterTask(Task, "DescriptionTask"));
                                        menu.getWheleTask(resultSet);
                                    } catch (SQLException e){
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                } 
                                case "8": {
                                    break;
                                } 
                                default: {
                                    sysOut.println("Введите корректный номер сущности!");
                                    break;
                                }
                            }
                            break;
                        }
                        case "4": {
                            break;
                        }
                        default: {
                            sysOut.println("Введите корректный номер сущности!");
                            break;
                        }
                    }
                    break;
                }
                case "3": {
                    menu.getEntitySelectionMenu();
                    String UpdateEntity = scan.nextLine();
                    switch (UpdateEntity) {
                        case "1": {
                            try{
                                menu.setLog("Добавление нового пользователя.");
                                prepareStatement = connection.prepareStatement(menu.getInsertUser());
                                sysOut.print("Введите фамилию нового пользователя:> ");
                                prepareStatement.setString(1, scan.nextLine());
                                sysOut.print("Введите имя нового пользователя:> ");
                                prepareStatement.setString(2, scan.nextLine());
                                sysOut.print("Введите отчество нового пользователя:> ");
                                prepareStatement.setString(3, scan.nextLine());
                                sysOut.print("Введите должность нового пользователя:> ");
                                prepareStatement.setString(4, scan.nextLine());
                                prepareStatement.execute();
                                sysOut.println("Пользователь успешно добавлен!");
                            } catch (SQLException e){
                                menu.setLog("Error: " + e);
                                sysOut.println("Вы ввели некорректные данные! Пользователь не был зарегистрирован!");
                            }
                            break;
                        }
                        case "2": {
                            try{
                                menu.setLog("Добавление нового проекта.");
                                prepareStatement = connection.prepareStatement(menu.getInsertProject());
                                sysOut.print("Введите название нового проекта:> ");
                                prepareStatement.setString(1, scan.nextLine());
                                prepareStatement.execute();
                                sysOut.println("Проект успешно добавлен!");
                            } catch (SQLException e){
                                menu.setLog("Error: " + e);
                                sysOut.println("Вы ввели некорректные данные! Проект не был зарегистрирован!");
                            }
                            break;
                        }
                        case "3": {
                            try{
                                menu.setLog("Добавление новой задачи.");
                                prepareStatement = connection.prepareStatement(menu.getInsertTask());
                                sysOut.print("Введите тему новой задачи:> ");
                                prepareStatement.setString(1, scan.nextLine());
                                sysOut.print("Введите номер проекта новой задачи:> ");
                                prepareStatement.setString(2, scan.nextLine());
                                sysOut.print("Введите номер типа новой задачи:> ");
                                prepareStatement.setString(3, scan.nextLine());
                                sysOut.print("Введите номер приоритета новой задачи:> ");
                                prepareStatement.setString(4, scan.nextLine());
                                sysOut.print("Введите номер исполнителя новой задачи:> ");
                                prepareStatement.setString(5, scan.nextLine());
                                sysOut.print("Введите описание новой задачи:> ");
                                prepareStatement.setString(6, scan.nextLine());
                                prepareStatement.execute();
                                sysOut.println("Задача успешно добавлена!");
                            } catch (SQLException e){
                                menu.setLog("Error: " + e);
                                sysOut.println("Вы ввели некорректные данные! Задача не была зарегистрирована!");
                            }
                            break;
                        }
                        case "4": {
                            break;
                        }
                        default: {
                            sysOut.println("Введите корректный номер сущности!");
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    menu.getEntitySelectionMenu();
                    String UpdateEntity = scan.nextLine();
                    switch (UpdateEntity) {
                        case "1": {
                            menu.getUserValueSelectionMenu();
                            String value  = scan.nextLine();
                            switch (value) {
                                case "1": {
                                    try {
                                        sysOut.print("Введите номер пользователя:> ");
                                        String UpUser = scan.nextLine();
                                        sysOut.print("Введите новоую фамилию пользователя:> ");
                                        String UpNameUser = scan.nextLine();
                                        menu.setLog("Обновление фамилии пользователя под номером "+UpUser+".");
                                        statement.executeUpdate(menu.getUpdate("user", "SurnameUser", "'"+UpNameUser+"'", "IdUser", UpUser));
                                        sysOut.println("Пользователь обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "2": {
                                    try {
                                        sysOut.print("Введите номер пользователя:> ");
                                        String UpUser = scan.nextLine();
                                        sysOut.print("Введите новое имя пользователя:> ");
                                        String UpNameUser = scan.nextLine();
                                        menu.setLog("Обновление имени пользователя под номером "+UpUser+".");
                                        statement.executeUpdate(menu.getUpdate("user", "NameUser", "'"+UpNameUser+"'", "IdUser", UpUser));
                                        sysOut.println("Пользователь обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "3": {
                                    try {
                                        sysOut.print("Введите номер пользователя:> ");
                                        String UpUser = scan.nextLine();
                                        sysOut.print("Введите новое отчество пользователя:> ");
                                        String UpNameUser = scan.nextLine();
                                        menu.setLog("Обновление отчества пользователя под номером "+UpUser+".");
                                        statement.executeUpdate(menu.getUpdate("user", "MiddleNameUser", "'"+UpNameUser+"'", "IdUser", UpUser));
                                        sysOut.println("Пользователь обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "4": {
                                    try {
                                        sysOut.print("Введите номер пользователя:> ");
                                        String UpUser = scan.nextLine();
                                        sysOut.print("Введите новую должность пользователя:> ");
                                        String UpNameUser = scan.nextLine();
                                        menu.setLog("Обновление должности пользователя под номером "+UpUser+".");
                                        statement.executeUpdate(menu.getUpdate("user", "PostUser", "'"+UpNameUser+"'", "IdUser", UpUser));
                                        sysOut.println("Пользователь обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "5": {
                                    try {
                                        sysOut.print("Введите номер пользователя:> ");
                                        String UpUser = scan.nextLine();
                                        sysOut.print("Введите новый статус активности пользователя(1/0):> ");
                                        String UpNameUser = scan.nextLine();
                                        menu.setLog("Обновление статуса пользователя под номером "+UpUser+".");
                                        statement.executeUpdate(menu.getUpdate("user", "ActivUser", "'"+UpNameUser+"'", "IdUser", UpUser));
                                        sysOut.println("Пользователь обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "6": {
                                    break;
                                }
                                default: {
                                    sysOut.println("Введите корректный номер атрибута!");
                                    break;
                                }
                            }
                            break;
                        }
                        case "2": {
                            menu.getProjectValueSelectionMenu();
                            String value  = scan.nextLine();
                            switch (value) {
                                case "1": {
                                    try {
                                        sysOut.print("Введите номер проекта:> ");
                                        String UpProject = scan.nextLine();
                                        sysOut.print("Введите новое имя проекта:> ");
                                        String UpNameProject = scan.nextLine();
                                        menu.setLog("Обновление имени проекта под номером "+UpProject+".");
                                        statement.executeUpdate(menu.getUpdate("project", "NameProject", "'"+UpNameProject+"'", "IdProject", UpProject));
                                        sysOut.println("Проект обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "2": {
                                    try {
                                        sysOut.print("Введите номер проекта:> ");
                                        String UpProject = scan.nextLine();
                                        sysOut.print("Введите статус активности проекта (1/0):> ");
                                        String UpNameProject = scan.nextLine();
                                        menu.setLog("Обновление статуса проекта под номером "+UpProject+".");
                                        statement.executeUpdate(menu.getUpdate("project", "ActivProject", "'"+UpNameProject+"'", "IdProject", UpProject));
                                        sysOut.println("Проект обновлён!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "3": {
                                    break;
                                }
                                default: {
                                    sysOut.println("Введите корректный номер атрибута!");
                                    break;
                                }
                            }
                            
                            break;
                        }
                        case "3": {
                            menu.getTaskValueSelectionMenu();
                            String value  = scan.nextLine();
                            switch (value) {
                                case "1": {
                                    try {
                                        sysOut.print("Введите номер задачи:> ");
                                        String UpTask = scan.nextLine();
                                        sysOut.print("Введите новую тему задачи:> ");
                                        String UpNameTask = scan.nextLine();
                                        menu.setLog("Обновление темы задачи под номером "+UpTask+".");
                                        statement.executeUpdate(menu.getUpdate("task", "TopicTask", "'"+UpNameTask+"'", "IdTask", UpTask));
                                        sysOut.println("Задача обновлена!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "2": {
                                    try {
                                        sysOut.print("Введите номер задачи:> ");
                                        String UpTask = scan.nextLine();
                                        sysOut.print("Введите новый проект для задачи:> ");
                                        String UpNameTask = scan.nextLine();
                                        menu.setLog("Обновление проекта задачи под номером "+UpTask+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getCountNotAnd("Project", "IdProject", UpNameTask));
                                        if (Integer.parseInt(menu.getWheleCount(resultSet)) == 0){
                                            System.out.println("Такого проекта нет!");
                                            break;
                                        } else {
                                            statement.executeUpdate(menu.getUpdate("task", "ProjectId", UpNameTask, "IdTask", UpTask));
                                        }   
                                        sysOut.println("Задача обновлена!"); 
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "3": {
                                    try {
                                        sysOut.print("Введите номер задачи:> ");
                                        String UpTask = scan.nextLine();
                                        sysOut.print("Введите номер нового типа задачи:> ");
                                        String UpNameTask = scan.nextLine();
                                        menu.setLog("Обновление типа задачи под номером "+UpTask+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getCountNotAnd("type", "TypeId", UpNameTask));
                                        if (Integer.parseInt(menu.getWheleCount(resultSet)) == 0){
                                            System.out.println("Такого типа нет!");
                                            break;
                                        } else {
                                            statement.executeUpdate(menu.getUpdate("task", "TypeId", UpNameTask, "IdTask", UpTask));
                                        }   
                                        sysOut.println("Задача обновлена!");                                         
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "4": {
                                    try {
                                        sysOut.print("Введите номер задачи:> ");
                                        String UpTask = scan.nextLine();
                                        sysOut.print("Введите номер нового приоритета задачи:> ");
                                        String UpNameTask = scan.nextLine();
                                        menu.setLog("Обновление приоритета задачи под номером "+UpTask+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getCountNotAnd("priority", "PriorityId", UpNameTask));
                                        if (Integer.parseInt(menu.getWheleCount(resultSet)) == 0){
                                            System.out.println("Такого приоритета нет!");
                                            break;
                                        } else {
                                            statement.executeUpdate(menu.getUpdate("task", "PriorityId", UpNameTask, "IdTask", UpTask));
                                        }   
                                        sysOut.println("Задача обновлена!");  
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "5": {
                                    try {
                                        sysOut.print("Введите номер задачи:> ");
                                        String UpTask = scan.nextLine();
                                        sysOut.print("Введите номер нового исполнителя задачи:> ");
                                        String UpNameTask = scan.nextLine();
                                        menu.setLog("Обновление исполнителя задачи под номером "+UpTask+".");
                                        ResultSet resultSet = statement.executeQuery(menu.getCountNotAnd("User", "IdUser", UpNameTask));
                                        if (Integer.parseInt(menu.getWheleCount(resultSet)) == 0){
                                            System.out.println("Такого исполнителя нет!");
                                            break;
                                        } else {
                                            statement.executeUpdate(menu.getUpdate("task", "UserId", UpNameTask, "IdTask", UpTask));
                                        }   
                                        sysOut.println("Задача обновлена!"); 
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "6": {
                                    try {
                                        sysOut.print("Введите номер задачи:> ");
                                        String UpTask = scan.nextLine();
                                        sysOut.print("Введите новое описание задачи:> ");
                                        String UpNameTask = scan.nextLine();
                                        menu.setLog("Обновление описания задачи под номером "+UpTask+".");
                                        statement.executeUpdate(menu.getUpdate("task", "DescriptionTask", "'"+UpNameTask+"'", "IdTask", UpTask));
                                        sysOut.println("Задача обновлена!");                             
                                    } catch (SQLException e) {
                                        menu.setLog("Error: " + e);
                                    }
                                    break;
                                }
                                case "7": {
                                    break;
                                }
                                default: {
                                    sysOut.println("Введите корректный номер атрибута!");
                                    break;
                                }
                            }
                            break;
                        }
                        case "4": {
                            break;
                        }
                        default: {
                            sysOut.println("Введите корректный номер сущности!");
                            break;
                        }
                    }
                    break;
                }
                case "5": {
                    menu.getEntitySelectionMenu();
                    String DeleteEntity = scan.nextLine();
                    switch (DeleteEntity) {
                        case "1": {
                            try {
                                sysOut.print("Введите порядковый номер пользователя:> ");
                                String DelProject = scan.nextLine();
                                menu.setLog("Удаленеи пользователя под номером "+DelProject+".");
                                ResultSet resultSet = statement.executeQuery(menu.getCount("Task", "UserId", DelProject));
                                if (Integer.parseInt(menu.getWheleCount(resultSet)) != 0){
                                    menu.setLog("Неудачное удаленеи пользователя под номером "+DelProject+".");
                                    System.out.println("Уданного пользователя остались незакрытые задачи!");
                                    System.out.println("Закройте их и сможете удалить пользователя");
                                    break;
                                } else {
                                    statement.executeUpdate(menu.getUpdate("user", "ActivUser", "0", "IdUser", DelProject));
                                }   
                                sysOut.println("Пользователь удалён!");                             
                            } catch (SQLException e) {
                                menu.setLog("Error: " + e);
                            }
                            break;
                        }
                        case "2": {
                            try {
                                sysOut.print("Введите порядковый номер проекта:> ");
                                String DelProject = scan.nextLine();
                                menu.setLog("Удаленеи проекта под номером "+DelProject+".");
                                ResultSet resultSet = statement.executeQuery(menu.getCount("Task", "ProjectId", DelProject));
                                if (Integer.parseInt(menu.getWheleCount(resultSet)) != 0){
                                    menu.setLog("Неудачное удаленеи проекта под номером "+DelProject+".");
                                    System.out.println("На данном проекте есть незакрытые задачи!");
                                    System.out.println("Закройте их и сможете удалить проект");
                                    break;
                                } else {
                                    statement.executeUpdate(menu.getUpdate("project", "ActivProject", "0", "IdProject", DelProject));
                                }   
                                sysOut.println("Проект удалён!");                             
                            } catch (SQLException e) {
                                menu.setLog("Error: " + e);
                            }
                            break;
                        }
                        case "3": {
                            try {
                                sysOut.println("Внимание! Задачи удалить нельзя! Данная функция просто закроет указанную вами задачу.");
                                sysOut.print("Введите порядковый номер задачи:> ");
                                String DelProject = scan.nextLine();
                                menu.setLog("Закрытие задачи под номером "+DelProject+".");
                                statement.executeUpdate(menu.getUpdate("task", "TypeId", "4", "IdTask", DelProject));
                                sysOut.println("Задача закрыта!");                             
                            } catch (SQLException e) {
                                menu.setLog("Error: " + e);
                            }
                            break;
                        }
                        case "4": {
                            break;
                        }
                        default: {
                            sysOut.println("Введите корректный номер сущности!");
                            break;
                        }
                    }
                    break;
                }
                case "6": { 
                    try {
                        statement.executeUpdate("CREATE TABLE `priority` ( " +
                            "`PriorityId` INT NOT NULL AUTO_INCREMENT, " +
                            "`NamePriority` VARCHAR(128) NOT NULL, " +
                            "PRIMARY KEY (`PriorityId`), " +
                            "UNIQUE INDEX `PriorityId_UNIQUE` (`PriorityId` ASC) VISIBLE);");
                        statement.executeUpdate("CREATE TABLE `type` ( " +
                            "`TypeId` INT NOT NULL AUTO_INCREMENT, " +
                            "`NameType` VARCHAR(128) NOT NULL, " +
                            "PRIMARY KEY (`TypeId`), " + 
                            "UNIQUE INDEX `TypeId_UNIQUE` (`TypeId` ASC) VISIBLE);");
                        statement.executeUpdate("INSERT INTO Priority (NamePriority) VALUE " +
                            "('Низкий'), " +
                            "('Средний'), " +
                            "('Высокий'), " +
                            "('Наивысший');");
                        statement.executeUpdate("INSERT INTO Type (NameType) VALUE " +
                            "('Новая'), " +
                            "('В работе'), " +
                            "('Решена'), " +
                            "('Закрыта');");
                        statement.executeUpdate("CREATE TABLE `project` ( " +
                            "`IdProject` INT NOT NULL AUTO_INCREMENT, " +
                            "`NameProject` VARCHAR(128) NOT NULL DEFAULT 'NameProject', " +
                            "`ActivProject` TINYINT NOT NULL DEFAULT 1, " +
                            "PRIMARY KEY (`IdProject`), " +
                            "UNIQUE INDEX `IdProject_UNIQUE` (`IdProject` ASC) VISIBLE);");
                        statement.executeUpdate("CREATE TABLE `user` ( " +
                            "`IdUser` INT NOT NULL AUTO_INCREMENT, " +
                            "`SurnameUser` VARCHAR(128) NOT NULL DEFAULT 'SurnameUser', " +
                            "`NameUser` VARCHAR(128) NOT NULL DEFAULT 'NameUser', " +
                            "`MiddleNameUser` VARCHAR(128) NULL, " +
                            "`PostUser` VARCHAR(128) NOT NULL DEFAULT 'Post', " +
                            "`ActivUser` VARCHAR(128) NOT NULL DEFAULT '1', " +
                            "PRIMARY KEY (`IdUser`), " +
                            "UNIQUE INDEX `IdUser_UNIQUE` (`IdUser` ASC) VISIBLE);");   
                        statement.executeUpdate("CREATE TABLE Task ( " + 
                            "IdTask INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                            "TopicTask  VARCHAR(100) NOT NULL DEFAULT 'TopicTask', " +
                            "ProjectId  INT NOT NULL, " +
                            "TypeId INT NOT NULL DEFAULT 1, " +
                            "PriorityId INT NOT NULL DEFAULT 1, " +
                            "UserId INT NOT NULL, " +
                            "DescriptionTask VARCHAR(500), " +
                            "FOREIGN KEY (ProjectId) REFERENCES Project (IdProject), " + 
                            "FOREIGN KEY (TypeId) REFERENCES Type (TypeId), " +
                            "FOREIGN KEY (PriorityId) REFERENCES Priority (PriorityId), " +
                            "FOREIGN KEY (UserId) REFERENCES User (IdUser));");   
                        } catch (SQLException e) {
                            menu.setLog("Error: " + e);
                            sysOut.println("Error: " + e);
                        } 
                    break;
                }
                case "7": { 
                    run = false;
                    break;
                }
                default: 
                    sysOut.println("Введите корректный номер действия!");
                    break;
            }
        }
        scan.close();
    }
}
