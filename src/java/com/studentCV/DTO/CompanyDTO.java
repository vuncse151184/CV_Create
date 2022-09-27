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
public class CompanyDTO implements Serializable{

    public String companyId;
    public String companyName;
    public String specialization;
    public String email;
    public String phoneNumber;
    public String addr;
    public String img;
    public boolean status;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyId, String companyName, String specialization, String email, String phoneNumber, String addr, String img, boolean status) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.specialization = specialization;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addr = addr;
        this.img = img;
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
