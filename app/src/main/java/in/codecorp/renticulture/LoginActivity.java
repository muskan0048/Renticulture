package in.codecorp.renticulture;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private EditText editEmail;
    private EditText editPassword;
    private Context mContext;
    private TextView textRegister;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textRegister = (TextView) findViewById(R.id.textRegister);
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(this);
        textRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textRegister:
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
                break;
            case R.id.btnLogin:
                loginFunctionality();
                break;
        }
    }


    private void loginFunctionality() {

        String userId = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        if (userId.equals("") || userId.equals(null)) {
            Toast.makeText(LoginActivity.this, "Please enter Username", Toast.LENGTH_LONG).show();
            editEmail.requestFocus();
        } else if (password.equals("") || password.equals(null)) {
            Toast.makeText(LoginActivity.this, "Please enter Password", Toast.LENGTH_LONG).show();
            editPassword.requestFocus();
        } else {
//            progressDialog.setMessage("LOADING");
            //          progressDialog.show();
            login(userId, password);
        }
    }

    void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Hi", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //   sessionManager.createLoginSession(user.getUid());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Hi", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }
                    }
                });

    }

}
