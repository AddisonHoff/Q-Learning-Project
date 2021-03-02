import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Maze X Size: ");
        int x = s.nextInt();
        System.out.println("Enter Maze Y Size: ");
        int y = s.nextInt();

        Maze m = new Maze(x,y);
        m.Generate();
        m.Print();

        System.out.println("Solve");

        Solver sol = new Solver(x,y,m);
        sol.Solve();
        sol.printSolution();

        System.out.println("Enter Number of Mazes: ");
        int numOfMazes = s.nextInt();

        System.out.println("Enter Save File Name: ");
        String file = s.nextLine();

        Saver saver = new Saver(x, y, numOfMazes, file);

        saver.Save();
    }
}