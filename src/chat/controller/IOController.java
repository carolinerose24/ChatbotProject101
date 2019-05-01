package chat.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;


public class IOController
{
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try
		{
			String filename = path;
			Calendar date = Calendar.getInstance();
			filename += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH);
			filename += " at " + date.get(Calendar.HOUR) + "-" + date.get(Calendar.MINUTE);
			filename += " chatbot save.txt";
			
			File saveFile = new File(filename);
			Scanner textScanner = new Scanner(textToSave);//gets input
			PrintWriter saveText = new PrintWriter(saveFile);//writes output
			
			while(textScanner.hasNext())
			{
				String currentLine = textScanner.nextLine();
				saveText .println(currentLine);
			}
			
			textScanner.close();
			saveText.close(); //classes
		}
		
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}

	}

	public static String loadFile(ChatController app, String path)
	{
		
		String contents = "";
		
		try
		{
			File saveFile = new File(path);
			Scanner fileScanner;
			if (saveFile.exists())
			{
				fileScanner = new Scanner(saveFile);
				while(fileScanner.hasNext())
				{
					contents += fileScanner.nextLine() + "\n";
				}
				fileScanner.close();
				
			}
			
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
		
		return contents;
	}
	

}
