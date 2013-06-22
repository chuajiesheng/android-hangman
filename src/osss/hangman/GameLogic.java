package osss.hangman;

import java.util.ArrayList;



public class GameLogic {
	
	private String word;
	private String usedLetters;
	
	public GameLogic(String word) {
		usedLetters = new String();
		this.word = word;
	}
	
	public ArrayList<Integer> checkLetter(char letter) {	
		ArrayList<Integer> arrayOfIndexes = new ArrayList<Integer>();
		if(letter == ' ') {
				return arrayOfIndexes;
		}
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) == letter){
					arrayOfIndexes.add(i);
			}
		}
		
		usedLetters += letter + " ";
		return arrayOfIndexes;
	}

	public String getUsedLetters() {
		return usedLetters;
	}
	
}
