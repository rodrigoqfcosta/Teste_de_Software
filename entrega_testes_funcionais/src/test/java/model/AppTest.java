
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
        assertEquals(540, aplicacao.HTTP(valorNominal, 1));
    }

    @Test
    public void CT02RQFC() throws URISyntaxException {
        assertEquals(540, aplicacao.HTTP(valorNominal, 5));
    }

    @Test
    public void CT03RQFC() throws URISyntaxException {
        assertEquals(570, aplicacao.HTTP(valorNominal, 6));
    }

    @Test
    public void CT04RQFC() throws URISyntaxException {
        assertEquals(570, aplicacao.HTTP(valorNominal, 10));
    }

    @Test
    public void CT05RQFC() throws URISyntaxException {
        assertEquals(600, aplicacao.HTTP(valorNominal, 11));
    }

    @Test
    public void CT06RQFC() throws URISyntaxException {
        assertEquals(600, aplicacao.HTTP(valorNominal, 15));
    }

    @Test
    public void CT07RQFC() throws URISyntaxException {
        double valor = valorNominal;
        double multa = valor * 0.02;
        double adicional = valor * 0.001;
        int dia = 16;
        if (dia >= 16 && dia < 31) {
            int multiplicador = dia - 16 + 1;
            adicional = valor * (0.001 * multiplicador);
        }
        assertEquals(valorNominal + adicional + multa, aplicacao.HTTP(valorNominal, 16));
    }

    @Test
    public void CT08RQFC() throws URISyntaxException {
        double valor = valorNominal;
        double multa = valor * 0.02;
        double adicional = valor * 0.001;
        int dia = 30;
        if (dia >= 16 && dia < 31) {
            int multiplicador = dia - 16 + 1;
            adicional = valor * (0.001 * multiplicador);
        }
        assertEquals(valorNominal + adicional + multa, aplicacao.HTTP(valorNominal, 30));
    }

    // Casos de testes dos valores invalidos:
    @Test
    public void CT09RQFC() throws URISyntaxException {
        assertEquals(-1, aplicacao.HTTP(valorNominal, 31));
    }

    @Test
    public void CT00RQFC() throws URISyntaxException {
        assertEquals(-1, aplicacao.HTTP(valorNominal, 0));
    }
}