package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class Article {
    String title,course,writtenby,price,discription,ownerid,artticleno;

    public Article(String title, String course, String writtenby, String price, String discription, String ownerid,String artticleno) {
        this.title = title;
        this.course = course;
        this.writtenby = writtenby;
        this.price = price;
        this.discription = discription;
        this.ownerid = ownerid;
        this.artticleno = artticleno;
    }

    public String getArtticleno() {
        return artticleno;
    }

    public void setArtticleno(String artticleno) {
        this.artticleno = artticleno;
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


    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }
}
