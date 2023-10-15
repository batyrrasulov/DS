package project4;

import java.util.ArrayList;
import java.util.List;

public class Maze
{
    private int rows;
    private int columns;
    private int[][] grid;
    private MazeCell[][] cells;
    private List<MazeCell> pathList;

    public Maze(int[][] data)
    {
        rows = data.length;
        columns = data[0].length;
        grid = data;
        cells = new MazeCell[rows][columns];

        for (int row = 0; row < rows; row ++)
        {
            for (int column = 0; column < columns; column ++)
            {
                cells[row][column] = new MazeCell(row, column);
            }
        }

        pathList = new ArrayList<>();
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }
    public int[][] getGrid()
    {
        return grid;
    }
    public MazeCell[][] getCells()
    {
        return cells;
    }

    public List<MazeCell> getPathList()
    {
        return pathList;
    }

    public boolean depthFirstSearch(MazeCell start, MazeCell end)
    {
        return true;
    }
}
