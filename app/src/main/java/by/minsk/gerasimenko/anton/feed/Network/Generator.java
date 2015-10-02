package by.minsk.gerasimenko.anton.feed.Network;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Generator {



    public OutputStream push() {

        OutputStream stream = new OutputStream() {
            @Override
            public void write(int oneByte) throws IOException {

            }
        };


        JsonFactory jfactory = new JsonFactory();

        try {
            JsonGenerator jGenerator = jfactory.createGenerator(stream, JsonEncoding.UTF8);


            jGenerator.writeStartObject();








            jGenerator.writeEndObject();

            jGenerator.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return stream;
    }
}
