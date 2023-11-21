package com.itvdn.javaProfessional.ex_003_JAXB.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


// Об'єкти класу Book будуть трансформуватися в xml елементи з назвою book
@XmlRootElement(name = "book")
public class Book {

    private String author;
    private String title;
    private double price;
    private Date publishDate;

    public Book() {
    }

    public Book(String author, String title, double price, Date publishDate) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "[" + author + ", " + title + ", " + price + ", " + publishDate + "]";
    }

    public Date getPublishDate() {
        return publishDate;
    }

    // Змінили стандартну назву на іншу
    @XmlElement(name = "publish_date")
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    // Якщо анотації немає поля name, то анотації відповідатимуть полям класу
    @XmlElement
    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }
}

