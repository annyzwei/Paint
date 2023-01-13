/*
	ICS207 - Ms. Strelkovska
	Dec. 31. 2019
	Final Project V4: Painting Software - West
	Creater of Awesomeness: Anny W.
*/

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//colours part
public class WestPanel extends JPanel implements ActionListener{
	
	static private Palette p;

	static private JButton colourChooser;
	
	//jcombo box
	static JComboBox picker;
	private JLabel l;
	String[] p_names;
	Color[][] p_cols;
	
	
	private Color col;
	private static int curr_p = 0;

	
	//colour combos
	static private final Color[] DEFAULT = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK};
	static private final Color[] PASTELS = {new Color(253,255,205), new Color(255,202,176), new Color(222,236,255), new Color(255,224,224), new Color(198,207,255),
											new Color(255,192,208), new Color(225,204,236), new Color(214,253,184), new Color(190,159,225), new Color(172,222,170)};
	static private final Color[] NEON = {new Color(178,252,255), new Color(243,142,255), new Color(94,223,255), new Color(237,12,239), new Color(62,100,255),
											new Color(129,5,216), new Color(244,255,97), new Color(50,255,106), new Color(168,255,62), new Color(39,170,128)};
	static private final Color[] SPRING = {new Color(241,248,100), new Color(188,235,60), new Color(124,189,30), new Color(161,234,251), new Color(253,253,253),
											new Color(255,206,243), new Color(202,187,233), new Color(249,152,159), new Color(252,203,143), new Color(250,240,150)};
	static private final Color[] SUMMER = {new Color(255,139,167), new Color(107,118,255), new Color(255,198,199), new Color(165,174,255), new Color(250,238,231),
											new Color(200,228,254), new Color(195,240,202), new Color(255,254,154), new Color(82,222,151), new Color(243,163,51)};
	static private final Color[] AUTUMN = {new Color(255,244,227), new Color(248,177,149), new Color(255,205,171), new Color(246,114,128), new Color(255,164,92),
											new Color(192,108,132), new Color(93,93,90), new Color(53,92,125), new Color(143,29,20), new Color(27,18,15)};
	static private final Color[] WINTER = {new Color(44,40,40), new Color(59,44,133), new Color(33,152,151), new Color(133,207,203), new Color(15,48,87),
											new Color(0,88,122), new Color(133,148,228), new Color(102,67,181), new Color(67,15,88), new Color(0,187,240)};
											
	//custom+variables
	static private Color[] custom = {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE};
	private static boolean customize = false;
	
	//constructer
	public WestPanel(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		p = new Palette(DEFAULT);
		p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//theme names
		p_names = new String[]{"Default", "Pastels", "Neon", "Spring", "Summer", "Autumn", "Winter", "Custom"};
		p_cols = new Color[][]{DEFAULT, PASTELS, NEON, SPRING, SUMMER, AUTUMN, WINTER, custom};

		
		l = new JLabel("PALETTE");
		l.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		l.setForeground(Color.WHITE);
		l.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(l);
		
		
		picker = new JComboBox(p_names);
		picker.setSelectedIndex(0);
		picker.addActionListener(this);
		picker.setMaximumSize(picker.getPreferredSize() );
		picker.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		add(picker);
		
		
		add(p);
		
		colourChooser = new JButton("CUSTOMIZE");
		colourChooser.setAlignmentX(Component.CENTER_ALIGNMENT);	
		colourChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(colourChooser);
		colourChooser.addActionListener(this);
		
		this.setBackground(new Color(67, 70, 75));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == picker){		
			curr_p = picker.getSelectedIndex(); // index of selected item
			p.switchPalette(p_cols[curr_p]);
			col = p.getColour();
			MyGUI_Painting.cvs.setBrushCol(col); 

		}
		
		//colour chooser
		if(e.getSource()==colourChooser){
			col = JColorChooser.showDialog(null, "Choose a color", col);
			if (col==null){        // if cancel is pressed the color will be null
				col = p_cols[curr_p][9];
			}
			
			if (p_cols[curr_p] == custom){ //custom palette
				custom[p.index] = col;
				p.changeColour(col);
			}
			MyGUI_Painting.cvs.setBrushCol(col); 
		}

	}
}



//palette buttons
class Palette extends JPanel implements ActionListener{
	
	static protected final int PALETTESIZE = 10;
	
	JButton[] col_buttons = new JButton[PALETTESIZE];
	Color[] colours = new Color[PALETTESIZE];
	Color col;
	public static int index;


	public Palette(Color[] a){
		this.setLayout(new GridLayout(5, 2, 5, 5));
		
		for (int i = 0; i < PALETTESIZE; i ++){
			colours[i] = a[i];
		}

		for (int i = 0; i < PALETTESIZE; i++){
			col_buttons[i] = new JButton();
			col_buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			col_buttons[i].setFocusPainted(false);
			
			if (colours[i] != Color.WHITE){
				col_buttons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			}
			else{
				col_buttons[i].setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
			}
			
			col_buttons[i].setBackground(colours[i]);
			
			this.add(col_buttons[i]); 
			
			col_buttons[i].addActionListener(this);
		}
		
		this.setPreferredSize(new Dimension(60, 130));
		this.setBackground(new Color(67, 70, 75));
		col = colours[9];
	}

	public void changeColour(Color a){
		colours[index] = a;
		col_buttons[index].setBackground(a);
	}
		
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < PALETTESIZE; i ++){
			if(e.getSource()==col_buttons[i]){
				col = colours[i];
				
				
				MyGUI_Painting.cvs.setBrushCol(col); 
				
				index = i;
				
				
				if (colours[i] != Color.BLACK){
					col_buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); // border around selected colour
				}
				else{
					col_buttons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 5)); // white border around black
				}
				
			}
			
			else{
				if (colours[i] != Color.WHITE){
					col_buttons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
				}
				else{
					col_buttons[i].setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
				}

			}
		}

    }
	
	public Color getColour(){
		col = colours[index];
		return col;
	}
	
	public void switchPalette(Color[] a){
		for (int i = 0; i < PALETTESIZE; i ++){
			colours[i] = a[i];
			col_buttons[i].setBackground(colours[i]);
			
		}

	}
	
}


