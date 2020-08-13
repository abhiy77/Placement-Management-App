package com.hiring.placementmanagement.com.hiring.placementmanagement.model;

import java.io.Serializable;

public class Student implements Serializable {

    private String email;
    private String fullName;
    private String password;
    private String rollNo;
    private String fatherName;
    private String collegeName;
    private String phoneNumber;
    private String CGPA;
    private String projectLink;
    private String DOB;
    private String yearOfPassing;
    private String juniorCollege;
    private String JuniorCollegePercentage;
    private String schoolName;
    private String schoolPercentage;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getJuniorCollege() {
        return juniorCollege;
    }

    public void setJuniorCollege(String juniorCollege) {
        this.juniorCollege = juniorCollege;
    }

    public String getJuniorCollegePercentage() {
        return JuniorCollegePercentage;
    }

    public void setJuniorCollegePercentage(String juniorCollegePercentage) {
        JuniorCollegePercentage = juniorCollegePercentage;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolPercentage() {
        return schoolPercentage;
    }

    public void setSchoolPercentage(String schoolPercentage) {
        this.schoolPercentage = schoolPercentage;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", CGPA='" + CGPA + '\'' +
                ", projectLink='" + projectLink + '\'' +
                ", DOB='" + DOB + '\'' +
                ", yearOfPassing='" + yearOfPassing + '\'' +
                ", juniorCollege='" + juniorCollege + '\'' +
                ", JuniorCollegePercentage='" + JuniorCollegePercentage + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolPercentage='" + schoolPercentage + '\'' +
                '}';
    }
}
