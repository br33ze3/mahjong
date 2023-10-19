package Max;
import java.util.ArrayList;
import java.util.Scanner;

public class Mahjong {

	public static void main(String[] args) {
		Player p1 = new Player("");
		p1.currentWind = Wind.East;
		Player p2 = new Player("");
		p2.currentWind = Wind.South;
		Player p3 = new Player("");
		p3.currentWind = Wind.West;
		Player p4 = new Player("");
		p4.currentWind = Wind.North;
		Player[] players = {p1, p2, p3, p4};
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the 4 player game of Mahjong! What will Player 1's name be?: ");
		p1.name = scan.nextLine();	
		System.out.println("What will Player 2's name be?: ");
		p2.name = scan.nextLine();
		System.out.println("What will Player 3's name be?: ");
		p3.name = scan.nextLine();
		System.out.println("What will Player 4's name be?: ");
		p4.name = scan.nextLine();
		System.out.println("East-Only (also known as short games) are only 4 rounds while Two-Wind "
				+ "matches (known as long games) are the length of 2 full east-only games.");
		System.out.println("Would you like to play East only or a Two-Wind game?");
		boolean isEastOnly;
		String response = scan.nextLine().toLowerCase();
		if(response == "east only") {
			isEastOnly = true;
		} else {
			isEastOnly = false;
		}
		Deck deck = new Deck();
		Game gameOfMahjong = new Game(isEastOnly);
		String command;
		int commandInt;
		Player currentPlayer = p1;
		int tilesLeft = 69;
		Tile previouslyDroppedTile = new Tile(Suit.HonorTile, 100, false, false);
		GameLoop: while(!gameOfMahjong.gameConcluded) { // Outermost loop for games
			deck.fillDeck();
			Game.dealTiles(p1, p2, p3, p4, deck);
			System.out.println("Begin " + gameOfMahjong + " Now!\n");
			RoundLoop: while(true) { // Middle Loop for Each Round 
				System.out.println("The current wind is " + gameOfMahjong.currentWind + gameOfMahjong.currentRound + ". It is now " + currentPlayer.name + "'s turn");
				currentPlayer.addTile(deck.allTiles.remove((int)(Math.random()*deck.allTiles.size())));
				tilesLeft--;
				currentPlayer.currentHand.orderTiles(); // Puts tiles in order based on Suit and Number(value)
				int count = 0;
				TurnLoop: while(true) { // Inner loop for each individual turn
					if(count == 0) {
						System.out.println("Your tiles are" + currentPlayer.currentHand);
					}
					System.out.println("\nWhat would you like to do? Type help for more information.");
					command = scan.next();
					if(command.toLowerCase().equals("help")) {
						System.out.println("You may input 'Pon', 'Chii', 'Win?', 'Yaku?', 'Discard', 'Pair?'");
					} else if(command.toLowerCase().equals("pon")) {
						System.out.println("Input the indices of the tiles you would like to Pon");
						int commandOne = scan.nextInt();
						int commandTwo = scan.nextInt();
						if(currentPlayer.currentHand.pon(previouslyDroppedTile, commandOne, commandTwo, tilesLeft)) {
							System.out.println("Input the index of the tile you would like to discard");
							commandInt = scan.nextInt();
							currentPlayer.currentHand.discard(commandInt);
							break TurnLoop;
						} else {
							System.out.println("You aren't able to pon that!");
							count++;
							continue;
						}
					} else if(command.toLowerCase().equals("win?")) { 
						if(currentPlayer.currentHand.checkIfWon()) { //If the player has won, it will return true and then the roundLoop will break
							System.out.println("Congratulations, you have won this round!");
							gameOfMahjong.nextRound(currentPlayer);
							break RoundLoop;
						} else {
							System.out.println("Not yet!");
							count++;
							continue;
						}
					} else if(command.toLowerCase().equals("yaku?")) {//calling this will not end your turn. it is just to check if you have a yaku (for new 
						if(currentPlayer.currentHand.checkForYaku(currentPlayer, gameOfMahjong)) { 
							System.out.println("You currently have a yaku.");
							System.out.println("Input the index of the tile you would like to discard");
							commandInt = scan.nextInt();
							currentPlayer.currentHand.discard(commandInt);
							count++;
							continue;					
						} else {
							System.out.println("You currently do not have a yaku.");
							count++;
							continue;
						}
					} else if(command.toLowerCase().equals("chii")) {
						System.out.println("Input the indices of the tiles you would like to chii");
						int commandOne = scan.nextInt();
						int commandTwo = scan.nextInt();
						if(currentPlayer.currentHand.chii(commandOne, commandTwo, previouslyDroppedTile)) {
							System.out.println("Input the index of the tile you would like to discard");
							commandInt = scan.nextInt();
							currentPlayer.currentHand.discard(commandInt);
							break TurnLoop;
						} else {
							System.out.println("You aren't able to chii yet!");
							count++;
							continue;
						}
					} else if(command.toLowerCase().equals("discard")) {
						System.out.println("Input the index of the tile you would like to discard");
						commandInt = scan.nextInt();
						previouslyDroppedTile = currentPlayer.currentHand.discard(commandInt);
						break TurnLoop;
					} else if(command.toLowerCase().equals("end round")) {
						break RoundLoop;
					} else if(command.toLowerCase().equals("pair?")) {
						System.out.println("Please input the indices for the pair");
						int commandOne = scan.nextInt();
						int commandTwo = scan.nextInt();
						if(currentPlayer.currentHand.checkForPair(commandOne, commandTwo)) {
							System.out.println("You currently have a pair");
							count++;
							continue;
						} else {
							System.out.println("You do not currently have a pair");
							count++;
							continue;
						}
					} else {
						System.out.println("That is not a valid command. Please try again");
						count++;
						
					}
				}
				Player previousPlayer = currentPlayer;
				currentPlayer = Player.nextPlayer(p1, p2, p3, p4, previousPlayer);
				if(tilesLeft == 0) {
					System.out.println();
					System.out.println("Exhaustive Draw! Would you like to continue playing?");
					command = scan.next();
					if(command.equals("no")) {
						break GameLoop;
					} else {
						break RoundLoop;
					}
				}
			}
			for(Player p : players) {
				Hand.wipeTiles(p.currentHand);
			}
			System.out.println();
			currentPlayer = Game.shiftWinds(p1, p2, p3, p4);
		}
	}
}
