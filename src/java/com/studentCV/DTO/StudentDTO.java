/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentCV.DTO;

import java.io.Serializable;

/**
 *
 * @author minhh
 */
public class StudentDTO implements Serializable{

    public int studentId;
    public String jobPosition;
    public String eduQua;
    public int experience;
    public String stuName;
    public String phoneNum;
    public String addr;
    public String email;
    public boolean status;

    public StudentDTO() {
    }

    public StudentDTO(String email) {
        this.email = email;
    }

    public StudentDTO(int studentId, String jobPosition, String eduQua, int experience, String stuName, String phoneNum, String addr, String email, boolean status) {
        this.studentId = studentId;
        this.jobPosition = jobPosition;
        this.eduQua = eduQua;
        this.experience = experience;
        this.stuName = stuName;
        this.phoneNum = phoneNum;
        this.addr = addr;
        this.email = email;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getEduQua() {
        return eduQua;
    }

    public void setEduQua(String eduQua) {
        this.eduQua = eduQua;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
