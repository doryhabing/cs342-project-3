import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MyTest {

	GameLogic game;
	List<String> words, letters;
	String word;
	Set<Integer> indexes;

	@BeforeEach
	void setup(){
		game = new GameLogic();
		words = new ArrayList<>();
		indexes = new HashSet<>();
		letters = new ArrayList<>();
		words.add("cat");
		words.add("dog");
	}

	@Test
	void test1_count_guesses() {
		assertEquals(0, game.guess_count);
		game.count_guesses();
		assertEquals(1, game.guess_count);
	}

	@Test
	void test2_guesses_remaining(){
		assertEquals(6, game.guesses_remaining());
		game.count_guesses();
		assertEquals(5, game.guesses_remaining());
	}

	@Test
	void test3_check_letter(){
		game.current_word = "bird";
        assertFalse(game.check_letter("w"));
		assertTrue(game.check_letter("b"));
	}

	@Test
	void test4_get_index(){
		game.current_word = "bird";
		game.check_letter("b");
		indexes = game.get_letter_index();
		assertEquals(1, indexes.size());
		assertTrue(indexes.contains(0));
	}

	@Test
	void test5_evaluate_win() {
		assertEquals(0, game.wins);
        assertFalse(game.evaluate_win());
		game.wins++;
		assertEquals(1, game.wins);
		assertFalse(game.evaluate_win());
		game.wins = 3;
		assertTrue(game.evaluate_win());
	}

	@Test
	void test6_evaluate_loss() {
		assertEquals(0, game.losses);
		assertFalse(game.evaluate_loss());
		game.losses++;
		assertEquals(1, game.losses);
		assertFalse(game.evaluate_loss());
		game.losses = 3;
		assertTrue(game.evaluate_loss());
	}

	@Test
	void test7_evaluate_loss() {
		game.losses = 3;
		assertEquals(3, game.losses);
		assertTrue(game.evaluate_loss());
	}

	@Test
	void test8_evaluate_win() {
		game.wins = 2;
		assertEquals(2, game.wins);
		assertFalse(game.evaluate_win());
		game.wins++;
		assertEquals(3, game.wins);
		assertTrue(game.evaluate_win());
	}

	@Test
	void test9_guesses_remaining2(){
		game.guess_count = 3;
		assertEquals(3, game.guesses_remaining());
		game.count_guesses();
		assertEquals(4, game.guess_count);
		assertEquals(2, game.guesses_remaining());
	}

	@Test
	void test10_get_index2(){
		game.current_word = "guava";
		assertFalse(game.check_letter("b"));
		indexes = game.get_letter_index();
		assertEquals(0, indexes.size());
		assertTrue(game.check_letter("v"));
		indexes = game.get_letter_index();
		assertEquals(1, indexes.size());
	}
}
