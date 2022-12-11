/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lthutrang
 */
@WebServlet(urlPatterns = {"/check"})
public class CheckingController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "form": {
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
            break;
            case "form_handler": {
                form_hanler(request, response);
            }
            break;
            case "close": {
                request.getRequestDispatcher("/").forward(request, response);
            }
            break;
        }
    }

    protected void form_hanler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dayStr = request.getParameter("day");
        String monthStr = request.getParameter("month");
        String yearStr = request.getParameter("year");
        request.setAttribute("day", dayStr);
        request.setAttribute("month", monthStr);
        request.setAttribute("year", yearStr);
        byte day = 0;
        byte month = 0;
        short year = 0;
        String check;
        //Check format input
        if (Pattern.matches("\\d{1,}", dayStr)) {
            if (Pattern.matches("\\d{1,2}", dayStr)) {
                day = Byte.parseByte(dayStr);
            } else {
                request.setAttribute("message", "Input data for Day is out of range!");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
            if (day < 1 || day > 31) {
                request.setAttribute("message", "Input data for Day is out of range!");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Input data for Day is incorrect format!");
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
        if (Pattern.matches("\\d{1,}", monthStr)) {
            if (Pattern.matches("\\d{1,2}", monthStr)) {
                month = Byte.parseByte(monthStr);
            } else {
                request.setAttribute("message", "Input data for Month is out of range!");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
            if (month < 1 || month > 12) {
                request.setAttribute("message", "Input data for Month is out of range!");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Input data for Month is incorrect format!");
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
        if (Pattern.matches("\\d{1,}", yearStr)) {
            if (Pattern.matches("\\d{1,4}", yearStr)) {
                year = Short.parseShort(yearStr);
            } else {
                request.setAttribute("message", "Input data for Year is out of range!");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
            if (year < 1000 || year > 3000) {
                request.setAttribute("message", "Input data for Year is out of range!");
                request.getRequestDispatcher("form.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Input data for Year is incorrect format!");
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }

        //Check validate 
        if (DateTimeChecker.isValidDate(day, month, year)) {
            check = "";
        } else {
            check = "NOT";
        }
        request.setAttribute("message", day+"/"+month+"/"+year+ check + " correct date time!");
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
