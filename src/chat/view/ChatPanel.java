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
	//refactor rename to change it for all instances of it
	private JButton ChatButton;
	private JButton CheckerButton;
	private JButton LoadButton;
	private JButton SaveButton;
	private JButton ClearButton;
	
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		
		ChatButton = new JButton ("Chat");
		CheckerButton = new JButton ("Check Text");
		
		LoadButton = new JButton ("Load");
		SaveButton = new JButton ("Save");
		ClearButton = new JButton ("Clear");
	
		
		chatField = new JTextField("Talk to the bot here", 50);

		chatArea = new JTextArea("", 20 ,50);
		
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
		this.setBackground(Color.PINK);
		
		this.add(chatField);
		this.add(chatPane);
		//do not add chatArea because it is in the scroll pane

		this.add(ChatButton);
		this.add(CheckerButton);
		this.add(LoadButton);
		this.add(SaveButton);
		this.add(ClearButton);
		

	}
	
	private void setUpLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, CheckerButton, 165, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, ChatButton, 0, SpringLayout.NORTH, CheckerButton);
		appLayout.putConstraint(SpringLayout.EAST, ChatButton, -6, SpringLayout.WEST, CheckerButton);
		appLayout.putConstraint(SpringLayout.WEST, LoadButton, 6, SpringLayout.EAST, CheckerButton);
		appLayout.putConstraint(SpringLayout.WEST, SaveButton, 6, SpringLayout.EAST, LoadButton);
		appLayout.putConstraint(SpringLayout.NORTH, SaveButton, 18, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, LoadButton, 18, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.NORTH, CheckerButton, 18, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatField, -159, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, ClearButton, 0, SpringLayout.NORTH, ChatButton);
		appLayout.putConstraint(SpringLayout.WEST, ClearButton, 6, SpringLayout.EAST, SaveButton);
	
	}
	
	private void setUpListeners()
	{
		ChatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String userText = chatField.getText();
				String response = "";
				response = appController.interactWithChatbot(userText);
				chatArea.append(response); //append puts stuff at the end
				chatArea.setCaretPosition(chatArea.getDocument().getLength());//caret -> cursor to bottom
				chatField.setText("");
			}
		});
		
		CheckerButton.addActionListener(new ActionListener() //check text
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
			//	String text = "";
			//	useChatbotCheckers(text);
			}
		});
		
		LoadButton.addActionListener(new ActionListener() //load button-clear button?
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		SaveButton.addActionListener(new ActionListener() //save button
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		ClearButton.addActionListener(new ActionListener() //clear button/ reset button
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				chatArea.setText("");
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
