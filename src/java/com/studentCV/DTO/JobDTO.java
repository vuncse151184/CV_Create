/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentCV.DTO;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author minhh
 */
public class JobDTO implements Serializable{

    public int jobId;
    public CompanyDTO company;
    public String jobReq;
    public String jobName;
    public float salary;
    public String jobType;
    public String jobLocation;
    public String jobExperience;
    public LocalDate jobPostDate;
    public String jobDescription;
    public boolean status;

    public JobDTO() {
    }

    public JobDTO(int jobId, CompanyDTO company, String jobReq, String jobName, float salary, String jobType, String jobLocation, String jobExperience, LocalDate jobPostDate, String jobDescription, boolean status) {
        this.jobId = jobId;
        this.company = company;
        this.jobReq = jobReq;
        this.jobName = jobName;
        this.salary = salary;
        this.jobType = jobType;
        this.jobLocation = jobLocation;
        this.jobExperience = jobExperience;
        this.jobPostDate = jobPostDate;
        this.jobDescription = jobDescription;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public String getJobReq() {
        return jobReq;
    }

    public void setJobReq(String jobReq) {
        this.jobReq = jobReq;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public LocalDate getJobPostDate() {
        return jobPostDate;
    }

    public void setJobPostDate(LocalDate jobPostDate) {
        this.jobPostDate = jobPostDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
