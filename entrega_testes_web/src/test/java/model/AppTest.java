package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    private AppSelenium aplication;
    private WebDriver driver;
    private static Double valorNominal = 600.0;

    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.aplication = new AppSelenium(driver);

    }

    @ParameterizedTest
    @CsvSource(value={"0:-1","31:-1"}, delimiter=':')
    public void CT00Selenium(String dia, double valorEsperado) throws InterruptedException {
        assertEquals(valorEsperado, aplication.requisicao(dia, valorNominal.toString()));
    }

    @ParameterizedTest
    @CsvSource(value={"1:540","2:540","3:540","4:540","5:540"}, delimiter=':')
    public void CT01Selenium(String dia, double valorEsperado) throws InterruptedException {
        assertEquals(valorEsperado, aplication.requisicao(dia, valorNominal.toString()));
    }

    @ParameterizedTest
    @CsvSource(value={"6:570","7:570","8:570","9:570","10:570"}, delimiter=':')
    public void CT02Selenium(String dia, double valorEsperado) throws InterruptedException {
        assertEquals(valorEsperado, aplication.requisicao(dia, valorNominal.toString()));
    }

    @ParameterizedTest
    @CsvSource(value={"11:600","12:600","13:600","14:600","15:600"}, delimiter=':')
    public void CT03Selenium(String dia, double valorEsperado) throws InterruptedException {
        assertEquals(valorEsperado, aplication.requisicao(dia, valorNominal.toString()));
    }

    @ParameterizedTest
    @CsvSource(value={"16:612.6","17:613.2","18:613.8","28:619.8","29:620.4","30:621"}, delimiter=':')
    public void CT04Selenium(String dia, double valorEsperado) throws InterruptedException {
        assertEquals(valorEsperado, aplication.requisicao(dia, valorNominal.toString()));
    }

    @AfterEach
    public void encerra(){
        driver.close();
    }

}

