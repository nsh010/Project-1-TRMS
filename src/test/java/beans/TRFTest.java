package beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TRFTest {
    TRF test = new TRF(1,"Event",2,"12/12/1992","12:30","12/12/2017","12/13/2017",8,"Delaware","Description",12.5,2,1,"Justification",null,2);

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
    void getEventName() {
        assertEquals("Event",test.getEventName());
    }

    @Test
    void setEventName() {
        test.setEventName("Name");
        assertEquals("Name",test.getEventName());
    }

    @Test
    void getEmployeeId() {
        assertEquals(2,test.getEmployeeId());
    }

    @Test
    void setEmployeeId() {
        test.setEmployeeId(1);
        assertEquals(1,test.getEmployeeId());
    }

    @Test
    void getDate() {
        assertEquals("12/12/1992",test.getDate());
    }

    @Test
    void setDate() {
        test.setDate("12/11/1992");
        assertEquals("12/11/1992",test.getDate());
    }

    @Test
    void getTime() {
        assertEquals("12:30",test.getTime());
    }

    @Test
    void setTime() {
        test.setTime("12:45");
        assertEquals("12:45",test.getTime());
    }

    @Test
    void getStart() {
        assertEquals("12/12/2017",test.getStart());
    }

    @Test
    void setStart() {
        test.setStart("12/13/2017");
        assertEquals("12/13/2017",test.getStart());
    }

    @Test
    void getStop() {
        assertEquals("12/13/2017",test.getStop());
    }

    @Test
    void setStop() {
        test.setStop("12/14/2017");
        assertEquals("12/15/2017",test.getStop());
    }

    @Test
    void getMissingWork() {
        assertEquals(8,test.getMissingWork());
    }

    @Test
    void setMissingWork() {
        test.setMissingWork(10);
        assertEquals(10,test.getMissingWork());
    }

    @Test
    void getLocation() {
        assertEquals("Delaware",test.getLocation());
    }

    @Test
    void setLocation() {
        test.setLocation("Maryland");
        assertEquals("Maryland",test.getLocation());
    }

    @Test
    void getDescription() {
        assertEquals("Description",test.getDescription());
    }

    @Test
    void setDescription() {
        test.setDescription("Enter Description Here ");
        assertEquals("Enter Description Here ",test.getDescription());
    }

    @Test
    void getCost() {
        assertEquals(12.5,test.getCost());
    }

    @Test
    void setCost() {
        test.setCost(13.74);
        assertEquals(13.74,test.getCost());
    }

    @Test
    void getGradeType() {
        assertEquals(2,test.getGradeType());
    }

    @Test
    void setGradeType() {
        test.setGradeType(0);
        assertEquals(0,test.getGradeType());
    }

    @Test
    void getEventType() {
        assertEquals(1,test.getEventType());
    }

    @Test
    void setEventType() {
        test.setEventType(2);
        assertEquals(2,test.getEventType());
    }

    @Test
    void getJustification() {
        assertEquals("Justification",test.getJustification());
    }

    @Test
    void setJustification() {
        test.setJustification("Enter here");
        assertEquals("Enter here",test.getJustification());
    }

    @Test
    void getAttachments() {
        assertEquals(null,test.getAttachments());
    }

    @Test
    void setAttachments() {
        byte[] testa = {};
        test.setAttachments(testa);
        assertEquals(testa,test.getAttachments());
    }

    @Test
    void getStatus() {
        assertEquals(2,test.getStatus());
    }

    @Test
    void setStatus() {
        test.setStatus(1);
        assertEquals(1,test.getStatus());
    }
}