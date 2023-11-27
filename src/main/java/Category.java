public class Category {
    String category_name;
    int category_num;
    Word word1;
    Word word2;
    Word word3;

    Category(String category, int cat_num) {
        this.category_name = category;
        this.category_num = cat_num;
        this.word1 = new Word();
        this.word2 = new Word();
        this.word3 = new Word();
    }

}
