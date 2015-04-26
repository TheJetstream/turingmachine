  package asg.projektarbeit.fuenfzehn;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * <b>[The FileConverter Class]</b> <br>
 * ------------ to edit -------------
 * @author Vincent, André
 * @version 0.1
 */
public class FileConverter {
	
	/* [Work in Progress (documentation)
	 * - File choose()
	 * - addArray2d(...)
	 * - 
	 */
	
	public File file;
	public JFileChooser fc = new JFileChooser();
	public FileNameExtensionFilter txt = new FileNameExtensionFilter(
	        "Turing-Maschinen-Grammatik (*.TMG; *.tmg)", "TMG", "tmg");
	public BufferedReader br;
	
	public FileConverter(){
	}
	
	/**
	 * 
	 * @return
	 */
	public File choose()
	/*
	 * Opens a Data-Browser and returns the chosen File 
	 */
	{
		fc.setFileFilter(txt);
		if(fc.showOpenDialog(null) == 0){
			return fc.getSelectedFile();
			}
		else {
			return null;
		}
	}
	
	/** <b>getLine(file, signal, shift)</b> <br>
	 * This method searches a line that is <b>shift</b> lines away from the line which starts with <b>signal</b>. Searches in file <b>file</b>.
	 * @param file The file that the line should be searched in.
	 * @param signal The start of the searched line-<b>shift</b>.
	 * @param shift How many lines from the line that starts with <b>shift</b> the searched line has to be.
	 * @return Returns the <b>line</b> as a String that is moved <b>shift</b> lines from the line that starts with <b>signal</b>.
	 * @throws IOException
	 */
	public String getLine(File file,String signal, int shift) throws IOException{
		br = new BufferedReader(new FileReader(file.getAbsolutePath().toString()));
		String line = "";
		int length = signal.length();
		
		while((line = br.readLine())!=null && line.length()!=0){
			if(line.length() >= length){
				if(line.substring(0, length).equals(signal)){
					if(shift == 0){
						line = line.substring(length, line.length());
					}
					else{
						for(int i = 1; i <= shift; ++i){
							line = br.readLine();
						}
					}
					return line;
				}
			}
		}
		return null;
	}
	
	/** <b>addArray2d(file, signal0, separator, type</b> <br>
	 * ------------ to edit -------------
	 * @param file
	 * @param signal0
	 * @param separator
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public String[][] addArray2d(File file , String signal0,char separator,final int type) throws IOException{
		String[][] array2d = null;
		String line = "";
		int i = 0;
		while(line != null){
			++i;
			line = getLine(file, signal0, i);
			if (line == null){break;}
			array2d = setLengthY(array2d, i);//array2d.length + 1);
			array2d[i-1] = addArray(line, separator, type);
		}
		if(array2d != null){
			return array2d;
		}
		else{
			JOptionPane.showMessageDialog(null, "Die Eingabe ist ungültig.");
			return null;
		}
	}
	
	/** <b>addArray(line, separator, type)</b> <br>
	 * ------------ to edit -------------
	 * @param line
	 * @param separator
	 * @param type
	 * @return
	 */
	public String[] addArray(String line,char separator,final int type){
	/*
	 * Writes the Chars and Strings given in the specified line into an String-Array
	 */
		String[] array = null;
		
		array = convertToArray(line, separator, type);
		
		if(array != null){
			return array;
		}
		else{
			JOptionPane.showMessageDialog(null, "Die Eingabe ist ungültig.");
			return null;
		}
	}
	
	/** <b>convertToArray(sequence, separator, type)</b> <br>
	 * ------------ to edit ------------- WTH is dat für englisch? u wot m8?
	 * @param sequence
	 * @param separator
	 * @param type
	 * @return
	 */
	public String[] convertToArray(String sequence, char separator, final int type){
	/*
	 * Changes the a Chars sequence into a String-Array during leaves out the separator
	 * (invalid separators or chars in the sequence: {, }, #)
	 */
		boolean invalids = false;
		boolean nextField = true;
		String[] array = new String[0];
		char symbol;
		int clips = 0;
		
		for(int i = 0; i < sequence.length(); ++i){
			symbol = sequence.charAt(i);
			if(symbol == '~'){
				break;
			}
			switch(symbol){
			case '{':
				++clips; break;
			case '}':
				--clips; break;
			case ' ': 
			case (char)(9):break;
			case ',': 
				nextField = true; break;
			case '#':
				if(type == 1){}
				else{
					invalids = true; break;
				}
			
			default:
				if(type == 3 & ((int)(symbol) < 48 | (int)(symbol) > 57) & symbol != 'z'){
					JOptionPane.showMessageDialog(null, "INPUT FAILURE");
				}
				else if(type == 3 & symbol == 'z'){}
				else{
					if(nextField){
						array = setLengthX(array, array.length + 1); nextField = false;
						}
					if(array[array.length - 1] == null){
						array[array.length - 1] = Character.toString(symbol);
						}
					else{
						array[array.length - 1] = array[array.length - 1] + Character.toString(symbol);
					}
				}
			}
		}
		if(clips < 0){
			JOptionPane.showMessageDialog(null, "Es fehlet eine"+(char)34+(char)123+(char)34+".");
			return null;
		}
		else if(clips > 0){
			JOptionPane.showMessageDialog(null, "Es fehlet eine"+(char)34+(char)125+(char)34+"." );
			return null;
		}
		if(invalids){
			JOptionPane.showMessageDialog(null, "In der Eingabe gibt es ein ungültige Zeichen.");
			return null;
		}
		return array;
	} 
	
	/** <b>setLengthX(array, length)</b> <br>
	 * Sets the length of the given array to the given integer.
	 * @param array The <b>array</b> that should be changed.
	 * @param length The <b>length</b> the <b>array</b> should have.
	 * @return
	 */
	public String[] setLengthX(String[] array, int length){
		String[] newArray = new String[length];
		for(int i = 0; i < array.length; ++i){
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/** <b>setLengthY(array, lengthY)</b> <br>
	 * Sets the length of the given array to the given integer.
	 * @param array The <b>array</b> that should be changed.
	 * @param lengthY The <b>length</b> the <b>array</b> should have.
	 * @return
	 */
	public String[][] setLengthY(String[][] array, int lengthY){
		System.out.println("Wird aufgerufen.");
		String[][] newArray = new String[lengthY][];
		System.out.println(newArray.length);
		if(array == null){
			array = new String[0][0];
		}
		for(int i = 0; i < array.length; ++i){
			newArray[i] = array[i];
			System.out.println(i);
		}
		return newArray;
	}
	
	/** <b>beginingState(line)</b> <br>
	 * ------------ to edit -------------
	 * @param line 
	 * @return
	 */
	public int beginningState(String line){
		/*
		 * Determines the beginning state of the TM
		 * if line == null ==> beginning state == 0;
		 */
		int state = 0;
		String strState = "";
		
		if(line == null){}
		else{
				strState = convertToArray(line, ',', 3)[0];
			if(strState != ""){
				state = Integer.parseInt(strState);
			}
		}
		return state;
	}
}

