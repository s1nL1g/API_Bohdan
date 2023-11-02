package studyPackAPI.pojoFiles;

public class RequestOrder {
    public int id;
    public String name;
    public String releaseDate;
    public int reviewScore;
    public String category;
    public String rating;

    public RequestOrder(int id, String name, String releaseDate, int reviewScore, String category, String rating) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.reviewScore = reviewScore;
        this.category = category;
        this.rating = rating;
    }
}
