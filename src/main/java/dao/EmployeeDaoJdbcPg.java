package dao;

import beans.Employee;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoJdbcPg implements EmployeeDao {
    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();


    @Override
    public Employee getByID(int id) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "SELECT employee_id, first_name, last_name, user_name, user_password, account_type, " +
                    "reimbursement_amount, team_id_ref, ssn, email, address, dob" +
                    " FROM users" +
                    " WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, id);

            //Execute update
            ResultSet results = ps.executeQuery();

            Employee employee = new Employee();

            while(results.next()) {
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setUserName(results.getString("user_name"));
                employee.setPassword(results.getString("user_password"));
                employee.setAccountType(results.getInt("account_type"));
                employee.setReimbursement(results.getDouble("reimbursement_amount"));
                employee.setTeam_id(results.getInt("team_id_ref"));
                employee.setSsn(results.getString("ssn"));
                employee.setEmail(results.getString("email"));
                employee.setAddress(results.getString("address"));
                employee.setDOB(results.getString("dob"));
                employee.setId(results.getInt("employee_id"));
                return employee;
            }

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public Employee getByUserPassword(String userName, String password) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "SELECT employee_id, first_name, last_name, user_name, user_password, account_type, reimbursement_amount, " +
                                "team_id_ref, ssn, email, address, dob" +
                                " FROM users" +
                                " WHERE user_name = ? AND user_password = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, userName);
            ps.setString(2, password);

            //Execute update
            ResultSet results = ps.executeQuery();

            Employee employee = new Employee();

            while(results.next()) {
                employee.setId(results.getInt("employee_id"));
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setUserName(results.getString("user_name"));
                employee.setPassword(results.getString("user_password"));
                employee.setAccountType(results.getInt("account_type"));
                employee.setReimbursement(results.getDouble("reimbursement_amount"));
                employee.setTeam_id(results.getInt("team_id_ref"));
                employee.setSsn(results.getString("ssn"));
                employee.setEmail(results.getString("email"));
                employee.setAddress(results.getString("address"));
                employee.setDOB(results.getString("dob"));
                return employee;
            }



        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void newEmployee(Employee employee) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "INSERT INTO users (first_name, last_name, user_name, user_password, account_type, " +
                                "reimbursement_amount, team_id_ref, ssn, email, address, dob)" +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING employee_id";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUserName());
            ps.setString(4, employee.getPassword());
            ps.setInt(5, employee.getAccountType());
            ps.setDouble(6, employee.getReimbursement());
            ps.setInt(7, employee.getTeam_id());
            ps.setString(8, employee.getSsn());
            ps.setString(9, employee.getEmail());
            ps.setString(10, employee.getAddress());
            ps.setString(11, employee.getDOB());

            // Get result set storing the primary key for the newly inserted object
            ResultSet results = ps.executeQuery();
            if(results.next()) {
                //Assign PK to ID field
                employee.setId(results.getInt("employee_id"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Employee employee) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE users SET first_name = ?, last_name = ?, user_name = ?, " +
                                "user_password = ?, account_type = ?, reimbursement_amount = ?, team_id_ref = ?, " +
                                    "ssn = ?, email = ?, address = ?, dob = ?" +
                                        "WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUserName());
            ps.setString(4, employee.getPassword());
            ps.setInt(5, employee.getAccountType());
            ps.setDouble(6, employee.getReimbursement());
            ps.setInt(7, employee.getTeam_id());
            ps.setString(8, employee.getSsn());
            ps.setString(9, employee.getEmail());
            ps.setString(10, employee.getAddress());
            ps.setString(11, employee.getDOB());
            ps.setInt(12, employee.getId());



            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee employee) {
        try(Connection conn = connectionUtil.getConnection()) {
            //Prepare query
            String query = "DELETE FROM users WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setInt(1, employee.getId());

            //Execute update
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
