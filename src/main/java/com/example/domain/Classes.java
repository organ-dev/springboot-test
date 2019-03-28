package com.example.domain;

/**
 * @Auther: ld
 * @Date: 2018/10/25 11:50
 * @Description:
 */
public class Classes {
    private int cid;
    private String cname;
    private Teacher teacher;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
