package com.example.lab4;

/**
 * Драйвер: створює масив із 5 книг і виводить інформацію про них.
 */
public class Main {
    private static final int BOOKS_COUNT = 5;
    
    /**
     * Точка входу програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Book[] books = new Book[BOOKS_COUNT];
        
        books[0] = new Book("Kobzar", "Taras Shevchenko", 1840, 240, 150.0);
        books[1] = new Book("Zakhar Berkut", "Ivan Franko", 1883, 320, 180.5);
        books[2] = new Book("Forest Song", "Lesya Ukrainka", 1911, 160, 120.0);
        books[3] = new Book("Shadows of Forgotten Ancestors", "Mykhailo Kotsiubynsky", 1911, 200, 140.0);
        books[4] = new Book("Intermezzo", "Mykhailo Kotsiubynsky", 1908, 90, 95.0);
        
        System.out.println("Список книг:");
        for(int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
}
