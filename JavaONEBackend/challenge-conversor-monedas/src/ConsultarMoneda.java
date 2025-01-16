import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConsultarMoneda {
    private final String api_key;
    private final String url_api;
    private final List<String> historial = new ArrayList<>();

    private String timestamp;
    private String monedaOrigen;
    private String monedaFinal;
    private double monto;
    private double resultado_conversion;

    public ConsultarMoneda(){
        Properties properties = new Properties();
        try {
            FileInputStream fileInput = new FileInputStream("config.properties");
            properties.load(fileInput);

            api_key = properties.getProperty("API_KEY");
            url_api = properties.getProperty("URL_API");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Divisa cambioMoneda(String monOrigen , String monFinal, double monto){
        this.monedaOrigen = monOrigen;
        this.monedaFinal = monFinal;
        this.monto = monto;

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatoFecha);

        String url_request = url_api + api_key +"/pair/"+monOrigen+"/"+monFinal+"/"+monto;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url_request))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Divisa divisa = new Gson().fromJson(response.body(), Divisa.class);
            this.resultado_conversion = divisa.conversion_result();
            historial.add(this.toString()+" con fecha a: "+timestamp);

            return divisa;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> consultarHistorial(){
        return historial;
    }

    @Override
    public String toString() {
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n La conversión de " + monto
                + " [" + monedaOrigen
                + "] a [" + monedaFinal
                + "] es igual a: "+resultado_conversion+" ["+monedaFinal+"]\n";
    }
}
