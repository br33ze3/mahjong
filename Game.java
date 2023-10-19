package Max;
import java.util.ArrayList;

public class Game {
	Wind currentWind = Wind.East;
	int currentRound = 1;
	boolean isEastOnly;
	boolean gameConcluded = false;
	
	public Game(boolean isEastOnly) {
		this.isEastOnly = isEastOnly;
	}
	
	public String nextRound(Player winner) {
		String str = "";
		if(isEastOnly) {
			if(currentRound == 4) {
				if(winner.currentWind != currentWind) {
					str = winner.name + " has won the round. The game has concluded.";
					gameConcluded = true;
				} else {
					str = winner.name + " has won the round. They are the dealer so the game will continue";
				}
			} else {
				if(winner.currentWind != currentWind) {
					currentRound++;
					str = winner.name + " has won the round. The wind is now East " + currentRound;
				} else {
					str = winner.name + " has won the round but they were the dealer. The wind is still East " + currentRound;
				}
			}
		} else {
			if(currentWind == Wind.South) {
				if(currentRound == 4) {
					if(winner.currentWind != currentWind) {
						str = winner.name + " has won the round. The game has concluded.";
						gameConcluded = true;
					} else {
						str = winner.name + " has won the round. They are the dealer so the game will continue";
					}
				} else {
					if(winner.currentWind != currentWind) {
						currentRound++;
						str = winner.name + " has won the round. The wind is now South " + currentRound;
					} else {
						str = winner.name + " has won the round but they were the dealer. The wind is still South " + currentRound;
					}
				}
			} else {
				if(currentRound == 4) {
					if(winner.currentWind != currentWind) {
						currentRound = 1;
						currentWind = Wind.South;
						str = winner.name + " has won the round. The wind is now South " + currentRound;
					} else {
						str = winner.name + " has won the round but they were the dealer. The wind is still East " + currentRound;
					}
				} else {
					if(winner.currentWind != currentWind) {
						currentRound++;
						str = winner.name + " has won the round. The wind is now South " + currentRound;
					} else {
						str = winner.name + " has won the round but they were the dealer. The wind is still South " + currentRound;
					}
				}
			}
		}
		return str;
	}
	
	public static void dealTiles(Player p1, Player p2, Player p3, Player p4, Deck deck) {
		deck.fillDeck();
		for(int i = 1; i<13; i++) {
			p1.addTile(deck.allTiles.remove((int)(Math.random()*deck.allTiles.size())));
			p2.addTile(deck.allTiles.remove((int)(Math.random()*deck.allTiles.size())));
			p3.addTile(deck.allTiles.remove((int)(Math.random()*deck.allTiles.size())));
			p4.addTile(deck.allTiles.remove((int)(Math.random()*deck.allTiles.size())));
		}
	}
	
	public String toString() {
		return this.currentWind + " " + this.currentRound;
	}
	
	public static Player shiftWinds(Player p1, Player p2, Player p3, Player p4) { // will return the East position Player
		if(p1.currentWind == Wind.East) {
			p1.currentWind = Wind.South;
			p2.currentWind = Wind.West;
			p3.currentWind = Wind.North;
			p4.currentWind = Wind.East;
			return p4;
		} else if(p1.currentWind == Wind.South) {
			p1.currentWind = Wind.West;
			p2.currentWind = Wind.North;
			p3.currentWind = Wind.East;
			p4.currentWind = Wind.South;
			return p3;
		} else if(p1.currentWind == Wind.West) {
			p1.currentWind = Wind.North;
			p2.currentWind = Wind.East;
			p3.currentWind = Wind.South;
			p4.currentWind = Wind.West;
			return p2;
		} else {
			p1.currentWind = Wind.East;
			p2.currentWind = Wind.South;
			p3.currentWind = Wind.West;
			p4.currentWind = Wind.North;
			return p1;
		}
	}
}
