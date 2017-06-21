package com.example.vincent.utilisateurs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.create) Button create;
    @BindView(R.id.display) Button display;
    @BindView(R.id.valider) Button valider;
    @BindView(R.id.name) EditText name;
    @BindView(R.id.email) EditText email;
    @BindView(R.id.urlimg) EditText urlimg;
    @BindView(R.id.form) LinearLayout form;
    @BindView(R.id.rvUser) RecyclerView myRecyclerView;

    private ArrayList<User> alRep = new ArrayList<>();
    private boolean ifForm = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ButterKnife.bind(this, inflater.inflate(R.layout.fragment_main, container, false));

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                form.setVisibility(View.VISIBLE);
                create.setVisibility(View.INVISIBLE);
                myRecyclerView.setVisibility(View.INVISIBLE);
                display.setVisibility(View.INVISIBLE);

                ifForm = true;
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRecyclerView.setVisibility(View.VISIBLE);
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().equals("") || email.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity().getBaseContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String pEmail = email.getText().toString();

                    if (!isValidEmail((pEmail)))
                    {
                        Toast.makeText(getActivity().getBaseContext(), getString(R.string.emailError), Toast.LENGTH_SHORT).show();
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
        });

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        myRecyclerView.setAdapter(new Adapter(alRep));
        create.setText(getString(R.string.create));
        display.setText(getString(R.string.display));
    }

    /*@OnClick(R.id.create)
    public void onClickCreate() {

        form.setVisibility(View.VISIBLE);
        create.setVisibility(View.INVISIBLE);
        myRecyclerView.setVisibility(View.INVISIBLE);
        display.setVisibility(View.INVISIBLE);

        ifForm = true;
    }

    @OnClick(R.id.display)
    public void onClickDisplay(){

        myRecyclerView.setVisibility(View.VISIBLE);
    }*/

    public static boolean isValidEmail(CharSequence target) {
        if(null == target) {
            return false;
        }
        else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    /*@OnClick(R.id.valider)
    public void onClickValider(){

        if(name.getText().toString().equals("") || email.getText().toString().equals(""))
        {
            Toast.makeText(getActivity().getBaseContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
        }
        else
        {
            String pEmail = email.getText().toString();

            if (!isValidEmail((pEmail)))
            {
                Toast.makeText(getActivity().getBaseContext(), getString(R.string.emailError), Toast.LENGTH_SHORT).show();
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
    }*/



    /*@Override
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
    }*/
}
