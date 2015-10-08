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
    @DatabaseField(dataType = DataType.STRING) private String newsText;

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

    private final static  News empty = new News();

    public static News getNews(NewsPOJO newsPOJO){

        News instance = new News();
        instance.set_id(newsPOJO.getId());
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

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
