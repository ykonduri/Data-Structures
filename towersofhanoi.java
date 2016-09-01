import java.util.Scanner;
public class towersofhanoi {
	public static void implement_towers_of_hanoi(int number, char frompeg, char topeg, char auxpeg){
		if(number==1){
			System.out.println("Move first disc from peg "+frompeg+" to peg "+topeg);
			return;
		}
		implement_towers_of_hanoi(number-1,frompeg,auxpeg,topeg);
		System.out.println("Move disc from peg "+frompeg+" to peg "+topeg);
		implement_towers_of_hanoi(number-1,auxpeg,topeg,frompeg);
		//System.out.println("Move disc from peg "+frompeg+" to peg "+topeg);
	}
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		char frompeg = 'A';
		char topeg = 'B';
		char auxpeg = 'C';
		System.out.println("Enter number of pegs in towers of Hanoi");
		int number = reader.nextInt();
		implement_towers_of_hanoi(number,frompeg,topeg,auxpeg);

	}

}
