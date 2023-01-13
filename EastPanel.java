/*
	ICS207 - Ms. Strelkovska
	Dec. 09. 2019
	Final Project V4: Painting Software - East
	Creater of Awesomeness: Anny W.
*/

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;


//brushes

public class EastPanel extends JPanel implements ActionListener{
	
	JButton pencil, eraser, square, line, circle, border, fill; //buttons
	
	private JLabel a, b;
	JSlider s_width, s_length;

	public EastPanel(){

		//layout
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));		

		//adding + formatting buttons
		pencil = new JButton(new ImageIcon("pencil.png"));
		pencil.setBackground(Color.WHITE);
		pencil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pencil.setAlignmentX(Component.CENTER_ALIGNMENT);
		pencil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		pencil.addActionListener(this);
		add(pencil);
		
		
		eraser = new JButton(new ImageIcon("eraser.png"));
		eraser.setBackground(Color.WHITE);
		eraser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eraser.setAlignmentX(Component.CENTER_ALIGNMENT);
		eraser.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		eraser.addActionListener(this);
		add(eraser);


		line = new JButton(new ImageIcon("line.png"));
		line.setBackground(Color.WHITE);
		line.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		line.setAlignmentX(Component.CENTER_ALIGNMENT);
		line.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		line.addActionListener(this);
		add(line);

		
		circle = new JButton(new ImageIcon("circle.png"));
		circle.setBackground(Color.WHITE);
		circle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		circle.setAlignmentX(Component.CENTER_ALIGNMENT);
		circle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		circle.addActionListener(this);
		add(circle);

		
		square = new JButton(new ImageIcon("square.png"));
		square.setBackground(Color.WHITE);
		square.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		square.setAlignmentX(Component.CENTER_ALIGNMENT);
		square.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		square.addActionListener(this);
		add(square);

		//labels and jsliders	
		a = new JLabel("SHAPE WIDTH");
		a.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		a.setForeground(Color.WHITE);
		a.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		a.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(a);
		
		s_width = new JSlider(JSlider.HORIZONTAL, 2, 75, 5);
		
		s_width.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				MyGUI_Painting.cvs.s_width = s_width.getValue()*5;
			}
		});
		
		s_width.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		s_width.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(s_width);	
				
		b = new JLabel("SHAPE LENGTH");
		b.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		b.setForeground(Color.WHITE);
		b.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(b);
		
		s_length = new JSlider(JSlider.HORIZONTAL, 2, 75, 5);
		s_length.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		s_length.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				MyGUI_Painting.cvs.s_length = s_length.getValue()*5;
			}
		});
		
		s_length.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

		add(s_length);	
		
		//background
		this.setBackground(new Color(67, 70, 75));
			
	}
	
	//helper method to reset borders
	private void changeBorder(JButton a){ 
		pencil.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		eraser.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		line.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		circle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		square.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		a.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	}
	
	//actionlistener
	public void actionPerformed(ActionEvent e) {
		//sends info to variables of canvas class
		
		if (e.getSource() == pencil){
			MyGUI_Painting.cvs.switchBrush = 0;
			MyGUI_Painting.cvs.eraser = false;
			changeBorder(pencil);
		}
		
		else if (e.getSource() == eraser){
			MyGUI_Painting.cvs.switchBrush = 0;
			MyGUI_Painting.cvs.eraser = true;
			changeBorder(eraser);
		}

		else if (e.getSource() == line){
			MyGUI_Painting.cvs.switchBrush = 1;
			MyGUI_Painting.cvs.eraser = false;
			changeBorder(line);
		}		
		
		else if (e.getSource() == circle){
			MyGUI_Painting.cvs.switchBrush = 2;
			MyGUI_Painting.cvs.eraser = false;
			changeBorder(circle);
		}		
		
		else if (e.getSource() == square){
			MyGUI_Painting.cvs.switchBrush = 3;
			MyGUI_Painting.cvs.eraser = false;
			changeBorder(square);
		}
	}
		

}