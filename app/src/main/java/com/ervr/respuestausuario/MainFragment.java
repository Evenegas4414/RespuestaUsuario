package com.ervr.respuestausuario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MainFragment extends Fragment {

    private EditText nameEditText;
    private Button continueButton;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        continueButton = view.findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                if (!name.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", name);

                    NavHostFragment.findNavController(MainFragment.this)
                            .navigate(R.id.action_mainFragment_to_secondActivity, bundle);
                } else {
                    Toast.makeText(requireContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}