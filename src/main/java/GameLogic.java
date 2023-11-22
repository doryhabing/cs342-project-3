import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GameLogic {
    String category1, category2, category3;
    Category cat1, cat2, cat3;
    int wins = 0, category1_used_word_count = 0, category2_used_word_count = 0, category3_used_word_count = 0;
    Set<String> guessed_letters = new HashSet<>();

    GameLogic() {
        cat1 = new Category("Animals", 1);
        cat1.word1.setWord("cat");
        cat1.word2.setWord("chinchilla");
        cat1.word3.setWord("bird");
        cat2 = new Category("Sports", 2);
        cat2.word1.setWord("hockey");
        cat2.word2.setWord("football");
        cat2.word3.setWord("basketball");
        cat3 = new Category("Fruit", 3);
        cat3.word1.setWord("banana");
        cat3.word2.setWord("watermelon");
        cat3.word3.setWord("guava");

        category1 = cat1.category_name;
        category2 = cat2.category_name;
        category3 = cat3.category_name;
    }

    public String pick_word(String category) {
        if (Objects.equals(category1, category)) {
            if (!cat1.word1.guessed) {
                category1_used_word_count++;
                return cat1.word1.word;
            } else if (!cat1.word2.guessed) {
                category1_used_word_count++;
                return cat1.word2.word;
            } else if (!cat1.word3.guessed) {
                category1_used_word_count++;
                return cat1.word3.word;
            }
        } else if (Objects.equals(category2, category)) {
            if (!cat2.word1.guessed) {
                category2_used_word_count++;
                return cat2.word1.word;
            } else if (!cat2.word2.guessed) {
                category2_used_word_count++;
                return cat2.word2.word;
            } else if (!cat2.word3.guessed) {
                category2_used_word_count++;
                return cat2.word3.word;
            }
        } else if (Objects.equals(category3, category)) {
            if (!cat3.word1.guessed) {
                category3_used_word_count++;
                return cat3.word1.word;
            } else if (!cat3.word2.guessed) {
                category3_used_word_count++;
                return cat3.word2.word;
            } else if (!cat3.word3.guessed) {
                category3_used_word_count++;
                return cat3.word3.word;
            }
        }
        return "";
    }

    public int letter_count() {
        return 0;
    }

    public boolean check_letter(String letter) {

        return false;
    }

    public boolean evaluate_win() {
        return wins == 3;
    }
}
