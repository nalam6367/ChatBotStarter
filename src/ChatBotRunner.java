import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
			*/
		public class ChatBotRunner
		{

			/**
			 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
			 */
			public static void main(String[] args)
			{
				ChatBot1 chatbot1 = new ChatBot1();
				ChatBot2 chatbot2 = new ChatBot2();
				ChatBot3 chatbot3 = new ChatBot3();
				ChatBot4 chatbot4 = new ChatBot4();


				Scanner in = new Scanner (System.in);
				System.out.println("Good Morning it is 6 o'clock. What would you like to talk about? (1)Weather (2)Music (3)Breakfast (4)Clothing");
				int statement = in.nextInt();
				if (statement == 1)
				{
					chatbot1.chatLoop("1");
				}
				else if(statement == 2)
				{
					chatbot2.chatLoop("1");
				}
				else if(statement == 3)
				{
					chatbot3.chatLoop("1");
				}
				else
				{
					chatbot2.chatLoop("4");
				}






	}

}
