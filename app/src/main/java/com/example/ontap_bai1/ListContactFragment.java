package com.example.ontap_bai1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.controller.ContactController;
import com.example.controller.IContactController;
import com.example.model.contact;

import java.util.ArrayList;
import java.util.List;


public class ListContactFragment extends Fragment {
    RecyclerView recyclerView;
    IContactController iContactController ;

    ContactAdater contactAdater;
    NavController navController;
    List<contact> listContact = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_contact, container, false);
        addViews(view);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.additem)
        {
            navController.navigate(R.id.action_listContactFragment_to_addContactFragment);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    private void addViews(View view) {
        recyclerView = view.findViewById(R.id.rcListContact);
        iContactController = (IContactController) ((MainActivity)getActivity()).getApplication();
        listContact = iContactController.getAllContact();
        contactAdater = new ContactAdater(listContact);
        navController = NavHostFragment.findNavController(ListContactFragment.this);
        ((MainActivity)getActivity()).controller = navController;

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(contactAdater);
    }

    public class ContactViewHodel extends RecyclerView.ViewHolder
    {
        TextView tvname, tvDOB, tvPhoneNumber;
        ImageView imgedit;

        public ContactViewHodel(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvName);
            tvDOB = itemView.findViewById(R.id.tvDOB);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);

        }

        public  void Bind(contact contact)
        {
            tvname.setText(contact.getName());
            tvDOB.setText(contact.getDOB());
            tvPhoneNumber.setText(contact.getPhone());
        }
    }

    public class ContactAdater extends RecyclerView.Adapter<ContactViewHodel>{

        List<contact> contactList = new ArrayList<>();

        public ContactAdater(List<contact> contactList) {
            this.contactList = contactList;
        }

        @NonNull
        @Override
        public ContactViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater= getLayoutInflater();
            View view = inflater.inflate(R.layout.contact,parent,false );
            return new ContactViewHodel(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHodel holder, int position) {
            holder.Bind(contactList.get(position));

        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }
    }
}
