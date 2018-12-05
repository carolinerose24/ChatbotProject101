package chat.view;

import javax.swing.*;

import chat.controller.ChatController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ChatPanel extends JPanel
{
	private SpringLayout appLayout;
	private ChatController appController;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	private JButton ChatButton;
	private JButton CheckerButton;
	private JButton LoadButton;
	private JButton SaveButton;
	
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		
		ChatButton = new JButton ("Chat");
		CheckerButton = new JButton ("Check Text");
		LoadButton = new JButton ("Load");
		SaveButton = new JButton ("Save");
		
		chatField = new JTextField("Talk to the bot here", 50);
		chatArea = new JTextArea("Chat Area", 20 ,50);
		
		chatPane = new JScrollPane();
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpScrollPane();
		
	}
	
	private void setUpPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(Color.lightGray);
		
		this.add(chatField);
		this.add(chatPane);
		//do not add chatArea because it is in the scroll pane

		this.add(ChatButton);
		this.add(CheckerButton);
		this.add(LoadButton);
		this.add(SaveButton);
		

	}
	
	private void setUpLayout()
	{
		
	}
	
	private void setUpListeners()
	{
		ChatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		CheckerButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		LoadButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		SaveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
	}
	
	private void setUpScrollPane()
	{
		chatArea.setEditable(false); //only for display, cannot grab stuff from it
		chatArea.setLineWrap(true); //wraps- when hits edge, wraps back around
		chatArea.setWrapStyleWord(true); //wraps as words not just random letters
		
		chatPane.setViewportView(chatArea); //put text in the chat area 
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//bc of word wrap
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		
	}
	
	
	
	
}
