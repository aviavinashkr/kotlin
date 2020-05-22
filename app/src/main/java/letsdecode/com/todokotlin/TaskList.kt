package letsdecode.com.todokotlin
/*in constructor , as we would need name of the list and list.
ArrayList<String> = ArrayList() it creates an empty list, so basically if the caller doesn't provide any list this
will create the empty list */
// to do list object. after this we would create a class to read and write to the disk.
class TaskList(val name: String, val taskList: ArrayList<String> = ArrayList()) {

}