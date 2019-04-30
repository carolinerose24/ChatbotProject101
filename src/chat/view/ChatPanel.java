package chat.view;

import javax.swing.*;

import chat.controller.ChatController;
import chat.controller.IOController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import chat.model.*;


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
	
	
	
	//imported images
	private ImageIcon chatIcon;
	private ImageIcon checkerIcon;
	private ImageIcon loadIcon;
	private ImageIcon saveIcon;
	private ImageIcon tweetIcon;
	private ImageIcon searchTwitterIcon;
	
	
	private JButton tweetButton;
	private JButton searchTwitterButton;
	
	
	private JPanel buttonPanel;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();

	
		
		chatField = new JTextField("Talk to the bot here", 50);
		
		chatPane = new JScrollPane();

		
		saveIcon = new ImageIcon(getClass().getResource("/chat/images/save.png"));
		chatIcon = new ImageIcon(getClass().getResource("/chat/images/chat.png"));
		loadIcon = new ImageIcon(getClass().getResource("/chat/images/load.png"));
		searchTwitterIcon = new ImageIcon(getClass().getResource("/chat/images/searchTwitter.png"));
		tweetIcon = new ImageIcon(getClass().getResource("/chat/images/tweet.png"));
		checkerIcon = new ImageIcon(getClass().getResource("/chat/images/search.png"));
		
		
		searchTwitterButton = new JButton(searchTwitterIcon);
		tweetButton = new JButton(tweetIcon);
		
		ChatButton = new JButton (chatIcon);
		CheckerButton = new JButton (checkerIcon);
		
		LoadButton = new JButton (loadIcon);
		SaveButton = new JButton (saveIcon);
		
		
		//ClearButton = new JButton ("Clear");


		buttonPanel = new JPanel(new GridLayout(1,0));
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, buttonPanel);
		appLayout.putConstraint(SpringLayout.SOUTH, chatField, -43, SpringLayout.NORTH, buttonPanel);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, buttonPanel);
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 474, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, buttonPanel, 59, SpringLayout.WEST, this);
		
		
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpScrollPane();
		setUpButtons();
		
		//getMostCommonWord();
		//call this here? needs a string input
		
		//set label equal to the string output
		
		
	}
	
	private void setUpPanel()
	{
		
		
		
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024,768));
		this.setBackground(Color.PINK);
		
		buttonPanel.setPreferredSize(new Dimension (900, 150));
		buttonPanel.setBackground(Color.LIGHT_GRAY);

		
		this.add(chatField);
		this.add(chatPane);
		this.add(buttonPanel);
		
				chatArea = new JTextArea("", 20 ,50);
				appLayout.putConstraint(SpringLayout.NORTH, chatField, 42, SpringLayout.SOUTH, chatArea);
				appLayout.putConstraint(SpringLayout.NORTH, chatArea, 43, SpringLayout.NORTH, this);
				appLayout.putConstraint(SpringLayout.WEST, chatArea, 59, SpringLayout.WEST, this);
				appLayout.putConstraint(SpringLayout.EAST, chatArea, -65, SpringLayout.EAST, this);
				
				add(chatArea);
				
					//	tweetButton = new JButton (tweetIcon);
					//	add(tweetButton);
						
						

		
		//do not add chatArea because it is in the scroll pane

//		this.add(ChatButton);
//		this.add(CheckerButton);
//		this.add(LoadButton);
//		this.add(SaveButton);
//		//this.add(ClearButton);
//		
//
//		this.add(searchTwitterButton);
//		this.add(tweetButton);
		
		
	}
	
	private void setUpButtons()
	{
		buttonPanel.add(SaveButton);
		buttonPanel.add(ChatButton);
		buttonPanel.add(CheckerButton);
		buttonPanel.add(LoadButton);
		buttonPanel.add(searchTwitterButton);
		buttonPanel.add(tweetButton);
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if (choice.equals("Save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
				
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		return path;
	}
	
	private void setUpLayout()
	{

		
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, searchTwitterButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -84, SpringLayout.WEST, searchTwitterButton);
		appLayout.putConstraint(SpringLayout.SOUTH, searchTwitterButton, -29, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, searchTwitterButton, 0, SpringLayout.EAST, SaveButton);
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
		
//		ClearButton.addActionListener(new ActionListener() //clear button/ reset button
//		{
//			public void actionPerformed(ActionEvent mouseClick)
//			{
//				chatArea.setText("");
//			}
//		});
//		
		searchTwitterButton.addActionListener(new ActionListener() //save button
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		tweetButton.addActionListener(new ActionListener() //save button
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String textToTweet = chatField.getText().trim();
				appController.tweet(textToTweet);
			}
		});
		
		
		

		
	}
	
	
	
	
	private void setUpScrollPane()
	{
		chatArea.setEditable(false); //only for display, cannot grab stuff from it
		chatArea.setLineWrap(true); //wraps- when hits edge, wraps back around
		chatArea.setWrapStyleWord(true);
	//maybe won't need these next two methods
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//bc of word wrap
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
	}
	
	

	
}
