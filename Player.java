package Max;

	enum Wind {
		North, East, South, West
	}
public class Player {
	String name;
	Hand currentHand;
	int currentPoints;
	Wind currentWind;
	
	public Player(String name) {
		this.name = name;
		this.currentHand = new Hand();
	}
	
	public Hand getCurrentHand() {
		return this.currentHand;
	}
	
	public void addTile(Tile t) {
		this.currentHand.addTile(t);
	}
	
	public void pickUpTile(Tile t, int discardIndex) {
		this.currentHand.pickUpTile(t, discardIndex);
	}
	
	public static Player nextPlayer(Player p1, Player p2, Player p3, Player p4, Player currentPlayer) {
		if(currentPlayer.equals(p1)) { return p2; }
		if(currentPlayer.equals(p2)) { return p3; }
		if(currentPlayer.equals(p3)) { return p4; }
		return p1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Player) {
			Player p = (Player)o;
			return p.name == this.name && p.currentWind == this.currentWind;
		}
		return false;
	}
	
}
