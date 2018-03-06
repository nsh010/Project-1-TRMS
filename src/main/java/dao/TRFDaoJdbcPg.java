package dao;

import beans.TRF;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TRFDaoJdbcPg implements TRFDao {
    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public TRF getByID(int id) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "SELECT * FROM trf WHERE trf_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, id);

            //Execute update
            ResultSet results = ps.executeQuery();

            TRF trf = new TRF();

            while(results.next()) {
                trf.setId(results.getInt("trf_id"));
                trf.setEventName(results.getString("event_name"));
                trf.setEmployeeId(results.getInt("employee_id_ref"));
                trf.setDate(results.getString("date_col"));
                trf.setTime(results.getString("time_col"));
                trf.setStart(results.getString("start_date"));
                trf.setStop(results.getString("stop_date"));
                trf.setMissingWork(results.getInt("missing_work"));
                trf.setLocation(results.getString("place"));
                trf.setDescription(results.getString("description"));
                trf.setCost(results.getDouble("cost_trf"));
                trf.setGradeType(results.getInt("grade_type"));
                trf.setEventType(results.getInt("event_type"));
                trf.setJustification(results.getString("justification"));
                trf.setAttachments(results.getBytes("attachments"));
                trf.setStatus(results.getInt("status"));
                return trf;
            }

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void newForm(TRF trf) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "INSERT INTO trf (event_name, employee_id_ref, date_col, time_col, start_date, " +
                    "stop_date, missing_work, place, description, cost_trf, grade_type, event_type, " +
                    "justification, attachments, status)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING trf_id";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, trf.getEventName());
            ps.setInt(2, trf.getEmployeeId());
            ps.setString(3, trf.getDate());
            ps.setString(4, trf.getTime());
            ps.setString(5, trf.getStart());
            ps.setString(6, trf.getStop());
            ps.setInt(7, trf.getMissingWork());
            ps.setString(8, trf.getLocation());
            ps.setString(9, trf.getDescription());
            ps.setDouble(10, trf.getCost());
            ps.setInt(11, trf.getGradeType());
            ps.setInt(12, trf.getEventType());
            ps.setString(13, trf.getJustification());
            ps.setBytes(14, trf.getAttachments());
            ps.setInt(15, trf.getStatus());

            // Get result set storing the primary key for the newly inserted object
            ResultSet results = ps.executeQuery();
            if(results.next()) {
                //Assign PK to ID field
                trf.setId(results.getInt("trf_id"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(TRF trf) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE trf SET event_name = ?, employee_id_ref = ?, date_col = ?, " +
                    "time_col = ?, start_date = ?, stop_date = ?, missing_work = ?, " +
                    "place = ?, description = ?, cost_trf = ?, grade_type = ?, " +
                    "event_type = ?, justification = ?, attachments = ?, status = ? " +
                    "WHERE trf_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, trf.getEventName());
            ps.setInt(2, trf.getEmployeeId());
            ps.setString(3, trf.getDate());
            ps.setString(4, trf.getTime());
            ps.setString(5, trf.getStart());
            ps.setString(6, trf.getStop());
            ps.setInt(7, trf.getMissingWork());
            ps.setString(8, trf.getLocation());
            ps.setString(9, trf.getDescription());
            ps.setDouble(10, trf.getCost());
            ps.setInt(11, trf.getGradeType());
            ps.setInt(12, trf.getEventType());
            ps.setString(13, trf.getJustification());
            ps.setBytes(14, trf.getAttachments());
            ps.setInt(15, trf.getStatus());
            ps.setInt(16, trf.getId());

            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(TRF trf) {
        try (Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "DELETE FROM trf WHERE trf_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, trf.getId());

            //Execute update
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
