package services;

import beans.Event;
import dao.EventDao;
import dao.EventDaoJdbcPg;

import java.util.List;

public class EventService {
    private static EventDao eventDao = new EventDaoJdbcPg();

    public List<Event> getByUserName(String userName){
        return eventDao.getByUserName(userName);
    }
}
