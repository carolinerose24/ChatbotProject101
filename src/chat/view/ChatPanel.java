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
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
		setUpScrollPane();
		
	}
	
	private void setUpPanel()
	{
		
	}
	
	private void setUpLayout()
	{
		
	}
	
	private void setUpListeners()
	{
		
	}
	
	private void setUpScrollPane()
	{
		
	}
}
