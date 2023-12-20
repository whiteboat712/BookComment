package system.bookcomment.model;


import java.beans.JavaBean;
import java.sql.Date;

@JavaBean
public class Book {
    /*书籍id*/
    int bid;
    /*书籍名称*/
    String bname;
    /*书籍作者*/
    String bauthor;
    /*书籍介绍*/
    String binfo;

    String cover;

    Date publishDate;

    String publisher;

    public Book(int bid, String bname, String bauthor, String binfo, String cover, Date publishDate, String publisher) {
        this.bid = bid;
        this.bname = bname;
        this.bauthor = bauthor;
        this.binfo = binfo;
        this.cover = cover;
        this.publishDate = publishDate;
        this.publisher = publisher;
    }

    public Book() {

    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBinfo() {
        return binfo;
    }

    public void setBinfo(String binfo) {
        this.binfo = binfo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", binfo='" + binfo + '\'' +
                ", cover='" + cover + '\'' +
                ", publishDate=" + publishDate +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
