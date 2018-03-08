package controllers;

import beans.Employee;
import beans.Reimbursement;
import beans.TRF;
import services.EmployeeService;
import services.JsonSerializer;
import services.ReimbursementService;
import services.TRFService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class newTRMS extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //get the claim
        BufferedReader reader = req.getReader();
        TRF claims = (TRF) new JsonSerializer().deserialize(reader, TRF.class);
        // new claim, set status to pending == 0
        claims.setStatus(0);
        // get cookies to determine the user
        Cookie[] cookies = req.getCookies();
        String userName = null,password = null;
        for(Cookie cookie : cookies){
            if (cookie.getName().equals("username")){
                userName = cookie.getValue();
                break;
            }
        }
        for(Cookie cookie : cookies){
            if (cookie.getName().equals("password")){
                password = cookie.getValue();
                break;
            }
        }
        //get user object
        EmployeeService employeeService = new EmployeeService();
        Employee test = employeeService.getByUserPassword(userName,password);
        claims.setEmployeeId(test.getId());
        
        TRFService service = new TRFService();
        service.newForm(claims);
    }
}
