package model.entity;

public class Entity {

	private String name;
	private boolean isSolid;	// True => Can't be stack with another Entity.isSolid:true
	private boolean isAlive;
	private boolean isMovible; 	// True => Can be moved
	private boolean isActive;	// False => Just pass his turn
	private boolean isMoving; 	// True => Can move by itself

	/**
	 * Default constructor
	 * name = NO_NAMED_ENTITY
	 * every boolean are false
	 */
	public Entity(){
		this("NO_NAMED_ENTITY");
	}

	/**
	 * Specific constructor
	 * @param n is the name of the entity
	 * every boolean are false
	 */
	public Entity(String n){
		this(n,false,false,false,false,false);
	}

	/**
	 * Specific constructor
	 * @param n is the name of the entity
	 * @param solid is true when an entity can't be stack with another solid entity
	 * @param alive is true when isn't an object
	 * @param movible is true when someone can moved it
	 * @param active is true when it doesn't just pass its turns
	 * @param moving is true when it can move by itself
	 */
	public Entity(String n, boolean solid, boolean alive, boolean movible, boolean active, boolean moving){
		name=n;
		isSolid=solid;
		isAlive=alive;
		isMovible=movible;
		isActive=active;
		isMoving=moving;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isMovible() {
		return isMovible;
	}

	public void setMovible(boolean isMovible) {
		this.isMovible = isMovible;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (isActive != other.isActive)
			return false;
		if (isAlive != other.isAlive)
			return false;
		if (isMovible != other.isMovible)
			return false;
		if (isMoving != other.isMoving)
			return false;
		if (isSolid != other.isSolid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString(){
		String result=name+" : ";
		result+= isSolid ? "solid":"ethereal";
		result+=", ";
		result+=isAlive ? "alive":"dead";
		result+=", ";
		result+=isMovible ? "movible":"unmovible";
		result+=", ";
		result+=isActive ? "active":"passive";
		result+=", ";
		result+=isMoving ? "mobile":"fix";
		return result;
	}
}
