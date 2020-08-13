package com.hiring.placementmanagement;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;

public class UpdateProfileActivity extends AppCompatActivity {

    private EditText studentFullName;
    private EditText studentFatherName;
    private EditText studentDOB;
    private EditText studentRollNo;
    private EditText studentCollegeName;
    private EditText studentYearOfPassingBTECH;
    private EditText studentCGPA;
    private EditText studentJuniorCollege;
    private EditText studentJuniorCollegePercentage;
    private EditText studentSchool;
    private EditText studentSchoolPercentage;
    private EditText studentPhoneNumber;
    private EditText studentProjectsLink;
    private Button studentSubmitButton;

    private FirebaseFirestore firestore;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        studentFullName = findViewById(R.id.student_full_name);
        studentFatherName = findViewById(R.id.student_father_name);
        studentDOB = findViewById(R.id.student_dob);
        studentRollNo = findViewById(R.id.student_rollno);
        studentCollegeName = findViewById(R.id.student_college_name);
        studentYearOfPassingBTECH = findViewById(R.id.student_yearofpassingBTECH);
        studentCGPA = findViewById(R.id.student_cgpa);
        studentJuniorCollege = findViewById(R.id.student_junior_college);
        studentJuniorCollegePercentage = findViewById(R.id.student_junior_college_percentage);
        studentSchool = findViewById(R.id.student_school);
        studentSchoolPercentage = findViewById(R.id.student_school_percentage);
        studentPhoneNumber = findViewById(R.id.student_phone_number);
        studentProjectsLink = findViewById(R.id.student_projects_link);
        studentSubmitButton = findViewById(R.id.student_submit_button);


        studentSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_student_FullName = studentFullName.getText().toString();
                String txt_student_FatherName = studentFatherName.getText().toString();
                String txt_student_DOB = studentDOB.getText().toString();
                String txt_student_RollNo = studentRollNo.getText().toString();
                String txt_student_CollegeName = studentCollegeName.getText().toString();
                String txt_student_YearOfPassingBTECH = studentYearOfPassingBTECH.getText().toString();
                String txt_student_CGPA = studentCGPA.getText().toString();

                if (Double.parseDouble(txt_student_CGPA) > 10) {
                    txt_student_CGPA = Double.toString(Double.parseDouble(txt_student_CGPA) / 10);
                }

                String txt_student_JuniorCollege = studentJuniorCollege.getText().toString();
                String txt_student_JuniorCollegePercentage = studentJuniorCollegePercentage.getText().toString();
                String txt_student_School = studentSchool.getText().toString();
                String txt_student_SchoolPercentage = studentSchoolPercentage.getText().toString();
                String txt_student_PhoneNumber = studentPhoneNumber.getText().toString();
                String txt_student_ProjectsLink = studentProjectsLink.getText().toString();


                if (TextUtils.isEmpty(txt_student_FullName) || TextUtils.isEmpty(txt_student_FatherName)
                        || TextUtils.isEmpty(txt_student_DOB) || TextUtils.isEmpty(txt_student_RollNo) ||
                        TextUtils.isEmpty(txt_student_CollegeName) || TextUtils.isEmpty(txt_student_YearOfPassingBTECH) || TextUtils.isEmpty(txt_student_CGPA)
                        || TextUtils.isEmpty(txt_student_JuniorCollege) || TextUtils.isEmpty(txt_student_JuniorCollegePercentage) || TextUtils.isEmpty(txt_student_School)
                        || TextUtils.isEmpty(txt_student_SchoolPercentage) || TextUtils.isEmpty(txt_student_PhoneNumber)
                        || TextUtils.isEmpty(txt_student_ProjectsLink)) {
                    Toast.makeText(UpdateProfileActivity.this, "Fill Complete Profile", Toast.LENGTH_SHORT).show();
                } else {

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("fullName", txt_student_FullName);
                    map.put("fatherName", txt_student_FatherName);
                    map.put("DOB", txt_student_DOB);
                    map.put("RollNo", txt_student_RollNo);
                    map.put("collegeName", txt_student_CollegeName);
                    map.put("CGPA", txt_student_CGPA);
                    map.put("juniorCollege", txt_student_JuniorCollege);
                    map.put("juniorCollegePercentage", txt_student_JuniorCollegePercentage);
                    map.put("schoolName", txt_student_School);
                    map.put("schoolPercentage", txt_student_SchoolPercentage);
                    map.put("phoneNumber", txt_student_PhoneNumber);
                    map.put("projectsLink", txt_student_ProjectsLink);
                    map.put("YearOfPassingBtech", txt_student_YearOfPassingBTECH);

                    String email = auth.getCurrentUser().getEmail();
                    firestore.collection("Users").document(email).set(map, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(UpdateProfileActivity.this, "Profile successfully updated", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(UpdateProfileActivity.this, LauncherActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onBackPressed(){

    }

}

