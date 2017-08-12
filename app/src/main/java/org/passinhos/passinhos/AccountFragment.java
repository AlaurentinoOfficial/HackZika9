package org.passinhos.passinhos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.passinhos.passinhos.Models.User;


public class AccountFragment extends Fragment {

    EditText Username;
    EditText FullName;
    EditText CPF;
    EditText State;

    EditText ChildFullName;
    EditText ChildCPF;
    EditText ChildState;

    FloatingActionButton btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        Username = (EditText) v.findViewById(R.id.user);
        FullName = (EditText) v.findViewById(R.id.name);
        CPF = (EditText) v.findViewById(R.id.cpf);
        State = (EditText) v.findViewById(R.id.state);

        ChildFullName = (EditText) v.findViewById(R.id.child_username);
        ChildCPF = (EditText) v.findViewById(R.id.child_cpf);
        ChildState = (EditText) v.findViewById(R.id.child_state);

        Username.setText(User.instance().getUsername());
        FullName.setText(User.instance().getFullName());
        CPF.setText(User.instance().getCPF());
        State.setText(User.instance().getState());

        ChildFullName.setText(User.instance().getChildFullname());
        ChildCPF.setText(User.instance().getChildCPF());
        ChildState.setText(User.instance().getChildState());


        btn = (FloatingActionButton) v.findViewById(R.id.save_perfil);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, R.string.save_accounts, Snackbar.LENGTH_LONG).show();
            }
        });

        return v;
    }
}

