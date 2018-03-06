package beans;

import java.util.Objects;

public class Reimbursement {
    private int id;
    private int event_id;
    private int status;
    private int teamApproval;
    private int teamEmployeeId;
    private int deptApproval;
    private int deptEmployeeId;
    private int benCoApproval;
    private int benCoUser;
    private int grade;
    private int employee_id_GM;
    private double amount;

    public Reimbursement() {
        this.id = 0;
        this.event_id = 0;
        this.status = 0;
        this.teamApproval = 0;
        this.teamEmployeeId = 0;
        this.deptApproval = 0;
        this.deptEmployeeId = 0;
        this.benCoApproval = 0;
        this.benCoUser = 0;
        this.grade = 0;
        this.employee_id_GM = 0;
        this.amount = 0;
    }

    public Reimbursement(int id, int event_id, int status, int teamApproval, int teamEmployeeId, int deptApproval, int deptEmployeeId, int benCoApproval, int benCoUser, int grade, int employee_id_GM, double amount) {
        this.id = id;
        this.event_id = event_id;
        this.status = status;
        this.teamApproval = teamApproval;
        this.teamEmployeeId = teamEmployeeId;
        this.deptApproval = deptApproval;
        this.deptEmployeeId = deptEmployeeId;
        this.benCoApproval = benCoApproval;
        this.benCoUser = benCoUser;
        this.grade = grade;
        this.employee_id_GM = employee_id_GM;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTeamApproval() {
        return teamApproval;
    }

    public void setTeamApproval(int teamApproval) {
        this.teamApproval = teamApproval;
    }

    public int getTeamEmployeeId() {
        return teamEmployeeId;
    }

    public void setTeamEmployeeId(int teamEmployeeId) {
        this.teamEmployeeId = teamEmployeeId;
    }

    public int getDeptApproval() {
        return deptApproval;
    }

    public void setDeptApproval(int deptApproval) {
        this.deptApproval = deptApproval;
    }

    public int getDeptEmployeeId() {
        return deptEmployeeId;
    }

    public void setDeptEmployeeId(int deptEmployeeId) {
        this.deptEmployeeId = deptEmployeeId;
    }

    public int getBenCoApproval() {
        return benCoApproval;
    }

    public void setBenCoApproval(int benCoApproval) {
        this.benCoApproval = benCoApproval;
    }

    public int getBenCoUser() {
        return benCoUser;
    }

    public void setBenCoUser(int benCoUser) {
        this.benCoUser = benCoUser;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getEmployee_id_GM() {
        return employee_id_GM;
    }

    public void setEmployee_id_GM(int employee_id_GM) {
        this.employee_id_GM = employee_id_GM;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id &&
                event_id == that.event_id &&
                status == that.status &&
                teamApproval == that.teamApproval &&
                teamEmployeeId == that.teamEmployeeId &&
                deptApproval == that.deptApproval &&
                deptEmployeeId == that.deptEmployeeId &&
                benCoApproval == that.benCoApproval &&
                benCoUser == that.benCoUser &&
                grade == that.grade &&
                employee_id_GM == that.employee_id_GM &&
                Double.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, event_id, status, teamApproval, teamEmployeeId, deptApproval, deptEmployeeId, benCoApproval, benCoUser, grade, employee_id_GM, amount);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", event_id=" + event_id +
                ", status=" + status +
                ", teamApproval=" + teamApproval +
                ", teamEmployeeId=" + teamEmployeeId +
                ", deptApproval=" + deptApproval +
                ", deptEmployeeId=" + deptEmployeeId +
                ", benCoApproval=" + benCoApproval +
                ", benCoUser=" + benCoUser +
                ", grade=" + grade +
                ", employee_id_GM=" + employee_id_GM +
                ", amount=" + amount +
                '}';
    }
}
