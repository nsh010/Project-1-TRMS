package dao;

import beans.Employee;

public interface EmployeeDao {

    public Employee getByID(int id);

    public Employee getByUserPassword(String userName, String password);

    public void newEmployee(Employee employee);

    public void update(Employee employee);

    public void delete(Employee employee);
}
