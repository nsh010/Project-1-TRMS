package dao;

import beans.Employee;
import org.junit.jupiter.api.Test;
import sun.security.pkcs11.Secmod;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoJdbcPgTest {

    @Test
    void getByID() {
        Employee test = new Employee(1,"Noop","Hundal","noopdog","hundal123",1,21.2,1,"122-21-1212","nsh@gmail.com","address","12/12/1992");
        Employee DB = new EmployeeDaoJdbcPg().getByID(1);
        assertEquals(test, DB);
    }

    @Test
    void getByUserPassword() {
        Employee test = new Employee(1,"Noop","Hundal","noopdog","hundal123",1,21.2,1,"122-21-1212","nsh@gmail.com","address","12/12/1992");
        Employee DB = new EmployeeDaoJdbcPg().getByUserPassword("noopdog","hundal123");
        assertEquals(test, DB);
    }

    @Test
    void newEmployee() {
        Employee newEmploy = new Employee(9,"harrison","ju","HarrisonJu","123456",1,500,1,"121-12-1214","harrison@gmail.com","address","12/12/1982");
        EmployeeDao testDao = new EmployeeDaoJdbcPg();
        testDao.newEmployee(newEmploy);
        Employee check = testDao.getByID(9);
        assertEquals(newEmploy,check);

    }

    @Test
    void update() {
        //change name
        Employee newEmploy = new Employee(2,"john","smith","HarrisonJu","123456",1,500,1,"121-12-1214","harrison@gmail.com","address","12/12/1982");
        EmployeeDao testDao = new EmployeeDaoJdbcPg();
        testDao.update(newEmploy);
        Employee check = testDao.getByID(2);
        assertEquals(newEmploy,check);
    }

    @Test
    void delete() {
        EmployeeDao testDao = new EmployeeDaoJdbcPg();
        Employee test = new EmployeeDaoJdbcPg().getByID(9);
        testDao.delete(test);
        assertEquals(null,testDao.getByID(9));
    }
}