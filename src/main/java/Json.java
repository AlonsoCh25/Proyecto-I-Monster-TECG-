import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Json {
    private ObjectMapper ObjectMapper = new ObjectMapper();

    public <A> A parse(String jsonSource, Class<A> clazz) throws JsonProcessingException {
        JsonNode node = ObjectMapper.readTree(jsonSource);
        return ObjectMapper.treeToValue(node, clazz);
    }
    public String toJson(Object data) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(data);
    }
}