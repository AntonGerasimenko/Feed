package by.minsk.gerasimenko.anton.feed.Network;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

import by.minsk.gerasimenko.anton.feed.models.NewsPOJO;


/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Parser {

    void parse(InputStream stream){
        try {
            JsonFactory factory = new JsonFactory();
            JsonParser parser  = factory.createParser(stream);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode treeNode = objectMapper.readTree(parser);
            String message = String.valueOf(treeNode.get("result").get("items"));

            NewsPOJO[] newses = objectMapper.readValue(message,NewsPOJO[].class);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
