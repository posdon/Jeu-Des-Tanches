package test.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.entity.Entity;

public class EntityTest {

	private Entity defaultEntity;
	private Entity e1;
	private Entity e2;
	private Entity e3;

	@Before
	public void init(){
		defaultEntity = new Entity();
		e1 = new Entity("e1");
		e2 = new Entity("e2");
		e3 = new Entity("e3",true,true,true,true,true);
	}

	@Test
	public void equalsTest() {
		System.out.println(defaultEntity.toString());
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		assertNotNull(defaultEntity);
		assertNotEquals(e1,e2);
		e1.setName("e2");
		assertTrue(e1.equals(e2));
		e2.setActive(true);
		assertFalse(e1.equals(e2));
	}

}
