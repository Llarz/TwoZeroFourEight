/*
*
* Description: contains the APIs for the Board class
*
*/

public class Board implements BoardInterface {
    // Declare the instance variables
    public static final int[] X_CENTERS = {5, 15, 25, 35};
    public static final int[] Y_CENTERS = {5, 15, 25, 35};
    private Tile[][] currentTiles;
    private int numberOfMoves;
    
    // Constructor
    public Board(Tile[][] currentTiles, int moves) {
        this.currentTiles = currentTiles;
        this.numberOfMoves = moves;
        moves = 0;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: boolean
    * Description: checks if board only contains ints with value 0
    */
    public boolean isEmpty() {
        Tile[][] tiles = this.currentTiles;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tiles[i][j].getTileIntegerValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Inserts empty tiles in a new board
    */
    public void insertTiles() {
        Tile[][] tiles = this.currentTiles;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tiles[i][j] == null) {
                    tiles[i][j] = new Tile(0);
                }
            }
        }
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Draws the board in its initial state
    */
    @Override
    public void drawInitialBoard() {
        Tile[][] tiles = this.currentTiles;
        // Draw the entire frame of the board
        PennDraw.setPenColor(204, 192, 179);
        PennDraw.filledSquare(20, 20, 20);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (currentTiles[i][j] != null) {
                    currentTiles[i][j].drawEmptyTiles();
                }
            }
        }
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Draws the board in its current state
    */
    public void drawCurrentBoard() {
        Tile[][] tiles = this.currentTiles;
        // Draw the entire frame of the board
        PennDraw.setPenColor(204, 192, 179);
        PennDraw.filledSquare(20, 20, 20);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (currentTiles[i][j] != null) {
                    currentTiles[i][j].drawCurrentTile();
                }
            }
        }
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Draws the current board in its initial state
    */
    public void addNewTiles() {
        Tile[][] tiles = this.currentTiles;
        // set up a random value generator
        int i = (int) Math.floor(Math.random() * 4);
        int j = (int) Math.floor(Math.random() * 4);
        int k = (int) Math.floor(Math.random() * 4);
        int l = (int) Math.floor(Math.random() * 4);
        
        if (this.isEmpty()) {
            if (tiles[i][j].equals(tiles[k][l]) == false) {
                if (tiles[i][j].getTileIntegerValue() == 0 &&
                tiles[k][l].getTileIntegerValue() == 0) {
                    double randomValue = Math.random();
                    tiles[i][j].setTileIntegerValue(2);
                    if (randomValue < 0.7) {
                        tiles[k][l].setTileIntegerValue(2);
                        } else {
                        tiles[k][l].setTileIntegerValue(4);
                    }
                }
                tiles[i][j].drawNewTile();
                tiles[k][l].drawNewTile();
            }
            } else {
            while (true) {
                if (tiles[i][j].getTileIntegerValue() == 0) {
                    tiles[i][j].setTileIntegerValue(2);
                    tiles[i][j].drawNewTile();
                }
                break;
            }
        }
    }
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: moves tiles in an upward motion when the 'w' key has been typed.
    */
    @Override
    public void moveUp() {
        Tile[][] tiles = this.currentTiles;
        int k = 0;
        // only press key once
        while (k < 2) {
            k++;
            for (int row = 1; row < tiles.length; row++) {
                for (int col = 0; col < tiles.length; col++) {
                    if (tiles[row][col].getTileIntegerValue() ==
                    currentTiles[row - 1][col].getTileIntegerValue() ||
                    tiles[row - 1][col].getTileIntegerValue() == 0) {
                        tiles[row - 1][col].setTileIntegerValue(tiles[row -
                        1][col].addValue(tiles[row][col]));
                        tiles[row][col].setTileIntegerValue(0);
                    }
                }
            }
        }
        PennDraw.clear();
        this.drawCurrentBoard();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles.length; col++) {
                this.setTilesPosition();
                tiles[row][col].drawCurrentTile();
            }
        }
        numberOfMoves++;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: moves the tiles in a downward motion when the 's' key has been
    * typed
    */
    @Override
    public void moveDown() {
        Tile[][] tiles = this.currentTiles;
        int k = 0;
        while (k < 2) {
            k++;
            for (int row = 1; row < tiles.length; row++) {
                for (int col = 0; col < tiles.length; col++) {
                    if (tiles[row - 1][col].getTileIntegerValue() ==
                    currentTiles[row][col].getTileIntegerValue() ||
                    tiles[row][col].getTileIntegerValue() == 0) {
                        tiles[row][col].addValue(tiles[row - 1][col]);
                        tiles[row - 1][col].setTileIntegerValue(0);
                    }
                }
            }
        }
        PennDraw.clear();
        this.drawCurrentBoard();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles.length; col++) {
                this.setTilesPosition();
                tiles[row][col].drawCurrentTile();
            }
        }
        numberOfMoves++;
    }
    
    /*
    * INPUT:
    * OUTPUT:
    * Description: moves the tiles to the left when the 'a' key has been typed
    */
    @Override
    public void moveRight() {
        Tile[][] tiles = this.currentTiles;
        int k = 0;
        while (k < 2) {
            k++;
            for (int row = 0; row < tiles.length; row++) {
                for (int col = 1; col < tiles.length; col++) {
                    if (tiles[row][col - 1].getTileIntegerValue() ==
                    currentTiles[row][col].getTileIntegerValue() ||
                    tiles[row][col].getTileIntegerValue() == 0) {
                        tiles[row][col].addValue(tiles[row][col - 1]);
                        tiles[row][col - 1].setTileIntegerValue(0);
                    }
                }
            }
        }
        PennDraw.clear();
        this.drawCurrentBoard();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles.length; col++) {
                this.setTilesPosition();
                tiles[row][col].drawCurrentTile();
            }
        }
        numberOfMoves++;
    }
    
    /*
    * INPUT:
    * OUTPUT:
    * Description:
    */
    @Override
    public void moveLeft() {
        Tile[][] tiles = this.currentTiles;
        int k = 0;
        while (k < 2) {
            k++;
            for (int row = 0; row < tiles.length; row++) {
                for (int col = 1; col < tiles.length; col++) {
                    if (tiles[row][col].getTileIntegerValue() ==
                    currentTiles[row][col].getTileIntegerValue() ||
                    tiles[row][col - 1].getTileIntegerValue() == 0) {
                        tiles[row][col - 1].addValue(tiles[row][col]);
                        tiles[row][col].setTileIntegerValue(0);
                    }
                }
            }
        }
        PennDraw.clear();
        this.drawCurrentBoard();
        for (int row = 1; row < tiles.length; row++) {
            for (int col = 0; col < tiles.length; col++) {
                this.setTilesPosition();
                tiles[row][col].drawCurrentTile();
            }
        }
        numberOfMoves++;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: boolean
    * Description: checks whether the board is full and there can be no other moves
    */
    @Override
    public boolean isFull() {
        Tile[][] tiles = this.currentTiles;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j].getTileIntegerValue() != 0) {
                    continue;
                    } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/a
    * Description: displays a notification that player has lost
    */
    @Override
    public void playerHasLost() {
        if (this.isFull() == true) {
            PennDraw.text(20, 20, "Game Over, You Lose!");
        }
    }
        
    /*
    * INPUT: N/A
    * OUTPUT: boolean as to whether or not player has won the game
    * Description: checks whether a player has a score of 2048 on one of the tiles
    */
    @Override
    public boolean playerHasWon() {
        Tile[][] tiles = this.currentTiles;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j].getTileIntegerValue() == 2048) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: the total number of moves played
    * Description: retrieves the total number of moves played in a game
    */
    @Override
    public int getNumberOfMoves() {
        return numberOfMoves;
    }
    
    /*
    * INPUT:
    * OUTPUT:
    * Description:
    */
    public void setTilesPosition() {
        Tile[][] tiles = this.currentTiles;
        for (int j = 0; j < tiles.length; j++) {
            for (int i = 0; i < tiles.length; i++) {
                tiles[j][i].setXCenter(X_CENTERS[i]);
                tiles[j][i].setYCenter(Y_CENTERS[i]);
            }
        }
    }        
}
