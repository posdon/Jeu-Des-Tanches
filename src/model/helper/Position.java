package model.helper;

public class Position {

	private final static int X_DEFAULT=-1;
	private final static int Y_DEFAULT=-1;
	private int x;
	private int y;

	public Position(){
		this(X_DEFAULT,Y_DEFAULT);
	}

	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}

	public Position(Position p){
		this.x=p.x;
		this.y=p.y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void setX(int x){
		this.x=x;
	}

	public void setY(int y){
		this.y=y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	public String toString(){
		return "x="+x+";y="+y;
	}
}
