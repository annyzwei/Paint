/*
	ICS207 - Ms. Strelkovska
	Dec. 09. 2019
	Final Project V4: Painting Software - South
	Creater of Awesomeness: Anny W.
*/

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;


public class SouthPanel extends JPanel implements ActionListener{
	
	JButton undo, redo, reset;
	
	JSlider size;
	
	JLabel c;
	
	//constr
	public SouthPanel(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 30));
		
		//brush size
		size = new JSlider(JSlider.HORIZONTAL, 2, 10, 5);
		
		size.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				MyGUI_Painting.cvs.setBrushSize(size.getValue());
			}
		});
		
		size.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
		size.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(size);		
		
		c = new JLabel("**");
		c.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		c.setForeground(new Color(67, 70, 75));
		c.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		add(c);
		
		reset = new JButton("RESET");
		reset.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
		
		reset.addActionListener(this);
		reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(reset);
		
		
		this.setBackground(new Color(67, 70, 75));
	}
	
	//clear
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset){
			MyGUI_Painting.cvs.clearCanvas();
			
		}

	}
}