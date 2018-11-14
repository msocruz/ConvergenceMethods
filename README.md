# ConvergenceMethods
Write programs for all the methods (Bisection, Newton-Raphson, Secant, False-Position and Modified Secant) for locating roots. Make sure that you have clever checks in your program to be warned and stop if you have a divergent solution or stop if the solution is very slowly convergent after a maximum number of iterations.


Use your programs to find the roots of the following functions and plot three graphs for each one of the functions. The first graph should plot the given function. Use any plotting software. This will give you the idea of the root/s of the function. The first graph should show the true percent relative error (y –axis) vs. the number of iterations (x-axis) for all the methods (only if the true root is given to you in the problem) and the second graph should show a similar plot but using the approximate percent error instead of the true percent relative error.

              (a) f(x) = 2x3 – 11.7x2 + 17.7x – 5

This function has 3 +ve roots, all of which lie between 0 and 4.  Find the roots. Implement the methods until ea < 1%. Let the maximum iterations be 100. For the modified secant method, use δ = 0.01. Plot the graphs for the approximate % relative error for different roots. Each graph should have 5 error curves, one for each method.


             (b) f(x) = x + 10 – xcosh(50/x)

For this function, plot the % approximate relative error for each method similar to the part (a). Use δ = 0.01 for modified secant method. Figure out the initial points for the other methods. As a hint, the root lies in the interval [120, 130]
