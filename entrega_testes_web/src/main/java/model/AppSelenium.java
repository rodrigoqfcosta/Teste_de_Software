package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppSelenium {
    private WebDriver driver;

    public AppSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public double requisicao(String diaSend, String valorSend) throws InterruptedException {
        driver.get("https://aluguebug.herokuapp.com/form");

        WebElement dia = driver.findElement(By.id("dia"));
        WebElement valor = driver.findElement(By.id("valor_nominal"));

        dia.sendKeys(diaSend);
        valor.sendKeys(valorSend);

        WebElement botao = driver.findElement(By.id("botao"));
        botao.click();

        Thread.sleep(1000);

        WebElement resposta = driver.findElement(By.id("resposta"));

        Double valorCalculado = Double.valueOf(resposta.getAttribute("value"));


        return valorCalculado;
    }

}