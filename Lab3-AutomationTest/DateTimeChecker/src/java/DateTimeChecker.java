/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lthutrang
 */
public class DateTimeChecker {

    public static byte checkDayInMonth(int month, short year) {
          
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                case 12:
                    return 32;
                case 2:
                     if (year % 4 == 0 && year % 100 != 0) {
                        return 29;
                    }else if (year % 400 == 0) {
                        return 29;
                    } 
                     else {
                        return 28;
                    }
                default:
                    return 30;
            }
        
    }

    public static boolean isValidDate(byte day, byte month, short year) {
        if (year > 1000 & year < 3000){
        if (month >= 1  && month <= 12 ) {
            if (day >= 1) {
                return day <= checkDayInMonth(month, year);
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else{
            return false;
        }
    }
}
