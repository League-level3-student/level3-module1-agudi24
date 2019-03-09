package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Add Name");
	JButton button2 = new JButton("View Names");
	JTextArea textarea = new JTextArea();
	ArrayList<String> names = new ArrayList<String>();
	String allnames = "";
	public static void main(String[] args) {
		_02_GuestBook GB = new _02_GuestBook();
		GB.GUI();
	}
	void GUI() {
	panel.add(button);
	panel.add(button2);
	frame.add(panel);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	button.addActionListener(this);
	button2.addActionListener(this);
	frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			String name = JOptionPane.showInputDialog("Enter a name:");
			names.add(name);
		}
		if(e.getSource() == button2) {
			for (int i = 0; i < names.size(); i++) {
				System.out.println("Guest #" + (i + 1) + ": " + names.get(i));
			
			if (i < names.size()) {
				allnames=allnames+"Guest #"+(i + 1)+": "+names.get(i)+"\n";
			}
			else if (i==names.size()) {
				allnames=allnames+"Guest #"+(i + 1)+": "+names.get(i);
			}
			}
			textarea.setText(allnames);
		}
		
	}
	
	
	
	
	
}

