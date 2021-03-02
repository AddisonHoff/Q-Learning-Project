import java.io.*;
import java.util.Arrays;

public class Saver{
    public Saver(int x, int y, int numOfMazes, String s){
        this.x = x;
        this.y = y;
        this.numOfMazes = numOfMazes;
        this.saveFile = s;
    }

    private int x;
    private int y;

    private int numOfMazes;

    String saveFile;

    public void Save(){
        for(int i = 0; i < numOfMazes; i++){
            Solver s = new Solver(x,y);
            try (PrintWriter out = new PrintWriter(saveFile + ".txt")){
                s.Solve();
                out.println("Map " + i + ":");
                out.println(Arrays.deepToString(s.m.map));
                out.println(s.returnSolution());
                out.println("--------------------------------------");
            } catch (Exception E){}
        }
    }



}
