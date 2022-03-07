import java.io.*;

public class Exercise17_03{

	public static void main(String[] args) throws IOException{
		RandomAccessFile inout = new RandomAccessFile("inout.dat","rw");
		writeNums(inout);
		System.out.println("The sum of the numbers in the file is: " + sumNums(inout));
	}
	
	public static void writeNums(RandomAccessFile inout) throws IOException{
		inout.seek(inout.length());		
		
		
		for(int i = 0; i < 4; i++) {		
			inout.writeInt((int)(Math.random() * 10));
		}
	}
	
	public static long sumNums(RandomAccessFile inout) throws IOException{
		long num = 0;
		inout.seek(0);
		int value;
		int i = 0;
		while(i < inout.length() ) {
			value = inout.readInt();
			num += value;
			i+=4;
		}
		
		return num;
	}
	
}