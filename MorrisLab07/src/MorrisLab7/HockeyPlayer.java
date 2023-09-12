package MorrisLab7;

public class HockeyPlayer extends Person {
	
	public enum Position {
		
		CENTER, RIGHT_WING, LEFT_WING, DEFENDER, GOALI, NO_POSITION_ASSIGNED
		
	}
	private int jerseyNum;
	private Position pos;
	
	public HockeyPlayer() {
		super();
		jerseyNum = -1;
		pos = Position.NO_POSITION_ASSIGNED;
	}
	
	public HockeyPlayer(String name, int num, Position p) {
		super(name);
		jerseyNum = num;
		pos = p;
	}
	
	public void deepCopy(HockeyPlayer H) {
		super.deepCopy(H);
		this.jerseyNum = H.jerseyNum;
		this.pos = H.pos;
	}
	
	public void setPlayer(String n, int num, Position p) {
		super.setName(n);
		pos = p;
		jerseyNum = num;
	}
	
	public String toString() {
		return super.toString() +"; Jersey: " + jerseyNum + "; Position: " + pos;
	}
	
	public boolean equals(HockeyPlayer P) {
		if (!super.equals(P)) {
			return false;
		}
		
		if (this.jerseyNum != P.jerseyNum) {
			return false;
		}
		
		if (this.pos != P.pos) {
			return false;
		}
		
		return true;
		
	}
	
	

}
