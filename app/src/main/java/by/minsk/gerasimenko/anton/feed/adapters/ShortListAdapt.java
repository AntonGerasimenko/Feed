package by.minsk.gerasimenko.anton.feed.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import by.minsk.gerasimenko.anton.feed.Logic.Convert;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class ShortListAdapt extends ArrayAdapter <News> {

    private List<News> objects;

    public ShortListAdapt(Context context, int resource, List<News> objects) {
        super(context, resource, objects);

        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_short_list, parent, false);
        }

        TextView date =(TextView) convertView.findViewById(R.id.date);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);


        News news = objects.get(position);


        date.setText(Convert.date(news.getDate()));
        title.setText(news.getTitle());


        return convertView;
    }
}
