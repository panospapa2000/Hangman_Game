import java.util.Scanner;

public class MainClass {

	public static int wins;
	public static int losses;
	
	public static void main(String[] args) {
		int games = 0;
		
		Scanner input = new Scanner(System.in);
		
		MainMenu();
		
		char answer = input.next().charAt(0);
		answer = Character.toUpperCase(answer);
		
			
		while(answer != 'E'){
			if(answer == 'N') {
				Game startgame = new Game();
				startgame.Gameplay(wins, losses);
				games++;
		    }
			if(answer == 'S') {
				System.out.println("You have played so far " + games + " games. You won " + wins + " times and lost " + losses + " times");
			}
			
			MainMenu();
			
			answer = input.next().charAt(0);
			answer = Character.toUpperCase(answer);
		}
		
		System.out.println("THANKS FOR PLAYING!!!");
	}

	public static void MainMenu() {
		System.out.println("");
		System.out.println("MAIN MENU");
		System.out.println("- Start a new Game (N)");
		System.out.println("- Statistics (S)");
		System.out.println("- Exit (E)");
		System.out.print("Please enter your choice: ");
	}
}