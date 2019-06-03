package ru.madd.dailyschedule;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This class bind {@link ScheduleListItem} to view.
 * It shows all data from item to view
 */
public class DailyScheduleViewHolder extends RecyclerView.ViewHolder {


    /**
     * Current showed item
     */
    private ScheduleListItem currentItem = null;
    private TextView Daily_Schedule_Element_Title;
    private TextView Daily_Schedule_Element_Buzz;
    private TextView Daily_Schedule_Element_Discription;
    private ProgressBar Daily_Schedule_Element_Prog_Bar;
    private CheckBox Daily_Schedule_Element_Check;


    public DailyScheduleViewHolder(@NonNull View itemView) {
        super(itemView);
        Daily_Schedule_Element_Title = itemView.findViewById(R.id.text_in_title);
        Daily_Schedule_Element_Buzz = itemView.findViewById(R.id.text_buzz);
        Daily_Schedule_Element_Discription = itemView.findViewById(R.id.text_discription);
        Daily_Schedule_Element_Prog_Bar = itemView.findViewById(R.id.progress_bar);
        Daily_Schedule_Element_Check = itemView.findViewById(R.id.check_box);//что делает R ?

    }

    public void bindToItem(ScheduleListItem item){
        this.currentItem = item;
        this.Daily_Schedule_Element_Title.setText(item.getTitle());
        this.Daily_Schedule_Element_Buzz.setText((CharSequence) item.getStartTime());//хуй знает, что творю, а хотел добавить время начала, то есть время срабатывания уведомления
        this.Daily_Schedule_Element_Discription.setText(item.getDescription());
        this.Daily_Schedule_Element_Prog_Bar.setProgress(item.getTitle());//как то так вышло, что теперь getTitle типа int, какой ему еще get  подсунуть не нашел(( не ругайся папа
        this.Daily_Schedule_Element_Check.setChecked(item.isTaskDone());// не уверен на счет isTaskDone, но под чек бокс нужен тип boolean выбрал тот что показался логичнее.

        //Write your code there
        //to show item's data on view's
    }
}
