package controllers;

import beans.Employee;
import beans.Reimbursement;
import beans.TRF;
import services.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class newTRMS extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        claims.setDate(dtf.format(now));

        // add the new form
        TRFService service = new TRFService();
        service.newForm(claims);



        // new form created so created new reimbursement form
        Reimbursement newForm = new Reimbursement();
        newForm.setEvent_id(claims.getId());
        newForm.setEmployee_id_GM(test.getId());
        Double money = claims.getCost();
        switch (claims.getEventType()){
            //Uiversity 80%
            case 1:
                money = Double.valueOf(Math.round((money*0.8)));
                break;
            // Seminars 60%
            case 2:
                money = Double.valueOf(Math.round((money*0.6)));
                break;
            // Certification Preparation Classes 75%
            case 3:
                money = Double.valueOf(Math.round((money*0.75)));
                break;
            // Certification 100%
            case 4:
                break;
            // Technical Training 90%
            case 5:
                money = Double.valueOf(Math.round((money*0.9)));
                break;
            // Other 30%
            case 6:
                money = Double.valueOf(Math.round((money*0.3)));
                break;
            default:
                money = 0.0;
                break;
        }


        newForm.setAmount(money);
        ReimbursementService reimbursementService = new ReimbursementService();
        reimbursementService.newTRF(newForm);
        resp.setStatus(200);
        resp.setHeader("Authorization", new AuthService().getToken(test));
        //resp.getWriter().write(output);
    }
}
