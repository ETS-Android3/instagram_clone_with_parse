package com.example.parse_instagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

  public static final String TAG = "LoginActivity";
  private EditText etUsername;
  private EditText etPassword;
  private Button btnLogin;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Set the content view to activity_login layout view
    setContentView(R.layout.activity_login);

    // Attach references to buttons in activity_login
    etUsername = findViewById(R.id.etUsername);
    etPassword = findViewById(R.id.etPassword);
    btnLogin = findViewById(R.id.btn_login);

    // Set button onclick listener
    btnLogin.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        Log.i(TAG, "onClick btnLogin");

        // Grab string input into username
        String username = etUsername.getText().toString();

        // Grab string input into password
        String password = etPassword.getText().toString();

        // Login the user
        loginUser(username, password);
      }
    });
  }

  private void loginUser(String username, String password) {
    Log.i(TAG, "Attempting to log in user: " + username);
    
    // Login in background
    ParseUser.logInInBackground(username, password, new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if (e != null) {
          Log.e(TAG, "Issue with login", e);
          Toast.makeText(LoginActivity.this, "Issue with login.", Toast.LENGTH_LONG).show();

          EditText myEditText = ((EditText) findViewById(R.id.etPassword));
          myEditText.getText().clear();

          return;
        }
        // Navigate to main activity
        goMainActivity();
        Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
      }
    });
  }

  // Go to main activity via an intent
  private void goMainActivity() {
    Intent i = new Intent(this, MainActivity.class);
    startActivity(i);
  }
}
