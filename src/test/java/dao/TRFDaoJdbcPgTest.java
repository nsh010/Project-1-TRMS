package dao;

import beans.TRF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TRFDaoJdbcPgTest {

    @Test
    void getByID() {
        TRF test = new TRF(0,"New Event",1,"2017-12-23","12:30:00","2017-12-13","2017-12-15",8,"delaware","aldsfjal",50,2,1,"1231",null,1);
        TRF DB = new TRFDaoJdbcPg().getByID(0);
        assertEquals(test, DB);
    }

    @Test
    void newForm() {
        //change the id to 1 and changed eventName
        TRF test = new TRF(1,"Change",1,"2017-12-23","12:30:00","2017-12-13","2017-12-15",8,"delaware","aldsfjal",50,2,1,"1231",null,1);
        TRFDao testDao = new TRFDaoJdbcPg();
        testDao.newForm(test);
        TRF check = testDao.getByID(1);
        assertEquals(test,check);
    }

    @Test
    void update() {
        //changed the event name
        TRF test = new TRF(0,"Event",1,"2017-12-23","12:30:00","2017-12-13","2017-12-15",8,"delaware","aldsfjal",50,2,1,"1231",null,1);
        TRFDao testDao = new TRFDaoJdbcPg();
        testDao.update(test);
        TRF check = testDao.getByID(0);
        assertEquals(test,check);
    }

    @Test
    void delete() {
        TRFDao testDao = new TRFDaoJdbcPg();
        TRF test = new TRFDaoJdbcPg().getByID(1);
        testDao.delete(test);
        assertEquals(null,testDao.getByID(1));
    }
}