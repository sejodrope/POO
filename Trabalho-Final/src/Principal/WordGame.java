package Principal;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordGame {

    public List<String> palavrasComLetraAleatoria = new ArrayList<>();
    public List<String> palavrasDigitadas = new ArrayList<>() ;
    public String caminhoArquivo = "src/Arquivos/palavras.txt"; // Adicionar aqui o caminho do arquivo palavras.txt

    public String letra;



    private static List<String> lerPalavrasDoArquivo(String caminhoArquivo) throws IOException {
        Path path = Paths.get(caminhoArquivo);
        List<String> linhas = Files.readAllLines(path, StandardCharsets.UTF_8);
        return linhas;
    }

    public void gerarListaDePalavras(String gerado){
        try {
            List<String> palavras = lerPalavrasDoArquivo(caminhoArquivo);
            for (String palavra : palavras){
                if(palavra.startsWith(gerado)){
                    palavrasComLetraAleatoria.add(palavra);
                }
            }
            System.out.println("Para começar digite palavras com 4 letras ou mais, iniciando com a letra: " + letra);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void gerarLetra() {
        Random random = new Random();
        char letraAleatoria = (char) (random.nextInt(26) + 'a');
        String letra = String.valueOf(letraAleatoria);
        this.letra = letra;
    }

}