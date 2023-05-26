package ac.id.unri.appchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText reg_email, reg_pass;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_email = findViewById(R.id.reg_email);
        reg_pass = findViewById(R.id.reg_password);
        btnRegister = findViewById(R.id.button_reg);

        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_email = reg_email.getText().toString().trim();
                String str_pass = reg_pass.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(str_email, str_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Akun berhasil dibuat...", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterActivity.this, LoginScreen.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Error, Pembuatan akun gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}