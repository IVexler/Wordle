public class Wordle {
	public static void main(String args[]) {
		Word word = new Word();
		Answer answer = new Answer(word);
		
		answer.askWord();
	}

}
