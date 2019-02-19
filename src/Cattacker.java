import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Cattacker {
	
private static BigInteger CCA(BigInteger C,int e,BigInteger n){
		
		BigInteger M,Cdash,rpowe,Cdashd;
		M=null;
		
		rpowe=(BigInteger.valueOf(2)).pow(e);
		Cdash=(C.multiply(rpowe)).mod(n);
		
		//decipher 
		Cdashd=(Cdash.modPow(BigInteger.valueOf(1019),n));
		
		M=Cdashd.divide(BigInteger.valueOf(2));
		
		return M;
	}
	
public static void main(String[] args){
	      BigInteger C=null,n=null;
	      int e=1;
	      Scanner scanner;
			File file = new File("Public.txt");
			try {
				scanner = new Scanner(file);

				  n=scanner.nextBigInteger();
				  e=scanner.nextInt();

					
				  scanner.close();
			} 
			catch (FileNotFoundException er) {
				er.printStackTrace();
			}
			Attack attack = new Attack();
			//C = attack.attack(msg);
	      BigInteger M=CCA(C,e,n);
	      System.out.println("The msg is: "+M);
		}

}
