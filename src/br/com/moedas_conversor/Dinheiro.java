package br.com.moedas_conversor;

public record Dinheiro(double valor, String base_code) {
    @Override
    public String toString() {
        return ("Dinheiro: " + base_code + valor);
    }
}
