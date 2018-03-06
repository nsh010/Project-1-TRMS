package beans;

import java.util.Arrays;
import java.util.Objects;

public class TRF {
    private int id;
    private String eventName;
    private int employeeId;
    private String date;
    private String time;
    private String start;
    private String stop;
    private int missingWork;
    private String location;
    private String description;
    private double cost;
    private int gradeType;
    private int eventType;
    private String justification;
    private byte[] attachments;
    private int status;

    public TRF(){
        this.id = 0;
        this.eventName = null;
        this.employeeId = 0;
        this.date = null;
        this.time = null;
        this.start = null;
        this.stop = null;
        this.missingWork = 0;
        this.location = null;
        this.description = null;
        this.cost = 0.00;
        this.gradeType = 0;
        this.eventType = 0;
        this.justification = null;
        this.attachments = null;
        this.status = 0;
    }

    public TRF(int id, String eventName, int employeeId, String date, String time, String start, String stop, int missingWork, String location, String description, double cost, int gradeType, int eventType, String justification, byte[] attachments, int status) {
        this.id = id;
        this.eventName = eventName;
        this.employeeId = employeeId;
        this.date = date;
        this.time = time;
        this.start = start;
        this.stop = stop;
        this.missingWork = missingWork;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.gradeType = gradeType;
        this.eventType = eventType;
        this.justification = justification;
        this.attachments = attachments;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getMissingWork() {
        return missingWork;
    }

    public void setMissingWork(int missingWork) {
        this.missingWork = missingWork;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TRF trf = (TRF) o;
        return id == trf.id &&
                employeeId == trf.employeeId &&
                missingWork == trf.missingWork &&
                Double.compare(trf.cost, cost) == 0 &&
                gradeType == trf.gradeType &&
                eventType == trf.eventType &&
                status == trf.status &&
                Objects.equals(eventName, trf.eventName) &&
                Objects.equals(date, trf.date) &&
                Objects.equals(time, trf.time) &&
                Objects.equals(start, trf.start) &&
                Objects.equals(stop, trf.stop) &&
                Objects.equals(location, trf.location) &&
                Objects.equals(description, trf.description) &&
                Objects.equals(justification, trf.justification) &&
                Arrays.equals(attachments, trf.attachments);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, eventName, employeeId, date, time, start, stop, missingWork, location, description, cost, gradeType, eventType, justification, status);
        result = 31 * result + Arrays.hashCode(attachments);
        return result;
    }

    @Override
    public String toString() {
        return "TRF{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", employeeId=" + employeeId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", start='" + start + '\'' +
                ", stop='" + stop + '\'' +
                ", missingWork=" + missingWork +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", gradeType=" + gradeType +
                ", eventType=" + eventType +
                ", justification='" + justification + '\'' +
                ", attachments=" + Arrays.toString(attachments) +
                ", status=" + status +
                '}';
    }
}
