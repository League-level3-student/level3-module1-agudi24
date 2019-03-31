package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> brackets = new Stack<Character>();
		for(int i = 0; i < b.length(); i++) {
			brackets.push(b.charAt(i));
		}
		int matched = 0;
		System.out.println(brackets.pop());
		for(int i = 0; i <= brackets.size(); i++) {
			char popped = brackets.pop();
			System.out.println(popped);
			if(popped == '}') {
				matched++;
			}
			else if(popped == '{'){
				matched--;
			}
		}
		System.out.println(matched);
		if(matched == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}



