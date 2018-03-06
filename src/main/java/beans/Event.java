package beans;

import java.util.Objects;

public class Event {
    private int id;
    private String eventName;

    public Event(int id, String eventName) {
        this.id = id;
        this.eventName = eventName;
    }

    public Event(){
        this.id = 0;
        this.eventName = null;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(eventName, event.eventName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, eventName);
    }
}
