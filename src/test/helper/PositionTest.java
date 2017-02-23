package test.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.helper.Position;

public class PositionTest {

	private Position p1;
	private Position p2;
	private Position p3;

	@Before
	public void init() {
		p1 = new Position(0,1);
		p2 = new Position();
		p3 = new Position(p1);
	}

	@Test
	public void equalsTest(){
		assertEquals(p1,p3);
		assertNotEquals(p1,p2);
		assertNotEquals(p2,p3);
	}

}
