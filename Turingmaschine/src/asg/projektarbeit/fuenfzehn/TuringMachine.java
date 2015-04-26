package asg.projektarbeit.fuenfzehn;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Color;

/**
 * <b>[The TuringMaschine Class]</b> <br>
 * ------------ to edit -------------
 * @author Vincent, André
 * @version 0.3
 */
public class TuringMachine {
	public static JFrame frame;
	
	public static FileConverter FileConv = new FileConverter();
	public static File file;// =new File("C:/Users/Vincent/Desktop/Schule/#5 Seminarfacharbeit/Test2.tmg");
	public final static int ALPHABETH = 0;
	public final static int INPUT = 1;
	public final static int GRAMMAR = 2;
	public static int state;
	public static String[] chars;
	public static String[] input;
	public static String[][] grammar;
	
	public TuringMachine(){
	}
	
	/** <b>main(args)</b> <br>
	 * ------------ to edit -------------
	 * @param args
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException {
		
		frame = new Frame("Startmenü", 600, 600, Color.MAGENTA);
		
		/*file = FileConv.choose();
		String line = FileConv.getLine(file, "Startzustand=", 0);
		state = FileConv.beginningState(line);
		System.out.println(state);
		line = FileConv.getLine(file, "Sigma=", 0);
		chars = FileConv.addArray(line , ',', ALPHABETH);
		for(int i = 0; i < chars.length; ++i){//falls Eingabe = null
			System.out.print(chars[i]+"," );
			}
		line = FileConv.getLine(file, "Input=", 0);
		input = FileConv.addArray(line , ',', INPUT);
		System.out.println();
		for(int i = 0; i < input.length; ++i){//falls Eingabe = null
			System.out.print(input[i]+"," );
			}
		grammar = FileConv.addArray2d(file , "Grammatik:", ',', 0);
		//String line = FileConv.getLine(file, "Grammatik:"+(char)(13)+(char)(10), 0);
		//System.out.println(grammar[1]);
		for(int i = 0; i < grammar.length; ++i){
			System.out.println();
			for(int j = 0; j < grammar[i].length; ++j){
				System.out.print(grammar[i][j] + ",");
			}
		}*/
	}
}