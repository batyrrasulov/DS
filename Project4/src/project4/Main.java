package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//starter code for MazeSolver
//CST-201

public class Main {
	/**
	 * 
	 * @param start
	 * @param end
	 * @param cells
	 * find a path through the maze
	 * if found, output the path from start to end
	 * if not path exists, output a message stating so
	 * 
	 */
	// implement this method
	public static void depthFirst(MazeCell start, MazeCell end, MazeCell[][] cells) {
		// create a stack to add cells
		MyStack<MazeCell> stack = new MyStack<MazeCell>();
		// a boolean flag to track if there is no solution
		boolean noSol = false;
		// the current MazeCell being visited
		MazeCell current;
		// push the start cell onto the stack
		stack.push(start); 
		// set the current cell to the start cell
		current = start;
		// mark the start cell as visited
		current.visit();
		// continue the loop while the current cell is not the end cell & there is still a possibility of a solution
		while(!current.equals(end) && !noSol) {	
			// if the current cell's direction is North
			if(current.getDirection() == 0 ) {	
				// if we are at the top row => we can't go North
				if(current.getRow() == 0) {
					current.advanceDirection();
					continue;
				}
				else {
					// get the cell to the North
					MazeCell northCell = cells[current.getRow() - 1][current.getCol()]; 
					// if there is no path in the North cell & it has been visited => move on
					if(northCell.getRow() == -1 || !northCell.unVisited()) {
						current.advanceDirection(); 
						continue;
					}
					else {
						// add the north cell to the stack
						stack.push(northCell);
						// set the north cell as the new current cell
						current = northCell;
						// mark the current cell as visited
						current.visit(); 
					}
				}
			}		
			// if the current cell's direction is East
			else if(current.getDirection() == 1) {
				// if we are at the last column => we can't go East
				if(current.getCol() == cells[0].length -1) {
					current.advanceDirection();
					continue;
				}
				else {
					// get the cell to the East
					MazeCell eastCell = cells[current.getRow()][current.getCol() + 1];
					// if there is no path in the East cell & it has been visited => move on
					if(eastCell.getRow() == -1 || !eastCell.unVisited()) {
						current.advanceDirection();
						continue;
					}
					else {
						// add the east cell to the stack
						stack.push(eastCell);
						// set the east cell as the new current cell
						current = eastCell;
						// mark the current cell as visited
						current.visit();
					}
				}
			}
			// if the current cell's direction is South
			else if(current.getDirection() == 2) {
				// if we are at the last row => we can't go South
				if(current.getRow() == cells.length -1) {
					current.advanceDirection();
					continue;
				}
				else{
					// get the cell to the South
					MazeCell southCell = cells[current.getRow() + 1][current.getCol()];
					// if there is no path in the South cell & it has been visited => move on
					if(southCell.getRow() == -1 || !southCell.unVisited()) {
						current.advanceDirection();
						continue;
					}
					else {
						// add the south cell to the stack
						stack.push(southCell);
						// set the south cell as the new current cell
						current = southCell;
						// mark the current cell as visited
						current.visit(); 
					}
				}
			}	
			// if the current cell's direction is West
			else if(current.getDirection() == 3){
				// if we are not on the first column
				if(current.getCol() != 0) {
					// get the cell to the west
					MazeCell westCell = cells[current.getRow()][current.getCol() - 1];
					// if there is no path in the West cell & it has been visited => reset
					if(westCell.getRow() == -1 || !westCell.unVisited()) {
						// remove the current cell from the top of the stack
							stack.pop();
							// set the new current cell to the one on top of the stack
							current = stack.top();
							// advance the direction of the current cell
							current.advanceDirection();
					}
					else {
						// add the west cell to the stack
						stack.push(westCell);
						// set the current cell to the west cell
						current = westCell; 
						// mark the current cell as visited
						current.visit();
					}
				}
				// if we are on the first column => reset to the last cell 
				else {
					// remove the current cell from the stack
					stack.pop(); 
					// set the new current cell to the last cell on the stack
					current = stack.top(); 
					// advance the direction of the current cell
					current.advanceDirection(); 
				}	
			} else {
	            // if the current cell is not the start cell => remove it from the stack and backtrack
				if(!current.equals(start)) {	
					stack.pop();
					current = stack.top();
					current.advanceDirection();
				}
				// there is no solution since we are back at the start with all paths explored
				else {
					noSol = true;
				}
			}
		}	
		if(noSol) {
			System.out.println("No path found.");
		}
        // print out the path by loading the coordinates into an array backwards
		else {
			MyStack<String> stack2 = new MyStack<String>();
			MyQueue<String> printable = new MyQueue<String>();
			while(!stack.empty()) {
				stack2.push(stack.top().toString());
				stack.pop();
			}
	        // print out the path by dequeuing from the printable queue
			while(!stack2.empty()) {
				printable.push(stack2.top());
				stack2.pop();
			}
			while(!printable.empty()) {
				System.out.println(printable.front());
				printable.pop();
			}
		}		
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
			
			//create the Maze from the file
			Scanner fin = new Scanner(new File("/Applications/Eclipse.app/Contents/MacOS/workspaceCST-201/Project4/src/project4/Maze.txt"));
			//read in the rows and cols
			int rows = fin.nextInt();
			int cols = fin.nextInt();
			
			//create the maze
			int [][] grid = new int[rows][cols];
			
			//read in the data from the file to populate
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					grid[i][j] = fin.nextInt();
				}
			}

			//look at it 
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == 3)
						System.out.print("S ");	
					else if (grid[i][j] == 4)
						System.out.print("E ");	
					else
						System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}

			//make a 2-d array of cells
			MazeCell[][] cells = new MazeCell[rows][cols];
			
			//populate with MazeCell obj - default obj for walls

			MazeCell start = new MazeCell(), end = new MazeCell();
			
			//iterate over the grid, make cells and set coordinates
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					//make a new cell
					cells[i][j] = new MazeCell();
					//if it isn't a wall, set the coordinates
					if (grid[i][j] != 0) {
						cells[i][j].setCoordinates(i, j);
						//look for the start and end cells
						if (grid[i][j] == 3)
							start = cells[i][j];
						if (grid[i][j] == 4) 
							end = cells[i][j];
						
					}

				}
			}
			
			//testing
			System.out.println("start:"+start+" end:"+end);
			
			//solve it!
			depthFirst(start, end, cells);
			
		}
}
