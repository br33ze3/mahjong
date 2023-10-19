package Max;

import java.util.ArrayList;

public class TestDeck {
	Tile[] bamboo = {
			(new Tile(Suit.Bamboo, 1, false, false)),
			(new Tile(Suit.Bamboo, 1, false, false)),
			(new Tile(Suit.Bamboo, 1, false, false)),
			(new Tile(Suit.Bamboo, 1, false, false)),
			(new Tile(Suit.Bamboo, 2, false, false)),
			(new Tile(Suit.Bamboo, 2, false, false)),
			(new Tile(Suit.Bamboo, 2, false, false)),
			(new Tile(Suit.Bamboo, 2, false, false)),
			(new Tile(Suit.Bamboo, 3, false, false)),
			(new Tile(Suit.Bamboo, 3, false, false)),
			(new Tile(Suit.Bamboo, 3, false, false)),
			(new Tile(Suit.Bamboo, 3, false, false)),
			(new Tile(Suit.Bamboo, 4, false, false)),
			(new Tile(Suit.Bamboo, 4, false, false)),
			(new Tile(Suit.Bamboo, 4, false, false)),
			(new Tile(Suit.Bamboo, 4, false, false)),
			(new Tile(Suit.Bamboo, 5, true, false)),
			(new Tile(Suit.Bamboo, 5, false, false)),
			(new Tile(Suit.Bamboo, 5, false, false)),
			(new Tile(Suit.Bamboo, 5, false, false)),
			(new Tile(Suit.Bamboo, 6, false, false)),
			(new Tile(Suit.Bamboo, 6, false, false)),
			(new Tile(Suit.Bamboo, 6, false, false)),
			(new Tile(Suit.Bamboo, 6, false, false)),
			(new Tile(Suit.Bamboo, 7, false, false)),
			(new Tile(Suit.Bamboo, 7, false, false)),
			(new Tile(Suit.Bamboo, 7, false, false)),
			(new Tile(Suit.Bamboo, 7, false, false)),
			(new Tile(Suit.Bamboo, 8, false, false)),
			(new Tile(Suit.Bamboo, 8, false, false)),
			(new Tile(Suit.Bamboo, 8, false, false)),
			(new Tile(Suit.Bamboo, 8, false, false)),
			(new Tile(Suit.Bamboo, 9, false, false)),
			(new Tile(Suit.Bamboo, 9, false, false)),
			(new Tile(Suit.Bamboo, 9, false, false)),
			(new Tile(Suit.Bamboo, 9, false, false))
	};
	
	public TestDeck() {}
	
