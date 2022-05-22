package Book_Borrowing_Management;

import java.util.Scanner;

public class Service {
    Reader[] readers = new Reader[100];
    Book[] books = new Book[100];
Management [] managements = new Management[100];
    //    nhap ban doc moi them vao
    public void addNewReader() {
        System.out.print("nhap so luong ban doc moi them vao: ");
        int readerNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNum; i++) {
            System.out.println("nhap thong tin ban doc them vao thu " + (i + 1));
            Reader reader = new Reader();
            reader.inputReader();
            saveReader(reader);
        }
    }

    //   luu ban doc vao danh sach
    private void saveReader(Reader reader) {
        for (int i = 0; i < readers.length; i++) {
            if (readers[i] == null) {
                readers[i] = reader;
                break;
            }
        }
    }

    // in ra danh sach ban doc da co
    public void showReader() {
        System.out.println("danh sach ban doc:");
        for (int i = 0; i < readers.length; i++) {
            if (readers[i] == null) break;
            else System.out.println("No " + (i + 1) + " : " + readers[i].toString());
        }
    }

    //    nhap sach moi
    public void addNewBook() {
        System.out.print("nhap so luong sach moi them vao: ");
        int bookNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < bookNum; i++) {
            System.out.println("nhap thong tin sach them vao thu " + (i + 1));
            Book book = new Book();
            book.inputBook();
            saveBook(book);
        }
    }

    //    luu sach vao danh sach
    private void saveBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }

    //    in ra danh sach sach da co
    public void showBook() {
        System.out.println("Danh sach sach:");
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) break;
            System.out.println("No " + (i + 1) + " : " + books[i].toString());
        }
    }

//  quan ly muon sach cho tung ban doc va in ra man hinh
    public void bookBorrowManagement(){
        if(readers[0]==null || books[0]==null){
            System.out.println("chua co du lieu ban doc hoac du lieu sach");
        }
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]==null) break;
            managements[i] = new Management();
            managements[i].borrowBook(readers[i], books );
        }
        System.out.println("BANG QUAN LY MUON SACH:");
        System.out.println("=======================================================================================");
        for (int i = 0; i < managements.length; i++) {
            if (managements[i]==null) break;
            managements[i].showBookBorrow();
            System.out.println("=======================================================================================");
        }
    }

//    ham sap xep theo ten ban doc
public Management[] sortByName(Management[] mng) {

    for (int i = 0; i < mng.length; i++) {
        if (mng[i] == null) break;
        for (int j = i; j < mng.length; j++) {
            if (mng[j] == null) break;
            if (mng[i].reader.getFullName().compareTo(mng[j].reader.getFullName()) > 0) {
                Management temp = mng[i];
                mng[i] = mng[j];
                mng[j] = temp;
            }
        }

    }
    return mng;
}

// ham in ra danh sach quan ly muon sach sap xep theo ten ban doc
    public void printSortByName(){
        managements = sortByName(managements);
        System.out.println("Bang quan ly sap xep theo ten ban doc:");
        System.out.println("=======================================================================================");
        for (int i = 0; i < managements.length; i++) {
            if (managements[i]==null) break;
            managements[i].showBookBorrow();
            System.out.println("=======================================================================================");
        }
    }

    public int countB(Book[] b) {
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Management[] sortByQuantity(Management[] mng) {
        for (int i = 0; i < mng.length; i++) {
            if (mng[i] == null) break;
            for (int j = i; j < mng.length; j++) {
                if (mng[j] == null) break;
                if (countB(mng[i].books) < countB(mng[j].books)) {
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }
        }
        return mng;
    }

    // ham in ra danh sach quan ly muon sach sap xep theo so luong sach duoc muon
public void printSortbyQuantity(){
    managements = sortByQuantity(managements);
    System.out.println("Bang quan ly sap xep theo so luong muon:");
    System.out.println("=======================================================================================");
    for (int i = 0; i < managements.length; i++) {
        if (managements[i]==null) break;
        managements[i].showBookBorrow();
        System.out.println("=======================================================================================");
    }
}

// ham tim kiem theo ten ban doc
public Management[] searchByName(Management[] mng, String name) {
    Management[] temp = new Management[mng.length];
    for (int i = 0; i < mng.length; i++) {
        if (mng[i] == null) break;
        if (mng[i].reader.getFullName().equalsIgnoreCase(name)) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == null) {
                    temp[j] = mng[i];
                    break;
                }
            }
        }
    }
    return temp;
}

// ham hiển thị danh sách mượn sách theo tên bạn đọc.
    public void showByName(){
        System.out.println("Nhap ten ban doc muon tim:");
        String name = (new Scanner(System.in)).nextLine();
        Management[] temp = searchByName(managements,name);
        if(temp[0]==null) {
            System.out.println("khong co ban doc ten "+name);
        }
        else {
            for (int i = 0; i < temp.length; i++) {
                if(temp[i]==null) break;
                temp[i].showBookBorrow();
            }
        }

    }
}



