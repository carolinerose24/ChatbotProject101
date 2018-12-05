package chat.view;

import javax.swing.*;

import chat.controller.ChatController;

import java.awt.Color;

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
	
		this.add(chatField);
		this.add(chatArea);
		this.add(chatPane);
		

		this.add(ChatButton);
		this.add(CheckerButton);
		this.add(LoadButton);
		this.add(SaveButton);
		
		this.setLayout(appLayout);
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
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		
	}
	
	
	
	
}
