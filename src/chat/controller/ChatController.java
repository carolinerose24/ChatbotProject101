package chat.controller;
import java.util.*;
 import javax.swing.JOptionPane;
 import chat.model.Chatbot;
 public class ChatController
{
	private Chatbot simplebot;
	private Chatbot chatbot;
	public ChatController() 
	{
		simplebot = new Chatbot();//default constructor
		chatbot = new Chatbot();
	}
	//refactoring -- rewriting + adding more things -> make it work better
	//umlet -- like an api because it gives headers but not the code inside
	public Chatbot getSimplebot()
	{
		return simplebot;
	}

	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	
	public void setSimplebot(Chatbot simplebot)
	{
		this.simplebot = simplebot;
	}
	
		
	public void start()
	{
		String userInput1 = "banana";
	//	String userInput1 = JOptionPane.showInputDialog(null, "Hi, what do you want to talk about?");

		while (!userInput1.equalsIgnoreCase("quit"))  //user input != to quit
		{
				//userText1 = JOptionPane.showInputDialog(null, "Type 'quit' to exit.");
			userInput1 = interactWithChatbot(userInput1);
		}
	}
	
	public String interactWithChatbot(String text)
	{
		String userInput1 = JOptionPane.showInputDialog(null, "Hi, what do you want to talk about?");

		String chatbotSays = simplebot.processText(userInput1);
		chatbotSays = "You said: " + userInput1 ;
		JOptionPane.showMessageDialog(null, chatbotSays);
	//	return userInput1;
		return  chatbotSays;
		

	}
	
	public String useChatbotCheckers(String text)
	{
		return text;
	}
	

	
}