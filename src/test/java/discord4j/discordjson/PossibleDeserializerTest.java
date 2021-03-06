package discord4j.discordjson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import discord4j.discordjson.json.MyJson;
import discord4j.discordjson.possible.Possible;
import discord4j.discordjson.possible.PossibleFilter;
import discord4j.discordjson.possible.PossibleModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class PossibleDeserializerTest {

    ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper()
                .registerModule(new PossibleModule())
                .registerModule(new Jdk8Module())
                .setDefaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.CUSTOM,
                        JsonInclude.Include.ALWAYS, PossibleFilter.class, null));
    }

    @Test
    public void testPresent() throws IOException {
        MyJson json = mapper.readValue(getClass().getResourceAsStream("/singleFieldPresent.json"), MyJson.class);

        Assert.assertEquals(Possible.of(Optional.of("isHere")), json.myField());
    }

    @Test
    public void testNull() throws IOException {
        MyJson json = mapper.readValue(getClass().getResourceAsStream("/singleFieldNull.json"), MyJson.class);

        assertEquals(Possible.of(Optional.empty()), json.myField());
    }

    @Test
    public void testAbsent() throws IOException {
        MyJson json = mapper.readValue(getClass().getResourceAsStream("/singleFieldAbsent.json"), MyJson.class);

        assertEquals(Possible.absent(), json.myField());
    }
}
