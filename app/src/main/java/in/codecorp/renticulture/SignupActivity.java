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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import in.codecorp.renticulture.Models.User;

public class SignupActivity extends AppCompatActivity {

    private Context mContext;
    private EditText editUsername;
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editCityName;
    private EditText editMobileNo;
    private EditText editEmail;
    private EditText editPassword;
    private Button btnRegister;
    private String userName;
    private String firstName;
    private String lastName;
    private String cityName;
    private String mobileNo;
    private String email;
    //SessionLogin sessionLogin;
    private String password;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mContext = this;
        //    progressDialog = new ProgressDialog(getApplicationContext());
        //      progressDialog.setMessage("Loading");
//        progressDialog.show();
        initUI();
    }

    private void initUI() {
        editUsername = (EditText) findViewById(R.id.editUsername);
        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        //  editCityName = (EditText) findViewById(R.id.editCityName);
        editMobileNo = (EditText) findViewById(R.id.editMobileNo);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        // tilUsername = (TextInputLayout) findViewById(R.id.tilUsername);
        //tilFirstName = (TextInputLayout) findViewById(R.id.tilFirstName);
        //tilLastName = (TextInputLayout) findViewById(R.id.tilLastName);
        //tilCityName = (TextInputLayout) findViewById(R.id.tilCityName);
        //tilMobileNo = (TextInputLayout) findViewById(R.id.tilMobileNo);
        //tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        //tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        mAuth = FirebaseAuth.getInstance();

        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invalidateField();
            }
        });
    }

    private void invalidateField() {
        userName = editUsername.getText().toString().trim();
        firstName = editFirstName.getText().toString().trim();
        lastName = editLastName.getText().toString().trim();
        //cityName = editCityName.getText().toString().trim();
        mobileNo = editMobileNo.getText().toString().trim();
        email = editEmail.getText().toString().trim();
        password = editPassword.getText().toString().trim();
        createUser(firstName,lastName, userName, email,mobileNo,password);

     /*   tilUsername.setError("");
        tilFirstName.setError("");
        tilLastName.setError("");
        tilCityName.setError("");
        tilMobileNo.setError("");
        tilEmail.setError("");
        tilPassword.setError("");
        if (userName.equals("")) {
            tilUsername.setError("Enter UserName");
            editUsername.requestFocus();
        } else if (firstName.equals("")) {
            tilFirstName.setError("Enter First Name");
            editFirstName.requestFocus();
        } else if (lastName.equals("")) {
            tilLastName.setError("Enter Last Name");
            editLastName.requestFocus();
        } else if (cityName.equals("")) {
            tilCityName.setError("Enter City Name");
            editCityName.requestFocus();
        } else if (mobileNo.equals("")) {
            tilMobileNo.setError("Enter Your Mobile No");
            editMobileNo.requestFocus();
        } else if (email.equals("") ) {
            tilEmail.setError("Enter Valid Email");
            editEmail.requestFocus();
        } else if (password.equals("")) {
            tilPassword.setError("Enter Your Password");
            editPassword.requestFocus();
        } *///else {
        // RegisterAsyncTask loginAsyncTask = new RegisterAsyncTask();
        //loginAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }



    void insertData(User user, String r){
        databaseReference.child(r).setValue(user);
    }

    void createUser(final String name,final String lname,final String uname, final String email, final String phone, final String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("hi", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            String r =user.getUid();
                            User user1 = new User(r, name,lname, uname, email, phone, password);
                            insertData(user1, r);
                            //sessionManager.createLoginSession(r);
                            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(intent);
                            //  updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Hi", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //   updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
