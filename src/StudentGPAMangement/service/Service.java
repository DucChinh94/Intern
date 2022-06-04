package StudentGPAMangement.service;

import StudentGPAMangement.Management.StudentManagement;
import StudentGPAMangement.Management.SubjectManagement;
import StudentGPAMangement.Management.TranscriptManagement;
import StudentGPAMangement.entity.Student;
import StudentGPAMangement.entity.Subject;
import StudentGPAMangement.entity.Transcript;
import StudentGPAMangement.util.DataUtil;
import StudentGPAMangement.util.file.FileUtil;

public class Service {
    public static Student[] students;
    public static Subject[] subjects;
    public static Transcript[] transcripts;
    public static TranscriptManagement transcriptManagement = new TranscriptManagement();
    public static StudentManagement studentManagement = new StudentManagement();
    public static SubjectManagement subjectManagement = new SubjectManagement();
    public static FileUtil fileUtil = new FileUtil();
    public static void initializeData(){
        Object teacherFromFile = fileUtil.readDataFromFile(StudentManagement.STUDENTDATAFILE);
        students = DataUtil.isNullOrEmpty(teacherFromFile) ? new Student[100] : (Student[]) teacherFromFile;

        Object subjectFromFile = fileUtil.readDataFromFile(SubjectManagement.SUBJECTDATAFILE);
        subjects = DataUtil.isNullOrEmpty(subjectFromFile) ? new Subject[100] : (Subject[]) subjectFromFile;
    }
}
