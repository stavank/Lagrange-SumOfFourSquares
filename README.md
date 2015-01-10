# Lagrange-SumOfFourSquares

This is a sequential and parallel code in Parallel Java 2 , for the Lagrange theorem that says,
"Every natural number can be represented as a sum of square of four integers "  - http://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
These programs are written in Parallel Java 2, a library develped by Prof. Alan Kaminsky - http://www.cs.rit.edu/~ark/
(Explanations and download instructions for Parallel Java 2 - http://www.cs.rit.edu/~ark/pj2.shtml )

The sequential version runs on a single processor, whereas, the parallel version can be run on multi-core chip with any number of cores.

This implemenation has the following characteristics : 

// Input is any integer

// Output is the lexicographically highest possible combination of four numbers and the number of combinations possible

// Example :

// input  : 10 

// output : 10 = 1^2 + 1^2 + 2^2 + 2^2 

//   		    2 

// Usage for sequential version : <TT> java jar=FourSquaresSeq.jar FourSquaresSeq <I>number</I> </TT> 

// Usage for parallel vesion : <TT> java pj2 jar=FourSquaresSmp.jar FourSquaresSmp <I>number</I> </TT> 

// Parallel version with 'n' cores <TT> java pj2 cores=n jar=FourSquaresSmp.jar FourSquaresSmp <I>number</I> </TT>
 


