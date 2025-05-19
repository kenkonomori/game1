package model;

public class ScoreEntry {
    private String id;
    public int score;

    public ScoreEntry(String id, int score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }
}
