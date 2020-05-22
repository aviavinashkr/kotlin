package letsdecode.com.todokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter(var lists: ArrayList<TaskList>) : RecyclerView.Adapter<ToDoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        var itemView: View
        val inflator: LayoutInflater = LayoutInflater.from(parent.context)
        itemView = inflator.inflate(R.layout.todolist, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemNumberTextView.text = (position + 1).toString()
        holder.itemListTextView.text = lists[position].name
    }

    fun addList(list: TaskList) {
        lists.add(list)
        notifyItemInserted(lists.size -1)

    }

}