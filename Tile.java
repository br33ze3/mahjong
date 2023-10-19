package Max;

	enum Suit {
		Bamboo, Dot, Character, HonorTile
	}
	enum HonorTile {
		WhiteDragon, RedDragon, GreenDragon, North, East, South, West
	}
	
public class Tile {

	private Suit suit;
	private int value; // Numbers 1-9 are valid and the honor tiles will be represented with 10-16
	private boolean isRedDora; 
	private boolean isKandora;
	
	public Tile(Suit suit, int value, boolean isRedDora, boolean isKandora) {
		this.suit = suit;
		this.value = value;
		this.isRedDora = isRedDora;
		this.isKandora = isKandora;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int compareTo(Tile t) {
		return this.getSuitValue() - t.getSuitValue();
	}
	
	private int getSuitValue() {
		if(getSuit() == Suit.Character) {
			return 4;
		} else if(getSuit() == Suit.Dot) {
			return 3;
		} else if(getSuit() == Suit.Bamboo) {
			return 2;
		} else {
			return 1;
		}
	}
	
	public int getValue() {
		return this.value;
	}
	public String toString() {
		if(this.suit != Suit.HonorTile) {
			if(!isRedDora && !isKandora) {
				return value + " of " + suit;
			} else if(!isRedDora && isKandora || isRedDora && !isKandora) {
				return value + " of " + suit + " (1 extra han)";
			} else {
				return value + " of " + suit + " (2 extra han)";
			}
		} else {
			if(!isKandora) {
				if(value == 10) {
					return "" + HonorTile.WhiteDragon;
				} else if(value == 11) {
					return "" + HonorTile.RedDragon;
				} else if(value == 12) {
					return "" + HonorTile.GreenDragon;
				} else if(value == 13) {
					return "" + HonorTile.North;
				} else if(value == 14) {
					return "" + HonorTile.East;
				} else if(value == 15) {
					return "" + HonorTile.South;
				} else {
					return "" + HonorTile.West;
				}
			} else {
				if(value == 10) {
					return "" + HonorTile.WhiteDragon + " (1 extra han)";
				} else if(value == 11) {
					return "" + HonorTile.RedDragon + " (1 extra han)";
				} else if(value == 12) {
					return "" + HonorTile.GreenDragon + " (1 extra han)";
				} else if(value == 13) {
					return "" + HonorTile.North + " (1 extra han)";
				} else if(value == 14) {
					return "" + HonorTile.East + " (1 extra han)";
				} else if(value == 15) {
					return "" + HonorTile.South + " (1 extra han)";
				} else {
					return "" + HonorTile.West + " (1 extra han)";
				}
			}
		}
		
	}
}
