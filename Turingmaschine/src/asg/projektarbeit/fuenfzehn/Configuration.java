package asg.projektarbeit.fuenfzehn;

/**
 * <b>[The Configuration Class]</b> <br>
 * In this class the values that should be used for the <i>complete</i> program are set.
 * @author Vincent
 * @version 0.2
 */
public class Configuration {

	/*
	 * Language String:
	 * g - german (Deutsch)
	 * e - english
	 * f - french [not implemented]
	 */
	public String language = "g";
	
	/** <b>set(type, value)</b> <br>
	 * This method sets the options for the program. 
	 * @param type The <b>type</b> of the Option that should be set to <b>value</b>
	 * @param value The <b>value</b> the Option <b>type</b> should be set to.
	 * @author Vincent
	 */
	public void set(String type, String value) {
		if (type.equalsIgnoreCase("language")) {
			if (value.equalsIgnoreCase("g") || value.equalsIgnoreCase("e") || value.equalsIgnoreCase("f")) {
				language = value.toLowerCase();
			}
		}
	}
	
	/** <b>getLanguage()</b> <br>
	 * To get the selected language.
	 * @return Returns <b>language</b>.
	 * @author Vincent
	 */
	public String getLanguage() {
		return language;
	}	
}
