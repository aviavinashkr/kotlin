package letsdecode.com.todokotlin

import android.content.Context
import android.preference.PreferenceManager

// for the constructor context is passed
class ListManager(private val context: Context) {

    // function to save list in shared preference.
    fun saveList(list: TaskList) {
        // for saving we would need reference for shared preference.
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context).edit()
        // shared preference does n't save list . It saves set
        sharedPrefs.putStringSet(list.name, list.taskList.toHashSet())
        sharedPrefs.apply()
    }

    //reading from shared preference. Return type is list of task list

    fun readList(): ArrayList<TaskList> {
        // get reference of a shared preference
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        // get contents. content contain map of keys and value.
        val contents = sharedPrefs.all
        // create a list to hold your tasklist
        var taskLists = ArrayList<TaskList>()

        for (taskList in contents) {
            val taskItems = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, taskItems)
            taskLists.add(list)
        }
        return taskLists


    }

}