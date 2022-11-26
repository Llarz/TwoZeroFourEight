/*
*
* Execution: java TwoZeroFourEightGame
* Description: implements the popular 2048 game by using wasd keys for control
*/

public class TwoZeroFourEightGame {
    
    public static final int[] X_CENTERS = {5, 15, 25, 35};
    public static final int[] Y_CENTERS = {5, 15, 25, 35};
    private static Tile[][] tiles = new Tile[4][4];
    private static Board currentBoard = new Board(tiles, 0);
    
    public static void main(String[] args) {
        PennDraw.setXscale(-10, 50);
        PennDraw.setYscale(-10, 60);
        //PennDraw.enableAnimation(2);
        while (true) {
            currentBoard.insertTiles();
            currentBoard.drawNewBoard();
            currentBoard.addNewTiles();
            keyIsPressed(currentBoard);
        }
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Inserts empty tiles in a new board
    */
    public static void keyIsPressed(Board b) {
        b = currentBoard;
        boolean boardIsFull = b.isFull();
        while (boardIsFull != true) {
            if (PennDraw.hasNextKeyTyped()) {
                int moves = 1;
                char c = PennDraw.nextKeyTyped();
                if (c == 'a') {
                    System.out.println(c);
                    b.moveLeft();
                    b.addNewTiles();
                    PennDraw.text(45, 55, "Moves:" + moves++);
                    } else if (c == 's') {
                    b.moveDown();
                    b.addNewTiles();
                    PennDraw.text(45, 55, "Moves:" + moves++);
                    } else if (c == 'd') {
                    b.moveRight();
                    b.addNewTiles();
                    PennDraw.text(45, 55, "Moves:" + moves++);
                    } else if (c == 'w') {
                    b.moveUp();
                    b.addNewTiles();
                    PennDraw.text(45, 55, "Moves:" + moves++);
                } else {
                }
            }
        }
        if (b.isFull()){
            b.playerHasLost();
            } else if (b.playerHasWon()) {
            PennDraw.text(20, 20, "You Won!");
        }
    }
}
