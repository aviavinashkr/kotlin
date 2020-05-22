package letsdecode.com.todokotlin

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var todoListRecyclerView: RecyclerView
    val listManager: ListManager = ListManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lists = listManager.readList()

        todoListRecyclerView = findViewById(R.id.lists_recyclerview)
        todoListRecyclerView.layoutManager = LinearLayoutManager(this)
        todoListRecyclerView.adapter = ToDoListAdapter(lists)
        fab.setOnClickListener { _ ->
            showCreateTodoListDialog()
        }
    }

    private fun showCreateTodoListDialog() {

        val dialogTitle = getString(R.string.name_of_the_list)
        val positiveButtonTitle = getString(R.string.create_list)
        val myDialog = AlertDialog.Builder(this)
        val todoTitleEditText = EditText(this)
        todoTitleEditText.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

        myDialog.setTitle(dialogTitle)
        myDialog.setView(todoTitleEditText)

        myDialog.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            val adapter = todoListRecyclerView.adapter as ToDoListAdapter
            val list = TaskList(todoTitleEditText.text.toString())
            listManager.saveList(list)
            adapter.addList(list)

            dialog.dismiss()
        }
        myDialog.create().show()
    }
}


