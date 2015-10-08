package by.minsk.gerasimenko.anton.feed.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by gerasimenko on 30.09.2015.
 */

@DatabaseTable(tableName="News")
public class News implements Serializable {
    @DatabaseField(dataType = DataType.INTEGER) private int _id;
    @DatabaseField(dataType = DataType.LONG) private long date;

    @DatabaseField(dataType = DataType.STRING) private String title;
    @DatabaseField(dataType = DataType.STRING) private String picturePath;
    @DatabaseField(dataType = DataType.STRING) private String text;
    @DatabaseField(dataType = DataType.STRING) private String urlImage;
    @DatabaseField(dataType = DataType.STRING) private String urlNews;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlNews() {
        return urlNews;
    }

    public void setUrlNews(String urlNews) {
        this.urlNews = urlNews;
    }

    public static News getEmpty() {
        return empty;
    }

    private final static  News empty;

    static {

        empty = new News();
        empty.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        empty.setTitle("Loren");
    }


    public static News getNews(NewsPOJO newsPOJO){

        News instance = new News();
        instance.setId(newsPOJO.getId());
        instance.setDate(newsPOJO.getPubDate());
        instance.setTitle(newsPOJO.getTitle());
        instance.setUrlImage(newsPOJO.getFrontImageUrl());
        instance.setUrlNews(newsPOJO.getShortUrl());

        return  instance;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static News empty(){

        return empty;
    }

    public  boolean isEmpty() {

        return (this.equals(empty));
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }
}
