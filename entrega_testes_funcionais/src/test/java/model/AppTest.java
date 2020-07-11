
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import java.net.URISyntaxException;

public class AppTest {

    Double valorNominal = (double) 600;
    App aplicacao = new App();

    // Casos de testes dos valores validos:
    @Test
    public void CT01RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 1);
        String str_json = my_json.toString();
        assertEquals(540, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT02RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 5);
        String str_json = my_json.toString();
        assertEquals(540, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT03RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 6);
        String str_json = my_json.toString();
        assertEquals(570, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT04RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 10);
        String str_json = my_json.toString();
        assertEquals(570, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT05RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 11);
        String str_json = my_json.toString();
        assertEquals(600, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT06RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 15);
        String str_json = my_json.toString();
        assertEquals(600, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT07RQFC() throws URISyntaxException {
        double valor = valorNominal;
        double multa = valor * 0.02;
        double adicional = valor * 0.001;

        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 16);
        String str_json = my_json.toString();
        int dia = (int) my_json.get("dia");
        if (dia >= 16 && dia < 31) {
            int multiplicador = dia - 16 + 1;
            adicional = valor * (0.001 * multiplicador);
        }
        assertEquals(valorNominal + adicional + multa, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT08RQFC() throws URISyntaxException {
        double valor = valorNominal;
        double multa = valor * 0.02;
        double adicional = valor * 0.001;

        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 30);
        String str_json = my_json.toString();
        int dia = (int) my_json.get("dia");
        if (dia >= 16 && dia < 31) {
            int multiplicador = dia - 16 + 1;
            adicional = valor * (0.001 * multiplicador);
        }
        assertEquals(valorNominal + adicional + multa, aplicacao.HTTP(str_json));
    }

    // Casos de testes dos valores invalidos:
    @Test
    public void CT09RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 31);
        String str_json = my_json.toString();
        assertEquals(-1, aplicacao.HTTP(str_json));
    }

    @Test
    public void CT00RQFC() throws URISyntaxException {
        JSONObject my_json = new JSONObject();
        my_json.put("valor_nominal", valorNominal);
        my_json.put("dia", 0);
        String str_json = my_json.toString();
        assertEquals(-1, aplicacao.HTTP(str_json));
    }
}