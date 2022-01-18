package com.example.etest.question;

import android.os.Parcel;

import java.io.Serializable;

public class Question implements Serializable {

    private int id;
    private String question;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private int num_exam;
    private String subjest;
    private String image;
    private  String answer=" ";
    public int position=-1;


    protected Question(Parcel in) {
        id = in.readInt();
        question = in.readString();
        ans_a = in.readString();
        ans_b = in.readString();
        ans_c = in.readString();
        ans_d = in.readString();
        result = in.readString();
        num_exam = in.readInt();
        subjest = in.readString();
        image = in.readString();
        answer = in.readString();
        position = in.readInt();
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String answer) {
        this.answer = answer;
    }

    ;

    public Question(){

    }

    public Question(int id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, int num_exam, String subjest, String image) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.num_exam = num_exam;
        this.subjest = subjest;
        this.image = image;
        this.answer=answer;
    }

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

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }

    public String getSubjest() {
        return subjest;
    }

    public void setSubjest(String subjest) {
        this.subjest = subjest;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}
