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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Company;
import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Student;

import java.util.ArrayList;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link StudentProfileFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link StudentProfileFragment#newInstance} factory method to
// * create an instance of this fragment.
// */

public class StudentCompanyFragment extends Fragment{

    Student student;
    ArrayList<Company> eligibleCompanies = new ArrayList<>();
    ListView eligibleCompanyListView;
    EligibleCompanyAdapter eligibleCompanyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_company, container, false);
    }

    public StudentCompanyFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            student = (Student)getArguments().getSerializable("Student");
            ArrayList<Company> allCompanies = getArguments().getParcelableArrayList("allCompanies");

            assert allCompanies != null;
            getEligibleCompanies(student, allCompanies);
        }
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){

        eligibleCompanyListView = view.findViewById(R.id.eligibleCompanyListView);

        eligibleCompanyAdapter = new EligibleCompanyAdapter(getActivity().getApplicationContext(), eligibleCompanies);

        eligibleCompanyListView.setAdapter(eligibleCompanyAdapter);
    }

    public void getEligibleCompanies(final Student student, final ArrayList<Company> allCompanies){
        for(Company cur : allCompanies){
            if(Double.parseDouble(cur.getCGPA()) <= Double.parseDouble(student.getCGPA()))
                eligibleCompanies.add(cur);
        }
    }
}
