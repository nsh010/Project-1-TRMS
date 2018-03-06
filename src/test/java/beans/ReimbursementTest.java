package beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementTest {
    Reimbursement test = new Reimbursement(1,2,3,4,5,6,7,8,9,100,11,12.5);

    @Test
    void getId() {
        assertEquals(1,test.getId());
    }

    @Test
    void setId() {
        test.setId(2);
        assertEquals(2,test.getId());
    }

    @Test
    void getEvent_id() {
        assertEquals(2,test.getEvent_id());
    }

    @Test
    void setEvent_id() {
        test.setEvent_id(3);
        assertEquals(3,test.getEvent_id());
    }

    @Test
    void getStatus() {
        assertEquals(3,test.getStatus());
    }

    @Test
    void setStatus() {
        test.setStatus(4);
        assertEquals(4, test.getStatus());
    }

    @Test
    void getTeamApproval() {
        assertEquals(4,test.getTeamApproval());
    }

    @Test
    void setTeamApproval() {
        test.setTeamApproval(5);
        assertEquals(5,test.getTeamApproval());
    }

    @Test
    void getTeamEmployeeId() {
        assertEquals(5, test.getTeamEmployeeId());
    }

    @Test
    void setTeamEmployeeId() {
        test.setTeamEmployeeId(6);
        assertEquals(6, test.getTeamEmployeeId());
    }

    @Test
    void getDeptApproval() {
        assertEquals(6, test.getDeptApproval());
    }

    @Test
    void setDeptApproval() {
        test.setDeptApproval(7);
        assertEquals(7,test.getDeptApproval());
    }

    @Test
    void getDeptEmployeeId() {
        assertEquals(7, test.getDeptEmployeeId());
    }

    @Test
    void setDeptEmployeeId() {
        test.setDeptEmployeeId(8);
        assertEquals(8,test.getDeptEmployeeId());
    }

    @Test
    void getBenCoApproval() {
        assertEquals(8,test.getBenCoApproval());
    }

    @Test
    void setBenCoApproval() {
        test.setBenCoApproval(9);
        assertEquals(9,test.getBenCoApproval());
    }

    @Test
    void getBenCoUser() {
        assertEquals(9,test.getBenCoUser());
    }

    @Test
    void setBenCoUser() {
        test.setBenCoUser(10);
        assertEquals(10,test.getBenCoUser());
    }

    @Test
    void getGrade() {
        assertEquals(100,test.getGrade());
    }

    @Test
    void setGrade() {
        test.setGrade(90);
        assertEquals(90,test.getGrade());
    }

    @Test
    void getEmployee_id_GM() {
        assertEquals(11,test.getEmployee_id_GM());
    }

    @Test
    void setEmployee_id_GM() {
        test.setEmployee_id_GM(12);
        assertEquals(12,test.getEmployee_id_GM());
    }

    @Test
    void getAmount() {
        assertEquals(12.5,test.getAmount());
    }

    @Test
    void setAmount() {
        test.setAmount(15.53);
        assertEquals(15.53,test.getAmount());
    }
}