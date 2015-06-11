package com.max.sample;

import org.codehaus.jackson.annotate.JsonProperty;

public class Student implements Comparable<Student> {
    private String lastName;
    private int age;
    private int grade;

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonProperty("grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student other) {
        int compareResult = this.getLastName().compareTo(other.getLastName());
        if (compareResult == 0) {
            compareResult = this.getAge() - other.getAge();
        }
        if (compareResult == 0) {
            compareResult = this.getGrade() - other.getGrade();
        }
        return compareResult;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
