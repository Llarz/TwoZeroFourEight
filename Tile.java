/*
* 
* Description: implements the APIs in the TileInterface to create a tile object
*
*/

public class Tile implements TileInterface {
    // Declare instance variables.
    private int integerValue;
    private int xCenter;
    private int yCenter;
    
    /* Constructor that randomly adds two tiles at the beginnig of a new game,
     * either both tiles with an int value of 2 or one with either 2 or 4
     */
    /*public Tile(int xCenter, int yCenter) {
        this.x = xCenter;
        this.y = yCenter;
    }
    */
    
    // Constructor that adds tiles
    public Tile(integerValue) {
        this.integerValue = integerValue;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: sets the various tiles to unique colors
    */
    @Override
    public void setTileColor() {
        if (integerValue == 0) {
            PennDraw.setPenColor(PennDraw.LIGHT_GRAY);
            } else if (integerValue == 2) {
            PennDraw.setPenColor(238, 228, 218);
            } else if (integerValue == 4) {
            PennDraw.setPenColor(237, 224, 200);
            } else if (integerValue == 8) {
            PennDraw.setPenColor(242, 177, 121);
            } else if (integerValue == 16) {
            PennDraw.setPenColor(245, 149, 99);
            } else if (integerValue == 32) {
            PennDraw.setPenColor(246, 124, 95);
            } else if (integerValue == 64) {
            PennDraw.setPenColor(246, 94, 59);
            } else if (integerValue == 128) {
            PennDraw.setPenColor(237, 207, 114);
            } else if (integerValue == 256) {
            PennDraw.setPenColor(237, 204, 97);
            } else if (integerValue == 512) {
            PennDraw.setPenColor(237, 200, 80);
            } else if (integerValue == 1024) {
            PennDraw.setPenColor(237, 197, 63);
            } else if (integerValue == 2048) {
            PennDraw.setPenColor(237, 194, 46);
        }
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Draws empty tiles in the beginning of the game 
    */
    @Override
    public void drawEmptyTiles() {
        Tile a = new Tile(0);
        a.setTileColor();
        PennDraw.filledSquare(this.getXCenter, this.getYCenter, 4);
    }

    /*
    * INPUT: N/A
    * OUTPUT: N/A
    * Description: Draws an updated tile at a certain location during the game.
    */
    public void drawCurrentTile() {
        Tile a = new Tile(this.integerValue);
        a.setTileColor();
        int xCentre = this.getXCenter();
        int yCentre = this.getYCenter();
        PennDraw.filledSquare(xCentre, yCentre, 4);
        PennDraw.setPenColor(12, 3, 10);
        PennDraw.setFontBold();
        PennDraw.setFontSize(32);
        if (this.getTileIntegerValue() != 0) {
            PennDraw.text(xCentre, yCentre, "" + this.getTileIntegerValue());
        }
    }
    
    /*
    * INPUT: a different tile
    * OUTPUT: the sum of the values of 2 tiles that merge
    * Description: adds the values of 2 tiles together
    */
    @Override
    public int addValues(Tile other) {
        return this.integerValue += other.integerValue;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: The interger value within a tile
    * Description: Gets the value of a tile
    */
    @Override
    public int getTileIntegerValue() {
        return integerValue;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: The interger value within a tile
    * Description: Sets a tile to a certain integer value
    */
    public void setTileIntegerValue(int newValue) {
        this.integerValue = newValue;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: The x-coordinate of the center of the tile.
    * Description: gets the x-coordinate of the center of the tile.
    */
    @Override
    public int getXCenter() {
        return xCenter;
    }
    
    /*
    * INPUT: N/A
    * OUTPUT: the y-coordinate of the center of the tile.
    * Description: Gets the y-coordinate of the center of the tile.
    */
    @Override
    public int getYCenter() {
        return yCenter;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void setXCenter(int newXCenter) {
        this.xCenter = newXCenter;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void setYCenter(int newYCenter) {
        this.yCenter = newYCenter;
    }
    
}
