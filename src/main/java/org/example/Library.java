package org.example;

import java.util.ArrayList;
import java.util.List;
/*
1)    - Создайте класс Library, который содержит список объектов Book.
   - Реализуйте глубокое клонирование объекта Library, чтобы при клонировании также клонировались все объекты Book.
   - Убедитесь, что изменения в клонированной библиотеке не влияют на исходную.
 */
public class Library implements Cloneable{
    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Library clone() {
        try {
            Library clone = (Library) super.clone();
            List<Book> booksCLone = new ArrayList<>();
            for (Book book : books) {
                booksCLone.add(book.clone());
            }
            clone.setBooks(booksCLone);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
