package acsse.csc2a.model;

/**
* Message Class carried by a ship {@link Ship}
* @author KGOSIEMANG_TA_217011260_CSC02A2_P03
* @version P02
*/

public class Message {
	/**
	 * instance variables
	 */
	private final String ID;
	private       String language;
	private       String Contents;
	private final EPLANET destPlanet;
	private final EPLANET srcPlanet;
	
	
	/**
	 * creates a Message class with the following parameters
	 * @param ID
	 * @param language
	 * @param Contents
	 * @param srcPlanet
	 * @param destPlanet
	 */
	
	public Message(String ID, String language, String Contents,EPLANET srcPlanet , EPLANET destPlanet) {
		this.ID = ID;
		this.language = language;
		this.Contents = Contents;
		this.srcPlanet = srcPlanet;
		this.destPlanet = destPlanet;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language 
	 * the language to change
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return Contents;
	}

	/**
	 * @param contents 
	 * the contents to change
	 */
	public void setContents(String contents) {
		Contents = contents;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		String ret = ID.substring(0, 5);
		return ret;
	}

	/**
	 * @return the sourcePlanet
	 */
	public EPLANET getSrcPlanet() {
		return srcPlanet;
	}

	/**
	 * @return the destinationPlanet
	 */
	public EPLANET getDestPlanet() {
		return destPlanet;
	}

}
