package labyrinth;

public class Mazes
{
        static final int ROWS = 2;
        static final int COLS = 2;

    public static void main(String [] args)
    {            
        Ellers ell = new Ellers(ROWS,COLS);
        ell.makeMaze();
        ell.printMaze();
       
        System.out.println();

        Solver ellSol = new Solver(ell.getMaze());
        ellSol.solveMaze();
        ellSol.printSolution();

       
    }
}
