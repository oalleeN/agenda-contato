package ada.tech.agenda.util;

import ada.tech.agenda.model.Contato;
import ada.tech.agenda.model.ContatoEmpresa;
import ada.tech.agenda.model.ContatoPessoal;
import ada.tech.agenda.model.ContatoProfissional;
import com.google.gson.*;

import java.lang.reflect.Type;

public class AdaptadorContato implements JsonDeserializer<Contato> {
    @Override
    public Contato deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject objetoJson = jsonElement.getAsJsonObject();
        String tipo = objetoJson.get("tipo").getAsString();

        switch (tipo) {
            case "ContatoEmpresa":
                return jsonDeserializationContext.deserialize(jsonElement, ContatoEmpresa.class);
            case "ContatoProfissional":
                return jsonDeserializationContext.deserialize(jsonElement, ContatoProfissional.class);
            case "ContatoPessoal":
                return jsonDeserializationContext.deserialize(jsonElement, ContatoPessoal.class);
            default:
                throw new JsonParseException("Tipo Desconhecido!");
        }
    }
}
