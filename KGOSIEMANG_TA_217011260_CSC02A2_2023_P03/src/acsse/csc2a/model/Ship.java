package acsse.csc2a.model;

/**
* @author KGOSIEMANG_TA_217011260_CSC02A2_P03
* @version P02
*/

public class Ship {
	
	private final String ID;
	private       String name;
	private       int messageIndex = 0;
	private       Message[] messages = null;
	
	public Ship(String ID, String name) {
		this.ID  = ID;
		this.name = name;
		messages = new Message[12];
	}
	
	/**
	 * method PrintMessages displays the messages transmitted by the Spaceship
	 * @return string representing the format of the message output
	 */
	
	public String PrintMessages()
	{
		String formatToReturn;
	
		StringBuffer sb = new StringBuffer();
		//append Ship ID and name
		sb.append("\s");
		sb.append(ID);
		sb.append(" ");
		sb.append(name);
		sb.append("\r\n");
		sb.append("*****PRINTING MESSAGES*****");
		sb.append("\r\n");
		
		for(Message msg : messages)
		{
			// checking if the message is not null
			if(msg == null)continue;
			{
				String src = msg.getSrcPlanet().toString();
				String dest =  msg.getDestPlanet().toString();
			 String messageFormat = String.format("\tID: MSG%s \tLANG :%s \tCONTENT:%s \n\tSrc: %s >>>>>>>>>>>>>>>>> Dest: %s\n",msg.getID(),
						msg.getLanguage(),msg.getContents(),src,dest);
				sb.append(messageFormat);
				sb.append("\r\n");
			}
		}
		
		formatToReturn = sb.toString();
		
		return formatToReturn;
	}
	
	/**
	 * addMessage method adds each message to the ship to be carried to another planet
	 */
	
	public void addMessageToArray(Message message)
	{
		
		messages[messageIndex++] = message; //add each message 
		
		if(messageIndex >= messages.length) // expand the size if the array gets full
		{
			Message[] newArray = new Message[messages.length *3];
			System.arraycopy(messages, 0, newArray, 0, messages.length);
			messages = newArray;
		}
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *  changes Ship name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		
		return ID;
	}
	

}

