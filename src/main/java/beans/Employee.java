package beans;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int accountType;
    private double reimbursement;
    private int team_id;
    private String ssn;
    private String email;
    private String address;
    private String DOB;


    public Employee() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.userName = null;
        this.password = null;
        this.accountType = 0;
        this.reimbursement = 0.00;
        this.team_id = 0;
        this.ssn = null;
        this.email = null;
        this.address = null;
        this.DOB = null;
    }

    public Employee(int id, String firstName, String lastName, String userName, String password, int accountType, double reimbursement, int team_id, String ssn, String email, String address, String DOB) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
        this.reimbursement = reimbursement;
        this.team_id = team_id;
        this.ssn = ssn;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(double reimbursement) {
        this.reimbursement = reimbursement;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                accountType == employee.accountType &&
                Double.compare(employee.reimbursement, reimbursement) == 0 &&
                team_id == employee.team_id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(userName, employee.userName) &&
                Objects.equals(password, employee.password) &&
                Objects.equals(ssn, employee.ssn) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(DOB, employee.DOB);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, userName, password, accountType, reimbursement, team_id, ssn, email, address, DOB);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", reimbursement=" + reimbursement +
                ", team_id=" + team_id +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }
}
