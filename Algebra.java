
public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
	int Result = x1;
	int Counter = x2;
	    if (Counter > 0) {
		   while (Counter > 0) {
			Result ++;
			Counter --;
		   }
		} else {
			while (Counter < 0) {
			Result --;
			Counter ++;	
			}
		}
		return Result;
	}

	public static int minus(int x1, int x2) {
		int Result = x1;
	    int Counter = x2;
		if ( Result > 0) {}
	    if (Counter > 0) {
		   while (Counter > 0) {
			Result --;
			Counter --;
		   }
		} else {
			while (Counter < 0) {
			Result --;
			Counter ++;	
			}
		} 
		if ( Result <0) {
		while (Counter > 0) {
			Result ++;
			Counter ++;
		   }
		} else {
			while (Counter < 0) {
			Result --;
			Counter --;	
			}	
		}

		return Result;
	}

	
	public static int times(int x1, int x2) {
		int Result = 0;
		int Time = x2; 
		int Counter = x1;
		if (Time > 0) {
			while (Time >0) {
				Result = plus(Result,Counter);
				Time --;
			} 
		 } else {
			while (Time < 0) {
				Result = minus(Result, Counter);
				Time ++;
				
			}
		 }
		 return Result;
	
	}

	public static int pow(int x, int n) {
		int result = 1;
		int time = x;
		int Counter = n;
			while (Counter>0) {
			result = times(result, time);
			Counter --;	
			}
             return result;
		}
		
	public static int div(int x1, int x2) {
		if (x1 ==x2) {
			return 1;
		}
		if (x1 <x2) {
			return 0;
		}
		int start= 0;
		int nam= x2;
		int finish = x1;
		int result= 0;
		if (x1 > x2) {
		while (result + nam <= finish) {
			start++;
			result= times(nam, start);
			
		} 
	}
	return start;
	 

	}  

	public static int mod(int x1, int x2) {
		if ( x1 ==x2) {
			return 0;
		} 
		if (x2 > x1) {
			return x1;
		} 
		if (x2 < x1) {
			int div = div(x1, x2);
        return x1 - times(x2, div);
		}
	    return 0;
	}	

	public static int sqrt(int x) {
		if (x<= 0) {
			return 0;
		}
		int i = 1;
		int result = 1;
			while (result <= x) {
				if (result == x) {
					return i;
				}
				i++;
				result = times(i, i);

				}

		return i;
	}	  	  
}