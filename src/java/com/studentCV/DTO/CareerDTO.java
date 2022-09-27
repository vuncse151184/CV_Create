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
public class CareerDTO implements Serializable{

    public int careerId;
    public String careerName;
    public boolean status;

    public CareerDTO() {
    }

    public CareerDTO(int careerId, String careerName, boolean status) {
        this.careerId = careerId;
        this.careerName = careerName;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCareerId() {
        return careerId;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

}
