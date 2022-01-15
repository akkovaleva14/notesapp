package com.hfad.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerNotesFragment extends Fragment {

    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    List<Notes> listForEdit;
    AppDataBase database;
    NotesDao notesDao;
    List<Notes> listOfNotesFromDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recycler_notes, container, false);
        EditText title = root.findViewById(R.id.title);
        recyclerView = root.findViewById(R.id.recyclerView);
        /* Для работы с RecyclerView необходим LayoutManager, а также Adapter.
        LayoutManager отвечает за форму отображения элементов:
        обычная линейная, в виде сетки, в виде шахматной сетки. */
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        database = App.getInstance().getDataBase();
        notesDao = database.getNotesDao();
        return root;
    }

    // создаем arraylist, чтобы с его помощью заполнить адаптер
    @Override
    public void onResume() {
        super.onResume();
         /* listForEdit = new ArrayList<Notes>();

        Notes notes1 = new Notes();
        notes1.setTitle("title1");
        notes1.setNote("note1");
        notes1.setImage("https://m.media-amazon.com/images/M/MV5BMTY5ODc1NjU5N15BMl5BanBnXkFtZTcwMTUyNDg3Mg@@._V1_.jpg");

        Notes notes2 = new Notes();
        notes2.setTitle("title2");
        notes2.setNote("note2");
        notes2.setImage("https://media.makeameme.org/created/nice-meme-5cd247.jpg");

        Notes notes3 = new Notes();
        notes3.setTitle("title3");
        notes3.setNote("note3");
        notes3.setImage(String.valueOf(R.drawable.bird));

        Notes notes4 = new Notes();
        notes4.setTitle("title4");
        notes4.setNote("note4");

        Notes notes5 = new Notes();
        notes5.setTitle("title5");
        notes5.setNote("note5");

        Notes notes6 = new Notes();
        notes6.setTitle("title6");
        notes6.setNote("note6");

        listForEdit.add(notes1);
        listForEdit.add(notes2);
        listForEdit.add(notes3);
        listForEdit.add(notes4);
        listForEdit.add(notes5);
        listForEdit.add(notes6); */

        // достали из базы данных список notes
        listOfNotesFromDB = notesDao.getAllNotes();

        notesAdapter = new NotesAdapter(requireContext(), listForEdit);
        recyclerView.setAdapter(notesAdapter);
    }
}
