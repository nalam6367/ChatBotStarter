import java.util.Random;
import java.util.Scanner;

/**Jackie Wu*/

public class ChatBot3
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;



	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());


		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));


		}

	}
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Welcome to Bot's Kitchen. Dam son you must be hungry, ask me a question on what you want to do about breakfast.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";

		if (statement.length() == 0)
		{
			response = "Did you fall back asleep?";
		}

		else if (findKeyword(statement, "Help") >= 0)
		{
			response = "I am doing my best!";
			emotion--;
		}

		else if (findKeyword(statement, "Thanks") >= 0)
		{
			response = "Glad I can help you!";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "Do I have",0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "Can I make",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "How do I make",0) >=0)
		{
			response = directions(statement);
		}
		else
		{
			response = getRandomResponse();
		}

		return response;
	}

	/**
	 * Take a statement with "Do I have <something>." and transform it into
	 * "I don't think you have <something>?"
	 * @param statement the user statement, assumed to contain "Do I have"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("?"))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "Do I have", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "I don't think you have " + restOfStatement + ".";
	}


	/**
	 * Take a statement with "Can I make <something>." and transform it into
	 * "You don't seem to have the right ingredients unfortunately to <something>?"
	 * @param statement the user statement, assumed to contain "Can I make"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("?"))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "Can I make", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "You don't seem to have the right ingredients unfortunately to " + restOfStatement + ".";
	}


	/**
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
							int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
					// letter
					&& ((after.compareTo("a") < 0) || (after
					.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	/**
	 * Take a statement with "How do I make  <something>." and transform it into a clickable link for the user
	 * @param statement the user statement, assumed to contain "How do I make"
	 * @return a link
	 */
	private String directions(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("?"))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "How do I make", 0);
		String restOfStatement = statement.substring(psn + 13).trim();
		String clean = restOfStatement.replaceAll("\\s+","");
		return "https://www.mycookbook-online.net/search_result/?q=" + clean + "&lang=en";
	}



	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}

	private String [] randomNeutralResponses = {"Do you need any help?",
			"What do you want to eat?",
			"Sounds interesting.",
			"Sounds delicious!",
			"Breakfast is the most important meal of the day!.",
			"I can hear your tummy growling!",
			"Are you ready to cook?"
	};
	private String [] randomAngryResponses = {"You're annoying me.", "Can you listen for once.", "Follow my directions."};
	private String [] randomHappyResponses = {"How does it taste?", "Today is gonna be a good day!", "Eat up and get ready!"};


}
