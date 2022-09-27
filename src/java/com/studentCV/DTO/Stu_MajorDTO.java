/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.DTO;

import java.io.Serializable;

/**
 *
 * @author tungp
 */
public class Stu_MajorDTO implements Serializable{

    public StudentDTO student;
    public MajorDTO major;
    public boolean status;

    public Stu_MajorDTO() {
    }

    public Stu_MajorDTO(StudentDTO student, MajorDTO major, boolean status) {
        this.student = student;
        this.major = major;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public MajorDTO getMajor() {
        return major;
    }

    public void setMajor(MajorDTO major) {
        this.major = major;
    }

}
