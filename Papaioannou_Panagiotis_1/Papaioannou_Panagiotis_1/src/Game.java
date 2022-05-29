import java.util.Random;
import java.util.Scanner;

public class Game {
	public void Gameplay(int wins, int losses) {
		int number;
		int guesses = 8;
		int correct_guesses = 0;
		int wrong_guesses = 0;
		
		
		Scanner input = new Scanner(System.in);
		
		Random rand = new Random();
		number = rand.nextInt(50);
	 	Dictionary current = new Dictionary();
	 	
	    char[] convertedArray = current.getWord(number).toCharArray();//ENTOLH POY METATREPEI STRING SE CHAR ARRAY
	    
	    char[] fillingGaps = new char[current.getWord(number).length()];//DHMIOYRGW ENAN PINAKA, O OPOIOS THA "KRYBEI" THN ZHTOYMENH LEKSI
	    
	    int i=0;
	    while(i<current.getWord(number).length()) {
	    	fillingGaps[i] = '-';//GIA KATHE GRAMMA THS LEKSIS ANTISTOIXIZETAI ME MIA PAULA (-)
	    	i++;
	    }
	    System.out.print("The random word is now: ");
	    System.out.println(fillingGaps);	    
	    System.out.println("You have " + guesses + " guesses left");
	    
	    boolean flag1 = false;
	    while(guesses > 0 && flag1 == false) {
		    	
		    	System.out.print("Your guess: ");
		    	char guess = input.next().charAt(0);//DIABAZEI ENAN XARAKTHRA
		    	guess = Character.toUpperCase(guess);//TO KANEI KEFALAIO 
		    	
		    	while(guess>=48 && guess<=57) {// SE PERIPTWSH POU O XRHSTHS EISAGEI ARITHMO ANTI GIA GRAMMA(NA NAI KALA O KWIDKAS ASCII)
		    		System.out.println("Numbers are not valid. Please insert a letter instead. ");
			    	System.out.print("Your guess: ");
			    	guess = input.next().charAt(0);
			    	guess = Character.toUpperCase(guess);
		    	}
		    	
		    	boolean flag = false;
		    	for(i=0; i<convertedArray.length; i++){
		    		if(convertedArray[i] == guess) {  //STHN PERIPTWSH POU YPARXEI TO EPILEGMENO GRAMMA
			    		fillingGaps[i] = guess;  //TO EPILEGMENO GRAMMA ANTIKATHISTATAI ME THN ANTISTOIXH TOY PAULA(KENO)
			    		flag = true;
			    	}
		    	}
		    	if (flag==true){
		    		System.out.println("Your guess is CORRECT!");
		    		System.out.print("The random word is now: ");
		    		System.out.println(fillingGaps);	    
		    		System.out.println("You have " + guesses + " guesses left");
		    		correct_guesses++;
		    	}
		    	else{
		    		System.out.println("There are no " + guess + "'s in the word.");
		    		wrong_guesses++;
		    		guesses--;
		    		System.out.print("The random word is now: ");
		    		System.out.println(fillingGaps);	    
		    		System.out.println("You have " + guesses + " guesses left");
		    	}
		    	
		    	flag1 = true;
	    		for(i=0; i<fillingGaps.length; i++){
	    			if(fillingGaps[i] == '-'){
	    				flag1 = false;
	    			}
	    		}
	    }
	    
	    
	    if(guesses == 0){
	    	System.out.println("You just lost the game :( ");
	    	MainClass.losses++;//METRHTHS TWN HTTWN
	    }
	    else{
	    	System.out.println("Congratulations! You guessed the word: " + current.getWord(number));
	    	MainClass.wins++;//METRHTHS TWN NIKWN
	    }
	    
	    System.out.println("You made " + correct_guesses + " correct guesses and " + wrong_guesses + " wrong guesses");
	}
}
