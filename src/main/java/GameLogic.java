import java.util.*;

public class GameLogic {
    String category1, category2, category3, current_letter, current_word, current_category;
    Category cat1, cat2, cat3;
    int wins = 0, losses = 0, category1_used_word_count = 0, category2_used_word_count = 0, category3_used_word_count = 0, guess_count = 0;
    List<String> correct_letters;

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

        correct_letters = new ArrayList<>();
        category1 = cat1.category_name;
        category2 = cat2.category_name;
        category3 = cat3.category_name;
        guess_count = 0;
    }

    public String pick_word(String category) {
        current_category = category;
        if (Objects.equals(category1, category)) {
            if (!cat1.word1.guessed && !cat1.word1.lost) {
                category1_used_word_count++;
                current_word = cat1.word1.word;
                return current_word;
            } else if (!cat1.word2.guessed && !cat1.word2.lost) {
                category1_used_word_count++;
                current_word = cat1.word2.word;
                return current_word;
            } else if (!cat1.word3.guessed && !cat1.word3.lost) {
                category1_used_word_count++;
                current_word = cat1.word3.word;
                return current_word;
            }
        } else if (Objects.equals(category2, category)) {
            if (!cat2.word1.guessed && !cat2.word1.lost) {
                category2_used_word_count++;
                current_word = cat2.word1.word;
                return current_word;
            } else if (!cat2.word2.guessed && !cat2.word2.lost) {
                category2_used_word_count++;
                current_word = cat2.word2.word;
                return current_word;
            } else if (!cat2.word3.guessed && !cat2.word3.lost) {
                category2_used_word_count++;
                current_word = cat2.word3.word;
                return current_word;
            }
        } else if (Objects.equals(category3, category)) {
            if (!cat3.word1.guessed && !cat3.word1.lost) {
                category3_used_word_count++;
                current_word = cat3.word1.word;
                return current_word;
            } else if (!cat3.word2.guessed && !cat3.word2.lost) {
                category3_used_word_count++;
                current_word = cat3.word2.word;
                return current_word;
            } else if (!cat3.word3.guessed && !cat3.word3.lost) {
                category3_used_word_count++;
                current_word = cat3.word3.word;
                return current_word;
            }
        }
        return "";
    }

    public void count_guesses() {
        guess_count++;
    }

    public int guesses_remaining() {
        return 6 - guess_count;
    }

    public boolean check_letter(String letter) {
        current_letter = letter;
        return current_word.contains(letter);
    }

    public Set<Integer> get_letter_index() {
        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < current_word.length(); i++) {
            if (current_letter.charAt(0) == current_word.charAt(i)) {
                correct_letters.add(current_letter);
                indexes.add(i);
            }
        }
        return indexes;
    }

    public boolean evaluate_win() {
        return wins == 3;
    }

    public boolean check_win() {
        if (correct_letters.size() == current_word.length() && guesses_remaining() > 0) {
            wins++;
            if (Objects.equals(category1, current_category)) {
                if (Objects.equals(cat1.word1.word, current_word)) {
                    cat1.word1.guessed = true;
                    cat1.word1.lost = false;
                } else if (Objects.equals(cat1.word2.word, current_word)) {
                    cat1.word2.guessed = true;
                    cat1.word2.lost = false;
                } else if (Objects.equals(cat1.word3.word, current_word)) {
                    cat1.word3.guessed = true;
                    cat1.word3.lost = false;
                }
            } else if (Objects.equals(category2, current_category)) {
                if (Objects.equals(cat2.word1.word, current_word)) {
                    cat2.word1.guessed = true;
                    cat2.word1.lost = false;
                } else if (Objects.equals(cat2.word2.word, current_word)) {
                    cat2.word2.guessed = true;
                    cat2.word2.lost = false;
                } else if (Objects.equals(cat2.word3.word, current_word)) {
                    cat2.word3.guessed = true;
                    cat2.word3.lost = false;
                }
            } else if (Objects.equals(category3, current_category)) {
                if (Objects.equals(cat3.word1.word, current_word)) {
                    cat3.word1.guessed = true;
                    cat3.word1.lost = false;
                } else if (Objects.equals(cat3.word2.word, current_word)) {
                    cat3.word2.guessed = true;
                    cat3.word2.lost = false;
                } else if (Objects.equals(cat3.word3.word, current_word)) {
                    cat3.word3.guessed = true;
                    cat3.word3.lost = false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean check_loss() {
        if (guess_count == 6) {
            losses++;
            if (Objects.equals(category1, current_category)) {
                if (Objects.equals(cat1.word1.word, current_word)) {
                    cat1.word1.guessed = false;
                    cat1.word1.lost = true;
                } else if (Objects.equals(cat1.word2.word, current_word)) {
                    cat1.word2.guessed = false;
                    cat1.word2.lost = true;
                } else if (Objects.equals(cat1.word3.word, current_word)) {
                    cat1.word3.guessed = false;
                    cat1.word3.lost = true;
                }
            } else if (Objects.equals(category2, current_category)) {
                if (Objects.equals(cat2.word1.word, current_word)) {
                    cat2.word1.guessed = false;
                    cat2.word1.lost = true;
                } else if (Objects.equals(cat2.word2.word, current_word)) {
                    cat2.word2.guessed = false;
                    cat2.word2.lost = true;
                } else if (Objects.equals(cat2.word3.word, current_word)) {
                    cat2.word3.guessed = false;
                    cat2.word3.lost = true;
                }
            } else if (Objects.equals(category3, current_category)) {
                if (Objects.equals(cat3.word1.word, current_word)) {
                    cat3.word1.guessed = false;
                    cat3.word1.lost = true;
                } else if (Objects.equals(cat3.word2.word, current_word)) {
                    cat3.word2.guessed = false;
                    cat3.word2.lost = true;
                } else if (Objects.equals(cat3.word3.word, current_word)) {
                    cat3.word3.guessed = false;
                    cat3.word3.lost = true;
                }
            }
            return true;
        }
        return false;
    }

    public boolean evaluate_loss() {
        return losses == 3;
    }
}

