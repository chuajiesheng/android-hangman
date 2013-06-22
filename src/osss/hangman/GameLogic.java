package osss.hangman;

import java.util.ArrayList;



public class GameLogic {
	
	private String word;
	private String mistakenLetters;
	
	public GameLogic(String word) {
		mistakenLetters = new String();
		this.word = word;
	}
	
	public ArrayList<Integer> checkLetter(char letter) {
		ArrayList<Integer> arrayOfIndexes = new ArrayList<Integer>();
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) == letter){
					arrayOfIndexes.add(i);
			}
		}
		
		if(arrayOfIndexes.isEmpty()){
			mistakenLetters += letter;
		}
		
		return arrayOfIndexes;
	}

	public String getMistakenLetters() {
		return mistakenLetters;
	}
	
	public static void main(String[] argv){
		String str = new String("mama");
		GameLogic game = new GameLogic(str);
		//System.out.println(game.checkLetter('a').size());
		for(int i = 0; i < game.checkLetter('a').size(); i++) {
			System.out.println(game.checkLetter('a').get(i) + " ");
		}
	}
}
