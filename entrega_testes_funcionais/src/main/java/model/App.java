package model;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.client.HttpClient;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws URISyntaxException {

		System.out.println("Rodrigo Querino Ferreira da Costa ");
		System.out.println("API web - https://aluguebug.herokuapp.com/calc\n");

		Scanner sc = new Scanner(System.in);

		Scanner sc = new Scanner(System.in);
        System.out.print("Valor nominal = $");
		double valorNominal = sc.nextDouble();
        System.out.print("Para o dia: ");
		int dia = sc.nextInt();
        sc.close();

		System.out.println("Valor calculado: $" + String.format("%.2f",  HTTP(valorNominal, dia)));

    }

    public static double HTTP(double x,int y) throws URISyntaxException {

			JSONObject my_json = new JSONObject();
			my_json.put("valor_nominal", x);
			my_json.put("dia", y);
			String str_json = my_json.toString();
			
			Double valor = null;
			URIBuilder uriBuilder = new URIBuilder("https://aluguebug.herokuapp.com/calc");
            uriBuilder.setParameter("dados", str_json);

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            HttpResponse httpResponse;
            try {
                httpResponse = client.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpEntity);
                String json = result.substring(1, result.length()-2);
                String jsonReplace = json.replace("\\", "");
                JSONObject newjson = new JSONObject(jsonReplace);
                valor = newjson.getDouble("valor_calculado");
                return valor;

            } catch (IOException exception) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, exception);
            } return valor;
        }
}