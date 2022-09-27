/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentCV.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author tungn
 */
public class Utils {

    public static long countDate(LocalDate date) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String nowFormatt = now.format(formatter);
        String dateFormatt = date.format(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long difference_In_Days = 0;
        try {
            Date d1 = sdf.parse(nowFormatt);
            Date d2 = sdf.parse(dateFormatt);

            long difference_In_Time = d2.getTime() - d1.getTime();

            difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difference_In_Days > 0 ? difference_In_Days : -1;
    }
}
