package ie.tudublin;

import processing.data.TableRow;

public class Task {
    
    //Creating Private Fields
    private String task;
    private int start;
    private int end;

    //Creating the Public Accessor Methods
    public String getTask() {
        return task;
    }

    //Creating the Public Accessor Methods
    public void setTask(String task) {
        this.task = task;
    }

    //Creating the Public Accessor Methods
    public int getStart() {
        return start;
    }

    //Creating the Public Accessor Methods
    public void setStart(int start) {
        this.start = start;
    }

    //Creating the Public Accessor Methods
    public int getEnd() {
        return end;
    }

    //Creating the Public Accessor Methods
    public void setEnd(int end) {
        this.end = end;
    }
    
    //Creating a constructor that takes initial values and assigns them to the fields.
    public Task(String task, int start, int end) {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    //Creating a constructor that takes a Processing TableRow field as a parameter 
    public Task(TableRow tr) {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    //Creating the appropiate toString method
    @Override
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", task=" + task + "]";
    }
}