	public void fillDeck() {
		
		
//		this.dots.add(new Tile(Suit.Dot, 1, false, false));
//		this.dots.add(new Tile(Suit.Dot, 1, false, false));
//		this.dots.add(new Tile(Suit.Dot, 1, false, false));
//		this.dots.add(new Tile(Suit.Dot, 1, false, false));
//		this.dots.add(new Tile(Suit.Dot, 2, false, false));
//		this.dots.add(new Tile(Suit.Dot, 2, false, false));
//		this.dots.add(new Tile(Suit.Dot, 2, false, false));
//		this.dots.add(new Tile(Suit.Dot, 2, false, false));
//		this.dots.add(new Tile(Suit.Dot, 3, false, false));
//		this.dots.add(new Tile(Suit.Dot, 3, false, false));
//		this.dots.add(new Tile(Suit.Dot, 3, false, false));
//		this.dots.add(new Tile(Suit.Dot, 3, false, false));
//		this.dots.add(new Tile(Suit.Dot, 4, false, false));
//		this.dots.add(new Tile(Suit.Dot, 4, false, false));
//		this.dots.add(new Tile(Suit.Dot, 4, false, false));
//		this.dots.add(new Tile(Suit.Dot, 4, false, false));
//		this.dots.add(new Tile(Suit.Dot, 5, true, false));
//		this.dots.add(new Tile(Suit.Dot, 5, false, false));
//		this.dots.add(new Tile(Suit.Dot, 5, false, false));
//		this.dots.add(new Tile(Suit.Dot, 5, false, false));
//		this.dots.add(new Tile(Suit.Dot, 6, false, false));
//		this.dots.add(new Tile(Suit.Dot, 6, false, false));
//		this.dots.add(new Tile(Suit.Dot, 6, false, false));
//		this.dots.add(new Tile(Suit.Dot, 6, false, false));
//		this.dots.add(new Tile(Suit.Dot, 7, false, false));
//		this.dots.add(new Tile(Suit.Dot, 7, false, false));
//		this.dots.add(new Tile(Suit.Dot, 7, false, false));
//		this.dots.add(new Tile(Suit.Dot, 7, false, false));
//		this.dots.add(new Tile(Suit.Dot, 8, false, false));
//		this.dots.add(new Tile(Suit.Dot, 8, false, false));
//		this.dots.add(new Tile(Suit.Dot, 8, false, false));
//		this.dots.add(new Tile(Suit.Dot, 8, false, false));
//		this.dots.add(new Tile(Suit.Dot, 9, false, false));
//		this.dots.add(new Tile(Suit.Dot, 9, false, false));
//		this.dots.add(new Tile(Suit.Dot, 9, false, false));
//		this.dots.add(new Tile(Suit.Dot, 9, false, false));
//		
//		this.character.add(new Tile(Suit.Character, 1, false, false));
//		this.character.add(new Tile(Suit.Character, 1, false, false));
//		this.character.add(new Tile(Suit.Character, 1, false, false));
//		this.character.add(new Tile(Suit.Character, 1, false, false));
//		this.character.add(new Tile(Suit.Character, 2, false, false));
//		this.character.add(new Tile(Suit.Character, 2, false, false));
//		this.character.add(new Tile(Suit.Character, 2, false, false));
//		this.character.add(new Tile(Suit.Character, 2, false, false));
//		this.character.add(new Tile(Suit.Character, 3, false, false));
//		this.character.add(new Tile(Suit.Character, 3, false, false));
//		this.character.add(new Tile(Suit.Character, 3, false, false));
//		this.character.add(new Tile(Suit.Character, 3, false, false));
//		this.character.add(new Tile(Suit.Character, 4, false, false));
//		this.character.add(new Tile(Suit.Character, 4, false, false));
//		this.character.add(new Tile(Suit.Character, 4, false, false));
//		this.character.add(new Tile(Suit.Character, 4, false, false));
//		this.character.add(new Tile(Suit.Character, 5, true, false));
//		this.character.add(new Tile(Suit.Character, 5, false, false));
//		this.character.add(new Tile(Suit.Character, 5, false, false));
//		this.character.add(new Tile(Suit.Character, 5, false, false));
//		this.character.add(new Tile(Suit.Character, 6, false, false));
//		this.character.add(new Tile(Suit.Character, 6, false, false));
//		this.character.add(new Tile(Suit.Character, 6, false, false));
//		this.character.add(new Tile(Suit.Character, 6, false, false));
//		this.character.add(new Tile(Suit.Character, 7, false, false));
//		this.character.add(new Tile(Suit.Character, 7, false, false));
//		this.character.add(new Tile(Suit.Character, 7, false, false));
//		this.character.add(new Tile(Suit.Character, 7, false, false));
//		this.character.add(new Tile(Suit.Character, 8, false, false));
//		this.character.add(new Tile(Suit.Character, 8, false, false));
//		this.character.add(new Tile(Suit.Character, 8, false, false));
//		this.character.add(new Tile(Suit.Character, 8, false, false));
//		this.character.add(new Tile(Suit.Character, 9, false, false));
//		this.character.add(new Tile(Suit.Character, 9, false, false));
//		this.character.add(new Tile(Suit.Character, 9, false, false));
//		this.character.add(new Tile(Suit.Character, 9, false, false));
//		
//		this.honorTiles.add(new Tile(Suit.HonorTile, 10, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 10, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 10, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 10, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 11, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 11, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 11, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 11, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 12, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 12, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 12, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 12, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 13, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 13, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 13, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 13, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 14, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 14, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 14, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 14, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 15, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 15, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 15, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 15, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 16, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 16, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 16, false, false));
//		this.honorTiles.add(new Tile(Suit.HonorTile, 16, false, false));
	}
	public Tile getTile(int index) {
		return this.bamboo[index];
	}
//	public ArrayList<Tile> cloneDeck() {
//		ArrayList<Tile> clonedTiles = new ArrayList<Tile>();
//		for(Tile t : this.allTiles) {
//			clonedTiles.add(t);
//		}
//		return clonedTiles;
//	}
//	
//	public Tile remove(int index) {
//		return this.allTiles.remove(index);
//	}
	

}
