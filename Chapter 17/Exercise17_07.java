import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        
    	Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
        outputData(input);
    }
    
    public static void outputData(ObjectInputStream input) throws ClassNotFoundException, IOException{
    	double loanAmounts = 0.0;
    	while(true)
    	{
    		try
    		{
    			Loan loan = (Loan) input.readObject();
    			loanAmounts += loan.getLoanAmount();
    			
    		}catch(EOFException ex) {
    			break;
    		}
    	}
    
    	System.out.println("Loan Amounts: " + loanAmounts);
    }
}
