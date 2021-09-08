package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean code", 111);
        books[1] = new Book("Clean code. 1", 222);
        books[2] = new Book("Clean code. 2", 333);
        books[3] = new Book("Clean code. 3", 444);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCountPages());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book curBook : books) {
            if (curBook.getName().equals("Clean code")) {
                System.out.println(curBook.getName() + " - " + curBook.getCountPages());
            }
        }
    }
}
