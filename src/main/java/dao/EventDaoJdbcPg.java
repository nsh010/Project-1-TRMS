package dao;

import beans.Event;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDaoJdbcPg implements EventDao{
    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public List<Event> getByUserName(String userName) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "SELECT trf_id, event_name" +
                    " FROM trf JOIN users on trf.employee_id_ref = employee_id" +
                    " WHERE user_name = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, userName);

            //Execute update
            ResultSet results = ps.executeQuery();

            List<Event> event = new ArrayList<>();

            while(results.next()) {
                String eventName = results.getString("event_name");
                int id = results.getInt("trf_id");

                event.add(new Event(id, eventName));
            }
            if(event.isEmpty()){
                return null;
            } else return event;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
