package iot.nirbhay.com.smartshare;

/**
 * Created by Nirbhay on 14-04-2018.
 */

public class Data {

    static String materialname="",discription="",amount="",course="",category="",writtenby="",isbn="",articleno="",paperid="",year="",ownerid="";
    static String sharedPrefrence = "SmartShare";
    public static void reset(){
        materialname="";
        discription="";
        amount="";
        course="";
        category="";
        writtenby="";
        isbn="";
        articleno="";
        paperid="";
        year="";
        ownerid="";
    }

    public static String getSharedPrefrence() {
        return sharedPrefrence;
    }

    public static void setSharedPrefrence(String sharedPrefrence) {
        Data.sharedPrefrence = sharedPrefrence;
    }

    public static String getMaterialname() {
        return materialname;
    }

    public static void setMaterialname(String materialname) {
        Data.materialname = materialname;
    }

    public static String getDiscription() {
        return discription;
    }

    public static void setDiscription(String discription) {
        Data.discription = discription;
    }

    public static String getAmount() {
        return amount;
    }

    public static void setAmount(String amount) {
        Data.amount = amount;
    }

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        Data.course = course;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        Data.category = category;
    }

    public static String getWrittenby() {
        return writtenby;
    }

    public static void setWrittenby(String writtenby) {
        Data.writtenby = writtenby;
    }

    public static String getIsbn() {
        return isbn;
    }

    public static void setIsbn(String isbn) {
        Data.isbn = isbn;
    }

    public static String getArticleno() {
        return articleno;
    }

    public static void setArticleno(String articleno) {
        Data.articleno = articleno;
    }

    public static String getPaperid() {
        return paperid;
    }

    public static void setPaperid(String paperid) {
        Data.paperid = paperid;
    }

    public static String getYear() {
        return year;
    }

    public static void setYear(String year) {
        Data.year = year;
    }

    public static String getOwnerid() {
        return ownerid;
    }

    public static void setOwnerid(String ownerid) {
        Data.ownerid = ownerid;
    }
}
