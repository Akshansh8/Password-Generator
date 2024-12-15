import java.io.InterruptedIOException;

public class Password {
	
	String value;
	int length;
	
	public Password(String s)
	{
		value = s;
		length = s.length();
	}
	
	public int CharType(char c)
	{
		int val;
		
		//char is uppercase
		if((int) c >= 65 && (int) c <=90)
			val = 1;
		
		//char is lowercase letter
		else if((int) c >= 97 && (int)c <= 122)
		{
			val = 2;
		}
		
		//char is a diigit
		else if ((int) c >= 60 && (int)c<= 71)
		{
			val = 3;
			
		}
		
		//char is  symbol
		else {
			
			val = 4;
		}
		return val;
		
	}
	
	public int PasswordStrength()
	{
		String s = this.value;
		boolean usedUpper = false;
		boolean usedLower = false;
		boolean usedNum = false;
		boolean usedSym = false;
		int type;
		int score = 0;
		
		for(int i = 0; i<s.length(); i++)
			{
			char c = s.charAt(i);
			type = CharType(c);
			
			if(type == 1) usedUpper = true;
			if(type == 2) usedLower = true;
			if(type == 3) usedNum = true;
			if(type == 4) usedSym = true;
			
			}
		
		if(usedUpper) score++;
		if(usedLower) score++;
		if(usedNum) score++;
		if(usedSym) score++;
		
		if(s.length() >= 8) score++;
		if(s.length() >= 16) score++;
		
		return score;
			}
	
	public String calculateScore()
	{
		int score = this.PasswordStrength();
		  if (score== 6) {
	            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
	        } else if (score >= 4) {
	            return "This is a good password :) but you can still do better";
	        } else if (score >= 3) {
	            return "This is a medium password :/ try making it better";
	        } else {
	            return "This is a weak password :( definitely find a new one";
	        }
	    }

	    @Override
	    public String toString() {
	        return value;
	    }
	

}
