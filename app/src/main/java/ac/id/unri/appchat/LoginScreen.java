package ac.id.unri.appchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email, pass;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        email = findViewById(R.id.titlemail);
        pass = findViewById(R.id.titlepassword);
        btnLogin = findViewById(R.id.btnlogin);
        btnRegister = findViewById(R.id.btnregister);

        //firebase auth
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_email = email.getText().toString().trim();
                String str_pass = pass.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(str_email,str_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginScreen.this, "Login Gagal, Username atau password salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_register = new Intent(LoginScreen.this, RegisterActivity.class);
                startActivity(i_register);
                finish();
            }
        });

    }
}