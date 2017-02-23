package model.helper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.exception.OutOfRangeException;

public class Grid<T> {

	private int xMax;
	private int yMax;
	private Map<T,Position> grid;

	/**
	 * By default : 0,0
	 */
	public Grid(){
		this(0,0);
	}

	/**
	 * Rows 0 : size-1
	 * Columns 0 : size-1
	 * @param size number of columns and rows
	 */
	public Grid(int size){
		this(size,size);
	}

	/**
	 * Rows 0 : y-1
	 * Columns 0 : x-1
	 * @param x number of columns
	 * @param y number of rows
	 */
	public Grid(int x, int y){
		xMax=x;
		yMax=y;
		grid = new HashMap<T,Position>();
	}

	public int getX(){
		return xMax;
	}

	public int getY(){
		return yMax;
	}

	public Map<T,Position> getGrid(){
		return grid;
	}

	public Position getPos(T t){
		return (grid.containsKey(t))? grid.get(t) : new Position();
	}

	public T getOn(Position p){
		if(grid.containsValue(p)){
			Iterator<T> itT = grid.keySet().iterator();
			while(itT.hasNext()){
				T currT = itT.next();
				if(grid.get(currT).equals(p)){
					return currT;
				}
			}
		}
		return null;
	}

	public boolean isOnGrid(T t){
		return grid.containsKey(t);
	}

	public boolean isOccupied(Position p){
		return grid.containsValue(p);
	}

	public void add(T t, Position p) throws OutOfRangeException {
		if(p.getX()>=0&&p.getX()<xMax&&p.getY()>=0&&p.getY()<yMax){
			clear(p);
			grid.put(t, p);
		}else{
			throw new OutOfRangeException("out of limit in add (Grid Template)");
		}
	}

	public void delete(T t){
		grid.remove(t);
	}

	public void clear(Position p){
		Iterator<T> it = grid.keySet().iterator();
		while(it.hasNext()){
			T currT = it.next();
			if(grid.get(currT).equals(p)){
				grid.remove(currT);
			}
		}
	}

	public void clearAll(){
		grid.clear();
	}

	public void moveDown(T t) throws OutOfRangeException{
		if(grid.containsKey(t)){
			Position oldP = grid.get(t);
			if(oldP.getY()<yMax-1){
				add(t, new Position(oldP.getX(),oldP.getY()+1));
			}
		}
	}

	public void moveRight(T t) throws OutOfRangeException{
		if(grid.containsKey(t)){
			Position oldP = grid.get(t);
			if(oldP.getX()<xMax-1){
				add(t, new Position(oldP.getX()+1,oldP.getY()));
			}
		}
	}

	public void moveUp(T t) throws OutOfRangeException{
		if(grid.containsKey(t)){
			Position oldP = new Position(grid.get(t));
			if(oldP.getY()>0){
				add(t, new Position(oldP.getX(), oldP.getY()-1));
			}
		}
	}

	public void moveLeft(T t) throws OutOfRangeException{
		if(grid.containsKey(t)){
			Position oldP = grid.get(t);
			if(oldP.getX()>0){
				add(t, new Position(oldP.getX()-1, oldP.getY()));
			}
		}
	}

	public void moveDown(Position p) throws OutOfRangeException{
		if(grid.containsValue(p)){
			if(p.getY()<yMax-1){
				add(getOn(p), new Position(p.getX(),p.getY()+1));
			}
		}
	}

	public void moveRight(Position p) throws OutOfRangeException{
		if(grid.containsValue(p)){
			if(p.getX()<xMax-1){
				add(getOn(p), new Position(p.getX()+1,p.getY()));
			}
		}
	}

	public void moveUp(Position p) throws OutOfRangeException{
		if(grid.containsValue(p)){
			if(p.getY()>0){
				add(getOn(p), new Position(p.getX(),p.getY()-1));
			}
		}
	}

	public void moveLeft(Position p) throws OutOfRangeException{
		if(grid.containsValue(p)){
			if(p.getX()>0){
				add(getOn(p), new Position(p.getX()-1,p.getY()));
			}
		}
	}
}
