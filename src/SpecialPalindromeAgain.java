
public class SpecialPalindromeAgain {

	
	//O(N^3)
	static long substrCount(int n, String s) {

		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				boolean flag = isSpecialPalindrome(s.substring(i, j+1));
				
				if (flag){
					counter++;
					System.out.println(s.substring(i, j+1));
				}
					
			}
		}
		return counter;
	}

	static boolean isSpecialPalindrome(String s) {
		if(s.length()==0)
			return false;
		
		int i = 0;
		int j = s.length() - 1;
		char ch=s.charAt(i);
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)|| s.charAt(i)!=ch)
				return false;
			i++;
			j--;
		}
		return true;

	}

	// 7
	// abcbaba
	public static void main(String[] args) {
		String str = "oo";
		//str="mnonopoo";
		//str="aaaa";
		//str="abcbaba";
		str="asasd";
		System.out.println(new SpecialPalindromeAgain().substrCount(str.length(), str));
	}
}
