package com.hiring.placementmanagement.com.hiring.placementmanagement.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable {
    private String companyName;
    private String CGPA;
    private String companyPackage;
    private String companyImage;
    private String contactNumber;
    private String description;

    public Company() {
    }

    protected Company(Parcel in) {
        companyName = in.readString();
        CGPA = in.readString();
        companyPackage = in.readString();
        companyImage = in.readString();
        contactNumber = in.readString();
        description = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", CGPA='" + CGPA + '\'' +
                ", companyPackage='" + companyPackage + '\'' +
                ", companyImage='" + companyImage + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getCompanyPackage() {
        return companyPackage;
    }

    public void setCompanyPackage(String companyPackage) {
        this.companyPackage = companyPackage;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(companyName);
        parcel.writeString(CGPA);
        parcel.writeString(companyPackage);
        parcel.writeString(companyImage);
        parcel.writeString(contactNumber);
        parcel.writeString(description);
    }
}