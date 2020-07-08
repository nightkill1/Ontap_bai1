package com.example.ontap_bai1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.controller.IContactController;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddContactFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    EditText edtName, edtDOB, edtSDT, edtID;
    Button btnLuu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        addViews(view);
        return view;
    }

    private void addViews(View view) {
      navController = NavHostFragment.findNavController(AddContactFragment.this);
        ((MainActivity)getActivity()).controller = navController;
        edtName = view.findViewById(R.id.edtName);
        edtID = view.findViewById(R.id.edtID);
        edtDOB = view.findViewById(R.id.edtDOB);
        edtSDT = view.findViewById(R.id.edtSDT);
        btnLuu = view.findViewById(R.id.button);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IContactController iContactController;
                int id = Integer.parseInt(edtID.getText().toString());
                String name = edtName.getText().toString();
                String DOB  = edtDOB.getText().toString();
                String SDT = edtSDT.getText().toString();


            }
        });


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {

    }
}
