package org.example;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class LibraryCloneTest {

    @Test
    void shouldDeepClone() {
        List<Book> bookList = List.of(
                new Book("book1", "author1"),
                new Book("book2", "author2")
        );
        Library library = new Library();
        library.setBooks(bookList);

        Library cloned = library.clone();

        assertNotSame(library, cloned);

        List<Book> clonedBooks = cloned.getBooks();
        assertEquals(bookList.size(), clonedBooks.size());
        for (int i = 0; i < bookList.size(); i++) {
            Book original = bookList.get(0);
            Book clone = clonedBooks.get(0);
            assertEquals(original, clone);
            assertNotSame(original, clone);
        }
    }


}