import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;


import static java.time.temporal.ChronoUnit.SECONDS;

public class Battacker {
	
private static BigInteger get_phi(BigInteger n){
	
	BigInteger one=BigInteger.valueOf(1);
	BigInteger two=BigInteger.valueOf(2);
	BigInteger i,z;
	BigInteger phi=null;

	//search for prime numbers
	for(i=two; i.compareTo(n)==-1; i=i.add(BigInteger.ONE)){
		if(n.mod(i).compareTo(BigInteger.ZERO)!=0) continue;
		if(checkprime(i)){
			z=n.divide(i);
			if(checkprime(z)){
				System.out.println("p: "+i);
				System.out.println("q: "+z);
				phi=(i.subtract(one)).multiply(z.subtract(one));
				break;
			}
		}
		
	}
	
	
	System.out.println("phi: "+phi);
	return phi;
	}

private static  boolean checkprime(BigInteger i){
	
	BigInteger zero=BigInteger.valueOf(0);
	BigInteger one=BigInteger.valueOf(1);
	BigInteger two=BigInteger.valueOf(2);
	boolean flag=true;
	
	if(i.compareTo(two) ==0) return true;
	if(i.mod(two).compareTo(zero)==0)
		return false;
	for(BigInteger j=two;(j.multiply(j)).compareTo(i)==-1;j=j.add(one)){
		
		if(j.mod(i).compareTo(zero)==0) {
			flag=false;
			break;
		}
	}
	return flag;
  }


	
public static void main(String[] args){
	
		BigInteger n=null,d=null;
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

		
		long lStartTime = System.currentTimeMillis();
	  
		BigInteger phi=get_phi(n);
		if (BigInteger.valueOf(e).gcd(phi).equals(BigInteger.ONE)) 
			 d=BigInteger.valueOf(e).modInverse(phi); 
		     else 
		        System.out.println("nop");
		
				long lEndTime = System.currentTimeMillis();
	    
	    System.out.println("d= "+d);
	    long output = lEndTime - lStartTime;

	    System.out.println("time= "+output);
		BigInteger t=BigInteger.valueOf(485409097).multiply(BigInteger.valueOf(2952270311l));
		System.out.println("t= "+t);
					
	    
   }


}
