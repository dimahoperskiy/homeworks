import dao.QuestionDao;
import models.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import services.*;
import utils.HibernateSessionFactoryUtil;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupService groupService = new GroupService();
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        SubjectService subjectService = new SubjectService();
        QuestionService questionService = new QuestionService();

        Group group1 = new Group("ПИ19-2", 2019);
        Group group2 = new Group("ПИ19-3", 2019);
        Group group3 = new Group("ПИ19-1", 2019);


        User user1 = new User("Дмитрий", "Хопёрский", "Юрьевич",
                "dimahoperskiy", "321");
        User user2 = new User("Олег", "Петров", "Игоревич",
                "simon", "221");
        User user3 = new User("Антон", "Поров", "Олегович",
                "antony", "111");
        User user4 = new User("Анастасия", "Прон", "Юрьевна",
                "stacy", "035");
        User user5 = new User("Даниил", "Милованов", "Михайлович",
                "javalord", "534");
        User user6 = new User("Егор", "Крид", "Алишерович",
                "kreed", "332");
        User user7 = new User("Михаил", "Коротеев", "Викторович",
                "unixlord", "332");
        User user8 = new User("Сергей", "Присада", "Анатольевич",
                "oracle", "445");
        User user9 = new User("Достонжон", "Баротов", "Нумонжонович",
                "molecular", "911");


        group1.setUserList(List.of(user1, user2, user6));
        group2.addUser(user3);
        group3.addUser(user4);

        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        groupService.saveGroup(group3);


        Role student = new Role("Студент");
        Role teacher = new Role("Преподаватель");
        Role admin = new Role("Администратор");

        student.setUserList(List.of(user1, user2, user3, user4, user6));
        teacher.setUserList(List.of(user7, user8, user9));
        admin.setUser(user5);

        roleService.saveRole(student);
        roleService.saveRole(teacher);
        roleService.saveRole(admin);


        Subject subject1 = new Subject("Java");
        Subject subject2 = new Subject("Python");
        Subject subject3 = new Subject("Система управления базами данных");
        Subject subject4 = new Subject("ОС семейства UNIX");

        TestList testList1 = new TestList("Экзамен");
        TestList testList2 = new TestList("Зачет");
        TestList testList3 = new TestList("Контрольная работа");
        TestList testList4 = new TestList("Экзамен");
        TestList testList5 = new TestList("Самостоятельная работа");
        TestList testList6 = new TestList("Экзамен");
        TestList testList7 = new TestList("Летучка");
        TestList testList8 = new TestList("Лабораторная работа");

        subject1.setTestListList(List.of(testList1, testList3));
        subject2.addTestList(testList2);
        subject3.setTestListList(List.of(testList4, testList5));
        subject4.setTestListList(List.of(testList6, testList7, testList8));

        user5.setTestListList(List.of(testList1, testList3));
        user9.addTestList(testList2);
        user8.setTestListList(List.of(testList4, testList5));
        user7.setTestListList(List.of(testList6, testList7, testList8));

        subjectService.saveSubject(subject1);
        subjectService.saveSubject(subject2);
        subjectService.saveSubject(subject3);
        subjectService.saveSubject(subject4);


        Question question1 = new Question("Что не является принципом ООП?", 2, true);
        Answer answer1 = new Answer("Трансмиссия", true);
        Answer answer2 = new Answer("Инкапсуляция", false);
        Answer answer3 = new Answer("Полиморфизм", false);
        question1.setAnswerList(new ArrayList<>(List.of(answer1, answer2, answer3)));

        Question question2 = new Question("Какой класс содержит в себе ArrayList и HashMap?", 2, true);
        Answer answer4 = new Answer("Hibernate", false);
        Answer answer5 = new Answer("Swing", false);
        Answer answer6 = new Answer("Collections", true);
        question2.setAnswerList(new ArrayList<>(List.of(answer4, answer5, answer6)));

        Question question5 = new Question("Какой Java фреймворк используется для написания сайтов?", 2, true);
        Answer answer12 = new Answer("Spring", true);
        Answer answer13 = new Answer("Flask", false);
        Answer answer14 = new Answer(".NET", false);
        question5.setAnswerList(List.of(answer12, answer13, answer14));

        Question question6 = new Question("Какой фремворк используется для написания GUI?", 2, true);
        Answer answer15 = new Answer("Swing", true);
        Answer answer16 = new Answer("Spring", false);
        Answer answer17 = new Answer("Hibernate", false);
        question6.setAnswerList(List.of(answer15, answer16, answer17));



        Question question3 = new Question("Что из перечисленного является дистрибутивом Linux?", 2, true);
        Answer answer7 = new Answer("React", false);
        Answer answer8 = new Answer("Angular", false);
        Answer answer9 = new Answer("Debian", true);
        question3.setAnswerList((List.of(answer7, answer8, answer9)));

        Question question7 = new Question("Какая команда открывает консольный графический редактор?", 2, true);
        Answer answer18 = new Answer("chmod", false);
        Answer answer19 = new Answer("sudo", false);
        Answer answer20 = new Answer("nano", true);
        question7.setAnswerList(List.of(answer18, answer19, answer20));

        Question question8 = new Question("Какая команда печатает текущую директорию?", 2, true);
        Answer answer21 = new Answer("cat", false);
        Answer answer22 = new Answer("pwd", true);
        Answer answer23 = new Answer("mkdir", false);
        question8.setAnswerList(List.of(answer21, answer22, answer23));


        Question question4 = new Question("Какой из языков является языком функионального программирования?", 2, true);
        Answer answer10 = new Answer("Java", false);
        Answer answer11 = new Answer("Python", true);
        question4.setAnswerList(List.of(answer10, answer11));

        Question question9 = new Question("Какая переменная ссылается на объект своего класса?", 2, true);
        Answer answer24 = new Answer("this", false);
        Answer answer25 = new Answer("self", true);
        question9.setAnswerList(List.of(answer24, answer25));


        Question question10 = new Question("Что из перечисленного является СУБД?", 2, true);
        Answer answer26 = new Answer("SQL", false);
        Answer answer27 = new Answer("PostgreSql", true);
        question10.setAnswerList(List.of(answer26, answer27));



        questionService.saveQuestion(question1);
        questionService.saveQuestion(question2);
        questionService.saveQuestion(question3);
        questionService.saveQuestion(question4);
        questionService.saveQuestion(question5);
        questionService.saveQuestion(question6);
        questionService.saveQuestion(question7);
        questionService.saveQuestion(question8);
        questionService.saveQuestion(question9);
        questionService.saveQuestion(question10);


        Schedule schedule1 = new Schedule(90, Date.valueOf("2020-11-23"), Time.valueOf("9:00:00"),
                Date.valueOf("2020-11-23"), Time.valueOf("10:30:00"), true);
        Schedule schedule2 = new Schedule(90, Date.valueOf("2020-11-23"), Time.valueOf("11:00:00"),
                Date.valueOf("2020-11-23"), Time.valueOf("12:30:00"), true);
        Schedule schedule3 = new Schedule(90, Date.valueOf("2020-11-24"), Time.valueOf("9:00:00"),
                Date.valueOf("2020-11-24"), Time.valueOf("10:30:00"), true);
        Schedule schedule4 = new Schedule(90, Date.valueOf("2020-11-24"), Time.valueOf("13:30:00"),
                Date.valueOf("2020-11-24"), Time.valueOf("15:00:00"), true);

        testList1.addSchedule(schedule1);
        testList2.addSchedule(schedule2);
        testList3.addSchedule(schedule3);
        testList4.addSchedule(schedule4);

        group1.setScheduleList(List.of(schedule1, schedule2));
        group2.setScheduleList(List.of(schedule3, schedule4));

        groupService.updateGroup(group1);
        groupService.updateGroup(group2);

        Test test1 = new Test(question1);
        Test test2 = new Test(question2);
        Test test5 = new Test(question5);
        Test test6 = new Test(question6);
        testList1.setTestList(List.of(test1, test2, test5, test6));

        StudentAnswer studentAnswer1 = new StudentAnswer();
        StudentAnswer studentAnswer2 = new StudentAnswer();
        StudentAnswer studentAnswer3 = new StudentAnswer();
        StudentAnswer studentAnswer4 = new StudentAnswer();

        studentAnswer1.create(user1, testList1, answer1);
        studentAnswer2.create(user1, testList1, answer6);
        studentAnswer3.create(user1, testList1, answer12);
        studentAnswer4.create(user1, testList1, answer15);

        subjectService.updateSubject(testList1.getSubject());
        userService.updateUser(user1);


        Test test3 = new Test(question3);
        Test test7 = new Test(question7);
        Test test8 = new Test(question8);
        testList7.setTestList(List.of(test3, test7, test8));

        StudentAnswer studentAnswer5 = new StudentAnswer();
        StudentAnswer studentAnswer6 = new StudentAnswer();
        StudentAnswer studentAnswer7 = new StudentAnswer();
        StudentAnswer studentAnswer8 = new StudentAnswer();

        studentAnswer5.create(user2, testList7, answer1);
        studentAnswer6.create(user2, testList7, answer6);
        studentAnswer7.create(user2, testList7, answer12);
        studentAnswer8.create(user2, testList7, answer15);

        subjectService.updateSubject(testList7.getSubject());
        userService.updateUser(user2);



































        System.out.println(group1.getUserList());
        System.out.println(groupService.findGroup(1).getUserList());





//
//
//        System.out.println(groupService.findAllGroups());
//        System.out.println("--------------------------");
//        System.out.println(userService.findAllUsers());


    }


}
