package dao;

import beans.Reimbursement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementDaoJdbcPgTest {

    @Test
    void getByID() {
        Reimbursement test = new Reimbursement(0,0,1,1,1,1,1,1,1,100,1,200.40);
        Reimbursement DB = new ReimbursementDaoJdbcPg().getByID(0);
        assertEquals(test,DB);
    }

    @Test
    void newTRF() {
        // change the id to 1 and changed status to 5
        Reimbursement test = new Reimbursement(1,0,5,1,1,1,1,1,1,100,1,200.40);
        ReimbursementDao doa = new ReimbursementDaoJdbcPg();
        doa.newTRF(test);
        Reimbursement DB = new ReimbursementDaoJdbcPg().getByID(1);
        assertEquals(test,DB);
    }

    @Test
    void update() {
        //change status
        Reimbursement test = new Reimbursement(0,0,5,1,1,1,1,1,1,100,1,200.40);
        ReimbursementDao doa = new ReimbursementDaoJdbcPg();
        doa.update(test);
        Reimbursement DB = new ReimbursementDaoJdbcPg().getByID(0);
        assertEquals(test,DB);

    }

    @Test
    void delete() {
        ReimbursementDao doa = new ReimbursementDaoJdbcPg();
        Reimbursement test =  new ReimbursementDaoJdbcPg().getByID(1);
        doa.delete(test);
        assertEquals(null,doa.getByID(1));
    }
}