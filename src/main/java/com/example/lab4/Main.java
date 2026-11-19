package com.example.lab4;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Драйвер програми: консольне меню для роботи зі списком книг.
 */
public class Main {

    private static final int MENU_CREATE = 1;
    private static final int MENU_PRINT = 2;
    private static final int MENU_EXIT = 3;
    
    /**
     * Точка входу програми. Показує меню, доки користувач не обере "Завершити".
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                int choice = readValue(scanner, "Ваш вибір: ", Main::parseMenuChoice);
                switch (choice) {
                    case MENU_CREATE -> {
                        books.add(readBook(scanner));
                        System.out.println("Книгу додано.");
                    }
                    case MENU_PRINT -> printBooks(books);
                    case MENU_EXIT -> running = false;
                }
            }
            System.out.println("Роботу завершено.");
        } catch  (NoSuchElementException e) {
            // введення закрито (наприклад, Ctrl+D / Ctrl+Z) - виходимо спокійно
            System.out.println();
            System.out.println("Введення завершено. Вихід з програми.");
        }
    }

    /** Виводить пункти меню. */
    private static void printMenu() {
        System.out.println();
        System.out.println("=== Меню ===");
        System.out.println(MENU_CREATE + ". Створити нову книгу");
        System.out.println(MENU_PRINT + ". Вивести всі книги");
        System.out.println(MENU_EXIT + ". Завершити роботу");
    }

    /**
     * Перетворює введений рядок на номер пункту меню.
     *
     * @param line введений рядок
     * @return номер пункту меню
     * @throws NumberFormatException    якщо рядок не є цілим числом
     * @throws IllegalArgumentException якщо номер поза межами меню
     */
    private static int parseMenuChoice(String line) {
        int choice = Integer.parseInt(line.trim());
        if (choice < MENU_CREATE || choice > MENU_EXIT) {
            throw new IllegalArgumentException("Оберіть пункт від " + MENU_CREATE + " до " + MENU_EXIT);
        }
        return choice;
    }

    /**
     * Виводить усі книги зі списку.
     *
     * @param books список книг
     */
    private static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        System.out.println("Список книг:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    /**
     * Зчитує всі поля книги з клавіатури. Кожне поле перевіряється окремо,
     * тому при помилці перепитується лише воно.
     *
     * @param scanner Scanner, прив'язаний до System.in
     * @return створена книга
     */
    private static Book readBook(Scanner scanner) {
        String title = readValue(scanner, "Назва: ", Book::validateTitle);
        String author = readValue(scanner, "Автор: ", Book::validateAuthor);
        int year = readValue(scanner, 
            "Рік видання (" + Book.MIN_YEAR + "-" + Book.MAX_YEAR + "): ",
            line -> Book.validateYear(Integer.parseInt(line.trim())));
        int pages = readValue(scanner,
            "Кількість сторінок (" + Book.MIN_PAGES + "-" + Book.MAX_PAGES + "): ",
            line -> Book.validatePages(Integer.parseInt(line.trim())));
        double price = readValue(scanner, "Ціна (не менше 0): ",
            line -> Book.validatePrice(Double.parseDouble(line.trim().replace(',', '.'))));
        String isbn = readValue(scanner, "ISBN (10 або 13 цифр): ", Book::validateIsbn);
        String genre = readValue(scanner, "Жанр: ", Book::validateGenre);
        return new Book(title, author, year, pages, price, isbn, genre);
    }

    /**
     * Універсальне зчитування значення з перевіркою. Запит повторюється,
     * доки парсер не поверне коректне значення.
     *
     * @param scanner Scanner, прив'язаний до System.in
     * @param prompt  запрошення до введення
     * @param parser  правило перетворення рядка у значення; кидає виняток, якщо рядок некоректний
     * @param <T>     тип результату
     * @return коректне значення
     */
    private static <T> T readValue(Scanner scanner, String prompt, Function<String, T> parser) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return parser.apply(line);
            } catch (NumberFormatException e) {
                System.out.println("Помилка: потрібно ввести число у правильному форматі.");
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
}
