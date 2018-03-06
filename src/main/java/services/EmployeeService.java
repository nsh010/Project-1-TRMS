package services;

import beans.Employee;
import dao.EmployeeDao;
import dao.EmployeeDaoJdbcPg;

public class EmployeeService {
    private static EmployeeDao employeeDao = new EmployeeDaoJdbcPg();


    public Employee getByID(int id){
        return employeeDao.getByID(id);
    }

    public Employee getByUserPassword(String userName, String password){
        return employeeDao.getByUserPassword(userName,password);
    }

    public void newEmployee(Employee employee){
        employeeDao.newEmployee(employee);
    }

    public void update(Employee employee){
        employeeDao.update(employee);
    }

    public void delete(Employee employee){
        employeeDao.delete(employee);
    }
}
