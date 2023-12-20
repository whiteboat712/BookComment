package system.bookcomment.model;

import java.beans.JavaBean;
import java.sql.Date;
import java.sql.Timestamp;

@JavaBean
public class Comment {

    int cid;

    int bid;

    int uid;

    String content;

    int parentid;

    Timestamp date;

    public Comment(int cid, int bid, int uid, String content, int parentid, Timestamp date) {
        this.cid = cid;
        this.bid = bid;
        this.uid = uid;
        this.content = content;
        this.parentid = parentid;
        this.date = date;
    }

    public Comment() {

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", bid=" + bid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", parentid=" + parentid +
                ", date=" + date +
                '}';
    }
}
