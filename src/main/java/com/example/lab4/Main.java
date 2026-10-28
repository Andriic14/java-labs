package com.example.lab4;
import java.util.Scanner;

/**
 * Драйвер: створює масив із 5 книг і виводить інформацію про них.
 */
public class Main {
    private static final int BOOKS_COUNT = 5;
    private static final int PREDEFINED_COUNT = 3;
    
    /**
     * Точка входу програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[BOOKS_COUNT];
        
        books[0] = new Book("Kobzar", "Taras Shevchenko", 1840, 240, 150.0);
        books[1] = new Book("Zakhar Berkut", "Ivan Franko", 1883, 320, 180.5);
        books[2] = new Book("Forest Song", "Lesya Ukrainka", 1911, 160, 120.0);
        
        System.out.println("Введіть дані для книг " + (PREDEFINED_COUNT + 1) + "-" + BOOKS_COUNT + ".");
        for(int i = PREDEFINED_COUNT; i < BOOKS_COUNT; i++) {
            System.out.println("Книга " + (i + 1) + ":");
            books[i] = readBook(scanner);
        }

        System.out.println();
        System.out.println("Список книг:");
        for(int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }

        demonstrateEqualsAndSetters(books);
        scanner.close();
    }

    /**
     * Демонстрація порівняння об'єктів і роботи сеттерів.
     *
     * @param books масив книг (має містити щонайменше дві заповнені книги)
     */
    private static void demonstrateEqualsAndSetters(Book[] books) {
        Book first = books[0];
        Book copy = new Book(first.getTitle(), first.getAuthor(),
                first.getYear(), first.getPages(), first.getPrice());

        System.out.println();
        System.out.println("first == copy: " + (first == copy));
        System.out.println("first.equals(copy): " + first.equals(copy));
        System.out.println("first.equals(books[1]): " + first.equals(books[1]));

        copy.setPrice(first.getPrice() + 50);
        System.out.println("Після зміни ціни копії через сеттер: " + copy);
        System.out.println("first.equals(copy): " + first.equals(copy));
    }

    /**
     * Зчитує всі поля однієї книги з клавіатури з перевіркою введення.
     *
     * @param scanner Scanner, прив'язаний до System.in
     * @return створена книга
     */
    private static Book readBook(Scanner scanner) {
        String title = readString(scanner, "Назва: ");
        String author = readString(scanner, "Автор: ");
        int year = readInt(scanner, "Рік видання (1-2100): ", 1, 2100);
        int pages = readInt(scanner, "Кількість сторінок (1-10000): ", 1, 10000);
        double price = readDouble(scanner, "Ціна (не менше 0): ", 0);
        return new Book(title, author, year, pages, price);
    }

    /**
     * Зчитує непорожній рядок. Запит повторюється, доки рядок порожній.
     *
     * @param scanner Scanner, прив'язаний до System.in
     * @param prompt  запрошення до введення
     * @return непорожній рядок без пробілів по краях
     */
    private static String readString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Помилка: рядок не може бути порожнім.");
        }
    }

    /**
     * Зчитує ціле число з діапазону [min; max]. Запит повторюється при помилці.
     *
     * @param scanner Scanner, прив'язаний до System.in
     * @param prompt  запрошення до введення
     * @param min     мінімально допустиме значення
     * @param max     максимально допустиме значення
     * @return коректне ціле число
     */
    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Помилка: число має бути від " + min + " до " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Помилка: потрібно ввести ціле число.");
            }
        }
    }

    /**
     * Зчитує дійсне число не менше за min. Кома приймається як десятковий роздільник.
     *
     * @param scanner Scanner, прив'язаний до System.in
     * @param prompt  запрошення до введення
     * @param min     мінімально допустиме значення
     * @return коректне дійсне число
     */
    private static double readDouble(Scanner scanner, String prompt, double min) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim().replace(',', '.');
            try {
                double value = Double.parseDouble(line);
                if (Double.isNaN(value) || Double.isInfinite(value)) {
                    System.out.println("Помилка: потрібно ввести звичайне число.");
                } else if (value < min) {
                    System.out.println("Помилка: число не може бути меншим за " + min + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: потрібно ввести число.");
            }
        }
    }
}
