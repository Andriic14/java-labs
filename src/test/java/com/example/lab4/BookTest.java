package com.example.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Автотести для перевірки валідації та винятків у класі {@link Book}.
 */
public class BookTest  {
    private Book book;

    /** Перед кожним тестом створює нову коректну книгу. */
    @BeforeEach
    void setUp() {
        book = new Book("Kobzar", "Taras Shevchenko", 1840, 240, 150.0,
                "9786171234567", "Poetry");
    }
    // ---------- Конструктор ----------
    @Test
    void shouldCreateBookWhenDataIsValid() {
        assertEquals("Kobzar", book.getTitle());
        assertEquals(1840, book.getYear());
        assertEquals("9786171234567", book.getIsbn());
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author", -5, 0, -1.0, "123", null);
        });
    }

    @Test
    void shouldThrowExceptionWhenTitleIsEmptyInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("   ", "Author", 2000, 100, 10.0, "9786171234567", "Poetry");
        });
    }

    @Test
    void shouldThrowExceptionWhenAuthorIsNullInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Title", null, 2000, 100, 10.0, "9786171234567", "Poetry");
        });
    }

    @Test
    void shouldThrowExceptionWhenYearOutOfRangeInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Title", "Author", 3000, 100, 10.0, "9786171234567", "Poetry");
        });
    }

    @Test
    void shouldThrowExceptionWhenIsbnInvalidInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Title", "Author", 2000, 100, 10.0, "12345", "Poetry");
        });
    }

    // ---------- Сетери ----------

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(-1);
        });
    }

    @Test
    void shouldThrowExceptionWhenPriceIsNaNInSetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(Double.NaN);
        });
    }

    @Test
    void shouldThrowExceptionWhenPagesIsZeroInSetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPages(0);
        });
    }

    @Test
    void shouldThrowExceptionWhenGenreIsEmptyInSetter() {
        assertThrows(IllegalArgumentException.class, () -> {
            book.setGenre("");
        });
    }

    // ---------- Додаткові перевірки поведінки ----------

    @Test
    void shouldKeepOldValueWhenSetterThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            book.setYear(-100);
        });
        assertEquals(1840, book.getYear());
    }

    @Test
    void shouldNormalizeIsbnAndTrimTitleInSetters() {
        book.setIsbn("978-0-13-235088-4");
        book.setTitle("  Clean Code  ");
        assertEquals("9780132350884", book.getIsbn());
        assertEquals("Clean Code", book.getTitle());
    }
}
