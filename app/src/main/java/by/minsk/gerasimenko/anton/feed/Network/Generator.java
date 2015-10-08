package by.minsk.gerasimenko.anton.feed.Network;
/*
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;*/

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import by.minsk.gerasimenko.anton.feed.models.Simple;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Generator {



    public void push(OutputStream out) {

        JsonFactory factory = new JsonFactory();
        try {

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
        }
    }
}
