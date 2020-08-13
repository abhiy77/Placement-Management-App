package com.hiring.placementmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Company;
import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Question;
import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Student;

import java.util.ArrayList;


public class StudentHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout studentDrawer;
    private FrameLayout studentFragmentContainer;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private Student student;
    private Bundle bundle;
    private ArrayList<Question> questionList;
    private ArrayList<Company> allCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(StudentHomeActivity.this, LauncherActivity.class));
            finish();
        }

        String email = auth.getCurrentUser().getEmail();
        allCompanies = new ArrayList<>();
        student = new Student();
        initialize(student, email);
        questionList = getQuestions();
        getAllCompanies();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity_home);


        Toolbar studentToolbar = findViewById(R.id.student_toolbar);
        setSupportActionBar(studentToolbar);

        studentDrawer = findViewById(R.id.student_drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, studentDrawer, studentToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        studentDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.student_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        studentFragmentContainer = findViewById(R.id.student_fragment_container);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.student_fragment_container, new StudentHomeFragment()).commit();
            navigationView.setCheckedItem(R.id.student_nav_home);
        }

        bundle = new Bundle();
        bundle.putSerializable("Student", student);
        bundle.putParcelableArrayList("QUESTION_LIST",questionList);
        bundle.putParcelableArrayList("allCompanies",allCompanies);
    }

    @Override
    public void onBackPressed() {
        if (studentDrawer.isDrawerOpen(GravityCompat.START)) {
            studentDrawer.closeDrawer(GravityCompat.START);
        } else {

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.student_nav_home:
                StudentHomeFragment studentHomeFragment = new StudentHomeFragment();
                Toast.makeText(StudentHomeActivity.this, student.toString(), Toast.LENGTH_LONG);
                getSupportFragmentManager().beginTransaction().replace(R.id.student_fragment_container, studentHomeFragment).commit();
                break;
            case R.id.student_nav_profile:
                StudentProfileFragment profileFragment = new StudentProfileFragment();
                profileFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.student_fragment_container, profileFragment).commit();
                break;

            case R.id.student_nav_companies:
                StudentCompanyFragment companyFragment = new StudentCompanyFragment();
                companyFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.student_fragment_container,companyFragment).commit();
                break;
            case R.id.student_nav_grades:
                getSupportFragmentManager().beginTransaction().replace(R.id.student_fragment_container, new StudentHomeFragment()).commit();
                break;
            case R.id.student_mock_test:
                StudentMockTestFragment mockTestFragment = new StudentMockTestFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.student_fragment_container, mockTestFragment).commit();
                mockTestFragment.setArguments(bundle);
                break;
            case R.id.student_nav_logout:

        }
        studentDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initialize(final Student student, final String email) {
        DocumentReference ref = firestore.collection("Users").document(email);
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    student.setEmail(documentSnapshot.getString("email"));
                    student.setPassword(documentSnapshot.getString("password"));
                    student.setFullName(documentSnapshot.getString("fullName"));
                    student.setFatherName(documentSnapshot.getString("fatherName"));
                    student.setDOB(documentSnapshot.getString("DOB"));
                    student.setRollNo(documentSnapshot.getString("RollNo"));
                    student.setCollegeName(documentSnapshot.getString("collegeName"));
                    student.setCGPA(documentSnapshot.getString("CGPA"));
                    student.setJuniorCollege(documentSnapshot.getString("juniorCollege"));
                    student.setJuniorCollegePercentage(documentSnapshot.getString("juniorCollegePercentage"));
                    student.setSchoolName(documentSnapshot.getString("schoolName"));
                    student.setSchoolPercentage(documentSnapshot.getString("schoolPercentage"));
                    student.setPhoneNumber(documentSnapshot.getString("phoneNumber"));
                    student.setProjectLink(documentSnapshot.getString("projectsLink"));
                    student.setYearOfPassing(documentSnapshot.getString("YearOfPassingBtech"));

                }
            }
        });

    }

    public void getAllCompanies(){
        firestore.collection("Companies").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Company cur = new Company();

                        cur.setCompanyName(document.getString("companyName"));
                        cur.setCompanyImage(document.getString("image"));
                        cur.setDescription(document.getString("description"));
                        cur.setCGPA(document.getString("CGPA"));
                        cur.setContactNumber(document.getString("contact"));
                        cur.setCompanyPackage(document.getString("package"));

                        allCompanies.add(cur);
                    }
                } else {
                    System.out.println("Error");
                }
            }
        });

    }

    private ArrayList<Question> getQuestions(){

        final ArrayList<Question> questionList = new ArrayList<>();

        CollectionReference ref = firestore.collection("MockTest");
        ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for(DocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Question question = documentSnapshot.toObject(Question.class);
                    questionList.add(question);
                }
            }
        });

        return questionList;
    }

}
