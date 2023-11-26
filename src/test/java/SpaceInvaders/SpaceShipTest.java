package SpaceInvaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpaceShipTest {

    @InjectMocks
    private SpaceShip spaceShip;

    @Mock
    private Position positionMock;

    private char orientation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        spaceShip = new SpaceShip(40, 30, 1.0, 1.0, 5, 0);
    }

    @Test
    void moveRightTest() {
        orientation = 'R';
        spaceShip.moveRight(orientation);
        positionMock.setX(spaceShip.getX());
        verify(positionMock).setX(41);
        positionMock.setY(spaceShip.getX());
        assertEquals(41, spaceShip.getPositionX());
        assertEquals(30, spaceShip.getPositionY());
    }


    @Test
    void moveLeftTest() {
        orientation = 'L';
        spaceShip.moveLeft(orientation);
        positionMock.setX(spaceShip.getX());
        verify(positionMock).setX(39);
        positionMock.setY(spaceShip.getY());
        assertEquals(39, spaceShip.getPositionX());
        assertEquals(30, spaceShip.getPositionY());
    }
    @Test
    void moveUpTest(){
        orientation = 'U';
        spaceShip.moveUp(orientation);
        positionMock.setY(spaceShip.getY());
        verify(positionMock).setY(31);
        verify(positionMock).setX(40);
        assertEquals(31, spaceShip.getPositionY());
        assertEquals(40, spaceShip.getPositionX());
    }
    @Test
    void moveDownTest(){
        orientation = 'D';
        when(positionMock.getY()).thenReturn(30);
        spaceShip.moveUp(orientation);
        verify(positionMock).setY(29);
        assertEquals(positionMock.getY(), spaceShip.getPositionY());
        verify(positionMock).setX(40);
        assertEquals(40, spaceShip.getPositionX());
    }
    @Test
    void upBoundaryTest(){
        spaceShip.setY(0);
        orientation = 'U';
        spaceShip.moveUp(orientation);
        verify(positionMock).setY(0);
        assertEquals(positionMock.getY(), spaceShip.getPositionY());
    }
    @Test
    void downBoundaryTest(){
        spaceShip.setY(50);
        orientation = 'D';
        spaceShip.moveDown(orientation);
        verify(positionMock).setY(50);
        assertEquals(positionMock.getY(), spaceShip.getPositionY());
    }
    @Test
    void leftBoundaryTest(){
        spaceShip.setX(0);
        orientation = 'L';
        spaceShip.moveLeft(orientation);
        verify(positionMock).setX(0);
        assertEquals(positionMock.getX(), spaceShip.getPositionX());
    }
    @Test
    void rightBoundaryTest(){
        spaceShip.setX(100);
        orientation = 'R';
        spaceShip.moveRight(orientation);
        verify(positionMock).setX(100);
        assertEquals(positionMock.getX(), spaceShip.getPositionX());
    }
}