package com.hiring.placementmanagement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Student;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link StudentProfileFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link StudentProfileFragment#newInstance} factory method to
// * create an instance of this fragment.
// */

public class StudentProfileFragment extends Fragment{

    Student studentInfo;

    private TextView studentFullName;
    private TextView studentFatherName;
    private TextView studentDOB;
    private TextView studentRollNo;
    private TextView studentCollegeName;
    private TextView studentYearOfPassing;
    private TextView studentCGPA;
    private TextView studentJuniorCollege;
    private TextView studentJuniorCollegePercentage;
    private TextView studentSchool;
    private TextView studentSchoolPercentage;
    private TextView studentEmail;
    private TextView studentPhoneNumber;
    private TextView studentProjectsLink;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public StudentProfileFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            studentInfo = (Student)getArguments().getSerializable("Student");
        }

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        studentFullName = getView().findViewById(R.id.profile_student_full_name);
        studentFatherName = getView().findViewById(R.id.profile_student_father_name);
        studentDOB = getView().findViewById(R.id.profile_student_DOB);
        studentRollNo= getView().findViewById(R.id.profile_student_roll_no);
        studentCollegeName = getView().findViewById(R.id.profile_student_college_name);
        studentYearOfPassing = getView().findViewById(R.id.profile_student_year_of_passing);
        studentCGPA = getView().findViewById(R.id.profile_student_CGPA);
        studentJuniorCollege= getView().findViewById(R.id.profile_student_junior_college);
        studentJuniorCollegePercentage = getView().findViewById(R.id.profile_student_junior_college_percentage);
        studentSchool = getView().findViewById(R.id.profile_student_school);
        studentSchoolPercentage = getView().findViewById(R.id.profile_student_school_percentage);
        studentEmail = getView().findViewById(R.id.profile_student_email);
        studentPhoneNumber = getView().findViewById(R.id.profile_student_phone_number);
        studentProjectsLink = getView().findViewById(R.id.profile_student_projects_link);

        studentFullName.setText(studentInfo.getFullName());
        studentFatherName.setText(studentInfo.getFatherName());
        studentDOB.setText(studentInfo.getDOB());
        studentRollNo.setText(studentInfo.getRollNo());
        studentCollegeName.setText(studentInfo.getCollegeName());
        studentYearOfPassing.setText(studentInfo.getYearOfPassing());
        studentCGPA.setText(studentInfo.getCGPA());
        studentJuniorCollege.setText(studentInfo.getJuniorCollege());
        studentJuniorCollegePercentage.setText(studentInfo.getJuniorCollegePercentage());
        studentSchool.setText(studentInfo.getSchoolName());
        studentSchoolPercentage.setText(studentInfo.getSchoolPercentage());
        studentEmail.setText(studentInfo.getEmail());
        studentPhoneNumber.setText(studentInfo.getPhoneNumber());
        studentProjectsLink.setText(studentInfo.getProjectLink());
    }
}