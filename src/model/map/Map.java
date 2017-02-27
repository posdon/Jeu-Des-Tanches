package model.map;

import model.entity.Entity;
import model.exception.NullEntityException;
import model.exception.OutOfRangeException;
import model.helper.Grid;
import model.helper.Position;

public class Map {

    private String id;
    private Grid<Entity> grid;
    private int nbPlayer;
    private Position[][] spawnPosByTeam;

    /**
     * Default :
     * 	id = DEFAULT_MAP
     * 	nbPlayer = 0
     * 	grid = 1x1
     */
    public Map(){
        this("DEFAULT_MAP",0,1);
    }

    /**
     * @param id : name of the map
     * @param nbPlayer : number of player/team
     * @param size : grid map = size x size
     */
    public Map(String id, int nbPlayer, int size){
        this(id,nbPlayer,size,size);
    }

    /**
     * grid map = width x height
     * @param id : name of the map
     * @param nbPlayer : number of player/team
     * @param width
     * @param height
     */
    public Map(String id, int nbPlayer, int width, int height){
        this.id=id;
        this.nbPlayer=nbPlayer;
        grid = new Grid<Entity>(width, height);
        spawnPosByTeam = new Position[nbPlayer][];
    }

    /* Getters and setters */
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Grid<Entity> getGrid() {
        return grid;
    }

    public void setGrid(Grid<Entity> grid) {
        this.grid = grid;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public Position[][] getSpawnPosByTeam() {
        return spawnPosByTeam;
    }

    public Position[] getSpawnPosByTeam(int team){
    	return this.spawnPosByTeam[team];
    }

    public void setSpawnPosByTeam(Position[][] spawnPosByTeam) {
        this.spawnPosByTeam = spawnPosByTeam;
    }

    public void setSpawnPosByTeam(int team, Position[] spawn) throws OutOfRangeException {
		if( team>0 && team<=nbPlayer ){
			spawnPosByTeam[team-1] = spawn;
		}else{
			throw new OutOfRangeException(team+" isn't a team for Map "+id+" in setSpawnPosByTeam");
		}
    }
    
    /* Boolean functions */
    
    public boolean isOccupied(Position t){
    	return grid.isOccupied(t);
    }
    
    public boolean isOccupiedBy(Position t, Entity e){
    	if(grid.isOnGrid(e)){
    		return t.equals(grid.getPos(e));
    	}else{
    		return false;
    	}
    }
    
    public boolean isOccupiedBy(Entity e, Position t){
    	if(grid.isOnGrid(e)){
    		return t.equals(grid.getPos(e));
    	}else{
    		return false;
    	}
    }
    
    
    /* Add, move and remove functions */

    public void addEntity(Entity e, Position p) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		if(grid.isOccupied(p) && e.isSolid()){
    			if(grid.getOn(p).isSolid()){
    				// Case : Both entity are solid
    				//TODO
    			}else{
    				// Case : Non-solid entity on p
    				grid.add(e, p);
    			}
    		}else{
    			// Case : Non-solid e or empty p
        		grid.add(e, p);
    		}
    	}else{
    		throw new NullEntityException(e+" is null in addEntity");
    	}
    }

    public void moveEntity(Entity e, Position p) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.delete(e);
    			grid.add(e, p);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in moveEntity");
    		}
    	}else{
    		throw new NullEntityException(e+" is null in moveEntity");
    	}
    }

    public void removeEntity(Position p) throws NullEntityException{
    	if(grid.isOccupied(p)){
    		grid.clear(p);
    	}else{
    		throw new NullEntityException("No entity on "+p+" in removeEntity (Entity)");
    	}
    }

    public void removeEntity(Entity e) throws NullEntityException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.delete(e);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in removeEntity (Entity)");
    		}
    	}else{
    		throw new NullEntityException(e+" is null in removeEntity");
    	}
    }

    public void moveEntityLeft(Entity e) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.moveLeft(e);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in moveEntityLeft (Entity)");
    		}
    	}else{
    		throw new NullEntityException("No entity in moveEntityLeft (Entity)");
    	}
    }
    
    public void moveEntityUp(Entity e) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.moveUp(e);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in moveEntityUp (Entity)");
    		}
    	}else{
    		throw new NullEntityException("No entity in moveEntityUp (Entity)");
    	}
    }
    
    public void moveEntityDown(Entity e) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.moveDown(e);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in moveEntityDown (Entity)");
    		}
    	}else{
    		throw new NullEntityException("No entity in moveEntityDown (Entity)");
    	}
    }
    
    public void moveEntityRight(Entity e) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.moveRight(e);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in moveEntityRight (Entity)");
    		}
    	}else{
    		throw new NullEntityException("No entity in moveEntityRight (Entity)");
    	}
    }

}
