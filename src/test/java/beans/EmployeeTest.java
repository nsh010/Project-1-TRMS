package beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getId() {
        Employee employee = new Employee();
        employee.setId(1);
        assertEquals(1,employee.getId());
    }

    @Test
    void setId() {
        Employee employee = new Employee();
        employee.setId(1);
        assertEquals(1,employee.getId());
    }

    @Test
    void getFirstName() {
        Employee employee = new Employee();
        employee.setFirstName("Noop");
        assertEquals("Noop",employee.getFirstName());
    }

    @Test
    void setFirstName() {
        Employee employee = new Employee();
        employee.setFirstName("Noop");
        assertEquals("Noop",employee.getFirstName());
    }

    @Test
    void getLastName() {
        Employee employee = new Employee();
        employee.setLastName("Hundal");
        assertEquals("Hundal",employee.getLastName());
    }

    @Test
    void setLastName() {
        Employee employee = new Employee();
        employee.setLastName("Hundal");
        assertEquals("Hundal",employee.getLastName());
    }

    @Test
    void getUserName() {
        Employee employee = new Employee();
        employee.setUserName("nshundal");
        assertEquals("nshundal",employee.getUserName());
    }

    @Test
    void setUserName() {
        Employee employee = new Employee();
        employee.setUserName("nshundal");
        assertEquals("nshundal",employee.getUserName());
    }

    @Test
    void getPassword() {
        Employee employee = new Employee();
        employee.setPassword("HunNoopdal4848");
        assertEquals("HunNoopdal4848",employee.getPassword());
    }

    @Test
    void setPassword() {
        Employee employee = new Employee();
        employee.setPassword("HunNoopdal4848");
        assertEquals("HunNoopdal4848",employee.getPassword());
    }

    @Test
    void getAccountType() {
        Employee employee = new Employee();
        employee.setAccountType(1);
        assertEquals(1,employee.getAccountType());
    }

    @Test
    void setAccountType() {
        Employee employee = new Employee();
        employee.setAccountType(1);
        assertEquals(1,employee.getAccountType());
    }

    @Test
    void getReimbursement() {
        Employee employee = new Employee();
        employee.setReimbursement(1.02);
        assertEquals(1.02,employee.getReimbursement());
    }

    @Test
    void setReimbursement() {
        Employee employee = new Employee();
        employee.setReimbursement(1.02);
        assertEquals(1.02,employee.getReimbursement());
    }

    @Test
    void getTeam_id() {
        Employee employee = new Employee();
        employee.setTeam_id(100);
        assertEquals(100,employee.getTeam_id());
    }

    @Test
    void setTeam_id() {
        Employee employee = new Employee();
        employee.setTeam_id(100);
        assertEquals(100,employee.getTeam_id());
    }

    @Test
    void getSsn() {
        Employee employee = new Employee();
        employee.setSsn("012-32-1213");
        assertEquals("012-32-1213",employee.getSsn());
    }

    @Test
    void setSsn() {
        Employee employee = new Employee();
        employee.setSsn("012-32-1213");
        assertEquals("012-32-1213",employee.getSsn());
    }

    @Test
    void getEmail() {
        Employee employee = new Employee();
        employee.setEmail("noop@gmail.com");
        assertEquals("noop@gmail.com",employee.getEmail());
    }

    @Test
    void setEmail() {
        Employee employee = new Employee();
        employee.setEmail("noop@gmail.com");
        assertEquals("noop@gmail.com",employee.getEmail());
    }

    @Test
    void getAddress() {
        Employee employee = new Employee();
        employee.setAddress("112 safe way lane");
        assertEquals("112 safe way lane",employee.getAddress());
    }

    @Test
    void setAddress() {
        Employee employee = new Employee();
        employee.setAddress("112 safe way lane");
        assertEquals("112 safe way lane",employee.getAddress());
    }

    @Test
    void getDOB() {
        Employee employee = new Employee();
        employee.setDOB("12/12/1992");
        assertEquals("12/12/1992",employee.getDOB());
    }

    @Test
    void setDOB() {
        Employee employee = new Employee();
        employee.setDOB("12/12/1992");
        assertEquals("12/12/1992",employee.getDOB());
    }
}