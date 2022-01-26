package com.hfad.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerNotesFragment extends Fragment {

    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    AppDataBase database;
    NotesDao notesDao;
    List<Notes> listOfNotesFromDB = new ArrayList<Notes>();
    ImageButton buttonPlus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recycler_notes, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        buttonPlus = root.findViewById(R.id.buttonPlus);
        /* Для работы с RecyclerView необходим LayoutManager, а также Adapter.
        LayoutManager отвечает за форму отображения элементов:
        обычная линейная, в виде сетки, в виде шахматной сетки. */
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        database = AppDataBase.getInMemoryDatabase(requireContext());
        notesDao = database.getNotesDao();
        return root;
    }

    // создаем arraylist, чтобы с его помощью заполнить адаптер
    @Override
    public void onResume() {
        super.onResume();
        listOfNotesFromDB = notesDao.getAllNotes();
        notesAdapter = new NotesAdapter(requireContext(), listOfNotesFromDB);
        recyclerView.setAdapter(notesAdapter);
        // вешаем метод setOnClickListener на нашу кнопку
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            // добавляем слушатель. слушатель может вызывать метод
            public void onClick(View v) {
                // по нажатию на кнопку вызывается др. layout - новый фрагмент для создания нов заметки
                setNewFragment();
            }
        });
    }

    // вызываем метод setNewFragment() по onClick'у на buttonPlus
    public void setNewFragment() {
        Fragment fragment = new EditNoteFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.recycler_container, fragment);
        transaction.commit();
    }
}
