import java.io.File;
import acsse.csc2a.file.FileHandler;
import acsse.csc2a.model.EPLANET;
import acsse.csc2a.model.Message;
import acsse.csc2a.model.Ship;

/**
 * Class which contains the main method
* @author KGOSIEMANG_TA_217011260_CSC02A2_2023_03
* @version P03
*/
public class Main {

	public static void main(String[] args) {
		
		//files to handle
		String[] filenames={ "normal.txt", "corrupt.txt", "large.txt" };
		for(String filename:filenames)
		{
			File currFile=new File("data", filename);
			//read ships from file
		Ship[] shipsFromFile=FileHandler.readShips(currFile);
		System.out.format("Found %d Ships in %s%n",shipsFromFile.length, filename);
		for(Ship ship:shipsFromFile)
		{
			if(ship!=null)
			{
				//Display ship information
				String shipID=ship.getID();
				String shipName=ship.getName();
				String messages =ship.PrintMessages();
				System.out.format("%s\t%s%n%s%n",shipID,shipName,messages);
			}
			else 
				//null reference in array
				System.err.println("Ship array has null reference");
		}
		}
		

	}

}

