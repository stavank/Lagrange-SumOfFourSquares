// FourSquaresSeq
// Program that finds the number of combinations of four different number squares whose sum is equal to a given number
// Input is an integer
// Output is the lexicographically highest possible combination of four numbers and the number of combinations possible
// @uthor Stavan Karia
// Example :
// input  : 10 
// output : 10 = 1^2 + 1^2 + 2^2 + 2^2 
//   		2 
// Usage : <TT> java jar=FourSquaresSeq.jar FourSquaresSeq <I>number</I> ...</TT> 

import edu.rit.pj2.Task;
import edu.rit.pj2.Vbl;
import java.util.*;
import java.lang.*;
import java.io.*;

// FourSquaresSeq is a program that finds the number of combinations of four different number squares whose sum is equal to a given number
public class FourSquaresSeq extends Task{

	// FinalVaules is the class that contains the lexicographically highest possible pair
	private static class FinalValues implements Vbl{
	
		// @ params aFinal, bFinal, cFinal, dFinal are final lexicographically highest values of the four integers found to satisfy the condition
		int aFinal,bFinal,cFinal,dFinal;
	
		//constructor initializes the set of parameter values with 0
		public FinalValues(){
			this.aFinal=0;
			this.bFinal=0;
			this.cFinal=0;
			this.dFinal=0;
		}
		
		// setVarValues function sets the new set of lexicographically higher values if found
		// This function takes the iterators as parameter which contain 'a','b','c','d' variables that satisfy the condition of input = a^2 + b^2 + c^2 + d^2
		public void setVarValue(int a, int b, int c, int d){
			this.aFinal=a;
			this.bFinal=b;
			this.cFinal=c;
			this.dFinal=d;
		}	
					
		// set function sets the new set of lexicographically higher values if found
		// This function takes the source object of 'Vbl' as parameter which contain 'a','b','c','d' variables that satisfy the condition of input = a^2 + b^2 + c^2 + d^2
		public void set(Vbl source){
			this.aFinal=((FinalValues)source).aFinal;
			this.bFinal=((FinalValues)source).bFinal;
			this.cFinal=((FinalValues)source).cFinal;
			this.dFinal=((FinalValues)source).dFinal;
		}
		
		// Create a clone of this vertex set.
		public Object clone(){
			return new  FinalValues();
         }
		 
		// reduce function checks if the current set of numbers is lexicographically higher than the existing highest set
		// This function takes the iterator values as parameters which satisfy the condition of input = a^2 + b^2 + c^2 + d^2
		public void reduce(Vbl candidate){
			if(((FinalValues)candidate).aFinal > this.aFinal){
				this.set(candidate);
			}
			else if (((FinalValues)candidate).aFinal==this.aFinal){
				if (((FinalValues)candidate).bFinal>this.bFinal){
					this.set(candidate);
				}	
				else if (((FinalValues)candidate).bFinal==this.bFinal){
					if(((FinalValues)candidate).cFinal>this.cFinal){
						this.set(candidate);
					}
				}		
			}	
		}			
	}
		

	// object of FinalValues is created using constructor
	// also in the object creation, the values of the parameters in the class FinalValues are initialized.
	FinalValues finalValues = new FinalValues();
		
	// object of FinalValues is created using constructor
	// also in the object creation, the values of the parameters in the class FinalValues are initialized.
	// candidate to check for lexicographically highest value
	FinalValues candidate = new FinalValues();	
	
	// main function
	public void main (String[] args) throws Exception
	{
		// check if number of arguments are as required by the program
		if(args.length!=1) usage();
	
		final int firstArg;
		// check if the arguments data type is the same as required by the program
		if (args.length > 0) {
		    try {
		        firstArg = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        usage();
		    }
		}

		// number : Variable to take the input
		final int number=Integer.parseInt(args[0]);
		
		//rootOfNumber : Variable to store square root of variable 'number'
		final int rootOfNumber=(int)Math.round(Math.sqrt(number));
			
		// a,b,c,d : Variables that contain the four numbers which square and add up to 'number'
		// countOfWays : Variable that stores number of possible ways of satisfying the condition. 
		int a,b,c,d,countOfWays=0;
	
			// remnantA : Variable to store remnant value after a^2
			int remnantA=0;
				
			// remnantB : Variable to store remnant value after b^2
			int remnantB=0;

			// sum : Local Variable to store remnant sum 
			int sum=0;
				
			// object to store candidate value of 'a', 'b','c','d'
			FinalValues candidate = new FinalValues();	
				
			
			// squareArray : Array to store squares of all possible integers.
			int squareArray[] = new int [rootOfNumber+1];

			for(int i=0;i<=rootOfNumber;i++){
				squareArray[i]=i*i;
			}				
	
			// logic where 'a', 'b', 'c', 'd' are found.
			for(a=rootOfNumber/2;a<=rootOfNumber;a++){
				remnantA = number - squareArray[a];	
				for(b = a; b >= 0; b--)
				{
					remnantB = remnantA - squareArray[b];
					if (remnantB < 0) 
						continue;

					if (remnantB > number/2) // because (a^2 + b^2) >= (c^2 + d^2)
						break;
						
					for (c = 0, d = b; c <= d;)
					{
						sum = squareArray[c] + squareArray[d];
						if (sum == remnantB ) 
						{
							
							// this looping mechanism has mapping of a->c,b->d,c->b,d->a 
							candidate.setVarValue(c,d,b,a);
							finalValues.reduce(candidate);
							countOfWays++;
							c++; d--;
						}
						else if (sum < remnantB)
							c++;
						else
							d--;
					}
				}
			}
			
			
			// Print the output in said format
			System.out.println(number+" = "+finalValues.aFinal+"^2 + "+finalValues.bFinal+"^2 + "+finalValues.cFinal+"^2 + "+finalValues.dFinal+"^2");
			System.out.println(countOfWays);
		}
		
		// Print the error message when the program is not run with proper arguments or incorrect format.
		private static void usage(){
		System.err.println("Please enter correct number of arguments and only integer as an input.");
		System.err.println("Usage : <TT> java pj2 jar=FourSquaresSeq.jar FourSquaresSeq <I>number</I> ...</TT> ");
		throw new IllegalArgumentException();
	}
}
