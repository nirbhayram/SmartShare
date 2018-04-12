package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class LNotes {

    String name,course,writtenby,amount,discription;

    public LNotes(String name, String course, String writtenby, String amount, String discription) {
        this.name = name;
        this.course = course;
        this.writtenby = writtenby;
        this.amount = amount;
        this.discription = discription;
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

    public String getWrittenby() {
        return writtenby;
    }

    public void setWrittenby(String writtenby) {
        this.writtenby = writtenby;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
