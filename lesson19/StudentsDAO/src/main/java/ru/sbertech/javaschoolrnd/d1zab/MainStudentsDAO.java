package ru.sbertech.javaschoolrnd.d1zab;

import ru.sbertech.javaschoolrnd.d1zab.daoClasses.StudentVisitsDao;
import ru.sbertech.javaschoolrnd.d1zab.daoClasses.TableUtil;
import ru.sbertech.javaschoolrnd.d1zab.daoClasses.LessonsDao;
import ru.sbertech.javaschoolrnd.d1zab.daoClasses.StudentsDao;
import ru.sbertech.javaschoolrnd.d1zab.model.Lesson;
import ru.sbertech.javaschoolrnd.d1zab.model.Student;
import ru.sbertech.javaschoolrnd.d1zab.model.StudentVisits;
import ru.sbertech.javaschoolrnd.d1zab.view.StudentVisitsConsoleFormatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MainStudentsDAO {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:file:~/test.db";

    public static void main(String[] args) {

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Can't load driver for h2 " + e.getMessage());
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, "user1", "")) {

            System.out.println("\nDrop tables if exist");
            TableUtil.dropTablesForTesting(connection);

            System.out.println("\nCreate tables");
            TableUtil.createTablesIfNotExist(connection);

            //Test StudentDao
            StudentsDao studentsDao = new StudentsDao(connection);

            Student studentNikola = new Student(0, "Nikola", "Tesla");
            Student studentIlon = new Student(0, "Ilon", "Musk");
            Student studentAlbert = new Student(0, "Albert", "Einstein");

            System.out.println("\nAdding students");
            studentsDao.insert(studentNikola);
            studentsDao.insert(studentIlon);
            studentsDao.insert(studentAlbert);

            System.out.println(studentNikola);
            System.out.println(studentIlon);
            System.out.println(studentAlbert);

            System.out.println("\nGetting student from DB by PK");
            System.out.println(studentsDao.getByPK(studentNikola.getId()));

            System.out.println("\nGetting all students from DB");
            studentsDao.getAll().forEach(System.out::println);

            System.out.println("\nUpdate student Einstein");
            studentAlbert.setFirstName("ALBERT");
            studentAlbert.setLastName("EINSTEIN");
            studentsDao.update(studentAlbert);
            System.out.println(studentsDao.getByPK(studentAlbert.getId()));

            System.out.println("\nDelete student Nikola");
            studentsDao.delete(studentNikola);
            studentsDao.getAll().forEach(System.out::println);

            //Test LessonDao
            LessonsDao lessonsDao = new LessonsDao(connection);

            System.out.println("\nAdding lessons");
            Lesson firstLesson = new Lesson(0, "mathematics", Timestamp.valueOf("2019-12-01 09:00:00"));
            Lesson secondLesson = new Lesson(0, "physics", Timestamp.valueOf("2019-12-01 11:00:00"));
            Lesson thirdLesson = new Lesson(0, "programming", Timestamp.valueOf("2019-12-01 13:00:00"));

            lessonsDao.insert(firstLesson);
            lessonsDao.insert(secondLesson);
            lessonsDao.insert(thirdLesson);

            System.out.println("\nGetting lesson from DB by PK");
            System.out.println(lessonsDao.getByPK(firstLesson.getId()));

            System.out.println("\nGetting all lessons from DB");
            lessonsDao.getAll().forEach(System.out::println);

            System.out.println("\nUpdate second lesson");
            secondLesson.setTitle("PHYSICS");
            secondLesson.setDate(Timestamp.valueOf("2019-12-01 11:30:00"));
            lessonsDao.update(secondLesson);
            System.out.println(lessonsDao.getByPK(secondLesson.getId()));

            System.out.println("\nDelete third lesson");
            lessonsDao.delete(thirdLesson);
            lessonsDao.getAll().forEach(System.out::println);

            //Test StudentVisitsDao
            StudentVisitsDao studentVisitsDao = new StudentVisitsDao(connection);

            System.out.println("\nAdding student visits");
            StudentVisits visit1 = new StudentVisits(0, 2,1);
            StudentVisits visit2 = new StudentVisits(0, 3,2);
            StudentVisits visit3 = new StudentVisits(0, 3,1);
            StudentVisits visit4 = new StudentVisits(0, 2,2);

            studentVisitsDao.insert(visit1);
            studentVisitsDao.insert(visit2);
            studentVisitsDao.insert(visit3);
            studentVisitsDao.insert(visit4);

            System.out.println("\nGetting student visits from DB by PK");
            System.out.println(studentVisitsDao.getByPK(visit1.getId()));

            System.out.println("\nGetting all student visits from DB");
            studentVisitsDao.getAll().forEach(System.out::println);

            System.out.println("\nUpdate student visits 3");
            visit3.setStudentId(3);
            visit3.setLessonId(1);
            studentVisitsDao.update(visit3);
            System.out.println(studentVisitsDao.getByPK(visit3.getId()));

            System.out.println("\nDelete student visits 3");
            studentVisitsDao.delete(visit3);
            studentVisitsDao.getAll().forEach(System.out::println);


            StudentVisitsConsoleFormatter.printStudentVisitsEntryList(studentVisitsDao.getAllJoin());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
