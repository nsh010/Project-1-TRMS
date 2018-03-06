package dao;

import beans.Reimbursement;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementDaoJdbcPg implements ReimbursementDao {
    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public Reimbursement getByID(int id) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "SELECT * FROM approval WHERE approval_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, id);

            //Execute update
            ResultSet results = ps.executeQuery();

            Reimbursement reimbursement = new Reimbursement();

            while(results.next()) {
                reimbursement.setId(results.getInt("approval_id"));
                reimbursement.setEvent_id(results.getInt("event_id"));
                reimbursement.setStatus(results.getInt("status"));
                reimbursement.setTeamApproval(results.getInt("team_approval"));
                reimbursement.setTeamEmployeeId(results.getInt("team_user"));
                reimbursement.setDeptApproval(results.getInt("department_approval"));
                reimbursement.setDeptEmployeeId(results.getInt("department_user"));
                reimbursement.setBenCoApproval(results.getInt("benCo_approval"));
                reimbursement.setBenCoUser(results.getInt("benCo_user"));
                reimbursement.setGrade(results.getInt("grade"));
                reimbursement.setEmployee_id_GM(results.getInt("employee_id_GM"));
                reimbursement.setAmount(results.getDouble("amount"));
                return reimbursement;
            }

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public void newTRF(Reimbursement reimbursement) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "INSERT INTO approval (event_id, status, team_approval, team_user, " +
                    "department_approval, department_user, benCo_approval, benCo_user, grade, employee_id_GM, amount)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING approval_id";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, reimbursement.getEvent_id());
            ps.setInt(2, reimbursement.getStatus());
            ps.setInt(3, reimbursement.getTeamApproval());
            ps.setInt(4, reimbursement.getTeamEmployeeId());
            ps.setInt(5, reimbursement.getDeptApproval());
            ps.setInt(6, reimbursement.getDeptEmployeeId());
            ps.setInt(7, reimbursement.getBenCoApproval());
            ps.setInt(8, reimbursement.getBenCoUser());
            ps.setInt(9, reimbursement.getGrade());
            ps.setInt(10, reimbursement.getEmployee_id_GM());
            ps.setDouble(11, reimbursement.getAmount());

            // Get result set storing the primary key for the newly inserted object
            ResultSet results = ps.executeQuery();
            if(results.next()) {
                //Assign PK to ID field
                reimbursement.setId(results.getInt("approval_id"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reimbursement reimbursement) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE approval SET event_id = ?, status = ?, team_approval = ?, " +
                    "team_user = ?, department_approval = ?, department_user = ?, benCo_approval = ?, " +
                    "benCo_user = ?, grade = ?, employee_id_GM = ?, amount =?" +
                    "WHERE approval_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, reimbursement.getEvent_id());
            ps.setInt(2, reimbursement.getStatus());
            ps.setInt(3, reimbursement.getTeamApproval());
            ps.setInt(4, reimbursement.getTeamEmployeeId());
            ps.setInt(5, reimbursement.getDeptApproval());
            ps.setInt(6, reimbursement.getDeptEmployeeId());
            ps.setInt(7, reimbursement.getBenCoApproval());
            ps.setInt(8, reimbursement.getBenCoUser());
            ps.setInt(9, reimbursement.getGrade());
            ps.setInt(10, reimbursement.getEmployee_id_GM());
            ps.setDouble(11, reimbursement.getAmount());
            ps.setInt(12, reimbursement.getId());

            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Reimbursement reimbursement) {
        try (Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "DELETE FROM approval WHERE approval_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, reimbursement.getId());

            //Execute update
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
