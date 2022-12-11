/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lthutrang
 */
public class DateTimeCheckerTest {

    DateTimeChecker d;

    public DateTimeCheckerTest() {
        d = new DateTimeChecker();
    }

    @Test
    @SuppressWarnings("static-access")
    public void testCheckDayInMonth() {
//        byte monthsHas31Days[] = {1, 3, 5, 7, 8, 10, 12};
//        byte monthsHas30Days[] = {4, 6, 9, 11};
//        short leapYears[] = {2000, 2024, 2032, 2400};
//        short nonleapYears[] = {2022, 2023, 2025, 2100, 2200, 2300, 2500};
        assertEquals(31, d.checkDayInMonth(1, (short) 2023));
        assertEquals(31, d.checkDayInMonth(3, (short) 2023));
        assertEquals(31, d.checkDayInMonth(5, (short) 2023));
        assertEquals(31, d.checkDayInMonth(7, (short) 2023));
        assertEquals(31, d.checkDayInMonth(8, (short) 2023));
        assertEquals(31, d.checkDayInMonth(10, (short) 2023));
        assertEquals(31, d.checkDayInMonth(12, (short) 2023));

        assertEquals(30, d.checkDayInMonth(4, (short) 2023));
        assertEquals(30, d.checkDayInMonth(6, (short) 2023));
        assertEquals(30, d.checkDayInMonth(9, (short) 2023));
        assertEquals(30, d.checkDayInMonth(11, (short) 2023));

        assertEquals(29, d.checkDayInMonth((byte) 2, (short) 2000));
        assertEquals(29, d.checkDayInMonth((byte) 2, (short) 2024));
        assertEquals(29, d.checkDayInMonth((byte) 2, (short) 2032));
        assertEquals(29, d.checkDayInMonth((byte) 2, (short) 2400));

        assertEquals(28, d.checkDayInMonth((byte) 2, (short) 2022));
        assertEquals(28, d.checkDayInMonth((byte) 2, (short) 2023));
        assertEquals(28, d.checkDayInMonth((byte) 2, (short) 2025));
        assertEquals(28, d.checkDayInMonth((byte) 2, (short) 2100));
        assertEquals(28, d.checkDayInMonth((byte) 2, (short) 2200));
        assertEquals(28, d.checkDayInMonth((byte) 2, (short) 2300));

    }

    @Test
    @SuppressWarnings("static-access")

    public void testIsValidDate() {
        assertEquals(false, d.isValidDate((byte) 1, (byte) 13, (short) 2022));
        assertEquals(false, d.isValidDate((byte) 1, (byte) 0, (short) 2022));
        for (byte month = 1; month <= 12; month++) {
            assertEquals(false, d.isValidDate((byte) 0, (byte) 1, (short) 2022));
            assertEquals(false, d.isValidDate((byte) 0, (byte) 12, (short) 2022));
            assertEquals(false, d.isValidDate((byte) 32, (byte) 1, (short) 2022));
            assertEquals(false, d.isValidDate((byte) 32, (byte) 12, (short) 2022));

        };
        for (byte month = 1; month <= 12; month++) {
            assertEquals(true, d.isValidDate((byte) 1, (byte) 1, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 2, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 3, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 4, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 5, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 6, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 7, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 8, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 9, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 10, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 11, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 1, (byte) 12, (short) 2022));

            assertEquals(true, d.isValidDate((byte) 28, (byte) 1, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 2, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 3, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 4, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 5, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 6, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 7, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 8, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 9, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 10, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 11, (short) 2022));
            assertEquals(true, d.isValidDate((byte) 28, (byte) 12, (short) 2022));
        };

    }

}
