package chat.view;
import javax.swing.JFrame;

import chat.controller.ChatController;


public class ChatFrame extends JFrame
{
	private ChatController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController appController)
	{
		super();
		
		this.appController = appController;
		this.appPanel = new ChatPanel(appController);
		
		setUpFrame();
	}
	
	private void setUpFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(800, 600);
		this.setTitle("Chatbot 2.0");
		this.setResizable(false);
		this.setVisible(true);
	}
}
