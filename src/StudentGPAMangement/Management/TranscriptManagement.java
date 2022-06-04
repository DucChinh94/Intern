package StudentGPAMangement.Management;

import StudentGPAMangement.entity.SubjectScore;
import StudentGPAMangement.entity.Transcript;
import StudentGPAMangement.service.Service;
import StudentGPAMangement.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TranscriptManagement {
    public static final String FILE_NAME = "transcript.dat";

    public int studentNeedToEnterScore() {
        return countStudentFromStudents() - countStudentFromTranscript();
    }

    public int countStudentFromStudents() {
        int count = 0;
        for (int i = 0; i < Service.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Service.students[i])) {
                break;
            }
            count++;
        }
        return count;
    }

    public int countStudentFromTranscript() {
        int count = 0;
        for (int i = 0; i < Service.transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(Service.transcripts[i])) {
                break;
            }
            count++;
        }
        return count;
    }

    public Boolean searchStudentFromTranscript(int studentID) {
        Transcript[] transcripts = Service.transcripts;
        for (Transcript transcript : transcripts) {
            if (DataUtil.isNullOrEmpty(transcript)) {
                return false;
            }
            if (transcript.getStudent().getStudentId() == studentID) {
                return true;
            }
        }
        return false;
    }



    public Boolean searchSubjectFromTranscript(int subjectID, SubjectScore[] subjectScore) {
        for (int i = 0; i < subjectScore.length; i++) {
            SubjectScore score = subjectScore[i];
            if (DataUtil.isNullOrEmpty(score)) {
                return false;
            }
            if (score.getSubject().getSubjectId() == subjectID) {
                return true;
            }
        }
        return false;
    }

    public void addNewTranscripts() {
        int numberSNTES = Service.transcriptManagement.studentNeedToEnterScore();
        System.out.println("Nhập điểm cho sinh viên:");
        if (numberSNTES == 0) {
            System.out.println("Toàn bộ sinh viên đã được nhập điểm");
            return;
        }
        System.out.println("Sô sinh viên chưa nhập điểm: " + numberSNTES);
        System.out.println("Nhập số lượng sinh viên muốn nhập điểm:");
        int number = -1;
        do {
            try {
                number = new Scanner(System.in).nextInt();
                if (number > numberSNTES) {
                    System.out.println("Số lượng sinh viên muốn nhập lớn hơn số lượng sinh viên chưa nhập điểm, mời nhập lại");
                    continue;
                }
                if (number <= 0) {
                    System.out.println("cần nhập số lượng lớn hơn 0. mời nhập lại");
                    continue;
                }
                for (int i = 0; i < number; i++) {
                    Transcript transcript = new Transcript();
                    transcript.inputTranscript();
                    addTranscriptToList(transcript);
                }
                Service.fileUtil.writeDataToFile(Service.transcripts, FILE_NAME);
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng sinh viên phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
    }

    public void addTranscriptToList(Transcript transcript) {
        for (int i = 0; i < Service.transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(Service.transcripts[i])) {
                Service.transcripts[i] = transcript;
                break;
            }
        }
    }

    public void showTranscripts() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Bảng điểm sinh viên");
        Transcript[] transcripts = Service.transcripts;
        for (Transcript transcript : transcripts) {
            if (DataUtil.isNullOrEmpty(transcript)) {
                break;
            }
            System.out.println(transcript);
        }
    }

    public void sortTranscriptByStudentName() {
        Transcript[] transcripts = Service.transcripts;
        for (int i = 0; i < transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(transcripts[i])) {
                break;
            }
            for (int j = i; j < transcripts.length; j++) {
                if (DataUtil.isNullOrEmpty(transcripts[j])) {
                    break;
                }
                if (transcripts[i].getStudent().getFullName()
                        .compareTo(transcripts[j].getStudent().getFullName()) > 0) {
                    Transcript temp = transcripts[i];
                    transcripts[i] = transcripts[j];
                    transcripts[j] = temp;
                }
            }
        }
        Service.transcripts = transcripts;
    }

    public void sortTranscriptBySubjectName() {
        Transcript[] transcripts = Service.transcripts;

        for (int i = 0; i < transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(transcripts[i])) {
                break;
            }
            SubjectScore[] subjectScore = transcripts[i].getScores();
            for (int j = 0; j < subjectScore.length; j++) {
                if (DataUtil.isNullOrEmpty(subjectScore[j])) {
                    break;
                }
                for (int k = j; k < subjectScore.length; k++) {
                    if (DataUtil.isNullOrEmpty(subjectScore[k])) {
                        break;
                    }
                    if (subjectScore[j].getSubject().getSubjectName()
                            .compareTo(subjectScore[k].getSubject().getSubjectName()) > 0) {
                        SubjectScore temp = subjectScore[j];
                        subjectScore[j] = subjectScore[k];
                        subjectScore[k] = temp;
                    }
                }
            }
            transcripts[i].setScores(subjectScore);
        }
        Service.transcripts = transcripts;
    }

    public float calculateGPA(Transcript transcripts) {
        SubjectScore[] subjectScores = transcripts.getScores();
        float score = 0;
        int sumNumberOfCredits = 0;
        for (int i = 0; i < subjectScores.length; i++) {
            if (DataUtil.isNullOrEmpty(subjectScores[i])){
                break;
            }
            score += subjectScores[i].getScore()*subjectScores[i].getSubject().getUnit();
            sumNumberOfCredits += subjectScores[i].getSubject().getUnit();
        }
        return score / sumNumberOfCredits;
    }

    public void showGPA() {
        System.out.println("Điểm tổng kết");
        Transcript[] transcripts = Service.transcripts;
        for (int i = 0; i < transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(transcripts[i])) break;
            System.out.print("STT" + (i + 1) + ". " + transcripts[i].getStudent().getFullName() + ": ");
            System.out.println(calculateGPA(transcripts[i]));
        }
    }
}
