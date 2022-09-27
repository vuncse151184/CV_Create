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
public class CV_CompanyDTO implements Serializable{

    public CV_DTO cv;
    public CompanyDTO company;
    public boolean status;

    public CV_CompanyDTO() {
    }

    public CV_CompanyDTO(CV_DTO cv, CompanyDTO company, boolean status) {
        this.cv = cv;
        this.company = company;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CV_DTO getCv() {
        return cv;
    }

    public void setCv(CV_DTO cv) {
        this.cv = cv;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

}
