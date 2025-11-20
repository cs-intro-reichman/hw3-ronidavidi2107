
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	

	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {	
		double Multrate = (1+ rate/100.0);
		double left = loan;
        for (int i =0; i <n; i ++) {
			left= left - payment;
			left = left*Multrate;
		}
		
		return left;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter =0;
		double payment = loan/n;
		double left = loan;
		while (left>= 0) {
		left = endBalance(loan, rate, n, payment);
		payment = payment + epsilon;
		iterationCounter ++;	
		}
		return payment;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) { 
	iterationCounter = 0;
    double L = loan/n;
	double H =  loan ;
	double g =  (H+L)/2;
	while ((H - L)> epsilon) {
		if ((endBalance(loan, rate, n, g))* (endBalance(loan, rate, n, L))> 0) {
			L = g;
		} else { H = g;	}
		g = (H+L)/2;
		iterationCounter++;
		
		}
		return g;
    }
}