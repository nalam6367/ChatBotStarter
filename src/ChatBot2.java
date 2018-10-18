import java.util.Random;
import java.util.Scanner;
//Christina Chau
/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot2
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;


	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
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
		return "Let's play some music! What kind of music do you want to listen to?";
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
		String choice = "";
		String song = "";
		//String []playlist= {};
		Random r = new Random ();
		if (statement.length() == 0)
		{
			response =  randomReplyResponse [r.nextInt(randomReplyResponse.length)];
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = randomSadResponse [r.nextInt(randomSadResponse.length)];
			emotion--;
		}
		else if (findKeyword(statement, "Pop") >= 0)
		{
			choice = randomPopResponse [r.nextInt(randomPopResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "Rock") >= 0)
		{
			choice = randomRockResponse [r.nextInt(randomRockResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "EDM") >= 0)
		{
			choice = randomEDMResponse [r.nextInt(randomEDMResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "R&B") >= 0)
		{
			choice = randomRBResponse [r.nextInt(randomRBResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "Tropical") >= 0)
		{
			choice = randomTropicalResponse [r.nextInt(randomTropicalResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "Country") >= 0)
		{
			choice = randomCountryResponse [r.nextInt(randomCountryResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "Progressive House") >= 0)
		{
			choice = randomProgressiveHouseResponse [r.nextInt(randomProgressiveHouseResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "Jazz") >= 0)
		{
			choice = randomJazzResponse [r.nextInt(randomJazzResponse.length)];
			response = "You should listen to " + choice +" . Would you like to add this to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;
			//}
		}
		else if (findKeyword(statement, "Soundtracks") >= 0)
		{
			choice = randomSoundtracksResponse [r.nextInt(randomSoundtracksResponse.length)];
			if (choice == "The Greatest Showman"){
				song = greatestShowman [r.nextInt(greatestShowman.length)];

			}
			else if (choice == "Cinderella"){
				song = cinderella [r.nextInt(cinderella.length)];
			}
			response = "You should listen to " + song + " from " + choice + " . Would you like to add it to your playlist?";
			//addSong(statement, "yes");
			//(statement.toLowerCase() == "yes")
			//{
			// int length = playlist.length;
			//playlist[length+1] = choice;

		}
		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "anything", 0) >= 0)
		{
			response = "How about" + randomGenreResponse [r.nextInt(randomGenreResponse.length)] + "?";
		}
		else if (findKeyword(statement, "choose", 0) >= 0)
		{
			response = "How about" + randomGenreResponse [r.nextInt(randomGenreResponse.length)] + "?";
		}
		else
		{
			response = getRandomResponse();
		}

		return response;
	}
	private String [] randomReplyResponse = {"Say something, please.", "Why aren't you answering?", "Stop ignoring me", "What's wrong?", "Do you want to listen to music?"};
	private String [] randomSadResponse = {"Why so negative?", "You're making me sad", "Whst's wrong?", "What made you this way?"};
	private String [] randomGenreResponse = {"Pop", "Rock", "EDM", "R&B", "Tropical", "Country", "Progressive House","Jazz", "Soundtracks", "KPop", "Classical"};
	private String [] randomPopResponse = {"God is a Woman by Ariana Grande", "This Feeling by The Chainsmokers", "Lost in Japan by Shawn Mendes", "In the Name of Love by Martin Garrix", "Cheap Thrills by Sia", "Young Dumb and Broke by Khalid", "Shape of You by Ed Sheeran", "Attention by Charlie Puth", "Love Yourself by Jusdtin Bieber"};
	private String [] randomRockResponse = {"My Blood by Twenty One Pilots", "Forever and Ever Moe by Nothing But Thieves", "Stronger by The Score", "You'll Be Fine by Palaye Royale", "Halo by Boston Manor", "The Dark by Thrice", "Anarchist by YUNGBLUD"};
	private String [] randomEDMResponse = {"Happier by Marshmello", "Born to Be Yours by Imagine Dragons", "Heroes by Alesso", "Clarity by Zedd", "Satellite by Tritonal", "Surrender by Cash Cash", "Still with Me by Tritonal", "Calling by Sebastian Ingrosso"};
	private String [] randomRBResponse = {"You Decide by Usher", "Feels Like Summer by Childish Gambino", "Wanna Be by The Internet","Call Out My Name by The Weeknd", "Love Lies by Normani","Don't Matter to Me by Drake", "Addicted by VanJess"};
	private String [] randomTropicalResponse = {"Mon Lafarte by El Beso", "La Murga by Hector Lavoe", "De Coloares by Milly Quezada", "El Gil de Tu Ex by Santaferia", "Tiburon by Proyecto Uno", "Adios Amor by Andy Andy"};
	private String [] randomCountryResponse = {"Hangin' On by Chris Young", "I Don't Know About You by Chris Lane", "Here Tonight by Brett Young", "Talk You Out Of It by Florida Georgia Line", "Good Girl by Dustin Lynch", "What Makes You Country by Luke Bryan", "Turnin' Me On by Blake Shelton"};
	private String [] randomProgressiveHouseResponse = {"Hope Endures by Guilty Spark", "In Time by Peace Treaty", "Aurora by Holbrook", "Roof Park by Matt Fax", "Anthem by EDX", "Assioma by Bottai", "Chills by Marco V", "Know My Love by Matt Nash", "Spaceman by Tim Mason"};
	private String [] randomJazzResponse = {"Infant Eyes by Fred Hersch Trio", "Curves by Tord Gustavsen Trio", "Drew Me Nearer by Joey Alexander", "Sad Tune by European Jazz Trio", "Taplow by Eyolf Dale", "I'll Wait and Pray by John Coltrane", "So In Love by Nestor Torres", "So Lovely by Ben Wolfe"}
	private String [] randomSoundtracksResponse = {"The Greatest Showman", "Cinderella", "Beauty and the Beast", "Game of Thrones", "Hamilton", "The Sound of Music"};
	private String [] greatestShowman = {"The Greatest Showman by Cast","A Million Dreams by Hugh Jackman", "Come Alive by Cast", "Never Enough by Loren Allred", "This Is Me by Keala Settle", "Rewrite the Stars by Zac Efron and Zendaya", "From Now On by Keala Settle"};
	private String [] cinderella = {"A Golden Childhood by Patrick Doyle", "The Freat Secret by Patric Doyle", "A New Family by Patrick Doyle", "The Stag by Patrick Doyle","Fairy Godmother by Patrick Doyle", "A Secret Garden by Patrick Doyle","The Slipper by Patrick Doyle","Strong by Sonna Rele", "A Dream Is a Wish Your Heart Makes by Al Hoffman"};

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	//private String addSong(String statement, String goal) //adds song onto playlist
	//{
	//goal = goal.toLowerCase();
	//if (goal == "yes")
	//playlist[]
	//}

	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}


	/**
	 * Take a statement with "I want <something>." and transform it into
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}


	/**
	 * Take a statement with "I <something> you" and transform it into
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}

		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);

		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}




	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
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

	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Oof",
			"Why?",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!", "Don't talk to me", "Shut up", "No", "I'm mad"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes.", "I'm happy today, are you?"};
