package dao;

import beans.Event;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventDaoJdbcPgTest {

    @Test
    void getByUserName() {
        List<Event> test = new EventDaoJdbcPg().getByUserName("noopdog");
        Event checkUN = new Event(0,"event");
        List<Event> check = new ArrayList<>();
        check.add(checkUN);
        assertEquals(test,check);
    }
}