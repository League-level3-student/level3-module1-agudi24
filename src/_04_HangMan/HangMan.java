package _04_HangMan;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements ActionListener{
	JButton button = new JButton();
	Stack<String> words = new Stack<String>();
	JLabel label = new JLabel();
	String numDash = "";
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}
	public void setup() {
		JFrame frame = new JFrame("Hangman!");
		JPanel panel = new JPanel();
		button.setText("Click for a question!");
		button.addActionListener(this);
		frame.setVisible(true);
		panel.add(label);
		panel.add(button);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			String question = JOptionPane.showInputDialog("Enter the number of words you want:");
			int questionNum = Integer.parseInt(question);
			for (int i = 0; i < questionNum; i++) {
				words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			}
			String poppedWord = words.pop();
			System.out.println(poppedWord);
			for (int i = 0; i < poppedWord.length(); i++) {
			numDash += "_ ";
			}
			label.setText(numDash);
			button.setVisible(false);
		}

	}
	
	
}
