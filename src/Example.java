
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPalindrom("asda"));

	}
	
	static public boolean isPalindrom(String s) {
		int sLen = s.length();
		if (sLen < 2) return true;
		else if(s.charAt(0) == s.charAt(sLen-1)) {
			return isPalindrom(s.substring(1,sLen-1));
		} else {
			return false;
		}
	}

}
