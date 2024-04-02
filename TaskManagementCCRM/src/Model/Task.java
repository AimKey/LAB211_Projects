package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private TaskType typeId;
    private String requirementName, assignee, reviewer;
    private String planFrom, planTo;
    private LocalDate date;

    public Task(Tasks tasks, TaskType typeId, String requirementName, Double planFrom, Double planTo, String assignee,
            String reviewer, String date) throws Exception {
        this.id = tasks.getCurId();
        this.typeId = typeId;
        this.requirementName = requirementName;
        this.planFrom = getTimeByDouble(planFrom);
        this.planTo = getTimeByDouble(planTo);
        this.assignee = assignee;
        this.reviewer = reviewer;
        setDate(date);
    }

    private String getTimeByDouble(Double d) {
        Double remain = (d % Math.floor(d)) * 60; // 8.5 % 8 = 0.5 -> 0.5 * 60 = 30
        return String.format("%s h %s", ((int) Math.floor(d)), remain.intValue() == 0 ? "" : remain.intValue());
    }

    public TaskType getTypeId() {
        return typeId;
    }

    public void setTypeId(TaskType typeId) {
        this.typeId = typeId;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDate(String date) throws Exception {
        if (!date.matches("\\d{2}/\\d{2}/\\d{4}"))
            throw new Exception("Wrong date format (dd/MM/yyyy)");
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        String s = String.format("%-5s %-10s %-15s %-15s %-15s %-10s %-10s", id, typeId, requirementName, assignee,
                reviewer, planFrom, planTo, getDate());
        return s;
    }

}
