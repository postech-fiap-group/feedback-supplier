package org.fiap.avaliacao.entity;

public class Assessment {

    private String description;
    private int grade;

    public Assessment(String description, int grade) {
        this.description = description;
        this.grade = grade;
    }

    public Assessment() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
