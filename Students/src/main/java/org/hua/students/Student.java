package org.hua.students;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int id;
    private double grade;

    public Student() {
        name = null;
        id = 0;
        grade = 0;
    }

    public void setDetails(String aName, int anId, Double aGrade) {
        name = aName;
        id = anId;
        grade = aGrade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Double getGrade() {
        return grade;
    }


}