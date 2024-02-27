import br.com.screenMatch.Exceptions.ConvertErrorYearException;
import br.com.screenMatch.models.OmdbTitle;
import br.com.screenMatch.models.Titles;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String movie = "";

        List<Titles> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!movie.equalsIgnoreCase("sair")) {
            System.out.println("Qual filme quer pesquisar? (Digite 'Sair' para encerrar)");
            movie = scanner.nextLine().replaceAll( "\\s", "+").trim();

            if (movie.equalsIgnoreCase("sair")){
                break;
            }

            String baseUrl = "https://www.omdbapi.com/?t=" + movie + "&apikey=2e6ef3c3";

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(baseUrl))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();


                OmdbTitle title = gson.fromJson(json, OmdbTitle.class);
                Titles myTitle = new Titles(title);
                titles.add(myTitle);

            } catch (NumberFormatException | ConvertErrorYearException exception) {
                System.out.println("Houve um erro: " + exception.getMessage());
            }
        }

        FileWriter writer = new FileWriter ("filmes.json");
        writer.write(gson.toJson(titles));
        writer.close();

        System.out.println("Programa encerrado!");
    }
}