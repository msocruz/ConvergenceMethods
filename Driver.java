/* Name: Maria Sabrina Cruz
 * Assignment: Project #2
 * Class: CS 3010
 */
import java.util.Scanner;
public class Driver {

	public Driver() 
	{
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc;
		boolean done = false;
		int choice = 0;
		while(!done)
		{
			System.out.println("(1) Bisection" 
							+ "\n(2) Newton_Raphson" 
							+ "\n(3) Secant"
							+ "\n(4) False_Position" 
							+ "\n(5) Modified Secant" 
							+ "\n(6) EXIT");
			System.out.print("Which method would you like to perform? :  ");
			
			sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			int function;
			double a, b;
			Method myMethod;
			switch(choice)
			{
			case 1: //Bisection
				System.out.print("Which function? (1 or 2) : ");
				function = sc.nextInt();
				System.out.print("Enter a: ");
				a = sc.nextDouble();
				System.out.print("Enter b: ");
				b = sc.nextDouble();
				
				myMethod = new Method(a, b);
				
				if(function == 1)
				{
					myMethod.bisection(function);
				}
				
				else if(function == 2)
				{
					myMethod.bisection(function);
				}
				break;
				
			case 2: //Newton-Raphson
				System.out.print("Which function? (1 or 2) : ");
				function = sc.nextInt();
				System.out.print("Enter starting point: ");
				a = sc.nextDouble();
		
				myMethod = new Method(a);
				
				if(function == 1)
				{
					myMethod.NewtonRaphson(function);
				}
				
				else if(function == 2)
				{
					myMethod.NewtonRaphson(function);
				}
				break; 
				
			case 3: //Secant
				System.out.print("Which function? (1 or 2) : ");
				function = sc.nextInt();
				System.out.print("Enter a: ");
				a = sc.nextDouble();
				System.out.print("Enter b: ");
				b = sc.nextDouble();
				
				myMethod = new Method(a, b);
				
				if(function == 1)
				{
					myMethod.Secant(function);
				}
				
				else if(function == 2)
				{
					myMethod.Secant(function);
				}
				break;
			case 4: //False-Position
				System.out.print("Which function? (1 or 2) : ");
				function = sc.nextInt();
				System.out.print("Enter a: ");
				a = sc.nextDouble();
				System.out.print("Enter b: ");
				b = sc.nextDouble();
				
				myMethod = new Method(a, b);
				
				if(function == 1)
				{
					myMethod.FalsePosition(function);
				}
				
				else if(function == 2)
				{
					myMethod.FalsePosition(function);
				}
				break; 
				
			case 5: //Modified Secant
				System.out.print("Which function? (1 or 2) : ");
				function = sc.nextInt();
				System.out.print("Enter starting point: ");
				a = sc.nextDouble();
		
				myMethod = new Method(a);
				
				if(function == 1)
				{
					myMethod.ModifiedSecant(function);
				}
				
				else if(function == 2)
				{
					myMethod.ModifiedSecant(function);
				}
				break; 
			case 6: //Exit
			default:
				System.out.println("Not a vaild choice.");
					
				
			}
		}
	}

}
