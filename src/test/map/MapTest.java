package test.map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.entity.Entity;
import model.exception.NullEntityException;
import model.exception.OutOfRangeException;
import model.helper.Position;
import model.map.Map;

public class MapTest {

	private Map m;
	private Entity e;
	private Position badPos;
	private Position p1;
	private Position p2;

	@Before
	public void init(){
		m = new Map("Map_Test",2,5,5);
		e = new Entity("Entity_Test");
		badPos = new Position(-1,-1);
		p1 = new Position(1,1);
		p2 = new Position(4,4);
	}

	@Test
	public void addEntityTest() throws NullEntityException, OutOfRangeException {
		try{
			m.addEntity(null, p1);
		}catch(NullEntityException e){
			assert(e.getMessage().contains("addEntity"));
		}
		try{
			m.addEntity(e, badPos);
		}catch(OutOfRangeException e){
			assert(e.getMessage().contains("add (Grid Template)"));
		}
	}

	@Test
	public void removeEntityTest() throws NullEntityException, OutOfRangeException{
		m.addEntity(e, p1);
		try{
			m.removeEntity(p2);
		}catch(NullEntityException e){
			assert(e.getMessage().contains("remove"));
		}
		try{
			m.removeEntity(p1);	
		}catch(NullEntityException e){
			assert(e.getMessage().contains("remove"));
		}

	}

	@Test
	public void moveEntityTest(){
		//TODO
	}
}
