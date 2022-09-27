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
public class MajorDTO implements Serializable{

    public String majorId;
    public String majorName;
    public boolean status;

    public MajorDTO() {
    }

    public MajorDTO(String majorId, String majorName, boolean status) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

}
