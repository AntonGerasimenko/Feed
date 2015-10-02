package by.minsk.gerasimenko.anton.feed.Network;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.codehaus.stax2.XMLInputFactory2;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;

import by.minsk.gerasimenko.anton.feed.models.Simple;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Parser {


    void p(InputStream stream){

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);

       XmlMapper xmlMapper = new XmlMapper(module);

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        /*try {
            JsonNode node = xmlMapper.readTree(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
*/

         try {
            Simple value = xmlMapper.readValue("<Simple><x>1</x><y>2</y></Simple>", Simple.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
