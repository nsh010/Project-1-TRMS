package controllers;

import beans.Employee;
import beans.Event;
import com.google.gson.Gson;
import services.AuthService;
import services.EmployeeService;
import services.EventService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Claims extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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


        EventService eventService = new EventService();
        List<Event> list = eventService.getByUserName(test.getUserName());
        String output = new Gson().toJson(list);
        resp.setStatus(200);
        resp.setHeader("Authorization", new AuthService().getToken(test));
        resp.getWriter().write(output);

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }
}
