package com.example.lab4;
/**
 * Книга: назва, автор, рік видання, кількість сторінок і ціна.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private int pages;
    private double price;

    /**
     * Створює книгу із заданими параметрами.
     * 
     * @param title  назва книги
     * @param author автор
     * @param year   рік видання
     * @param pages  кількість сторінок
     * @param price  ціна
     */
    public Book(String title, String author, int year, int pages, double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    /** @return назва книги */
    public String getTitle() {
        return title;
    }

    /** @param title нова назва книги */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return автор книги */
    public String getAuthor() {
        return author;
    }

    /** @param author новий автор */
    public void setAuthor(String author) {
        this.author = author;
    }

    /** @return рік видання */
    public int getYear() {
        return year;
    }

    /** @param year новий рік видання */
    public void setYear(int year) {
        this.year = year;
    }

    /** @return кількість сторінок */
    public int getPages() {
        return pages;
    }

    /** @param pages нова кількість сторінок */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /** @return ціна книги */
    public double getPrice() {
        return price;
    }

    /** @param price нова ціна */
    public void setPrice(double price) {
        this.price = price;
    }
}
