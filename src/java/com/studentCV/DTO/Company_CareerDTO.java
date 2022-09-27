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
public class Company_CareerDTO implements Serializable{

    public CareerDTO career;
    public CompanyDTO company;
    public boolean status;

    public Company_CareerDTO() {
    }

    public Company_CareerDTO(CareerDTO career, CompanyDTO company, boolean status) {
        this.career = career;
        this.company = company;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CareerDTO getCareer() {
        return career;
    }

    public void setCareer(CareerDTO career) {
        this.career = career;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

}
