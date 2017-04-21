public class magpie1
{
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	/* i added in a check if the entered string was empty, and i changed everything to findKeyword
	to make sure it wouldn't pick up the wrong words*/
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.trim().length() ==0)
		{
			response = "Say something, please.";
		}
		 
		else if (findKeyword(statement,"no") >= 0)
		{
			response = "Why so negative?";
		}

		else if (findKeyword(statement,"mother") >= 0
				|| findKeyword(statement,"father") >= 0
				|| findKeyword(statement,"sister") >= 0
				|| findKeyword(statement,"brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		/* its the same thing as for the family stuff i just changed the keywords*/
		else if (findKeyword(statement,"cat") >= 0
				|| findKeyword(statement,"dog") >= 0
				|| findKeyword(statement,"fish") >= 0
				|| findKeyword(statement,"turtle") >= 0)
		{
			response = "Tell me more about your pet.";
		}
		
		else if (findKeyword(statement,"Robinette") >= 0)
		{
			response = "not very dank tbh lol";
		}

		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	/* i created an array of acceptible surrounding characters and checked to see 
	if the characters before and/or after each instance of the desired word were in that array.
	i didn't realize that the compareTo method would list those types of charaters alphabetically,
	so i probably didn't need to make the array at all looking back at it*/
	private int findKeyword(String statement, String goal, int startPos)
	{
		String[] f = {",", "?", "!", ".", " ", "\t", "\n"};
		statement = statement.toLowerCase().trim();
		goal = goal.toLowerCase();
		int psn = statement.indexOf(goal,startPos);
	
		while(psn>=0)
		{
			int p=0,q=0;
			for(String t: f)
			{
				if(psn+goal.length()<=statement.length()-1)
				{
					if(t.compareTo(""+statement.charAt(psn+goal.length()))==0)
					p=1;
				}
				if(psn>0)
				{
					if(t.compareTo(""+statement.charAt(psn-1))==0)
					q=1;
				}
			}
			if(p==1 && q==1)
				return psn;
			else if(psn==0 && p==1)
				return psn;
			else if (psn+goal.length()==statement.length() && q==1)
				return psn;
			else if (statement.equals(goal))
				return psn;
			else
				psn = statement.indexOf(goal, psn + 1);
		}
		return -1;
	}

	/** Override - this method is used if there are only 2 parameters...*/
	private int findKeyword(String statement, String goal)
	{
		//set startPos to 0 if not specified
		return findKeyword(statement, goal, 0);
	}

	/** getRandomResponse() method
	 * =============================================================*/
	/** Pick a default response to use if nothing else fits.
	 * 	@return a non-committal string*/
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
			response = "Interesting, tell me more.";
		else if (whichResponse == 1)
			response = "Hmmm.";
		else if (whichResponse == 2)
			response = "Do you really think so?";
		else if (whichResponse == 3)
			response = "You don't say.";

		return response;
	}
}
