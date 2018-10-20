import java.util.Random;
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
				System.out.println("What is your name?");
				String name = in.nextLine();
				Random r = new Random ();
				int [] time = {5,6,7,8,9,10,11};
				System.out.println("Good Morning " + name+ ", it is "+ time [r.nextInt(time.length)] + " o'clock. What would you like to talk about? (1)Clothing (2)Music (3)Breakfast (4)Weather");
				int statement = in.nextInt();
				if (statement == 1)
				{
					chatbot1.chatLoop(name);
				}
				else if(statement == 2)
				{
					chatbot2.chatLoop(name);
				}
				else if(statement == 3)
				{
					chatbot3.chatLoop(name);
				}
				else if(statement == 4)
				{
					chatbot4.chatLoop(name);
				}
				else
				{
					System.out.println("Please enter a valid number");
				}






	}

}
