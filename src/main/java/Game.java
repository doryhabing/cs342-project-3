public class Game {
    Category category1;
    Category category2;
    Category category3;

    Game() {
        category1 = new Category("Animals", 1);
        category1.word1.setWord("cat");
        category1.word2.setWord("chinchilla");
        category1.word3.setWord("bird");
        category2 = new Category("Sports", 2);
        category2.word1.setWord("hockey");
        category2.word2.setWord("football");
        category2.word3.setWord("basketball");
        category3 = new Category("Fruit", 3);
        category1.word1.setWord("banana");
        category1.word2.setWord("watermelon");
        category1.word3.setWord("guava");
    }
}
