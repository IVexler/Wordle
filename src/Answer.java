import java.util.*;

public class Answer {
	public static String wordList[] = {"about", "above", "abuse", "actor", "acute", "admit", "adopt", "adult", "after", "again", "agent", "agree", "ahead", "alarm", "album", "alert", "alike", "alive", "allow", "alone", "along", "alter", "among", "anger", "Angle", "angry", "apart", "apple", "apply", "arena", "argue", "arise", "array", "aside", "asset", "audio", "audit", "avoid", "award", "aware", "badly", "baker", "bases", "basic", "basis", "beach", "began", "begin", "begun", "being", "below", "bench", "billy", "birth", "black", "blame", "blind", "block", "blood", "board", "boost", "booth", "bound", "brain", "brand", "bread", "break", "breed", "brief", "bring", "broad", "broke", "brown", "build", "built", "buyer", "cable", "calif", "carry", "catch", "cause", "chain", "chair", "chart", "chase", "cheap", "check", "chest", "chief", "child", "china", "chose", "civil", "claim", "class", "clean", "clear", "click", "clock", "close", "coach", "coast", "could", "count", "court", "cover", "craft", "crash", "cream", "crime", "cross", "crowd", "crown", "curve", "cycle", "daily", "dance", "dated", "dealt", "death", "debut", "delay", "depth", "doing", "doubt", "dozen", "draft", "drama", "drawn", "dream", "dress", "drill", "drink", "drive", "drove", "dying", "eager", "early", "earth", "eight", "elite", "empty", "enemy", "enjoy", "enter", "entry", "equal", "error", "event", "every", "exact", "exist", "extra", "faith", "false", "fault", "fiber", "field", "fifth", "fifty", "fight", "final", "first", "fixed", "flash", "fleet", "floor", "fluid", "focus", "force", "forth", "forty", "forum", "found", "frame", "frank", "fraud", "fresh", "front", "fruit", "fully", "funny", "giant", "given", "glass", "globe", "going", "grace", "grade", "grand", "grant", "grass", "great", "green", "gross", "group", "grown", "guard", "guess", "guest", "guide", "happy", "harry", "heart", "heavy", "hence", "henry", "horse", "hotel", "house", "human", "ideal", "image", "index", "inner", "input", "issue", "japan", "jimmy", "joint", "jones", "judge", "known", "label", "large", "laser", "later", "laugh", "layer", "learn", "lease", "least", "leave", "legal", "level", "lewis", "light", "limit", "links", "lives", "local", "logic", "loose", "lower", "lucky", "lunch", "lying", "magic", "major", "maker", "march", "maria", "match", "maybe", "mayor", "meant", "media", "metal", "might", "minor", "minus", "mixed", "model", "money", "month", "moral", "motor", "mount", "mouse", "mouth", "movie", "music", "needs", "never", "newly", "night", "noise", "north", "noted", "novel", "nurse", "occur", "ocean", "offer", "often", "order", "other", "ought", "paint", "panel", "paper", "party", "peace", "peter", "phase", "phone", "photo", "piece", "pilot", "pitch", "place", "plain", "plane", "plant", "plate", "point", "pound", "power", "press", "price", "pride", "prime", "print", "prior", "prize", "proof", "proud", "prove", "queen", "quick", "quiet", "quite", "radio", "raise", "range", "rapid", "ratio", "reach", "ready", "refer", "right", "rival", "river", "robin", "roger", "roman", "rough", "round", "route", "royal", "rural", "scale", "scene", "scope", "score", "sense", "serve", "seven", "shall", "shape", "share", "sharp", "sheet", "shelf", "shell", "shift", "shirt", "shock", "shoot", "short", "shown", "sight", "since", "sixth", "sixty", "sized", "skill", "sleep", "slide", "small", "smart", "smile", "smith", "smoke", "solid", "solve", "sorry", "sound", "south", "space", "spare", "speak", "speed", "spend", "spent", "split", "spoke", "sport", "staff", "stage", "stake", "stand", "start", "state", "steam", "steel", "stick", "still", "stock", "stone", "stood", "store", "storm", "story", "strip", "stuck", "study", "stuff", "style", "sugar", "suite", "super", "sweet", "table", "taken", "taste", "taxes", "teach", "teeth", "terry", "texas", "thank", "theft", "their", "theme", "there", "these", "thick", "thing", "think", "third", "those", "three", "threw", "throw", "tight", "times", "tired", "title", "today", "topic", "total", "touch", "tough", "tower", "track", "trade", "train", "treat", "trend", "trial", "tried", "tries", "truck", "truly", "trust", "truth", "twice", "under", "undue", "union", "unity", "until", "upper", "upset", "urban", "usage", "usual", "valid", "value", "video", "virus", "visit", "vital", "voice", "waste", "watch", "water", "wheel", "where", "which", "while", "white", "whole", "whose", "woman", "women", "world", "worry", "worse", "worst", "worth", "would", "wound", "write", "wrong", "wrote", "yield", "young", "youth"};
	
