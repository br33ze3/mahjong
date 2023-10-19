package Max;
import java.util.ArrayList;
import java.util.Scanner;
public class Hand {
	private ArrayList<Tile> currentTiles = new ArrayList<Tile>();
	private boolean hasPair = false;
	private boolean hasYaku = false; // Win Condition
	private boolean isHandClosed = true; // If you pon/chii or kan of the previously dropped tile, your hand opens 
								  // (halving han received at the end of the round)
	private int tripleCount = 0;
	private int straightCount = 0;
	public Hand() {
	}
	
	public void pickUpTile(Tile t, int discardIndex) {
		currentTiles.add(discardIndex, t);
	}
	
	public void addTile(Tile t) {
		currentTiles.add(t);
	}
	
	public String toString() {
		String str = "\n0: | ";
		for(int i = 0; i<currentTiles.size()-1; i++) {
			int num = i+1;
			str += currentTiles.get(i) + " | \n" + num + ": | ";
		}
		return str + currentTiles.get(currentTiles.size()-1) + " |";
	}
	
	
	 public boolean checkIfWon() {
		 if(hasPair) {
			 if(hasYaku) {
				 if(tripleCount + straightCount == 4) {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 public boolean checkForPair(int index1, int index2) {
		 if(currentTiles.get(index1).equals(currentTiles.get(index2))) {
			 hasPair = true;
			 return true;
		 }
 		 return false;
	 }
	 
	 public boolean pon(Tile droppedTile, int index1, int index2, int tilesLeft) {
		 if(tilesLeft == 69) {
			 System.out.println("There is nothing to pon");
			 return false;
		 }
		 Tile t1 = currentTiles.get(index1);
		 Tile t2 = currentTiles.get(index2);
		 Scanner scan = new Scanner(System.in);
		 int discardIndex;
		 if(droppedTile.getSuit() == t1.getSuit() 
				 && droppedTile.getSuit() == t2.getSuit()) {
			 if(t1.getValue() == t2.getValue() && droppedTile.getValue() == t2.getValue()) {
				 currentTiles.add(droppedTile);
				 isHandClosed = false;
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public Tile discard(int index) {
		 int commandInt = index;
		 while(true) {
			 if(commandInt >= 0 && commandInt <= 12) {
				 return currentTiles.remove(commandInt);
			 } else {
				 System.out.println("Please input a valid index");
				 Scanner scan = new Scanner(System.in);
				 commandInt = scan.nextInt();
			 }
		 }
	 }
	 
	 public boolean checkForYaku(Player p, Game g) {
		 if(hasYaku) {
			 return true;
		 }
		 if(isHandClosed) {
			 hasYaku = true;
			 return true;
		 }
		 int allSimplesCount = 0, WDCount = 0, RDCount = 0, GDCount = 0, GWCount = 0, PWCount = 0;
		 Wind currentWind = g.currentWind;
		 Wind playerWind = p.currentWind;
		 for(int i = 0; i<currentTiles.size(); i++) { // All simples Yaku (No 1's, 9's, or honor tiles)
			 if(currentTiles.get(i).getValue() > 1 && currentTiles.get(i).getValue() < 9) {
				 allSimplesCount++;
			 } 
			 if(currentTiles.get(i).getValue() == 10) {
				 WDCount++;
			 } else if(currentTiles.get(i).getValue() == 11) {
				 RDCount++;
			 } else if(currentTiles.get(i).getValue() == 12) {
				 GDCount++;
			 }
			 if(currentWind == Wind.North) {
				 if(currentTiles.get(i).getValue() == 13) {
					 GWCount++;
				 }
			 } else if(currentWind == Wind.East) {
				 if(currentTiles.get(i).getValue() == 14) {
					 GWCount++;
				 }
			 } else if(currentWind == Wind.South) {
				 if(currentTiles.get(i).getValue() == 15) {
					 GWCount++;
				 }
			 } else {
				 if(currentTiles.get(i).getValue() == 16) {
					 GWCount++;
				 }
			 }
			 if(playerWind == Wind.North) {
				 if(currentTiles.get(i).getValue() == 13) {
					 PWCount++;
				 }
			 } else if(playerWind == Wind.East) {
				 if(currentTiles.get(i).getValue() == 14) {
					 PWCount++;
				 }
			 } else if(playerWind == Wind.South) {
				 if(currentTiles.get(i).getValue() == 15) {
					 PWCount++;
				 }
			 } else {
				 if(currentTiles.get(i).getValue() == 16) {
					 PWCount++;
				 }
			 }
		 }
		 if(allSimplesCount == 13 || WDCount >= 3 || RDCount >= 3 || GDCount >= 3 || GWCount >= 3 || PWCount >= 3) {
			 hasYaku = true;
			 return true;
		 } 
		 return false;
	 }
	 public boolean chii(int index1, int index2, Tile previouslyDroppedTile) {
		 int aValue = currentTiles.get(index1).getValue();
		 int bValue = currentTiles.get(index2).getValue();
		 int cValue = previouslyDroppedTile.getValue();
		 int min = Math.min(aValue, Math.min(bValue, cValue));
		 int max = Math.max(aValue, Math.max(bValue, cValue));
		 return max - min == 2 && aValue != bValue && aValue != cValue && bValue!= cValue;
	 }
	 

	 
	 public void orderTiles() {
		 while(true) {
			 for(int i = 0; i<currentTiles.size(); i++) {
					int index = i;
					for(int j = i+1; j<currentTiles.size(); j++) {
						if(currentTiles.get(j).compareTo(currentTiles.get(index)) > 0) {
							index = j;
						}
					}
					Tile temp = currentTiles.get(index);
					currentTiles.set(index, currentTiles.get(i));
					currentTiles.set(i, temp);
				}
			 break;
		 }
		 ArrayList<Tile> character = new ArrayList<Tile>();
		 ArrayList<Tile> dot = new ArrayList<Tile>();
		 ArrayList<Tile> bamboo = new ArrayList<Tile>();
		 ArrayList<Tile> honorTiles = new ArrayList<Tile>();
		 
		 for(Tile t : currentTiles) {
			 if(t.getSuit() == Suit.Character) {
				 character.add(t);
			 } else if(t.getSuit() == Suit.Dot) {
				 dot.add(t);
			 } else if(t.getSuit() == Suit.Bamboo) {
				 bamboo.add(t);
			 } else {
				 honorTiles.add(t);
			 }
		 }

		 while(true) {
			 for(int i = 0; i<character.size(); i++) {
				 int index = i;
				 for(int j = i+1; j<character.size(); j++) {
					 if(character.get(j).getValue() < character.get(index).getValue()) {
						 index = j;
					 }
				 }
				 Tile temp = character.get(index);
				 character.set(index, character.get(i));
				 character.set(i, temp);
			 }
			 break;
		 }
		 while(true) {
			 for(int i = 0; i<dot.size(); i++) {
				 int index = i;
				 for(int j = i+1; j<dot.size(); j++) {
					 if(dot.get(j).getValue() < dot.get(index).getValue()) {
						 index = j;
					 }
				 }
				 Tile temp = dot.get(index);
				 dot.set(index, dot.get(i));
				 dot.set(i, temp);
			 }
			 break;
		 }
		 while(true) {
			 for(int i = 0; i<bamboo.size(); i++) {
				 int index = i;
				 for(int j = i+1; j<bamboo.size(); j++) {
					 if(bamboo.get(j).getValue() < bamboo.get(index).getValue()) {
						 index = j;
					 }
				 }
				 Tile temp = bamboo.get(index);
				 bamboo.set(index, bamboo.get(i));
				 bamboo.set(i, temp);
			 }
			 break;
		 }
		 while(true) {
			 for(int i = 0; i<honorTiles.size(); i++) {
				 int index = i;
				 for(int j = i+1; j<honorTiles.size(); j++) {
					 if(honorTiles.get(j).getValue() < honorTiles.get(index).getValue()) {
						 index = j;
					 }
				 }
				 Tile temp = honorTiles.get(index);
				 honorTiles.set(index, honorTiles.get(i));
				 honorTiles.set(i, temp);
			 }
			 break;
		 }
		 ArrayList<Tile> newCurrentTiles = new ArrayList<Tile>();
		 for(int i = 0; i<character.size();i++) {
			 newCurrentTiles.add(character.get(i));
		 }
		 for(int i = 0; i<dot.size();i++) {
			 newCurrentTiles.add(dot.get(i));
		 }
		 for(int i = 0; i<bamboo.size();i++) {
			 newCurrentTiles.add(bamboo.get(i));
		 }
		 for(int i = 0; i<honorTiles.size();i++) {
			 newCurrentTiles.add(honorTiles.get(i));
		 }
		 currentTiles = newCurrentTiles;
	 }
	 
	 public static void wipeTiles(Hand h) {
		 for(int i = 0; i<h.currentTiles.size(); i++) {
			 h.currentTiles.remove(i);
		 }
	 }
	
}
