package TeacherSalaryManagement;

import java.util.Scanner;

public class Management {
    Teacher teacher;
    Subject[] subject = new Subject[100];
    int[] classNumber = new int[100];

    //    ham tim kiem mon hoc
    public Subject searchSubject(Subject[] subjects, int id) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) break;
            if (subjects[i].getSubjectId() == id) {
                return subjects[i];
            }
        }
        return null;
    }

    public int lessonQuantity(Management mng) {
        int sum = 0;
        for (int i = 0; i < mng.subject.length; i++) {
            if (mng.subject[i] == null) break;
            sum += mng.classNumber[i] * mng.subject[i].getTotalLesson();
        }
        return sum;
    }

    public boolean checkSubject(Subject[] subjects, int id) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) break;
            if (subjects[i].getSubjectId() == id) return false;
        }
        return true;
    }

    public Management[] declarationTable(Management[] mng, Teacher[] teachers, Subject[] subjects) {
        if (teachers[0] == null) {
            System.out.println("Chưa có giảng viên trong danh sách");
            return null;
        }
        if (subjects[0] == null) {
            System.out.println("Chưa có môn học nào trong danh sách");
            return null;
        }
        System.out.println("Bang ke khai giang day cho tung giang vien");
        for (int i = 0; i < mng.length; i++) {
            mng[i] = new Management();
            if (teachers[i] == null) {
                break;
            }
            mng[i].teacher = teachers[i];
            System.out.println("Giảng viên " + teachers[i].getTeacherId() + ":");
            System.out.println("Các môn giảng dậy của giảng viên " + teachers[i].getTeacherId() + ":");
            int k = 0;
            d:
            do {
                System.out.println("Nhập mã môn học thứ " + (k + 1) + " la: ");
                do {
                    int idSubject = 0;
                    boolean flag;
                    do {

                        String digit = "\\d{3}";
                        String input = new Scanner(System.in).next();
                        flag = input.matches(digit);

                        if (!flag) {
                            System.out.println("nhập sai!, mời nhập lại");
                            continue;
                        }
                        idSubject = Integer.parseInt(input);

                    } while (!flag);
                    if (!checkSubject(mng[i].subject, idSubject)) {
                        System.out.println("Môn học đã được nhập,hãy nhập môn học khác");
                        continue;
                    }
                    if (idSubject == 0) break d;
                    Subject sb = searchSubject(subjects, idSubject);
                    if (sb != null) {
                        mng[i].subject[k] = sb;
                        System.out.println("Nhập số lớp của môn học(tối đa 3):");

                        do {
                            int classQuantity = new Scanner(System.in).nextInt();
                            if (classQuantity > 3) {
                                System.out.println("không được quá 3 lớp, Nhập lại");
                                continue;
                            }
                            if (mng[i].subject[k].getTotalLesson() * classQuantity + lessonQuantity(mng[i]) > 200) {

                                System.out.println("Đã vượt quá 200 tiết học, nhập lại");
                                continue;
                            }
                            mng[i].classNumber[k] = classQuantity;
                            System.out.println("Đã có " + lessonQuantity(mng[i]) + " tiết học(tối đa 200)");
                            break;
                        } while (true);
                        k++;
                        break;
                    }
                    System.out.println("Nhập sai id môn học, nhập lại");
                } while (true);
            } while (true);
        }
        return mng;
    }

    // ham hien thi bang ke khai
    public void showDeclarationTable(Management[] mng) {
        if (mng[0] == null) {
            System.out.println("Chưa lập bảng kê khai");
            return;
        }
        System.out.println("====Bảng kê khai giảng dậy====");
        for (int i = 0; i < mng.length; i++) {
            if (mng[i].teacher == null) break;
            System.out.println("GIảng viên " + mng[i].teacher.getTeacherId() + ":" + mng[i].teacher.getFullName() + ":");
            for (int j = 0; j < mng[i].subject.length; j++) {
                if (mng[i].subject[j] == null) break;
                System.out.print("\t\t");
                System.out.println("Môn học " + mng[i].subject[j].getSubjectId() + ":" + mng[i].subject[j].getSubjectName() + " Số lớp: " + mng[i].classNumber[j]);
            }
            System.out.println("\t\tTổng số tiết học: " + lessonQuantity(mng[i]));
        }
    }

    public Management[] sortByName(Management[] mng) {

        for (int i = 0; i < mng.length; i++) {
            if (mng[i] == null) break;
            for (int j = i; j < mng.length; j++) {
                if (mng[j].teacher == null) break;
                if (mng[i].teacher.getFullName().compareTo(mng[j].teacher.getFullName()) > 0) {
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }
        }
        return mng;
    }

    public Management[] sortByLessonQuantity(Management[] mng) {
        for (int i = 0; i < mng.length; i++) {
            if (mng[i] == null) break;
            for (int j = i; j < mng.length; j++) {
                if (mng[j] == null) break;
                if (lessonQuantity(mng[i]) < lessonQuantity(mng[j])) {
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }

        }
        return mng;
    }

    public float caculatorSalary() {
        float total = 0;
        for (int i = 0; i < subject.length; i++) {
            if (subject[i] == null) break;
            total += subject[i].subjectExpence() * classNumber[i];
        }
        return total;
    }

    //    ham tinh luong
    public void salary(Management[] mng) {
        float[] salary = new float[100];
        for (int i = 0; i < mng.length; i++) {
            if (mng[i].teacher == null) break;
            salary[i] = mng[i].caculatorSalary();
            System.out.print("Giảng viên " + mng[i].teacher.getTeacherId() + ":" + mng[i].teacher.getFullName());
            System.out.print(" Có tổng lương là: " + salary[i] + "\n");
        }
    }
}
