package org.passinhos.passinhos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.passinhos.passinhos.Models.Mask;
import org.passinhos.passinhos.Models.User;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    EditText name;
    EditText cpf;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText) findViewById(R.id.login_username);
        cpf = (EditText) findViewById(R.id.login_cpf);
        btn = (Button) findViewById(R.id.login_confirm);

        name.setText(User.instance().getUsername());
        cpf.setText(User.instance().getCPF());

        cpf.addTextChangedListener(Mask.insert("###.###.###-##", cpf));

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().equals("") && !cpf.getText().equals("")) {
                    Intent i = new Intent(LoginActivity.this, NavigationActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                    Snackbar.make(v, "Usuário ou senha não pode ser nulos!", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}

