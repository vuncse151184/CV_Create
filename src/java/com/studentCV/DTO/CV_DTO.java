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
public class CV_DTO implements Serializable{

    public int cvId;
    public StudentDTO student;
    public boolean status;

    public CV_DTO() {
    }

    public CV_DTO(int cvId, StudentDTO student, boolean status) {
        this.cvId = cvId;
        this.student = student;
        this.status = status;
    }

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
