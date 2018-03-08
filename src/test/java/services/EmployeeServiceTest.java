package services;

import beans.Employee;
import dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService mockEmployeeService = new EmployeeService();

    @Mock
    EmployeeDao mockDoa = mock(EmployeeDao.class);
    Employee test = new Employee(1,"Noop","Hundal","noopdog","hundal123",1,21.2,1,"122-21-1212","nsh@gmail.com","address","12/12/1992");


    @Test
    void getByID() {
        when(mockDoa.getByID(1)).thenReturn(new Employee());
        assertTrue(mockEmployeeService.getByID(1) != null);
    }

    @Test
    void getByID1() {
        when(mockDoa.getByID(1)).thenReturn(test);
        assertEquals(test,mockEmployeeService.getByID(1));
    }

    @Test
    void getByID2() {
        when(mockDoa.getByID(2)).thenReturn(null);
        assertNull(mockEmployeeService.getByID(2));
    }

    @Test
    void getByUserPassword() {
        when(mockDoa.getByUserPassword("noopdog","hundal123")).thenReturn(test);
        assertEquals(test,mockEmployeeService.getByUserPassword("noopdog","hundal123"));
    }

    @Test
    void newEmployee() {
        EmployeeService mockEmployeeServiceDelete = mock(EmployeeService.class);
        mockEmployeeServiceDelete.newEmployee(any(Employee.class));
        verify(mockEmployeeServiceDelete,times(1)).newEmployee(any(Employee.class));
    }

    @Test
    void update() {
        EmployeeService mockEmployeeServiceDelete = mock(EmployeeService.class);
        mockEmployeeServiceDelete.update(any(Employee.class));
        verify(mockEmployeeServiceDelete,times(1)).update(any(Employee.class));
    }

    @Test
    void delete() {
        EmployeeService mockEmployeeServiceDelete = mock(EmployeeService.class);
        mockEmployeeServiceDelete.delete(any(Employee.class));
        verify(mockEmployeeServiceDelete,times(1)).delete(any(Employee.class));
    }
}