package beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    Event test = new Event(10,"New Event");

    @Test
    void getId() {
        assertEquals(10,test.getId());
    }

    @Test
    void setId() {
        test.setId(12);
        assertEquals(12,test.getId());
    }

    @Test
    void getEventName() {
        assertEquals("New Event",test.getEventName());
    }

    @Test
    void setEventName() {
        test.setEventName("Old Event");
        assertEquals("Old Event",test.getEventName());
    }
}