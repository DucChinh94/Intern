package StudentGPAMangement.main;

import StudentGPAMangement.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.initializeData();
        int choice = -1;

            do {
                System.out.println("\n\n==================PHẦN MỀM QUẢN LÝ ĐIỂM SINH VIÊN==================\n\n");
                System.out.println("1. Nhập danh sách sinh viên mới");
                System.out.println("2. In ra sanh sách sinh viên");
                System.out.println("3. Nhập danh sách môn học mới");
                System.out.println("4. In ra danh sách môn học");
                System.out.println("5. Lập bảng điểm cho sinh viên");
                System.out.println("6. Sắp xếp danh sách bảng điểm theo học tên sinh viên");
                System.out.println("7. Sắp xếp danh sách bảng điểm theo tên môn học");
                System.out.println("8. Tính điểm tổng kết chung cho mỗi sinh viên");
                System.out.println("0. Kết thúc chương trình");
                System.out.println("------------------------------------------------------------------------------");
                System.out.print("chon thao tac thuc hien: ");
                try {
                    choice = new Scanner(System.in).nextInt();
                    if (choice > 0 && choice < 9) {
                        switch (choice) {
                            case 1:
                                Service.studentManagement.addNewStudent();
                                break;
                            case 2:
                                Service.studentManagement.showStudents();
                                break;
                            case 3:
                                Service.subjectManagement.addNewSubject();
                                break;
                            case 4:
                                Service.subjectManagement.showSubjects();
                                break;
                            case 5:
                                Service.transcriptManagement.addNewTranscripts();
                                Service.transcriptManagement.showTranscripts();
                                break;
                            case 6:
                                Service.transcriptManagement.sortTranscriptByStudentName();
                                Service.transcriptManagement.showTranscripts();
                                break;
                            case 7:
                                Service.transcriptManagement.sortTranscriptBySubjectName();
                                Service.transcriptManagement.showTranscripts();
                                break;
                            case 8:
                                Service.transcriptManagement.showGPA();
                                break;
                            case 0:
                                System.out.println("Exit");
                                break;
                        }
                    }
                    else System.out.println("Chi duoc phep nhap tu 0 den 6. Xin moi nhap lai.");
                } catch (InputMismatchException e) {
                    System.out.println("nhap sai dinh dang. Xin moi nhap lai la dang so nguyen");
                }
            } while (true);
    }
}