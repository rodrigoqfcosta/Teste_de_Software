package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.net.URISyntaxException;

public class AppTestCSV {
    private App aplicacao;
    double valorNominal = (double) 600;

    @BeforeEach
    public void init(){
        valorNominal = (double) 600;
        aplicacao = new App();
    }

    @ParameterizedTest
    @CsvSource(value={"0:-1","31:-1"}, delimiter=':')
    public void cal00CSV(int dia, double resultadoEsperado) throws URISyntaxException {

        double resultado = aplicacao.HTTP(valorNominal, dia);
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource(value={"1:540","2:540","3:540","4:540","5:540"}, delimiter=':')
    public void cal01CSV(int dia, double resultadoEsperado) throws URISyntaxException {

        double resultado = aplicacao.HTTP(valorNominal, dia);
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource(value={"6:570","7:570","8:570","9:570","10:570"}, delimiter=':')
    public void cal02CSV(int dia, double resultadoEsperado) throws URISyntaxException {

        double resultado = aplicacao.HTTP(valorNominal, dia);
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource(value={"11:600","12:600","13:600","14:600","15:600"}, delimiter=':')
    public void cal03CSV(int dia, double resultadoEsperado) throws URISyntaxException {

        double resultado = aplicacao.HTTP(valorNominal, dia);
        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource(value={"16:612.6","17:613.2","18:613.8","28:619.8","29:620.4","30:621"}, delimiter=':')
    public void cal04CSV(int dia, double resultadoEsperado) throws URISyntaxException {

        double resultado = aplicacao.HTTP(valorNominal, dia);
        assertEquals(resultadoEsperado, resultado);
    }

}