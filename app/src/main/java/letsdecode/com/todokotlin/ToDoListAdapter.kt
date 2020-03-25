package letsdecode.com.todokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter : RecyclerView.Adapter<ToDoViewHolder>() {
    val todoLists: Array<String> =
        arrayOf("Android Development", "Housework", "Errands", "Shopping")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        var itemView: View
        val inflator: LayoutInflater = LayoutInflater.from(parent.context)
        itemView = inflator.inflate(R.layout.todolist, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return todoLists.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemNumberTextView.text = (position + 0).toString()
        holder.itemListTextView.text = (todoLists[position])
    }

}