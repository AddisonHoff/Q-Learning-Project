import java.util.*;

public class Maze {
    public Maze(int x, int y){
        this.x = x;
        this.y = y;
    }

    private int x = 5;
    private int y = 5;

    public int startx;
    public int starty;

    public int endX;
    public int endY;

    public double startValue;

    private int numberOfBlocks = (x*y)/(x+y);

    public double[][] map = new double[x][y];

    Random r = new Random();


    public void Generate(){
        boolean startGened = false;
        boolean endGened = false;
        boolean fullyGened = false;

        for(int i = 0; i < numberOfBlocks; i++){
            int randX = r.nextInt(x);
            int randY = r.nextInt(y);

            if(map[randX][randY] == 100.0){
                i = i - 1;
            }
            else{
                map[randX][randY] = 100.0;
            }
        }

        while(!endGened){
            int randX = r.nextInt(x);
            int randY = r.nextInt(y);

            if(map[randX][randY] != 100.0){
                map[randX][randY] = -100.0;
                endGened = true;
                endX = randX;
                endY = randY;
            }
        }

        while(!startGened){
            int randX = r.nextInt(x);
            int randY = r.nextInt(y);

            if(map[randX][randY] != 100.0 && map[randX][randY] != -100.0){
                startValue = Math.sqrt((Math.abs(endX - randX) * Math.abs(endX - randX)) + (Math.abs(endY - randY) * Math.abs(endY - randY)));
                map[randX][randY] = startValue;
                startx = randX;
                starty = randY;
                startGened = true;
            }
        }

        while(!fullyGened){
            int randX = r.nextInt(x);
            int randY = r.nextInt(y);
            double value;
            for(int i = 0; i < y; i++) {
                for(int j = 0; j < x; j++) {
                    if (map[j][i] != 100.0 && map[j][i] != startValue && map[j][i] != -100.0) {
                        value = Math.sqrt((Math.abs(endX - j) * Math.abs(endX - j)) + (Math.abs(endY - i) * Math.abs(endY - i)));
                        map[j][i] = value;
                    }
                }
            }
            fullyGened = true;

        }
    }

    public void Print(){
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                System.out.print(map[j][i] + ",");
            }
            System.out.println();
        }
    }
}
