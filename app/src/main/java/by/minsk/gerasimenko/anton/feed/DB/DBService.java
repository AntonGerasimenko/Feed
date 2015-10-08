package by.minsk.gerasimenko.anton.feed.DB;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.minsk.gerasimenko.anton.feed.models.News;
import by.minsk.gerasimenko.anton.feed.models.NewsPOJO;

/**
 * Created by gerasimenko on 08.10.2015.
 */
public class DBService {

    public static void put(List<NewsPOJO> newses) {
        try {
            Dao<News,String> dao = DBManager.getInstance().getHelper().getNewsDao();

            List<News> list = new ArrayList<>();
            for(NewsPOJO newsPOJO:newses){
                list.add(News.getNews(newsPOJO));
            }
            dao.create(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Set<Integer> getDownloadedId(){
        Set<Integer> out = new HashSet<>();

        for (News news:getAll()) {
            out.add(news.get_id());
        }

        return out;
    }

    public static List<News> getAll(){
        try {
            Dao<News,String>     dao = DBManager.getInstance().getHelper().getNewsDao();
            return  dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static void addTextNews(int id,String htmlText) {



    }
}
