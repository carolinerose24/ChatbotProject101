package chat.model;


import chat.controller.ChatController;
import twitter4j.Twitter;

public class ChatTwitter
{
	private ChatController app;
	private Twitter chatTwitter;
	
	public ChatTwitter(ChatController app)
	{
		 this.app = app;
	}
	
}
