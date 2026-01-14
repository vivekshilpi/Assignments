package com.miniproject3;

public class Student {
    private int id;
    private String name;
    private String branch;
    private double percentage;
    private int yearOfPassing;
    private int semester;

    public Student(int id, String name, String branch, double percentage, int yearOfPassing, int semester) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
        this.yearOfPassing = yearOfPassing;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-10s | Branch: %-5s | %%: %.2f | YOP: %d | Sem: %d", 
                id, name, branch, percentage, yearOfPassing, semester);
    }
}