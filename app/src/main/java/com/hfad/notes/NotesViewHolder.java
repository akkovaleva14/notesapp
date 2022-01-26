package com.hfad.notes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

/* NotesViewHolder предоставляет прямую ссылку на каждый View-компонент, используется для
 кэширования View-компонентов и последующего быстрого доступа к ним */
public class NotesViewHolder extends RecyclerView.ViewHolder {

    /* Наш NotesViewHolder должен содержать переменные для всех View-компонентов, которым мы хотим
    задавать какие-либо свойства в процессе работы пользователя со списком */
    TextView title;
    TextView note;

    // создали конструктор, который принимает на вход View-компонент строкИ и ищет все дочерние компоненты
    public NotesViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        note = itemView.findViewById(R.id.textContent);
    }

    public void bind(Notes notes) {
        title.setText(notes.getTitle());
        note.setText(notes.getNote());
    }
}