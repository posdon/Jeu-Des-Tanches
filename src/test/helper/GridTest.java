package test.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exception.OutOfRangeException;
import model.helper.Grid;
import model.helper.Position;

public class GridTest {

	private Grid<Integer> grid;
	private int number1;
	private int number2;
	private int number3;

	@Before
	public void init() throws OutOfRangeException{
		grid = new Grid<Integer>(5,5);
		number1 = 1;
		number2 = 2;
		number3 = 3;
		grid.add(number1, new Position(3,1));
		grid.add(number2, new Position(0,0));
		grid.add(number3, new Position(4,4));
	}

	@Test
	public void exceptionTest(){
		try {
			grid.add(number1, new Position(-1,-1));
		} catch (OutOfRangeException e) {
			assert(e.getMessage().contains("in add"));
		}
	}

	@Test
	public void moveUpTest() throws OutOfRangeException {
		assertEquals(number1, (int) grid.getOn(new Position(3,1)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		grid.moveUp(number1);
		grid.moveUp(number2);
		grid.moveUp(number3);
		assertEquals(number1, (int) grid.getOn(new Position(3,0)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,3)));
		assertNull(grid.getOn(new Position(3,1)));
		assertNull(grid.getOn(new Position(4,4)));
		grid.moveUp(new Position(3,0));
		grid.moveUp(new Position(0,0));
		grid.moveUp(new Position(4,3));
		assertEquals(number1, (int) grid.getOn(new Position(3,0)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,2)));
		assertNull(grid.getOn(new Position(4,3)));
	}

	@Test
	public void moveRightTest() throws OutOfRangeException {
		assertEquals(number1, (int) grid.getOn(new Position(3,1)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		grid.moveRight(number1);
		grid.moveRight(number2);
		grid.moveRight(number3);
		assertEquals(number1, (int) grid.getOn(new Position(4,1)));
		assertEquals(number2, (int) grid.getOn(new Position(1,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		assertNull(grid.getOn(new Position(3,1)));
		assertNull(grid.getOn(new Position(0,0)));
		grid.moveRight(new Position(4,1));
		grid.moveRight(new Position(1,0));
		grid.moveRight(new Position(4,4));
		assertEquals(number1, (int) grid.getOn(new Position(4,1)));
		assertEquals(number2, (int) grid.getOn(new Position(2,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		assertNull(grid.getOn(new Position(1,0)));
	}

	@Test
	public void moveLeftTest() throws OutOfRangeException {
		assertEquals(number1, (int) grid.getOn(new Position(3,1)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		grid.moveLeft(number1);
		grid.moveLeft(number2);
		grid.moveLeft(number3);
		assertEquals(number1, (int) grid.getOn(new Position(2,1)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(3,4)));
		assertNull(grid.getOn(new Position(3,1)));
		assertNull(grid.getOn(new Position(4,4)));
		grid.moveLeft(new Position(2,1));
		grid.moveLeft(new Position(0,0));
		grid.moveLeft(new Position(3,4));
		assertEquals(number1, (int) grid.getOn(new Position(1,1)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(2,4)));
		assertNull(grid.getOn(new Position(3,4)));
		assertNull(grid.getOn(new Position(2,1)));
	}

	@Test
	public void moveDownTest() throws OutOfRangeException {
		assertEquals(number1, (int) grid.getOn(new Position(3,1)));
		assertEquals(number2, (int) grid.getOn(new Position(0,0)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		grid.moveDown(number1);
		grid.moveDown(number2);
		grid.moveDown(number3);
		assertEquals(number1, (int) grid.getOn(new Position(3,2)));
		assertEquals(number2, (int) grid.getOn(new Position(0,1)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		assertNull(grid.getOn(new Position(3,1)));
		assertNull(grid.getOn(new Position(0,0)));
		grid.moveDown(new Position(3,2));
		grid.moveDown(new Position(0,1));
		grid.moveDown(new Position(4,4));
		assertEquals(number1, (int) grid.getOn(new Position(3,3)));
		assertEquals(number2, (int) grid.getOn(new Position(0,2)));
		assertEquals(number3, (int) grid.getOn(new Position(4,4)));
		assertNull(grid.getOn(new Position(0,1)));
		assertNull(grid.getOn(new Position(3,2)));
	}
}
