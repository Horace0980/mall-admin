package com.cskaoyan.malladmin.bean.market;

import java.util.Date;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 20:39
 */

public class Issue {
    int id;
    String question;
    String answer;
    Date addTime;
    Date updateTime;
    boolean deleted;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Issue() {
    }

    public Issue(int id, String question, String answer, Date addTime, Date updateTime, boolean deleted) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
