package com.hfad.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

// тут наполняем объект класса. есть holder'ы для всего
// нашли все на макете, с этим всем работаем в onresume

public class EditNoteFragment extends Fragment {
    EditText title;
    ImageButton saveButton;
    ImageButton arrowButton;
    EditText noteToFill;
    AppDataBase appDataBase;
    Notes noteAnotherOne;
    NotesDao notesDao;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_edit_note, container, false);
        title = root.findViewById(R.id.title);
        saveButton = root.findViewById(R.id.buttonSave);
        arrowButton = root.findViewById(R.id.buttonArrow);
        noteToFill = root.findViewById(R.id.note);
        appDataBase = AppDataBase.getInMemoryDatabase(requireContext());
        notesDao = appDataBase.getNotesDao();
        noteAnotherOne = new Notes();
        return root;
    }

    // пользователь заполнил title - забираем gettext'ом
    // аналогично с заметкой
    // далее с помощью dao (метод для взаимодейтсвия с базой данных)
    // в dao наш метод insert - помещает объект внутрь базы данных
    // итого: noteanotherone лежит в базе данных
    // когда? все происходит при клике на "сохранить" + переходим в др фрагмент
    // в др. фрагм - где список заметок
    @Override
    public void onResume() {
        super.onResume();
        arrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                noteAnotherOne.title = title.getText().toString();
                noteAnotherOne.note = noteToFill.getText().toString();
                notesDao.insert(noteAnotherOne);
                setNewFragment();
            }
        });
    }

    public void setNewFragment() {
        // создали переменную fragment класса Fragment; в нее записали объект класса,
        // в который мы хотим перейти
        Fragment fragment = new RecyclerNotesFragment();
        // создали переменную transaction класса FragmentTransaction
        // в ней предлагаем начать транзакцию. обращаемся к менеджеру, который
        // может начать транзакцию
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        // у объекта транзакции заменяем один фрагмент (по сути - макет, который у нас был,
        // edittext) - на объект класса нашего фрагмента, который создали выше
        // альтернатива replace - add (будет наложение)
        transaction.replace(R.id.edit_container, fragment);
        // запускаем транзакцию
        transaction.commit();
    }
}