	public Word word;
	public Boolean correctAnswer = false;
	public int attempts = 0;
	public String ans;
	
	public String[] answersList = new String[5];
	
	public String[] matchWithWord = { "_", "_", "_", "_", "_" };
	
	public char[] lettersInPosition = new char[5];
	public char[] lettersNotInPosition = new char[5];
	
	public int lastLIP = 0;
	public int lastLNIP = 0;
	
	public Answer(Word word) {
		this.word = word;
	}
	
	
	
	public void askWord() {
		System.out.println("Enter a 5 letter word:");
		
		while(!correctAnswer && attempts <= 5) {
			System.out.println();
			
			if(attempts != 0) {
				checkLetters(ans);
				displayAnswers(attempts);
			}
			
			System.out.println(word.getChosenWord());
			Scanner sc = new Scanner(System.in);
			ans = sc.nextLine().toUpperCase();
			
			Boolean isWord = checkIfWord(ans);
			
			if(!isWord) {
				while(!isWord) {
					System.out.println("Not a valid word");
					sc = new Scanner(System.in);
					ans = sc.nextLine().toUpperCase();
					
					isWord = checkIfWord(ans);
				}
			}
			
			answersList[attempts] = ans;
			correctAnswer = checkAnswer(ans);
			attempts++;
		}
		
		if(correctAnswer) {
			System.out.print("Correct! The word was ");
			System.out.println(word.getChosenWord());
		} else {
			System.out.print("The word was: ");
			System.out.println(word.getChosenWord());
		}
		
	}
	
	public Boolean checkAnswer(String ans){
		char[] wordArray = word.toString().toUpperCase().toCharArray();
		char[] answerArray = ans.toCharArray();
		
		for(int i = 0; i < wordArray.length; i++) {
			if(wordArray[i] == answerArray[i]) {
				correctAnswer = true;
			} else {
				return false;
			}
		}
		
		return correctAnswer;
	}
	
	public void displayAnswers(int attempt) {
		for(int i = 0; i < attempt; i++) {
			System.out.println(answersList[i]);
		}
		
		for(String m : matchWithWord) {
			System.out.print(m + " ");
		}
		
		System.out.println();
		
		/**
		System.out.print("Letters in position: ");
		for(int i = 0; i < lastLIP; i++) {
			System.out.println(lettersInPosition);
		}

		System.out.println();
		
		System.out.print("Letters not in position: ");
		for(int i = 0; i < lastLNIP; i++) {
			System.out.println(lettersNotInPosition);
		}
		
		System.out.println();
		*/
	}
	
	public boolean checkIfWord(String ans) {
		for(String w : wordList) {
			if(w.equals(ans.toLowerCase())) {
				return true;
			}
		}
		
		return false;
	}
	
	public void checkLetters(String ans) {
		char[] wordArray = word.toString().toUpperCase().toCharArray();
		char[] answerArray = ans.toCharArray();
		
		for(int i = 0; i < (answerArray.length); i++) {
			for(char c : wordArray) {
				if(c == answerArray[i]) {
					if(wordArray[i] == answerArray[i]) {
						
					} else {
						
					}
				}
			}
		}
		
	}
}
