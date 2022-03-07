import java.io.*;

public class Exercise17_01{
	
	public static void main(String[] args) throws IOException{
		try (
			RandomAccessFile inout = new RandomAccessFile("Exercise17_01.txt","rw");
		){
			inout.seek(inout.length());
			
			for(int i = 0; i < 100; i++) {
				inout.writeInt((int)(Math.random() * 10) + 48);
				inout.write(32);
			}
			
		}
	}
}