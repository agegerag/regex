package acsse.csc2a.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import acsse.csc2a.model.Ship;
import acsse.csc2a.model.EPLANET;
import acsse.csc2a.model.Message;

public class FileHandler {
	/**
	 * Parse a string and get back a ship
	 * @param shipString
	 *    string to parse
	 *    @return The Ship instance created from the parsed instance
	 */
	
	private static Ship parseShip(String shipString )
	{
		StringTokenizer shipTokens=new StringTokenizer(shipString," ");
		String ID= shipTokens.nextToken();
		String Shipname="";
		while(shipTokens.hasMoreTokens())
		{
			Shipname=Shipname+shipTokens.hasMoreTokens()+" ";
		}
		return new Ship(ID,Shipname);
	}
	/**
	 * Parse a string and get back a Message
	 * @param messageString
	 *    The string to parse
	 * @return The Message instance created from the parsed string   
	 */
	private static Message  parseMessage(String messageString) {
		StringTokenizer messageTokens=new StringTokenizer(messageString," ");
		String ID=messageTokens.nextToken();
		String language=messageTokens.nextToken();
		String content=messageTokens.nextToken();
		EPLANET srcPlanet=EPLANET.valueOf(messageTokens.nextToken());
		EPLANET destPlanet=EPLANET.valueOf(messageTokens.nextToken());
		return new Message(ID,language,content,srcPlanet,destPlanet);
	}
	/**
	 * Read Ships and related Messages from a textfile
	 * @param FileHandle the file to read from
	 * @return The array of Ships that existed in the file 
	 */
	public static Ship[] readShips(File FileHandle)
	{
		//create default sized array
		Ship[] ships=new Ship[2];
		int shipIndex=0;
		//open resource with ARM
		try(Scanner shipTxtIn=new Scanner(FileHandle))
		{
			final Pattern shipPattern=Pattern.compile("SH\\d{4}\\s+.+");
			final Pattern messagePattern=Pattern.compile("MSG\\D{6}\\s+[a-zA-Z]+\\s+[a-zA-Z0-9]+\\s+[a-zA-Z]+\\s+[a-zA-Z]+");
			
			//current ship being processed in the file
			Ship currShip=null;
			//read file
			while(shipTxtIn.hasNextLine())
			{
				//get a line from file
				String line=shipTxtIn.nextLine();
				Matcher shipMatcher=shipPattern.matcher(line);
				Matcher messageMatcher=messagePattern.matcher(line);
				//Test patterns using matcher
				if(shipMatcher.matches()) {
					//check if we already have a ship, add to array if we do
					if(currShip!=null)
					{
						ships[shipIndex++]=currShip;
						//Resize as needed
						if(shipIndex>=ships.length) {
							ships=Arrays.copyOf(ships,ships.length*2);
						}
					}//Process new ship
					currShip=parseShip(line);  
				}
				else if(messageMatcher.matches())
				{
					if(currShip!=null)
					{ 
						Message currMessage=parseMessage(line);
						currShip.addMessageToArray(currMessage);
					}
					else {
						//handle a special case where a 1st ship has not been read yet
						System.err.println("No valid Ship read yet. Skipping message");
					}
				}
				else
				{
					//No matching regular expression
					//System.err.format("'%s' does not match any pattern.%n, line);");
				}
			}
			if(currShip!=null)
			{
				ships[shipIndex++]=currShip;
				//resize as needed
				if(shipIndex>=ships.length)
				{
					ships=Arrays.copyOf(ships,ships.length*2);
				}
			}
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
		//resize array to be exact size without without nulls
		ships=Arrays.copyOf(ships,shipIndex);
		return ships;
	}
	

}
