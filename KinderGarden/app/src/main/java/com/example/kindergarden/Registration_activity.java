package com.example.kindergarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kindergarden.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration_activity extends AppCompatActivity {


    private ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_registration);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

       binding.registrationButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (binding.emailFieldR.getText().toString().isEmpty() || binding.passwordFieldR.getText().toString().isEmpty() || binding.childNumberField.getText().toString().isEmpty() || binding.nameFiled.getText().toString().isEmpty() || binding.groupNumbField.getText().toString().isEmpty()) {
                   Toast.makeText(getApplicationContext(), "Поля не могут быть пустыми", Toast.LENGTH_LONG);
               }
               else {
                   FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.emailFieldR.getText().toString(), binding.passwordFieldR.getText().toString())
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                HashMap<String, String> userInfo = new HashMap<>();
                                userInfo.put("email", binding.emailFieldR.getText().toString());
                                userInfo.put("group", binding.groupNumbField.getText().toString());
                                userInfo.put("child_number", binding.childNumberField.getText().toString());
                                userInfo.put("full_name", binding.nameFiled.getText().toString());

                                FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);

                                startActivity(new  Intent(Registration_activity.this, MainActivity.class));
                            }

                               }
                           });
               }
           }
       });

    }
}