public class Game {
    GameLogic gl;
    Category category1;
    Category category2;
    Category category3;
    String category, current_word;

    Game() {
        gl = new GameLogic();
    }

    public String newWord(String category) {
        return gl.pick_word(category);
    }
}
