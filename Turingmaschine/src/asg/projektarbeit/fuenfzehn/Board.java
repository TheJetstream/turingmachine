package asg.projektarbeit.fuenfzehn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JPanel;

/**
 * <b> [The Board class]</b> <br>
 * ------------ to edit -------------
 * @author Vincent, André, Christian
 * @version 0.1
 */
@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{
	
	@SuppressWarnings("unused")
	private int bw;
	@SuppressWarnings("unused")
	private int bh;
	@SuppressWarnings("unused")
	private Timer timer;
	@SuppressWarnings("unused")
	private Graphics2D g2d;
	
	/** <b>Board(xPos, yPos, boardwidth, boardheight, color)</b> <br>
	 * This method generates a board at the given Position with the given parameters.
	 * @param boardwidth The <b>width</b> that should be used for the board.
	 * @param boardheight The <b>height</b> that should be used for the board.
	 * @param color The <b>color</b> used for the generated board.
	 */
	public Board(int xPos,int yPos , int boardwidth, int boardheight, Color color) {;
	    this.setSize(10,10);
    	//this.bw = boardwidth;
    	//this.bh = boardheight;
    	this.setLocation(xPos, yPos);
		//this.setBounds(100, 300, 200, 40);
    	//addKeyListener(new TAdapter());
    	//addMouseListener(new MAdapter());
    	setFocusable(true);
    	setBackground(color);
    	setDoubleBuffered(true);

    
    
    	timer = new Timer();
	} 
	
	/** <b>paint(g)</b> <br>
	 * ------------ to edit -------------
	 * @param g Creates the graphic module <b>g</b>.
	 */
	public void paint(Graphics g) {
		    super.paint(g);
		    g2d = (Graphics2D) g;
		    
		    
		    Toolkit.getDefaultToolkit().sync();
		    g.dispose();
		  }
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
