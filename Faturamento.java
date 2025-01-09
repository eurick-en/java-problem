import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Faturamento {
    public static void main(String[] args) {
        try {
            // Lendo o arquivo JSON
            String json = new String(Files.readAllBytes(Paths.get("faturamento.json")));
            JSONArray dados = new JSONArray(json);

            double menor = Double.MAX_VALUE;
            double maior = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < dados.length(); i++) {
                double valor = dados.getJSONObject(i).getDouble("valor");
                if (valor > 0) { // Ignorar dias sem faturamento
                    soma += valor;
                    diasComFaturamento++;
                    if (valor < menor) menor = valor;
                    if (valor > maior) maior = valor;
                }
            }

            double media = soma / diasComFaturamento;
            int diasAcimaDaMedia = 0;

            for (int i = 0; i < dados.length(); i++) {
                double valor = dados.getJSONObject(i).getDouble("valor");
                if (valor > media) diasAcimaDaMedia++;
            }

            System.out.println("Menor faturamento: " + menor);
            System.out.println("Maior faturamento: " + maior);
            System.out.println("Dias acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
