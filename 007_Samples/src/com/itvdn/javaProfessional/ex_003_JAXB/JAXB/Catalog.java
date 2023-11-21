package com.itvdn.javaProfessional.ex_003_JAXB.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "catalog")
public class Catalog {

    // Список книг та за допомогою анотації буде згенеровано елемент book
    @XmlElement(name = "book")
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(books.toArray());
    }
}

