package Book_Borrowing_Management;

import java.util.Scanner;

public class Management {

     Reader reader;
    Book[] books = new Book[15];

    //ham kiem tra so luong sach cua tung dau sach khong duoc muon qua 3 quyen
    private boolean bookTitle(Book[] books, String title) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getSpecialized().equals(title)) count++;
        }
        if (count > 3) return false;
        return true;
    }

    //    ham tim kiem sach muon
    private Book searchBook(Book[] books, int bookId) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            if (books[i].getBookId() == bookId) return books[i];
        }
        return null;
    }

    //  ham them sach da muon vao danh sach muon
    private void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    // ham quan ly muon sach
    public void borrowBook(Reader reader, Book[] books) {
        this.reader = reader;
        Scanner input = new Scanner(System.in);
        int n=0;
        do {
            System.out.print("nhap vao so luong sach ma ban doc " + reader.getReaderId() + " muon: ");
            n = input.nextInt();
            if (n < 1 || n > 15) System.out.println("So luong muon khong hop le. Xin moi nhap lai!");
        } while (n < 1 || n > 15);
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (this.books[this.books.length - 1] != null) {
                System.out.println("khong the muon them sach vi so luong sach da muon toi da");
                break;
            }
            if (this.books[i] == null) {
                do {
                    System.out.println("nhap ma sach thu " + index + " ma ban doc muon: ");
                    int id = input.nextInt();
                    if (searchBook(books, id) == null) {
                        System.out.println("khong ton tai ID nay, Nhap lai id.");
                        continue;
                    }
                    index++;
                    Book b = searchBook(books, id);
                    if (bookTitle(this.books, b.getSpecialized())) {
                        addBook(b);
                        break;
                    } else {
                        System.out.println("qua so luong sach cua 1 dau sach, hay chon sach khac");
                        index--;
                    }
                } while (true);
            }
        }
    }

    //    ham hien thi danh sach sach da muon cua ban doc
    public void showBookBorrow() {
        System.out.println("Ban doc " + reader.getReaderId() + ":" + reader.getFullName() + " da muon cac sach:");
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            System.out.print("\t");
            System.out.println(books[i].toString());
        }
    }
}
