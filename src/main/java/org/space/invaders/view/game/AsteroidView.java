package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.print.DocFlavor;
import java.io.IOException;

public class AsteroidView extends View{
    private static final int CHAR_WIDTH = 3;
    private static final int CHAR_HEIGHT = 3;
    boolean isInvincible = false;

    //TODO implement spaceship model and then paint it
    private static final String[] AsteroidModel = {" " , " "};
    public AsteroidView(TextGraphics textGraphics ) {
        super(CHAR_WIDTH , CHAR_HEIGHT , textGraphics);
    }
    @Override
    public void draw()
    {

        if(isInvincible == false)
        {
            // TODO select model and call draw String[] spaceship =
        }
    }

    public void drawSpaceShip(String[] spaceship , int spaceshipX, int spaceshipY) throws IOException
    {
        for(int y = 0 ; y < spaceship.length ; y++)
        {
            for(int x = 0 ; x < spaceship[0].length() ; x++)
            {
                char character = spaceship[y].charAt(x);
                if (character != ' ') {
                    setColor(character);
                    graphics.fillRectangle(new TerminalPosition(spaceshipX * CHAR_WIDTH
                                    , spaceshipY * charHeight)
                            , new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }

    public String[] getAsteroidModel(){return AsteroidModel;}
}
