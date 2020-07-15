package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {


        Scanner sc = new Scanner(System.in);

        System.out.println("Rodrigo Querino Ferreira da Costa ");
        System.out.println("API web - https://aluguebug.herokuapp.com/form\n");

        System.out.print("Valor nominal: $");
        String valor = sc.next();
        System.out.print("Para o dia: ");
        String dia = sc.next();

        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        AppSelenium selenium = new AppSelenium(driver);
        System.out.println("\nValor calculado: $" + String.format("%.2f", selenium.requisicao(dia,valor)));

        driver.close();

    }

}