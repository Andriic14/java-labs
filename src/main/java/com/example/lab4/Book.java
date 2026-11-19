package com.example.lab4;
import java.util.Objects;
/**
 * Книга: назва, автор, рік видання, кількість сторінок і ціна.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private int pages;
    private double price;
    private String isbn;
    private String genre;

    /**
     * Створює книгу із заданими параметрами.
     * 
     * @param title  назва книги
     * @param author автор
     * @param year   рік видання
     * @param pages  кількість сторінок
     * @param price  ціна
     * @param isbn ISBN книги
     * @param genre жанр
     */
    public Book(String title, String author, int year, int pages, double price, String isbn, String genre){
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
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

    /** @return ISBN книги */
    public String getIsbn() {
        return isbn;
    }

    /** @param isbn новий ISBN */
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    /** @return жанр книги */
    public String getGenre() {
        return genre;
    }

    /** @param genre новий жанр */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Повертає текстове подання книги.
     *
     * @return рядок з усіма полями
     */
    @Override 
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', year=" + year 
            + ", pages=" + pages + ", price=" + price 
            + ", isbn='" + isbn + "', genre='" + genre + "}";
    }

    /**
     * Порівнює книги за значеннями всіх полів.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо o є книгою з такими самими полями
     */
    @Override 
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year 
                && pages == book.pages
                && Double.compare(price, book.price) == 0
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(isbn, book.isbn)
                && Objects.equals(genre, book.genre);
    }

    /**
     * Обчислює хеш-код, узгоджений з {@link #equals(Object)}.
     *
     * @return хеш-код книги
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, pages, price, isbn, genre);
    }
}

