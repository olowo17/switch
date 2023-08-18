package com.interswitch.services.taskservice.model;

public class Task {

    private Long id;
    private String name;
//    private Long employeeId;

    private Long isAssignedTo;

    public Task() {
    }

//    public Task(String name, Long employeeId) {
//        this.name = name;
//        this.employeeId = employeeId;
//    }

    public Task(String name, Long isAssignedTo) {
        this.name = name;
        this.isAssignedTo = isAssignedTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getIsAssignedTo() {
        return isAssignedTo;
    }

    public void setIsAssignedTo(Long isAssignedTo) {
        this.isAssignedTo = isAssignedTo;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAssignedTo=" + isAssignedTo +
                '}';
    }
}
