/*
	ICS207 - Ms. Strelkovska
	Dec. 31. 2019
	Final Project V4: Painting Software - Center
	Creater of Awesomeness: Anny W.
*/


import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

//canvas
public class Canvas extends JPanel implements  MouseListener, MouseMotionListener {
	
	protected static final int LENGTH = 750;
	
	private int count = 0;
	
	protected Graphics draw;	
	
	public int switchBrush = 0;
	private int sx, sy;
	
	private Color brushColour;

	private boolean dragging; //user is drawing
	public boolean eraser; //no colour
    
	public static int s_width = 20, s_length = 20;
	  
	private int brushSize;

	//constr
	public Canvas(){
		brushColour = Color.BLACK;

		brushSize = 5;

		this.setSize(LENGTH, LENGTH);

		this.setBackground(Color.WHITE);
		
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	//clear
	public void clearCanvas(){
		repaint();
	}
	
	//change colour
	public void setBrushCol (Color x){
		brushColour = x;
	}
	
	//change size
	public void setBrushSize (int x){
		brushSize = x;
	}
	
     
	//gets drawing surface
	private void setUpGraphics() {
		
		draw = MyGUI_Painting.cvs.getGraphics();
        draw.setColor(brushColour);

	}
	
	
	//stamps
	public void mouseClicked( MouseEvent e ){
		
		if (dragging){ //no repeats
            return; 
		}
		
		setUpGraphics();
		
		if (switchBrush == 2){
			draw.fillOval(e.getX()-(s_width/2), e.getY()-(s_length/2), s_width, s_length);
		}
		else if (switchBrush == 3){
			draw.fillRect(e.getX()-(s_width/2), e.getY()-(s_length/2), s_width, s_length);
		}
		
		dragging = true;
	}


	public void mousePressed( MouseEvent e ){
		setUpGraphics();			

		if (switchBrush == 1){ //line
			sx = e.getX();
			sy = e.getY();
			
		}
		
    }

	public void mouseReleased( MouseEvent e ){
		dragging = false;
		
		
		draw.dispose();
        draw = null;

	}

	//crosshair cursor
	public void mouseEntered( MouseEvent e ) {
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	public void mouseExited( MouseEvent e ) {
		setCursor(Cursor.getDefaultCursor());
	}

   // MouseMotionListener event handlers
	public void mouseDragged( MouseEvent e )   {

		int x = e.getX();
		int y = e.getY();
		int radius = (int)Math.pow(brushSize,2);
		

		
		switch(switchBrush){
			case 0:
				if (eraser){
					draw.setColor(Color.WHITE);
				}
				draw.fillOval(x-(radius/2), y-(radius/2), radius, radius);  // draw circle
				break;	
			case 1:
				draw.drawLine(sx, sy, x, y);
				break;
		}


		dragging = true;
	}

	public void mouseMoved( MouseEvent e )   {

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}
}
