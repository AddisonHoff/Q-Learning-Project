import java.util.*;

public class Solver {
    public Solver(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Solver(int x, int y, Maze m){
        this.x = x;
        this.y = y;
        this.m = m;
    }

    private int x;
    private int y;

    private ArrayList coordinateArray;

    Maze m;

    public void Solve(){

        int currX = m.startx;
        int currY = m.starty;

        int lastX = m.startx;
        int lastY = m.starty;

        boolean isImpossible = false;

        while(currX != m.endX || currY != m.endY || !isImpossible){
            double upValue = 100;
            double downValue = 100;
            double rightValue = 100;
            double leftValue = 100;

            try{ upValue = m.map[currX][currY+1];
                System.out.println("worked"); } catch (Exception e){ upValue = 100;
                System.out.println("didntwork");}
            try{ downValue = m.map[currX][currY-1]; } catch (Exception e){ downValue = 100; }
            try{ rightValue = m.map[currX+1][currY]; } catch (Exception e){ rightValue = 100;}
            try{ leftValue = m.map[currX-1][currY]; } catch (Exception e){ leftValue = 100; }
            try {
                if (upValue < downValue && upValue < rightValue && upValue < leftValue) {
                    currY++;
                    String s = new String(currX + "," + currY);
                    coordinateArray.add(s);
                    System.out.println(currX + ", " + currY);
                } else if (downValue < upValue && downValue < rightValue && downValue < leftValue) {
                    currY--;
                    String s = new String(currX + "," + currY);
                    coordinateArray.add(s);
                    System.out.println(currX + ", " + currY);
                } else if (rightValue < downValue && rightValue < upValue && rightValue < leftValue) {
                    currX++;
                    String s = new String(currX + "," + currY);
                    coordinateArray.add(s);
                    System.out.println(currX + ", " + currY);
                } else {
                    currX--;
                    String s = new String(currX + "," + currY);
                    coordinateArray.add(s);
                    System.out.println(currX + ", " + currY);
                }
            } catch (Exception E){}

            if(lastX == currX && lastY == currY){
               isImpossible = true;
            }
        }
    }

    public ArrayList returnSolution(){
        return coordinateArray;
    }

    public void printSolution(){
        for(int i = 0; i < coordinateArray.size(); i++) {
            System.out.println(coordinateArray.get(i));
            System.out.println("|");
        }
        if(coordinateArray.isEmpty()){
            System.out.println("isEmpty");
        }
    }
}
