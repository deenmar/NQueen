import java.util.Scanner;

public class QueenSimulation {

    public static void solve(int max){
        LinkedStack<Queen> board = new LinkedStack<>();
        LinkedStack<Queen> tester = new LinkedStack<>();
        boolean testSolutions = false;
        boolean testFill = false;
        int boardSize = max;
        int conflictCounter;
        int counter = 0;

        while(counter < boardSize) {
            for (int row = 1; row <= boardSize; row++) {
                conflictCounter = 0;
                for (int column = 1; column <= boardSize; column++) {
                    queenPlacement(row, column, board);
                    if (conflictTester(board)) {
                        conflictCounter++;
                        board.pop();
                    }//end if
                    else if (conflictCounter == boardSize) {
                        Queen temporary = board.pop();
                        row--;
                        column = temporary.getCol() + 1;
                        conflictCounter = column;
                    }//END elif
                }//end FOR
            }//end FOR
            if(boardSize == board.size()){
                for(int i = 0; i < board.size(); i++){
                    System.out.println(board.itemAt(i).toString());
                }

            }
            counter++;
        }//end of while
    }

    public static void queenPlacement(int row, int column, LinkedStack<Queen>board){
        Queen queen = new Queen(row, column);
        board.push(queen);
    }


    public static boolean conflictTester(LinkedStack<Queen>board){
        Queen temporary = board.itemAt(0);
        for(int i=1; i < board.size(); i++){
            if(temporary.conflict(board.itemAt(i))){
                return true;
            }
        }
        return false;
    }


    // "simulation"
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the size of the board you want to test. (1 digit)");
        //int userInput = scan.nextInt();

        solve(5);
    }

}