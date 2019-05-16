package ebook;

public class Book {
    private int id;
    private String name;
    private String subtitle;
    private Press publish;
    private int version;
    private String language;
    private String cover;
    private float price;
    private int inventory;
    private int saled;
    private float score;
    private int score_num;
    private  String onsale;
    private String ISBN;

    public Book(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Press getPublish() {
        return publish;
    }

    public int getVersion() {
        return version;
    }

    public String getLanguage() {
        return language;
    }

    public String getCover() {
        return cover;
    }

    public float getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public int getSaled() {
        return saled;
    }

    public float getScore() {
        return score;
    }

    public int getScore_num() {
        return score_num;
    }

    public String getOnsale() {
        return onsale;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setPublish(Press publish) {
        this.publish = publish;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setScore_num(int score_num) {
        this.score_num = score_num;
    }

    public void setOnsale(String onsale) {
        this.onsale = onsale;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
