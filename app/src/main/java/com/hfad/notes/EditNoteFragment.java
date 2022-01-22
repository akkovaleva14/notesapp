package com.hfad.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


public class EditNoteFragment extends Fragment {
    EditText title;
    ImageButton saveButton;
    ImageButton arrowButton;
    EditText noteToFill;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_edit_note, container, false);
        title = root.findViewById(R.id.title);
        saveButton = root.findViewById(R.id.savebutton);
        arrowButton = root.findViewById(R.id.arrowbutton);
        noteToFill = root.findViewById(R.id.note);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
