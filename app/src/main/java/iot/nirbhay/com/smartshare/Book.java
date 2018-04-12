package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class Book {

    String title,course,writtenby,price,discription,isbn,ownerid;

    public Book(String title, String course, String writtenby, String price, String discription, String isbn, String ownerid) {
        this.title = title;
        this.course = course;
        this.writtenby = writtenby;
        this.price = price;
        this.discription = discription;
        this.isbn = isbn;
        this.ownerid = ownerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getWrittenby() {
        return writtenby;
    }

    public void setWrittenby(String writtenby) {
        this.writtenby = writtenby;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }
}
