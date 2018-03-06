package dao;

import beans.Event;

import java.util.List;

public interface EventDao {

    public List<Event> getByUserName(String userName);

}
