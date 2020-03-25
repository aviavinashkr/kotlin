package letsdecode.com.todokotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var itemNumberTextView = itemView.findViewById<TextView>(R.id.itemNumber)
    var itemListTextView = itemView.findViewById<TextView>(R.id.detailOfTheList)

}