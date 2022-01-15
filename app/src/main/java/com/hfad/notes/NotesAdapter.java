package com.hfad.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/* Adapter (переходник) – класс, который отвечает за связь элементов java кода с View-компонентами.
Т.е. получая набор java объектов, мы должны подать его на вход в адаптер,
который преобразует его уже в набор View-компонентов, которые и использует в дальнейшем RecyclerView.
Мы сооздаем новый пакет adapter, где размещаем класс NotesAdapter.
    Adapter, используемый при работе с RecyclerView, обязан определить объект типа ViewHolder,
который предоставляет доступ ко всем View-компонентам в каждой строке списка.
    Каждый адаптер должен реализовывать 3 главных метода:
    1) onCreateViewHolder(ViewGroup parent, int viewType)
    2) onBindViewHolder(ViewHolder holder, int position)
    3) getItemCount() */


/* Унаследовали наш адаптер (NotesAdapter) от RecyclerView.Adapter и указали наш ViewHolder,
(<NotesViewHolder>), который предоставит нам доступ к View-компонентам */
public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private List<Notes> listOfNotes;
    private LayoutInflater mInflater;
/* LayoutInflater - public abstract class; extends Object.
Instantiates a layout XML file into its corresponding View objects. It is never used directly.
Instead, use Activity.getLayoutInflater() or Context#getSystemService to retrieve a standard
LayoutInflater instance that is already hooked up to the current context and correctly
configured for the device you are running on. */


    // конструктор нашего адаптера
    NotesAdapter(Context context, List<Notes> listNotes) {
        this.mInflater = LayoutInflater.from(context);
        this.listOfNotes = listNotes; // проверяем работоспособность
        // listOfNotes = new ArrayList<>();
    }
/* public static LayoutInflater from(Context context):
Obtains the LayoutInflater from the given context */


    /* THE METHOD MUST BE HERE
    public abstract NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
– метод вызывается для создания объекта ViewHolder, в конструктор которого необходимо передать
созданный View-компонент, с которым в дальнейшем будут связываться java объекты.
Метод вызывается без нашего личного вмешательства, т.к. RecyclerView в себе инкапсулирует логику
переиспользования элементов
- сalled when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
This new ViewHolder should be constructed with a new View that can represent the items of the given type.
You can either create a new View manually or inflate it from an XML layout file.
The new ViewHolder will be used to display items of the adapter using onBindViewHolder(ViewHolder, int, List).
Параметры:
    Parent : The ViewGroup is the parent view that will hold your cell that you are about to create.
So, the ViewGroup parent is the RecyclerView here (it will hold your cell). The parent is used
during the layout inflation process so you can see it passed in to the inflate call.
    ViewType : The viewType is useful if you have different types of cells in your list.
For example, if you have a header cell and a detail cell. You can use the viewType to make sure
that you inflate the correct layout file for each of those two types of cells.*/
    // указываем макет item'a (R.layout.item_list), кот. будем использовать: "надуваmь" item.
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list, parent, false);
        return new NotesViewHolder(view);
    }
/* public View inflate (int resource, ViewGroup root, boolean attachToRoot)
Inflate a new view hierarchy from the specified xml resource. Throws InflateException if there is an error.
Parameters:
    int resource: ID for an XML layout resource to load (e.g., R.layout.main_page)
    ViewGroup root: Optional view to be the parent of the generated hierarchy (if attachToRoot is true),
or else simply an object that provides a set of LayoutParams values for root of the returned
hierarchy (if attachToRoot is false.) This value may be null.
    boolean attachToRoot: Whether the inflated hierarchy should be attached to the root parameter?
If false, root is only used to create the correct subclass of LayoutParams for the root view in the XML.
    Returns View: the root View of the inflated hierarchy. If root was supplied and attachToRoot is true,
this is root; otherwise it is the root of the inflated XML file.
 */


    /* THE METHOD MUST BE HERE
    public abstract void onBindViewHolder (NotesViewHolder holder, int position)
= метод отвечает за связь java объекта и View. Метод также вызывается без нашего участия.
Он будет вызываться чаще, чем метод onCreateViewHolder из-за того, что View компоненты будут
переиспользоваться и в один и тот же визуальный элемент в процессе жизнедеятельности списка
будут устанавливаться разные данные
- Called by RecyclerView to display the data at the specified position. This method should update
the contents of the RecyclerView.ViewHolder.itemView to reflect the item at the given position.
    RecyclerView takes advantage of the fact that as you scroll and new rows come on screen
    also old rows disappear off screen. Instead of creating new view for each new row, an
    old view is recycled and reused by binding new data to it. This happens exactly in onBindViewHolder().
    Initially you will get new unused view holders and you have to fill them with data you
    want to display. But as you scroll you'll start getting view holders that were used for
     rows that went off screen and you have to replace old data that they held with new data.*/
// связываем начинку с вьюшкой
    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        holder.bind(listOfNotes.get(position)); // заполняет по позиции
    }


    /* THE METHOD MUST BE HERE
int getItemCount ()
– сообщает количество элементов в списке.
- Returns the total number of items that can be laid out. Note that this number is not necessarily
equal to the number of items in the adapter, so you should always use this number for your
position calculations and never access the adapter directly. */
    // возвращает кол-во элементов recycler'a; адаптеру нужно знать, сколько элементов отобразить на экране
    @Override
    public int getItemCount() {
        return listOfNotes.size();
    }

}
