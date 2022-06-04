package StudentGPAMangement.Management;

import StudentGPAMangement.entity.Student;
import StudentGPAMangement.service.Service;
import StudentGPAMangement.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagement {
    public static final String STUDENTDATAFILE = "student.dat";
    public void addNewStudent(){
        System.out.print("nhap so sinh vien moi: ");
        int studentNumber = -1;
        do {
            try {
                studentNumber = new Scanner(System.in).nextInt();
                if (studentNumber > 0) break;
                System.out.println("Nhap sai dinh dang. Xin moi nhap lai la la dang so nguyen duong");
            } catch (InputMismatchException e){
                System.out.println("Nhap sai dinh dang. Xin moi nhap lai la la dang so nguyen");
            }
        } while (true);
        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student();
            student.inputInfo();
            addStudentToArray(student);
        }
        Service.fileUtil.writeDataToFile(Service.students, STUDENTDATAFILE);
    }

    private void addStudentToArray(Student student) {
        for (int i = 0; i < Service.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Service.students[i])) {
                Service.students[i] = student;
                break;
            }
        }
    }

    public void showStudents() {
        System.out.println("Danh sách sinh viên");
        for (int i = 0; i < Service.students.length; i++) {
            Student student = Service.students[i];
            if (DataUtil.isNullOrEmpty(student)) {
                break;
            }
            System.out.println(student.toString());
        }
    }

    public Student checkStudentId(int studentId){
        Student student;
        for (int i = 0; i < Service.students.length; i++){
            if (DataUtil.isNullOrEmpty(Service.students[i])) {
                return null;
            }
            if (Service.students[i].getStudentId() == studentId) {
                student = Service.students[i];
                return student;
            }
        }
        return null;
    }
}
