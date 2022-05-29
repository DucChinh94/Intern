package TeacherSalaryManagement;

import Book_Borrowing_Management.Book;

import java.util.Scanner;

public class Service {
    Teacher[] teachers = new Teacher[100];
    Subject[] subjects = new Subject[100];
    Management[] managements = new Management[100];
    Management management = new Management();

    public void addTeacher() {
        System.out.print("nhap so giang vien moi duoc them vao: ");
        int teacherNumber = -1;
        do {
            teacherNumber = new Scanner(System.in).nextInt();
            if (teacherNumber < 0) System.out.println("Nhap sai! Moi nhap lai.");
        } while (teacherNumber < 0);
        for (int i = 0; i < teacherNumber; i++) {
            System.out.println("nhap thong tin giang vien them vao thu " + (i + 1));
            Teacher teacher = new Teacher();
            teacher.inputTeacher();
            saveTeacher(teacher);
        }
    }

    private void saveTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
        }
    }

    public void showTeacher() {
        System.out.println("Danh sach giang vien: ");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) break;
            else System.out.println("No " + (i + 1) + " : " + teachers[i].toString());
        }
    }

    public void addSubject() {
        System.out.print("Nhap so mon hoc moi duoc them vao: ");
        int subjectNumber = -1;
        do {
            subjectNumber = new Scanner(System.in).nextInt();
            if (subjectNumber < 0) System.out.println("Nhap sai! Moi nhap lai.");
        } while (subjectNumber < 0);
        for (int i = 0; i < subjectNumber; i++) {
            System.out.println("nhap thong tin mon hoc them vao thu " + (i + 1));
            Subject subject = new Subject();
            subject.inputInfo();
            saveSubject(subject);
        }
    }

    private void saveSubject(Subject subject) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                subjects[i] = subject;
                break;
            }
        }
    }

    public void showSubject() {
        System.out.println("Danh sach mon hoc: ");
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) break;
            System.out.println("No " + (i + 1) + " : " + subjects[i].toString());
        }
    }

    public void declarationTableManagement() {
        managements = management.declarationTable(managements, teachers, subjects);
        management.showDeclarationTable(managements);
    }

    public void printSortByName() {
        System.out.println("Bảng kê khai sau khi sắp xếp theo tên");
        managements = management.sortByName(managements);
        management.showDeclarationTable(managements);
    }

    public void printSortByLessonQuantity() {
        System.out.println("Bảng kê khai sau khi sắp xếp theo số tiết");
        managements = management.sortByLessonQuantity(managements);
        management.showDeclarationTable(managements);
    }

    public void salaryTable() {
        System.out.println("Bang luong");
        management.salary(managements);
    }
}
