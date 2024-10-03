import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarValor {

    private String valorInicial;
    private String valorFinal;
    private Double valorConvertir;
    private Double result;

    public Double GenerarValor (String valorInicial, String valorFinal, Double valorConvertir) throws IOException, InterruptedException {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.valorConvertir = valorConvertir;
        String direccion = "https://v6.exchangerate-api.com/v6/55123114e290377804b6dbbe/latest/" + valorInicial.toUpperCase();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String stringResponse = response.body();
        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONObject ratesObject = jsonObject.getJSONObject("conversion_rates");
        Double rate = ratesObject.getDouble(valorFinal.toUpperCase());
        return this.result = rate*valorConvertir;
    }
}
