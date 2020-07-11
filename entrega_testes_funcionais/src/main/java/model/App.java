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

		JSONObject my_json = new JSONObject();
		System.out.println("Valor nominal = $");
		my_json.put("valor_nominal", sc.nextDouble());
		System.out.println("Para o dia: ");
		my_json.put("dia", sc.nextInt());
		String str_json = my_json.toString();
		sc.close();

		System.out.println("Valor calculado: $" + String.format("%.2f",  HTTP(str_json)));

    }

    public static double HTTP(String str_json) throws URISyntaxException {

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