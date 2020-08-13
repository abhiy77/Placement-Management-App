package com.hiring.placementmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText passwordSignUp;
    private EditText confirmPasswordSignUp;
    private EditText emailSignUp;
    private Button signUpButton;
    private TextView studentLoginView;

    private FirebaseAuth auth;
    private FirebaseFirestore firestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailSignUp =  findViewById(R.id.emailSignUp);
        passwordSignUp =  findViewById(R.id.passwordSignUp);
        confirmPasswordSignUp = findViewById(R.id.confirmPasswordSignUp);
        signUpButton = findViewById(R.id.signUpButton);
        studentLoginView = findViewById(R.id.student_login_view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailSignUp.getText().toString();
                final String password = passwordSignUp.getText().toString();
                String confirmPassword = confirmPasswordSignUp.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this,"Enter correct email and password",Toast.LENGTH_LONG).show();
                }
                else if(!password.equals(confirmPassword)){
                    Toast.makeText(RegisterActivity.this,"Password mismatch",Toast.LENGTH_LONG).show();
                }
                else if(password.length() < 8){
                    Toast.makeText(RegisterActivity.this,"Password should have a minimum of 8 characters",Toast.LENGTH_LONG).show();
                }
                else{
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                HashMap<String,Object> map = new HashMap<>();
                                map.put("email",email);
                                map.put("password",password);

                                firestore.collection("Users").document(email).set(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_LONG).show();
                                    }
                                });


                                Intent intent = new Intent(RegisterActivity.this,UpdateProfileActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

        studentLoginView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(RegisterActivity.this,StudentLoginActivity.class));
            }
        });

    }
}