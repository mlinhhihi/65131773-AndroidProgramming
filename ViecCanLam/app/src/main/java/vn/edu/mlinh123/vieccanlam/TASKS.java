package vn.edu.mlinh123.vieccanlam;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class TASKS implements Serializable {
    String name;
    String date;
    String message;
    String priority;

    public TASKS(String date, String message, String name, String priority) {
        this.date = date;
        this.message = message;
        this.name = name;
        this.priority = priority;
    }

    public TASKS() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    //
    public HashMap<String, String> toFirebaseObject(){
        HashMap<String, String> taskObjects = new HashMap<String, String>();
        taskObjects.put("name",name);
        taskObjects.put("date",date);
        taskObjects.put("message",message);
        taskObjects.put("priority",priority);
        return taskObjects;
    }
}
