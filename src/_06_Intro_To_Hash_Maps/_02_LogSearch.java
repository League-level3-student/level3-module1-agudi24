package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
	JButton button1 = new JButton("Add Entry");  
	JButton button2 = new JButton("Search By ID");  
	JButton button3 = new JButton("View List");
	String IDNum;
	String IDName;
	int IDNumber;
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.setup();
	}
	HashMap<Integer, String> personIDs = new HashMap<Integer, String>();
	
	public void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		frame.setVisible(true);
		panel.add(label);
		panel.add(button1);
		button1.addActionListener(this);
		panel.add(button2);
		button2.addActionListener(this);
		panel.add(button3);
		button3.addActionListener(this);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			IDNum = JOptionPane.showInputDialog("Enter an ID number:");
			IDNumber = Integer.parseInt(IDNum);
			IDName = JOptionPane.showInputDialog("Enter a name:");
			personIDs.put(IDNumber, IDName);
		}
		if(e.getSource() == button2) {
			IDNum = JOptionPane.showInputDialog("Enter an ID number:");
			IDNumber = Integer.parseInt(IDNum);
			if(personIDs.containsKey(IDNumber)) {
				JOptionPane.showMessageDialog(null, personIDs.get(IDNumber));
			}
		}
		if(e.getSource() == button3) {
			Iterator<HashMap.Entry<Integer, String>> itr = personIDs.entrySet().iterator();
			System.out.println(itr.hasNext());
			System.out.println(personIDs.size());
			    while(itr.hasNext()) {
			    	System.out.println("ID: " + itr.next().getKey() + " " + "NAME: " + itr.next().getValue());
			    }
				
	}
}
}
