import java.io.*;
import java.util.Scanner;

public class Exercise17_15{
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter encrypted file name: ");
		String inputString = "src/" + input.next();
		System.out.println();
		System.out.print("Enter output file name: ");
		String outputString = "src/" + input.next();
		
		
		try (
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputString));
        ) 
		{ 
			System.out.println("Successfuly made input stream");
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputString));
			
			outputStream.write(inputStream.read()-5);
			outputStream.close();
        } 
        catch (IOException ex) {
            System.out.println("Input file could not be opened");
        }
	}	
}