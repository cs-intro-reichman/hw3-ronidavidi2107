
public class Anagram {
	public static void main(String args[]) {
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		
		System.out.println(preProcess("What? No way!!!"));
		

		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		String str = "1234567";
		Boolean pass = true;
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  


	public static boolean isAnagram(String str1, String str2) {
		String newStr1 = preProcess(str1);
		String newSrt2 = preProcess(str2);
		if ( newStr1.length() != newSrt2.length()) {
        return false;
		}
		for ( char c = 'a'; c <= 'z'; c++) {
			int count = 0;
			for ( int i = 0; i < newStr1.length(); i ++) {
				if (newStr1.charAt(i) == c) {
					count++;
				}
			}
			int count2 = 0;
			for ( int i=0 ; i < newSrt2.length(); i ++) {
				if (newSrt2.charAt(i) == c) {
					count2 ++;
				}
			}
			 if ( count != count2) {
				return false;
			 }
		}
		return true;
	
	}
	   
	public static String preProcess(String str) {
		String lowstr = str.toLowerCase();
		String result = " ";
		for ( int i =0; i < lowstr.length(); i ++) {
			char c =lowstr.charAt(i);
			if ( c >= 'a' && c <= 'z') {
				result = result + 'c';

			}
		}
		return result;
	} 
	   
	public static String randomAnagram(String str) {
	String newStr = preProcess(str);
	String result = "";
	while (newStr.length() > 0) {
		int currectLenght = newStr.length ();
		int randomIndex = (int) ( Math.random()*currectLenght);
		char randomC = newStr.charAt(randomIndex);
		result = result + randomC;
		String partBefor = newStr.substring(0, randomIndex);
		String partAfter = newStr.substring( randomIndex +1);
		newStr = partBefor+ partAfter;
	}

		return result;
	}
}
