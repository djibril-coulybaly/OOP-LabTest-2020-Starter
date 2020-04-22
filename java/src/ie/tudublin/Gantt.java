package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{
	//Declare an ArrayList to hold instances of the Task class	
	ArrayList<Task> gantTasks = new ArrayList<Task>();


	public void settings()
	{
		size(800, 600);
	}
	
	//Populates the arrayList from the file tasks.csv
	public void loadTasks()
	{
		Table table = loadTable("tasks.csv","header");

        for (TableRow row : table.rows()) {
            Task ganttAdd = new Task(row);
            gantTasks.add(ganttAdd);
        }
	}

	//Prints the elements of the ArrayList.
	public void printTasks()
	{
		for (Task gantTask: gantTasks) {
            System.out.println(gantTask);
        }
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
	}
}
