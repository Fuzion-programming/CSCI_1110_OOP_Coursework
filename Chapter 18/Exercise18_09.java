import java.util.Scanner;

public class Exercise18_09{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String value = input.nextLine();
		reverseDisplay(value);
	}
	
	public static void reverseDisplay(String value) {
		//System.out.println(value);
		if(value != null && value.length() > 0){
			System.out.print(value.substring(value.length()-1));
			value = value.substring(0,value.length()-1);
			reverseDisplay(value);
		}
	}
}