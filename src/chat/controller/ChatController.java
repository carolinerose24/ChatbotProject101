package chat.controller;

import javax.swing.JOptionPane;

import chat.model.ChatTwitter;
import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot simplebot; // MUST INITIALIZE MODEL BEFORE THE VIEW -> CHATBOT BEFORE APPFRAME!!!!!! will
								// either crash or be blank
	private ChatTwitter myTwitter;
	private Chatbot chatbot;
	private ChatFrame appFrame;

	public ChatController()
	{
		simplebot = new Chatbot();// default constructor
		myTwitter = new ChatTwitter(this);
		chatbot = new Chatbot();
		this.appFrame = new ChatFrame(this);
	}
	// refactoring -- rewriting + adding more things -> make it work better
	// umlet -- like an api because it gives headers but not the code inside

	// command a, command shift f
	// --------------------------------------getters/setters-------------------------
	public ChatFrame getAppFrame()
	{
		return appFrame;
	}

	public Chatbot getSimplebot()
	{
		return simplebot;
	}

	public Chatbot getChatbot()
	{
		return chatbot;
	}

	public void setAppFrame(ChatFrame appFrame)
	{
		this.appFrame = appFrame;
	}

	public void setSimplebot(Chatbot simplebot)
	{
		this.simplebot = simplebot;
	}

	public void setChatbot(Chatbot chatbot)
	{
		this.chatbot = chatbot;
	}

	// ---------------------------------------------methods----------------------
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}

	private void close()
	{
		System.exit(0);
	}

	public void start()
	{

		this.appFrame = new ChatFrame(this);

		// String userInput1 = "banana";
		// // String userInput1 = JOptionPane.showInputDialog(null, "Hi, what do you
		// want
		// // to talk about?");
		//
		// while (!userInput1.equalsIgnoreCase("quit")) // user input != to quit
		// {
		// // userText1 = JOptionPane.showInputDialog(null, "Type 'quit' to exit.");
		// userInput1 = interactWithChatbot(userInput1);
		// }
	}

	public String interactWithChatbot(String text)
	{
		// String userInput1 = "";
		// JOptionPane.showInputDialog(null, "Hi, what do you want to talk about?");

		// String chatbotSays = simplebot.processText(text);

		// chatbotSays += (int)(Math.random() * responseList.size());

		// if (text == null)
		// {
		// userInput1 = "null";
		// output += "You really should not send null.";
		// }
		String output = "";
		output += simplebot.processText(text);
		return output;

		// constructors initialize data members
		// userInput1 = "You said: " + userInput1;
		// JOptionPane.showMessageDialog(null, userInput1);
		// return userInput1;

	}

	public String useChatbotCheckers(String text)
	{
		String testedValues = "The following checkers passed: ";

		if (simplebot.contentChecker(text))
		{
			testedValues += "\nContent Checker";
		}

		if (simplebot.spookyChecker(text))
		{
			testedValues += "\nSpooky Checker";
		}

		if (simplebot.validityChecker(text))
		{
			testedValues += "\nValidity Checker";
		}

		if (text.equalsIgnoreCase("spooky"))
		{
			text = "Halloween";
		}

		return testedValues;
	}

	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}

	public String findWords(String user)
	{
		String results = myTwitter.getMostCommonWord(user);
		return results;
	}

}