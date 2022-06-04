package StudentGPAMangement.Management;

import StudentGPAMangement.entity.Subject;
import StudentGPAMangement.service.Service;
import StudentGPAMangement.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectManagement {
public static final String SUBJECTDATAFILE = "subject.dat";
public void addNewSubject(){
    System.out.println("Nhap so sach moi: ");
    int subjectNumber = -1;
    do {
        try {
            subjectNumber = new Scanner(System.in).nextInt();
            if (subjectNumber > 0) break;
            System.out.println("Nhap sai dinh dang. Nhap lai dang so nguyen duong");
        } catch (InputMismatchException e){
            System.out.println("Nhap sai dinh dang. Nhap lai dang so nguyen");
        }
    } while (true);
    for (int i=0; i<subjectNumber;i++){
        Subject subject = new Subject();
        subject.inputSubject();
        addSubjectToArray(subject);
    }
    Service.fileUtil.writeDataToFile(Service.subjects,SUBJECTDATAFILE);
    }

    private void addSubjectToArray(Subject subject) {
        for (int i = 0; i < Service.subjects.length; i++) {
            if(DataUtil.isNullOrEmpty(Service.subjects[i])){
                Service.subjects[i] = subject;
                break;
            }
        }
    }

    public void showSubjects(){
        System.out.println("Danh sach mon hoc");
        for (int i = 0; i < Service.subjects.length; i++) {
            Subject subject = Service.subjects[i];
            if (DataUtil.isNullOrEmpty(subject)){
                break;
            }
            System.out.println(subject.toString());
        }
    }

    public Subject checckSubjectId(int subjectId){
    Subject subject;
    for (Subject value: Service.subjects){
        if (DataUtil.isNullOrEmpty(value)) return null;
        if (value.getSubjectId() == subjectId){
            subject = value;
            return subject;
        }
    }
    return null;
    }
}

