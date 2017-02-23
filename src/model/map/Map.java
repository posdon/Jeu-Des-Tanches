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

    public void addEntity(Entity e, Position p) throws NullEntityException, OutOfRangeException{
    	if(e!=null){
    		grid.add(e, p);
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
    		throw new NullEntityException("No entity on "+p+" in removeEntity(Position)");
    	}
    }

    public void removeEntity(Entity e) throws NullEntityException{
    	if(e!=null){
    		if(grid.isOnGrid(e)){
    			grid.delete(e);
    		}else{
    			throw new NullEntityException(e+" isn't on grid in removeEntity(Entity)");
    		}
    	}else{
    		throw new NullEntityException(e+" is null in removeEntity");
    	}
    }

    public void moveEntityLeft(Entity e){
    	//TODO all the move Entity
    }

}
