package system.bookcomment.model;

import java.beans.JavaBean;

@JavaBean
public class Rating {
    int rid;
    int bid;
    int uid;
    int score;

    public Rating() {
    }

    public Rating(int rid, int bid, int uid, int score) {
        this.rid = rid;
        this.bid = bid;
        this.uid = uid;
        this.score = score;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rid=" + rid +
                ", bid=" + bid +
                ", uid=" + uid +
                ", score=" + score +
                '}';
    }
}
