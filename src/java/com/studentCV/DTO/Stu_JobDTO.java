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
public class Stu_JobDTO implements Serializable{

    public StudentDTO student;
    public JobDTO job;
    public boolean status;

    public Stu_JobDTO() {
    }

    public Stu_JobDTO(StudentDTO student, JobDTO job, boolean status) {
        this.student = student;
        this.job = job;
        this.status = status;
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

    public JobDTO getJob() {
        return job;
    }

    public void setJob(JobDTO job) {
        this.job = job;
    }

}
