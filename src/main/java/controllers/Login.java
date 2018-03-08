package controllers;

import beans.Employee;
import com.google.gson.Gson;
import services.AuthService;
import services.EmployeeService;
import services.JsonSerializer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        BufferedReader reader = req.getReader();
        Employee login = (Employee) new JsonSerializer().deserialize(reader, Employee.class);
        EmployeeService service = new EmployeeService();
        Employee test = service.getByUserPassword(login.getUserName(),login.getPassword());

        if(test.getUserName().equals(login.getUserName()) && test.getPassword().equals(login.getPassword())) {
            String output = new Gson().toJson(test);
            resp.setStatus(200);
            resp.setHeader("Authorization", new AuthService().getToken(test));
            resp.getWriter().write(output);
        }
    }
}
