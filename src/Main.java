import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import br.com.moedas_conversor.Dinheiro;
import br.com.moedas_conversor.ExchangeRateResponse;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int escolha;
        double valor;
        double valorConvertido;
        ExchangeRateResponse exchangeRateResponse;
        Dinheiro dinheiro;
        Dinheiro dinheiro_convertido;

        // Criar uma instância do Gson
        Gson gson = new Gson();

        String api = "https://v6.exchangerate-api.com/v6/";
        String API_KEY = "e844f05a88c7c78747859b26";

        // Create an instance of HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest for a GET request
        HttpRequest request;

        // Send the request and store the response in a variable
        HttpResponse<String> response;

        // Get the response body
        String responseBody;

        do {
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda");
            System.out.println("1) Dólar - Peso argentino");
            System.out.println("2) Peso argentino - Dólar");
            System.out.println("3) Dólar - Real brasileiro");
            System.out.println("4) Real brasileiro - Dólar");
            System.out.println("5) Dólar - Peso colombiano");
            System.out.println("6) Peso colombiano - Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o valor em Dólar:");
                    valor = sc.nextDouble();

                    request = HttpRequest.newBuilder()
                            .uri(URI.create(api + API_KEY + "/latest/USD"))
                            .build();
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    responseBody = response.body();

                    exchangeRateResponse = gson.fromJson(responseBody, ExchangeRateResponse.class);
                    valorConvertido = valor * exchangeRateResponse.getConversion_rate("ARS");

                    dinheiro = new Dinheiro(valor, "USD");
                    dinheiro_convertido = new Dinheiro(valorConvertido, "ARS");

                    System.out.println("Valor inserido: " + dinheiro.base_code() + dinheiro.valor());
                    System.out.println("Valor convertido: " + dinheiro_convertido.base_code() + dinheiro_convertido.valor());

                    break;
                case 2:
                    System.out.println("Digite o valor em Peso:");
                    valor = sc.nextDouble();

                    request = HttpRequest.newBuilder()
                            .uri(URI.create(api + API_KEY + "/latest/ARS"))
                            .build();
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    responseBody = response.body();

                    exchangeRateResponse = gson.fromJson(responseBody, ExchangeRateResponse.class);
                    valorConvertido = valor * exchangeRateResponse.getConversion_rate("USD");

                    dinheiro = new Dinheiro(valor, "ARS");
                    dinheiro_convertido = new Dinheiro(valorConvertido, "USD");

                    System.out.println("Valor inserido: " + dinheiro.base_code() + dinheiro.valor());
                    System.out.println("Valor convertido: " + dinheiro_convertido.base_code() + dinheiro_convertido.valor());

                    break;
                case 3:
                    System.out.println("Digite o valor em Dólar:");
                    valor = sc.nextDouble();

                    request = HttpRequest.newBuilder()
                            .uri(URI.create(api + API_KEY + "/latest/USD"))
                            .build();
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    responseBody = response.body();

                    exchangeRateResponse = gson.fromJson(responseBody, ExchangeRateResponse.class);
                    valorConvertido = valor * exchangeRateResponse.getConversion_rate("BRL");

                    dinheiro = new Dinheiro(valor, "USD");
                    dinheiro_convertido = new Dinheiro(valorConvertido, "BRL");

                    System.out.println("Valor inserido: " + dinheiro.base_code() + dinheiro.valor());
                    System.out.println("Valor convertido: " + dinheiro_convertido.base_code() + dinheiro_convertido.valor());

                    break;

                case 4:
                    System.out.println("Digite o valor em Real:");
                    valor = sc.nextDouble();

                    request = HttpRequest.newBuilder()
                            .uri(URI.create(api + API_KEY + "/latest/BRL"))
                            .build();
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    responseBody = response.body();

                    exchangeRateResponse = gson.fromJson(responseBody, ExchangeRateResponse.class);
                    valorConvertido = valor * exchangeRateResponse.getConversion_rate("USD");

                    dinheiro = new Dinheiro(valor, "BRL");
                    dinheiro_convertido = new Dinheiro(valorConvertido, "USD");

                    System.out.println("Valor inserido: " + dinheiro.base_code() + dinheiro.valor());
                    System.out.println("Valor convertido: " + dinheiro_convertido.base_code() + dinheiro_convertido.valor());

                    break;

                case 5:
                    System.out.println("Digite o valor em Dólar:");
                    valor = sc.nextDouble();

                    request = HttpRequest.newBuilder()
                            .uri(URI.create(api + API_KEY + "/latest/USD"))
                            .build();
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    responseBody = response.body();

                    exchangeRateResponse = gson.fromJson(responseBody, ExchangeRateResponse.class);
                    valorConvertido = valor * exchangeRateResponse.getConversion_rate("COP");

                    dinheiro = new Dinheiro(valor, "USD");
                    dinheiro_convertido = new Dinheiro(valorConvertido, "COP");

                    System.out.println("Valor inserido: " + dinheiro.base_code() + dinheiro.valor());
                    System.out.println("Valor convertido: " + dinheiro_convertido.base_code() + dinheiro_convertido.valor());

                    break;

                case 6:
                    System.out.println("Digite o valor em Peso colombiano:");
                    valor = sc.nextDouble();

                    request = HttpRequest.newBuilder()
                            .uri(URI.create(api + API_KEY + "/latest/COP"))
                            .build();
                    response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    responseBody = response.body();

                    exchangeRateResponse = gson.fromJson(responseBody, ExchangeRateResponse.class);
                    valorConvertido = valor * exchangeRateResponse.getConversion_rate("USD");

                    dinheiro = new Dinheiro(valor, "COP");
                    dinheiro_convertido = new Dinheiro(valorConvertido, "USD");

                    System.out.println("Valor inserido: " + dinheiro.base_code() + dinheiro.valor());
                    System.out.println("Valor convertido: " + dinheiro_convertido.base_code() + dinheiro_convertido.valor());

                    break;

                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
                    break;
            }
            System.out.println("\n*****************************************\n");

        } while (escolha != 0);
    }
}
