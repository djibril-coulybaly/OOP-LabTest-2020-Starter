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
	float paddingText;

	public void settings()
	{
		size(800, 600);
		paddingLeft = width * 0.07f;
		paddingText = width * 0.17f;
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
		float loop = 0;
		float blockHeight = 30;
		float yPosition = 90;
		colorMode(HSB);


		//Displaying the Task names from the file task.csv
		for (Task gantTask: gantTasks) {
            fill(255);
            textAlign(LEFT, CENTER);
            text(gantTask.getTask(), paddingLeft, paddingTop);
			paddingTop+=gap;
		}
		
		//Displaying the Gantt Chart Lines and Numbering 
		for(int i = 1; i <= 30; i++) {
			textAlign(CENTER);
			text(i,map(i,0,30,paddingText,width - paddingLeft),35);
			stroke(255);
			line(map(i,0,30,paddingText,width - paddingLeft),50,map(i,0,30,paddingText,width - paddingLeft),height-50);
		}

		//Displaying the tasks 
		for (Task gantTask: gantTasks) {
			fill(map(loop,0,gantTasks.size(),0,255),255,255);
			noStroke();
			rect(map(gantTask.getStart(),0,30,paddingText,width - paddingLeft), yPosition, map((gantTask.getEnd() - gantTask.getStart()),0,30, 0,width - paddingText - 50), blockHeight, 5);
			yPosition+=gap;
			loop++;
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
