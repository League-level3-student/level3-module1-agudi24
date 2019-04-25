package _04_HangMan;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements ActionListener, KeyListener{
	JButton button = new JButton();
	Stack<String> words = new Stack<String>();
	JLabel label = new JLabel();
	String numDash = "";
	
	ArrayList<String> numDashArray = new ArrayList<String>();
	ArrayList<Character> charWords = new ArrayList<Character>();
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}
	public void setup() {
		JFrame frame = new JFrame("Hangman!");
		JPanel panel = new JPanel();
		button.setText("Click for a question!");
		button.addActionListener(this);
		frame.addKeyListener(this);
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
			charWords.add(poppedWord.charAt(i));
			}
			for (Character character : charWords) {
				//character = '_';
				numDash += '_' + " ";
				
				for (int i = 0; i < charWords.size(); i++) {
					character = charWords.get(i);
				}
			}
			System.out.println(charWords);
			numDashArray.add(numDash);
			System.out.println(numDashArray);
			button.setVisible(false);
			numDash = numDashArray.toString();
			label.setText(numDash);
		}


	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyPressed = e.getKeyChar();
		for (int i = 0; i < charWords.size(); i++) {
			if(keyPressed == charWords.get(i)) {
				System.out.println(charWords.get(i));
			}
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
