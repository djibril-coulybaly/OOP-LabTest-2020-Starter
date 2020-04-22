package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{
	//Declare an ArrayList to hold instances of the Task class	
	ArrayList<Task> gantTasks = new ArrayList<Task>();

	//Global Variables
	float paddingLeft;

	public void settings()
	{
		size(800, 600);
		paddingLeft = width * 0.07f;
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
	
	//Displays the Gantt Chart
	public void displayTasks()
	{
		float paddingTop = 100;
		float gap = 50;

		//Displaying the Task names from the file task.csv
		for (Task gantTask: gantTasks) {
            fill(255);
            textAlign(LEFT, CENTER);
            text(gantTask.getTask(), paddingLeft, paddingTop);
			paddingTop+=gap;
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
		displayTasks();
	}
}
