package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class QPaper {

    String name,course,paperid,price,discription,year;

    public QPaper(String name, String course, String paperid, String price, String discription, String year) {
        this.name = name;
        this.course = course;
        this.paperid = paperid;
        this.price = price;
        this.discription = discription;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
