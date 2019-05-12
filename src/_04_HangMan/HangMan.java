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

public class HangMan implements ActionListener, KeyListener {
	JButton button = new JButton();
	JButton playAgainButton = new JButton();
	Stack<String> words = new Stack<String>();
	JLabel label = new JLabel();
	JLabel scoreLabel = new JLabel();
	int score = 0;
	JFrame frame = new JFrame("Hangman!");
	JPanel panel = new JPanel();
	String numDash = "";
	int letterGuessedRight = 0;
	ArrayList<String> numDashArray = new ArrayList<String>();
	ArrayList<Character> charWords = new ArrayList<Character>();
	ArrayList<String> answerWord = new ArrayList<String>();
	int numLives = 10;
	boolean wrongAnswer = true;

	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}

	public void setup() {
		button.setText("Click for a question!");
		button.addActionListener(this);
		frame.addKeyListener(this);
		frame.setVisible(true);
		scoreLabel.setText("Number of Lives: " + numLives);
		panel.add(label);
		panel.add(scoreLabel);
		panel.add(button);
		frame.add(panel);
		playAgainButton.addActionListener(this);
		playAgainButton.setText("Click to play again");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		wrongAnswer = true;
		char keyPressed = e.getKeyChar();
		for (int i = 0; i < charWords.size(); i++) {
			if (keyPressed == charWords.get(i)) {
				String answer = charWords.get(i).toString();
				numDashArray.remove(i);
				numDashArray.add(i, answer);
				label.setText(numDashArray.toString());
				letterGuessedRight++;
				wrongAnswer = false;
			}
			// letterGuessedRight == charWords.size()
			if (!numDashArray.contains("_")) {
				score++;
				charWords.clear();
				numDashArray.clear();
				nextWord();
			}
		}
		System.out.println(wrongAnswer);
		if (wrongAnswer == true) {
			numLives--;
			scoreLabel.setText("Number of Lives: " + numLives);
		}
		if (numLives == 0) {
			label.setText("You Lose!");
			scoreLabel.setText("");
			panel.add(playAgainButton);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			String question = JOptionPane.showInputDialog("Enter the number of words you want:");
			int questionNum = Integer.parseInt(question);
			for (int i = 0; i < questionNum; i++) {
				words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			}
			nextWord();
			System.out.println(questionNum);
		}
		if (e.getSource() == playAgainButton) {
			HangMan hangmanAgain = new HangMan();
			hangmanAgain.setup();
			nextWord();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void nextWord() {
		letterGuessedRight = 0;
		if (!words.isEmpty()) {
			String poppedWord = words.pop();
			System.out.println(poppedWord);
			for (int i = 0; i < poppedWord.length(); i++) {
				charWords.add(poppedWord.charAt(i));
			}
		} else {
			label.setText("You Win!");
			scoreLabel.setText("");
			panel.add(playAgainButton);
		}
		for (Character character : charWords) {
			// character = '_';
			numDashArray.add("_");
			for (int i = 0; i < charWords.size(); i++) {
				character = charWords.get(i);
			}
		}
		System.out.println(charWords);
		System.out.println(numDashArray);
		button.setVisible(false);
		label.setText(numDashArray.toString());
	}
}
