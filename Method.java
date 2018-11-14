/* Name: Maria Sabrina Cruz
 * Assignment: Project #2
 * Class: CS 3010
 */

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Method 
{

	public double A;
	public double B;
	
	public Method(double a)
	{
		A = a;
	}
	public Method(double a, double b) 
	{
		A = a;
		B = b;
	}

	public double error(double x, double y)
	{
		return Math.abs((x - y) / x);
	}
	
	public double function(int choice, double x)
	{
		double result = 0;
		if(choice == 1)
			result = (2 * x * x * x) - (11.7 * x * x) + (17.7 * x) - 5;
		
		if(choice == 2)
			{
			double a = Math.exp(50/x);
			double b = Math.exp(-(50/x));
			result = x + 10 - (x * Math.cosh(50/x));
			}
		
		return result;
	}
	
	public double derivative(int choice, double x)
	{
		double result = 0;
		if(choice == 1)
			result = (3 * 2 * x * x) - (2 * 11.7 * x);
		
		if(choice == 2)
		{
			result = ((50 * Math.sinh(50/x)) - (Math.cosh(50/x) - 1) * x) / x;
		}
		
		return result;
	}
	
	
	public void bisection(int choice)
	{
		ArrayList<Double> table = new ArrayList<Double>();
		boolean done = false;
		int n = 0;
		double prevC;
		double error = 1;
		DecimalFormat itr = new DecimalFormat("#");
		DecimalFormat ft = new DecimalFormat("#.###");
		double c = A;
		while(function(choice, c) != 0 && n != 100)
		{
			c = (A + B) / 2;
			
			table.add((double) n);
			table.add(A);
			table.add(B);
			table.add(c);
			table.add(function(choice, A));
			table.add(function(choice, B));
			table.add(function(choice, c));
			
			if(n == 0)
			{
				prevC = 0;
				error = 0;
				System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", "n", "a", "b", "c", "f(a)", "f(b)", "f(c)", "error");
			}
			
			else 
			{
				prevC = table.get((n*8 - 1) - 4);
				error = error(c, prevC);
				if(error < 0.01)
				{
					System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(B), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, B)), ft.format(function(choice, c)), ft.format(error));
					System.out.println("Root is " + c + " with " + error * 100 + "% error");
					break;
				}
			}
			
			table.add(error);
						
			System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(B), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, B)), ft.format(function(choice, c)), ft.format(error));
			
			if(function(choice, c) == 0)
			{
				System.out.println("Root is " + c + " with " + error * 100 + "% error");
				break;
			}
			
			else if(function(choice, A) * function(choice, c) > 0)
			{
				A = c;
			}
			
			else if(function(choice, A) * function(choice, c) < 0)
			{
				B = c;
			}
			
			n++;
		}
		
	}
	
	public void NewtonRaphson(int choice)
	{
		int n = 0;
		double error = 0;
		DecimalFormat itr = new DecimalFormat("#");
		DecimalFormat ft = new DecimalFormat("#.###");
		double x1 = 1;
		
		while(function(choice, A) != 0 && n < 101)
		{
			
			x1 = A - (function(choice, A) / derivative(choice, A));
			error = error(x1, A);
			if(error < 0.01 && n != 0)
			{
				System.out.format("%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(x1), ft.format(function(choice, A)), ft.format(derivative(choice, A)), ft.format(error));
				System.out.println("Root is " + A + " with " + error * 100 + "% error");
				break;
			}
			
			if(n == 0)
			{
				System.out.format("%15s%15s%15s%15s%15s%15s\n", "n", "xn", "xn+1", "f(xn)", "f'(xn)", "error");
			}
			System.out.format("%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(x1), ft.format(function(choice, A)), ft.format(derivative(choice, A)), ft.format(error));
			
			
			A = x1;
			n++;
		}
	}
	
	public void Secant(int choice)
	{
		ArrayList<Double> table = new ArrayList<Double>();
		int n = 0;
		double prevC;
		double error = 1;
		DecimalFormat itr = new DecimalFormat("#");
		DecimalFormat ft = new DecimalFormat("#.###");
		double c = A;
		while(function(choice, c) != 0 && n != 100)
		{
			c = B - (function(choice, B) * ((B - A) / (function(choice, B) - function(choice, A))));
			
			table.add((double) n);
			table.add(A);
			table.add(B);
			table.add(c);
			table.add(function(choice, A));
			table.add(function(choice, B));
			table.add(function(choice, c));
			
			if(n == 0)
			{
				prevC = 0;
				error = 0;
				System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", "n", "xn-1", "xn", "xn+1", "f(xn-1)", "f(xn)", "f(xn+1)", "error");
			}
			
			else 
			{
				prevC = table.get((n*8 - 1) - 4);
				error = error(c, prevC);
				if(error < 0.01)
				{
					System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(B), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, B)), ft.format(function(choice, c)), ft.format(error));
					System.out.println("Root is " + c + " with " + error * 100 + "% error");
					break;
				}
			}
			
			table.add(error);
			
			System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(B), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, B)), ft.format(function(choice, c)), ft.format(error));
			
			if(function(choice, c) == 0)
			{
				System.out.println("Root is " + c + " with " + error * 100 + "% error");
			}
			
			A = B;
			B = c;
			
			n++;
		}
	}
		

	public void FalsePosition(int choice)
	{
		ArrayList<Double> table = new ArrayList<Double>();
		int n = 0;
		double prevC;
		double error = 1;
		DecimalFormat itr = new DecimalFormat("#");
		DecimalFormat ft = new DecimalFormat("#.###");
		double c = A;
		boolean found = false;
		while(function(choice, c) != 0 && n < 101)
		{
			c =  B - ((function(choice, B) * (B - A)) / (function(choice, B) - function(choice, A)));
			
			table.add((double) n);
			table.add(A);
			table.add(B);
			table.add(c);
			table.add(function(choice, A));
			table.add(function(choice, B));
			table.add(function(choice, c));
			
			if(n == 0)
			{
				prevC = 0;
				error = 0;
				System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", "n", "a", "b", "c", "f(a)", "f(b)", "f(c)", "error");
			}
			
			else 
			{
				prevC = table.get((n*8 - 1) - 4);
				error = error(c, prevC);
				if(error < 0.01)
				{
					System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(B), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, B)), ft.format(function(choice, c)), ft.format(error));
					System.out.println("Root is " + c + " with " + error * 100 + "% error");
					break;
				}
			}
			
			table.add(error);
						
			System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(B), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, B)), ft.format(function(choice, c)), ft.format(error));
			
			if(function(choice, c) == 0)
			{
				System.out.println("Root is " + c + " with " + error * 100 + "% error");
				found = true;
			}
			
			else if(function(choice, A) * function(choice, c) > 0)
			{
				A = c;
			}
			
			else if(function(choice, A) * function(choice, c) < 0)
			{
				B = c;
			}
			
			n++;
		}
		
	}
	
	public void ModifiedSecant(int choice)
	{
		int n = 0;
		double DELTA = 0.01;
		double error = 1;
		DecimalFormat itr = new DecimalFormat("#");
		DecimalFormat ft = new DecimalFormat("#.###");
		double c = A;
		while(function(choice, c) != 0 && n != 100)
		{
			c = A - function(choice, A) * ((DELTA*A) / (function(choice, (A + DELTA*A)) - function(choice, A)));

			if(n == 0)
			{
				System.out.format("%15s%15s%15s%15s%15s%15s\n", "n", "xn", "xn+1", "f(xn)", "f(xn + dxn)", "error");
			}
			error = error(c, A);
	
			if(error < 0.01 && n != 0)
			{
				System.out.format("%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, A + (DELTA*A))), ft.format(error));
				System.out.println("Root is " + c + " with " + error * 100 + "% error");
				break;
			}
			System.out.format("%15s%15s%15s%15s%15s%15s\n", itr.format(n), ft.format(A), ft.format(c), ft.format(function(choice, A)), ft.format(function(choice, A + (DELTA*A))), ft.format(error));
			
			if(function(choice, c) == 0)
			{
				System.out.println("Root is " + c + " with " + error * 100 + "% error");
			}
			
			A = c;
			n++;
		}
	}
}

	
