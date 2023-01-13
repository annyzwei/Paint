/*
	ICS207 - Ms. Strelkovska
	Dec. 31. 2019
	Final Project V4: Painting Software - Main
	Creater of Awesomeness: Anny W.
*/

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//gui class
class MyGUI_Painting extends JFrame{

	private static Container cont;
	
	private static  WestPanel ws;
	public static Canvas cvs;
	private static SouthPanel ss;
	private static EastPanel es;
	

    public MyGUI_Painting() {	
		
		super("Digital Painting");
		
		ws = new WestPanel();
		
		cvs = new Canvas();
				
		ss = new SouthPanel();
		
		es = new EastPanel();

		
		cont = getContentPane();  // get container - top of the frame
		cont.setLayout(new BorderLayout());
				
		cont.add(ws, BorderLayout.WEST);
		cont.add(cvs, BorderLayout.CENTER);
		cont.add(ss, BorderLayout.SOUTH);
		cont.add(es, BorderLayout.EAST);
	
    }
}    

//main class
public class Paint{
    public static void main(String[] arg){
		
		MyGUI_Painting frame = new MyGUI_Painting();
		
		frame.setVisible(true);
		frame.setSize(1200, 800);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
}