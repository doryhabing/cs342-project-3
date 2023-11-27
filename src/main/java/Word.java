public class Word {
    int word_length;
    String word;
    char[] letters;
    boolean guessed = false;
    boolean lost = false;

    Word() {
        this.word_length = 0;
        this.word = "";
    }

    public int getLength() {
        return word_length;
    }

    public void setLength(int x) {
        this.word_length = x;
    }

//    public String getWord(){
//        return word;
//    }
    public void setWord(String word){
        this.word = word;
    }

}
