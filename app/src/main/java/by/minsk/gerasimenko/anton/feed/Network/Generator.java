package by.minsk.gerasimenko.anton.feed.Network;
/*
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;*/

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.io.OutputStream;

import by.minsk.gerasimenko.anton.feed.models.FuncConnect;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Generator {


    public boolean generateRequest(OutputStream out, FuncConnect type) {
        assert (type!= null);
        assert (out !=null);

        switch (type) {
            case ALL_NEWS:
                return getAllNews(out);
            case CURR_NEWS:
                int id = type.getId();
                return id > 0 && getcurrNews(out, id);
        }
        return false;
    }


    private boolean getAllNews(OutputStream out) {
        try {
            JsonFactory factory = new JsonFactory();
            JsonGenerator generator  = factory.createGenerator(  out    , JsonEncoding.UTF8);

            generator.writeStartObject();
            generator.writeArrayFieldStart("params");
                generator.writeStartObject();
                    generator.writeNumberField("count", 10);
                generator.writeEndObject();
            generator.writeEndArray();
            generator.writeStringField("method", "/tutby/news/popular");
            generator.writeNumberField("jsonrpc", 2.0);
            generator.writeNumberField("id", 4);

            generator.writeEndObject();
            generator.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean getcurrNews(OutputStream out, int id){
        try {
            JsonFactory factory = new JsonFactory();
            JsonGenerator generator  = factory.createGenerator(  out    , JsonEncoding.UTF8);

            generator.writeStartObject();
            generator.writeArrayFieldStart("params");
                generator.writeStartObject();
                    generator.writeNumberField("id", id);
                    generator.writeBooleanField("removeTags", true);
                    generator.writeBooleanField("removeImages",true);
                generator.writeEndObject();
            generator.writeEndArray();
            generator.writeStringField("method", "/tutby/news/popular");
            generator.writeNumberField("jsonrpc", 2.0);
            generator.writeNumberField("id", 4);


          //  {"params":{"id":"467758","removeTags":false,"removeImages":false},"jsonrpc":"2.0","method":"/tutby/news/article","id":8}

            generator.writeEndObject();
            generator.close();

        } catch (IOException e){

            return false;
        }
        return true;
    }
}
