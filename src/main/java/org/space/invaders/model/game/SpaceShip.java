package org.space.invaders.model.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.view.game.SpaceshipView;


public class SpaceShip extends Element {
    private boolean invincible;
    private boolean shooting;
    private boolean isMini;
    private SpaceshipView spaceshipView;
    private long time;

    public SpaceShip(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate , alive , height , width , 0);
        this.isMini = false;
        toggleMini(isMini);
    }
    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
        if (invincible == true) time = System.currentTimeMillis();
    }
    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public boolean isMini() {
        return isMini;
    }

    public void toggleMini(boolean mini) {
        isMini = mini;
        if(mini)
        {
            setXVelocity(5);
            setYVelocity(5);
        }else
        {
            setXVelocity(1);
            setYVelocity(1);
        }
    }
    public void shot()
    {
        //TODO actually shot
    }
    public void miniShot()
    {

    }
    public void draw(TextGraphics textGraphics)
    {
        spaceshipView = new SpaceshipView(this , textGraphics);
        spaceshipView.draw();
    }

    @Override
    public String[] getDesign() {
        return spaceshipView.getDesign();
    }
    public void calculateInvincibility()
    {
        if((double) (System.currentTimeMillis() - time) /1000 > (2+0.5))
        {
            setInvincible(false);
        }
    }
}

