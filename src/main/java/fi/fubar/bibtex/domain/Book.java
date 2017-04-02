package fi.fubar.bibtex.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String handle;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String address;

    public String getHandle() {
        return handle;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setHandle(String handle) {
        if (!handle.isEmpty()) {
            this.handle = handle;
        }
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        }
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        }
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        }
    }

    public void setPublisher(String publisher) {
        if (!address.isEmpty()) {
            this.publisher = publisher;
        }
    }

    public void setAddress(String address) {
        if (!address.isEmpty()) {
            this.address = address;
        }
    }

}
