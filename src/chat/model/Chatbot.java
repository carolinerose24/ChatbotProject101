package chat.model;
 import java.util.ArrayList;

import javax.swing.JOptionPane;
 public class Chatbot
{
	 //data, constructor, methods
	
	ArrayList <String> responseList = new ArrayList<String>();
	ArrayList <String> spookyList = new ArrayList<String>();
 	private String currentUser;
	private String joke;
	private String content;
	private String name;
	
 	
	public String askName (String name)
	{
		name = JOptionPane.showInputDialog(null, "What is your name?");
		return name;
	}
	
	private void buildTheLists()
	{
		responseList.add("Hello, how are you?");
		responseList.add("Goodbye?");
		responseList.add("Yes, I agree");
		responseList.add("No, I disagree");
		responseList.add("What's your favorite color?");
		responseList.add("I do not understand.");
		responseList.add("Where are you from?");
		responseList.add("What is your favorite movie?");
		responseList.add("What is your name?");
		responseList.add("That is not right");
		responseList.add("What a wonderful world we live in.");
		responseList.add("What type of music do you listen to?");
		responseList.add("Bananas are a good source of Potassium.");
		responseList.add("Do you like mountains or the beach more?");
		responseList.add("What do you want to be when you grow up?");
		responseList.add("What day is it today?");
		
		
		spookyList.add("This is Halloween!");
		spookyList.add("Ghost Shark is coming!");
		spookyList.add("Here's Johnny!!");
		spookyList.add("I see dead people.");
		spookyList.add("He was dead the whole time!");
		spookyList.add("It's alive! It's ALIVE!");
		spookyList.add("Don't blink. Blink and you're dead. They are fast. Faster than you can believe. Don't turn your back. Don't look away. And don't blink. Good Luck.");
		spookyList.add("Hey, who turned out the lights?");
		spookyList.add("Are you going to shoot me like a naughtly little boy, or fight me like a man?");
		spookyList.add("Donald Trump");
		spookyList.add("No more sugar cookies for you Santa, you're gonna eat your words!");
	}
	
	

	
	public Chatbot() //default  constructor to avoid error/crash
	{ //THIS WAY WORKS
//		currentUser = "Bob";
//		joke = "your face";
//		content = "  ";
//		name = "what is this one for? I don't know.";
		

		
		//you could also do it this way
		this.name = "bananaaaa"; //or do it this way
		this.currentUser = new String ("What a turnout!");
		this.content = new String ("sharknado");
		this.name = new String ("not null");
	
		//initialize lists:
		this.responseList = new ArrayList<String>(); //now these are not null-list of nothing
		this.spookyList = new ArrayList<String>();
		
		buildTheLists();
	}
	
	public Chatbot(String content)//, String joke, String currentUser, String name, ArrayList<String> responseList, ArrayList<String> spookyList)
	{
		this.currentUser = currentUser;
		this.joke = joke;
		
		
		this.content = content;
		
		
		this.name = name;
		this.responseList = responseList;
		this.spookyList = spookyList;
	}
	
	public String processText (String userInput1)
	{
		
		//learn about printf!!!! for the tests mta test

		String answer = "";
		int randomIndex = (int)(Math.random() * responseList.size());
	//	String output = "";
	//	output = "You said: \" "  + userInput1 + "\"" + " \nChatbot says: \"" + (responseList.get(randomIndex)) + "\"";
	//	put	chatbotSays1 = (int)(Math.random() * responseList.size());

		if (userInput1 == null)
		{
			userInput1 = " ";
			answer += "You should really not send null.";
		}
		else //if (contentChecker(userInput1)) //not content?
		{
			answer += "You said: " + userInput1 + "\n";
			
			if (contentChecker(userInput1))
			{
				answer += "You said the special words. \n";
			}
			answer += "Chatbot says: " + responseList.get(randomIndex) + "\n";
			
	//		output += " You said the specials words. \n" ; //  \t = tab
		//	output = "You said: \" "  + userInput1 + "\"" + " Chatbot says: \"" + (content) + "\"" + "You said the special words!";
		}
		
		return answer;
	}
	//java -visibility, return type, name, parameters
	//swift- public func legitimacyChecker (input : String) -> Bool
	//swift- visibility func name (parameters) -> return type
	
	public boolean validityChecker(String text)
	{
		boolean isValid = false;
		
		if (text!= null && text.length() > 3)
		{
			isValid = true;
		}
		return isValid;
	}
	
	
	
	
	public boolean legitimacyChecker (String userInput)
	{
		boolean isValid = false;
		if (userInput == null)
		{
			isValid = false;
		}
		else if (userInput.equals(""))
		{
			isValid = false;
		}
		else if (userInput.contains("sdf") || userInput.contains("jkl") )		
		{
			isValid = false;
		}
		else if (userInput.length() < 2)
		{
			isValid = false;
		}
		else
		{
			isValid = true;
		}
		
		return isValid;
	}
	
	public boolean spookyChecker (String userInput)
	{
		boolean isValid = true;
		for (String phrase: spookyList)
		{	
		
		if (userInput.contains("Halloween"))
		{
			isValid = true;
		}
		else if(userInput.contains("Easter"))
		{
			isValid = false;
		}
		}
		return isValid;
		
	}
		
	
	public boolean contentChecker (String userInput) //userinput is just a random variable-doesn't relate to userInput1
	{
		//must use index of (first index is 0) , substring
		boolean isValid = true;
		//String text = "";
		if (userInput.equals(content))
		{
			isValid = true;

		}
		

		else if (userInput.equals(""))
		{
			isValid = false;
		}
		else if(userInput.contains("text" + content + "text" ))
		{
			isValid = false;
		}
		else if (userInput.contains("text" + content)) //&& userInput.indexOf(userInput.length()-1 == content.length()))//&& is the last index?
		{
			isValid = false;
		}
		else if (userInput.contains(content + "text"))//&& is the first index?
		{
			isValid = false;
		}
		
		else if (userInput.contains("You said the special words"))
		{
			isValid = true;
//			String output = "You said: \" "  + userInput + "\"" + " Chatbot says: \"" + (content) + "\"" + "You said the special words!";

		}
		
		return isValid;
	}
	
	
	
	
	
//----------------------------------------------getters------------------------------------	
	public String getCurrentUser()
	{
		return currentUser;
	}
	public String getJoke()
	{
		return joke;
	}
	public String getContent()
	{
		return content;
	}
	public String getName()
	{
		return name;
	}
	public ArrayList<String> getResponseList()
	{
		return responseList;
	}
	public ArrayList<String> getSpookyList()
	{
		return spookyList;
	}
//----------------------------------------------setters-----------------------------------------
	
	public void setCurrentUser(String currentUser)
	{
		this.currentUser = currentUser; 
	}
	public void setJoke(String joke)
	{
		this.joke = joke; 
	}
	public void setContent(String content)
	{
		this.content = content; 
	}
	public void setName(String name)
	{
		this.name = name; 
	}
	public void setResponseList(ArrayList<String> responseList)
	{
		this.responseList = responseList; 
	}
	public void setSpookyList(ArrayList<String> spookyList)
	{
		this.spookyList = spookyList; 
	}
	
	
	
	
	//to make a method
	//Plain sentences
	//Break it down
	//Pseudocode--half sentences/half code
	//Actual code
	
	
 }