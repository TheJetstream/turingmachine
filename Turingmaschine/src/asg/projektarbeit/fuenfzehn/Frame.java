package asg.projektarbeit.fuenfzehn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <b>[The Frame Class]</b> <br>
 * ------------ to edit -------------
 * @author Vincent, André, Christian
 * @version 0.1
 */
@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener{
	
	private JFrame frame;
	//The frame, ComboBox and panel for the "Language Chooser"
	private JFrame cl = new JFrame();
	JPanel panel = new JPanel();
	@SuppressWarnings("rawtypes")
	JComboBox chooseLanguageBox = new JComboBox();
	//board
	private Board board;
	//Initializes the Configuration Class (for e.g. language)
	public static Configuration config = new Configuration();
	//Initializes all buttons (without text)
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button0 = new JButton();
	
	/** <b>Frame(title, width, height, color)</b> <br>
	 * This method creates a frame with the given parameters.
	 * @param title The <b>title</b> of the window.
	 * @param width The <b>width</b> of the window.
	 * @param height The <b>height</b> of the window.
	 * @param color The <b>color</b> that should be used in the background.
	 * @author André, Christian
	 */
	public Frame(String title, int width, int height, Color color) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(color);
		frame.setVisible(true);
			
		updateLanguage();
		
		switch(title){
		case "Startmenü":
			JPanel jp = new JPanel();
			frame.add(jp, BorderLayout.NORTH);
			
			button1.setBounds(100, 100, 100, 40);
			button1.addActionListener(this);
			jp.add(button1); 
				
			button2.setBounds(250, 100, 100, 40);
			button2.addActionListener(this);
			jp.add(button2);
				
			button3.setBounds(300, 100, 100, 40);
			button3.addActionListener(this);
			jp.add(button3);

			button4.setBounds(400, 100, 100, 40);
			button4.addActionListener(this);
			jp.add(button4);
			
			
			break;
		case "Turingmaschine":
			board = new Board(100, 40, 100, 100, Color.BLACK);
			frame.setLayout(new BorderLayout());
			frame.getContentPane().add(board, BorderLayout.CENTER);
			frame.setSize(1000, 1000);
			break;
		}
	}
	
	/** <b>chooseLanguage()</b> <br>
	 * This method brings up the <i>Language Choose</i> screen. <br>
	 * @author Vincent
	 */
	@SuppressWarnings("unchecked")
	public void chooseLanguage() {
        //cl.setTitle("Language");
        cl.setSize(250, 100);
        
 
        JLabel question = new JLabel("Choose the language:");
        String comboBoxList[] = {"German (Deutsch)", "English (English)", "More to come"};
 
        for (int i = 0; i < comboBoxList.length; i++) {
        	chooseLanguageBox.addItem(comboBoxList[i]);	
        }
		
        panel.add(question);
        panel.add(chooseLanguageBox);
        panel.add(button0);
        button0.addActionListener(this);
        chooseLanguageBox.addActionListener(this);
           
        cl.add(panel);
        cl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cl.setVisible(true);
	}

	/** <b>actionPerformed(e)</b> <br>
	 * This method checks all Actions performed on: <br>
	 * - <i>Language Chooser</i> <br>
	 * - <i>Main Frame</i>
	 * @author Vincent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			
		}
		else if (e.getSource() == button2) {
			
		}
		else if (e.getSource() == button3){
			System.exit(0);	
		}
		else if (e.getSource() == button4) {
			chooseLanguage();
		}
		else if (e.getSource() == button0) {
			if (chooseLanguageBox.getSelectedIndex() == 0) {
				System.out.println("0");
				cl.dispose();
				chooseLanguageBox.removeAllItems();
				panel.removeAll();
				config.set("language", "g");
				updateLanguage();
			}
			else if (chooseLanguageBox.getSelectedIndex() == 1) {
				System.out.println("1");
				cl.dispose();
				chooseLanguageBox.removeAllItems();
				panel.removeAll();
				config.set("language", "e");
				updateLanguage();
			}
		}
		
	}	
	
	/** <b>updateLanguage()</b> <br>
	 * This method updates the language. <br>
	 * It uses the language given in the <b>Configuration Class</b>. <br>
	 * Default is English text.
	 * @author Vincent
	 */
	public void updateLanguage() {
		if (config.getLanguage().equals("g")) {
			button0.setText("OK");
			
			button1.setText("Datei hinzufügen");
			button2.setText("Übernehmen");
			button3.setText("Schließen");
			button4.setText("test");
		}
		else if (config.getLanguage().equals("e")) {
			button0.setText("OK");
			
			button1.setText("Add File");
			button2.setText("Assume");
			button3.setText("Close");
			button4.setText("test");
		}
		else {
			button0.setText("OK");
			
			button1.setText("Add File");
			button2.setText("Assume");
			button3.setText("Close");
			button4.setText("test");
		}
	}
}
