package com.example.domain;

/**
 * @Auther: ld
 * @Date: 2018/10/25 11:50
 * @Description:
 */
public class Teacher {
    private int tid;
    private String tname;
    private Classes classes;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", classes=" + classes +
                '}';
    }
}
