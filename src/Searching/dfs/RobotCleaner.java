package Searching.dfs;

import java.util.HashSet;
import java.util.Set;

interface Robot {
     // Returns true if the cell in front is open and robot moves into the cell.
     // Returns false if the cell in front is blocked and robot stays in the current cell.
     public boolean move();
     // Robot will stay in the same cell after calling turnLeft/turnRight.
     // Each turn will be 90 degrees.
     public void turnLeft();
     public void turnRight();

     // Clean the current cell.
     public void clean();
 }

public class RobotCleaner {
    private static final int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public void cleanRoom(Robot robot) {
        cleanRobot(robot, 0, 0, 0, new HashSet<>());
    }

    public void cleanRobot(Robot robot, int x, int y, int currentDirection, Set<String> visited){
        robot.clean();
        visited.add(x+" "+y);


        for(int i=0; i<4; i++){
            int nx = x + directions[currentDirection][0];
            int ny = y + directions[currentDirection][1];

            if(!visited.contains(nx+" "+ny) && robot.move()){
                cleanRobot(robot, nx, ny, currentDirection, visited);
            }

            robot.turnRight();
            currentDirection++;
            currentDirection %= 4;
        }
        // Move backward one step while maintaining the orientation.
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
