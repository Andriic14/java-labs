package com.example.lab4;
import java.util.Objects;
/**
 * Книга: назва, автор, рік видання, кількість сторінок, ціна, ISBN і жанр.
 */
public class Book {

    /** Мінімально допустимий рік видання. */
    public static final int MIN_YEAR = 1;
    /** Максимально допустимий рік видання. */
    public static final int MAX_YEAR = 2100;
    /** Мінімальна кількість сторінок. */
    public static final int MIN_PAGES = 1;
    /** Максимальна кількість сторінок. */
    public static final int MAX_PAGES = 10000;

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
     * @throws IllegalArgumentException якщо хоча б один параметр некоректний
     */
    public Book(String title, String author, int year, int pages, double price, String isbn, String genre){
        this.title = validateTitle(title);
        this.author = validateAuthor(author);
        this.year = validateYear(year);
        this.pages = validatePages(pages);
        this.price = validatePrice(price);
        this.isbn = validateIsbn(isbn);
        this.genre = validateGenre(genre);
    }

    /** @return назва книги */
    public String getTitle() {
        return title;
    }

    /** 
     * @param title нова назва книги 
     * @throws IllegalArgumentException якщо назва null або порожня
    */
    public void setTitle(String title) {
        this.title = validateTitle(title);
    }

    /** @return автор книги */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @param author новий автор
     * @throws IllegalArgumentException якщо автор null або порожній
     */
    public void setAuthor(String author) {
        this.author = validateAuthor(author);
    }

    /** @return рік видання */
    public int getYear() {
        return year;
    }

    /** 
     * @param year новий рік видання
     * @throws IllegalArgumentException якщо рік некоректний
     */
    public void setYear(int year) {
        this.year = validateYear(year);
    }

    /** @return кількість сторінок */
    public int getPages() {
        return pages;
    }

    /** 
     * @param pages нова кількість сторінок
     * @throws IllegalArgumentException якщо кількість сторінок некоректна
     */
    public void setPages(int pages) {
        this.pages = validatePages(pages);
    }

    /** @return ціна книги */
    public double getPrice() {
        return price;
    }

    /** 
     * @param price нова ціна
     * @throws IllegalArgumentException якщо ціна некоректна
     */
    public void setPrice(double price) {
        this.price = validatePrice(price);
    }

    /** @return ISBN книги */
    public String getIsbn() {
        return isbn;
    }

    /** 
     * @param isbn новий ISBN
     * @throws IllegalArgumentException якщо ISBN некоректний
     */
    public void setIsbn(String isbn){
        this.isbn = validateIsbn(isbn);
    }

    /** @return жанр книги */
    public String getGenre() {
        return genre;
    }

    /** 
     * @param genre новий жанр
     * @throws IllegalArgumentException якщо жанр null або порожній
     */
    public void setGenre(String genre) {
        this.genre = validateGenre(genre);
    }

    /**
     * Перевіряє текстове поле: воно не може бути null або порожнім.
     * 
     *  @param value     значення для перевірки
     *  @param fieldName назва поля (для повідомлення про помилку)
     *  @return значення без пробілів по краях
     *  @throws IllegalArgumentException якщо рядок null або порожній
     */
    private static String validateText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле \"" + fieldName + "\" не може бути порожнім");
        }
        return value.trim();
    }

    /**
     * Перевіряє назву книги.
     *
     * @param title назва
     * @return коректна назва без пробілів по краях
     * @throws IllegalArgumentException якщо назва null або порожня
     */
    public static String validateTitle(String title)  {
        return validateText(title, "Назва");
    }

    /**  
     * Перевіряє автора.
     * 
     * @param author автор
     * @return коректне ім'я автора без пробілів по краях
     * @throws IllegalArgumentException якщо автор null або порожній
     */
    public static String validateAuthor(String author) {
        return validateText(author, "Автор");
    }

    /**    
     * Перевіряє жанр.
     * 
     * @param genre жанр
     * @return коректний жанр без пробілів по краях
     * @throws IllegalArgumentException якщо жанр null або порожній
     */
    public static String validateGenre(String genre) {
        return validateText(genre, "Жанр");
    }

    /** 
     * Перевіряє рік видання.
     * 
     * @param year рік
     * @return той самий рік, якщо він коректний
     * @throws IllegalArgumentException якщо рік поза межами [MIN_YEAR; MAX_YEAR]
     */
    public static int validateYear(int year) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Рік має бути від " + MIN_YEAR + " до " + MAX_YEAR);
        }
        return year;
    }
    
    /**
     * Перевіряє кількість сторінок.
     * 
     * @param pages кількість сторінок
     * @return те саме значення, якщо воно коректне
     * @throws IllegalArgumentException якщо значення поза межами [MIN_PAGES; MAX_PAGES]
     */
    public static int validatePages(int pages) {
        if (pages < MIN_PAGES || pages > MAX_PAGES) {
            throw new IllegalArgumentException("Кількість сторінок має бути від " + MIN_PAGES + " до " + MAX_PAGES);
        }
        return pages;
    }

    /**
     * Перевіряє ціну.
     * 
     * @param price ціна
     * @return та сама ціна, якщо вона коректна
     * @throws IllegalArgumentException якщо ціна NaN, нескінченна або від'ємна
     */
    public static double validatePrice(double price) {
        if (Double.isNaN(price) || Double.isInfinite(price)) {
            throw new IllegalArgumentException("Ціна має бути звичайним числом");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }
        return price;
    }

    /**
     * Перевіряє ISBN: після видалення пробілів і дефісів має лишитися 10 або 13 цифр.
     * 
     * @param isbn ISBN, наприклад "978-0-13-235088-4"
     * @return ISBN, що складається лише з цифр
     * @throws IllegalArgumentException якщо ISBN null або має неправильний формат
     */
    public static String validateIsbn(String isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN не може бути null");
        }
        String digits = isbn.replaceAll("[\\s-]", "");
        if (!digits.matches("\\d{10}|\\d{13}")) {
            throw new IllegalArgumentException("ISBN має містити 10 або 13 цифр");
        }
        return digits;
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
            + ", isbn='" + isbn + "', genre='" + genre + "'}";
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

