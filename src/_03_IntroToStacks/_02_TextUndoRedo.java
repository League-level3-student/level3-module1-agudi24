package _03_IntroToStacks;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String typedChar = "";
	int stringLength = 0;
	Stack<Character> charStack = new Stack<Character>();
	public static void main(String[] args) {
		_02_TextUndoRedo tur = new _02_TextUndoRedo();
		tur.run();
	}
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	public void run() {
	frame = new JFrame();
	panel = new JPanel();
	label = new JLabel();
	frame.setVisible(true);
	label.setText("Enter something");
	panel.add(label);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(panel);
	frame.addKeyListener(this);
	label.setText(typedChar);
	frame.pack();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		char keyPressed = e.getKeyChar();
		// TODO Auto-generated method stub
		typedChar += keyPressed;
		label.setText(typedChar);
		if(keyPressed != KeyEvent.VK_BACK_SPACE && keyPressed != KeyEvent.VK_SPACE) {
			stringLength++;
		}
		if(keyPressed == KeyEvent.VK_BACK_SPACE){
			charStack.add(typedChar.charAt(typedChar.length() - 1));
			System.out.println("backspace");
			System.out.println(typedChar.length());
			typedChar = typedChar.substring(0, stringLength - 1);
			stringLength--;
			label.setText("");
			label.setText(typedChar);
			System.out.println(charStack);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
