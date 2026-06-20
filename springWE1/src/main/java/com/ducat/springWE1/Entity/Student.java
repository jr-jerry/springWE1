package com.ducat.springWE1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuId;
    private int stuAge;
    private String stuName;
    public int getStuId() {
        return stuId;
    }
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
    public int getStuAge() {
        return stuAge;
    }
    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}