package com.example.kindergarden;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.kindergarden.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.firebase.ui.database.FirebaseListOptions;




public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static int SIGN_IN_CODE=1;



    BottomNavigationView bottomNavigationView;

    ChatFragment chatFragment = new ChatFragment();
    ReviewFragment reviewFragment = new ReviewFragment();
    HometasksFragment hometasksFragment = new HometasksFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_CODE) {
            if (resultCode == RESULT_OK) {
                Snackbar.make(activity_main, "Вы авторизованы", Snackbar.LENGTH_LONG).show();

            }
            else {
                Snackbar.make(activity_main, "Вы не авторизованы", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Registration_activity.class));
            }
        }
    }

    private RelativeLayout activity_main;
    private FloatingActionButton sendBtn;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*

        setContentView(R.layout.activity_main);
        activity_main = findViewById(R.id.activity_main);
        sendBtn = findViewById(R.id.btnSend);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textField = findViewById(R.id.messageField);
                if(textField.getText().toString() == "")
                    return;

                FirebaseDatabase.getInstance().getReference().push().setValue(
                        new Message(
                                FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                        textField.getText().toString()
                        )
                );
                textField.setText("");
            }
        });
        if(FirebaseAuth.getInstance().getCurrentUser()==null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_CODE);
        else {
            Snackbar.make(activity_main, "Вы авторизованы", Snackbar.LENGTH_LONG).show();
            displayAllMessages();
        }

        */

      setContentView(R.layout.activity_main);

      bottomNavigationView = findViewById(R.id.bottom_nav);

      getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
      bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem item) {
              switch (item.getItemId()){
                  case R.id.chat:
                      getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
                      return true;
                  case R.id.psyho_review:
                      getSupportFragmentManager().beginTransaction().replace(R.id.container, reviewFragment).commit();
                      return true;
                  case R.id.notification:
                      getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationsFragment).commit();
                      return true;
                  case R.id.homework:
                      getSupportFragmentManager().beginTransaction().replace(R.id.container, hometasksFragment).commit();
                      return true;


              }
              return false;
          }
      });




/*

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController); */


    }



}