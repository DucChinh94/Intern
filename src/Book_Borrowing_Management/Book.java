package Book_Borrowing_Management;

import java.util.Scanner;

public class Book {
    private static int autoId = -1;
    private int bookId;
    private String bookName;
    private String author;
    private String specialized;
    private int publishYear;

    public Book() {
        if (autoId == -1) {
            autoId = 10000;
            this.bookId = autoId;
        } else this.bookId = ++autoId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", specialized='" + specialized + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }

    public void inputBook() {
        System.out.print("nhap ten sach: ");
        this.setBookName(new Scanner(System.in).nextLine());
        System.out.print("nhap ten tac gia: ");
        this.setAuthor(new Scanner(System.in).nextLine());
        System.out.print("nhap nam san xuat: ");
        this.setPublishYear(new Scanner(System.in).nextInt());
        System.out.println("chon chuyen nganh: ");
        System.out.println("1. khoa hoc tu nhien");
        System.out.println("2. van hoc nghe thuat");
        System.out.println("3. dien tu vien thong");
        System.out.println("4. cong nghe thong tin");
        int choice = -1;
        do {
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice < 1 || choice > 4) System.out.println("Nhap sai. Moi nhap lai!");
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                this.setSpecialized("khoa hoc tu nhien");
                break;
            case 2:
                this.setSpecialized("van hoc nghe thuat");
                break;
            case 3:
                this.setSpecialized("dien tu vien thong");
                break;
            case 4:
                this.setSpecialized("cong nghe thong tin");
                break;
        }
    }
}
