package com.example.vincent.utilisateurs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.create) Button create;
    @BindView(R.id.display) Button display;
    @BindView(R.id.valider) Button valider;
    @BindView(R.id.name) EditText name;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.urlimg) EditText urlimg;
    @BindView(R.id.form) LinearLayout form;

    @BindView(R.id.rvUser) RecyclerView rvUser;

    private ArrayList<User> alRep = new ArrayList<>();
    private boolean ifForm = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(new Adapter(alRep));
        create.setText(getString(R.string.create));
        display.setText(getString(R.string.display));
    }

    @OnClick(R.id.create)
    public void onClickCreate() {

        form.setVisibility(View.VISIBLE);
        create.setVisibility(View.INVISIBLE);
        rvUser.setVisibility(View.INVISIBLE);
        display.setVisibility(View.INVISIBLE);

        ifForm = true;
    }

    @OnClick(R.id.valider)
    public void onClickValider(){

        if(name.getText().toString().equals("") || email.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, getString(R.string.empty), Toast.LENGTH_SHORT).show();
        }
        else
        {
            String pEmail = email.getText().toString();

            if (!isValidEmail((pEmail)))
            {
                Toast.makeText(MainActivity.this, getString(R.string.emailError), Toast.LENGTH_SHORT).show();
                email.setText("");
            }
            else
            {
                form.setVisibility(View.INVISIBLE);
                create.setVisibility(View.VISIBLE);
                display.setVisibility(View.VISIBLE);
                ifForm = false;

                String pNom = name.getText().toString();
                String pUrl = urlimg.getText().toString();

                email.setText("");
                name.setText("");
                urlimg.setText("");

                User user = new User();
                user.setNom(pNom);
                user.setEmail(pEmail);
                user.setImg(pUrl);
                alRep.add(user);
            }
        }
    }

    @OnClick(R.id.display)
    public void onClickDisplay(){

        rvUser.setVisibility(View.VISIBLE);
    }

    public static boolean isValidEmail(CharSequence target) {
        if(null == target) {
            return false;
        }
        else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public void onBackPressed(){

        if(ifForm)
        {
            form.setVisibility(View.INVISIBLE);
            create.setVisibility(View.VISIBLE);
            rvUser.setVisibility(View.VISIBLE);
            display.setVisibility(View.VISIBLE);
            ifForm = false;
        }
        else
        {
            super.onBackPressed();
        }
    }
}
