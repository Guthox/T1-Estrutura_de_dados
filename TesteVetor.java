import java.io.FileWriter;
import java.io.File;

public class TesteVetor {
    public static void main(String[] args) {
        
        int[] tamanhos = {200_000, 400_000, 600_000, 800_000, 1_000_000, 1_200_000, 1_400_000};

        for (int i = 0; i < tamanhos.length; i++){
            testarSort(tamanhos[i]);
            System.out.println("Teste com " + tamanhos[i] + " elementos finalizado.");
        }
        System.out.println("Todos os testes finalizados");
        
    }


    private static void testarSort(int tamanho){
        MeuVetor vetor = new MeuVetor(tamanho);
        String csvBubble = "Número do Teste,Tempo(ms)\n";
        String csvInsertion = csvBubble;
        String csvSelection = csvInsertion;
        vetor.preencheVetor();
        long startTime;
        long tempo;
        long endTime; 
        
        for (int i = 1; i <= 20; i++){
            // BubbleSort
            startTime = System.currentTimeMillis();
            vetor.bubbleSort();
            endTime = System.currentTimeMillis();
            tempo = endTime-startTime;
            System.out.println("BubbleSort " + i + ": \t" + tempo);
            csvBubble += i + "," +  tempo + "\n";

            vetor.resetVetor();
            vetor.preencheVetor();

            // Insertion Sort
            startTime = System.currentTimeMillis();
            vetor.insertionSort();
            endTime = System.currentTimeMillis();
            tempo = endTime-startTime;
            System.out.println("Insertion " + i + ": \t" + tempo);
            csvInsertion += i + "," +  tempo + "\n";

            vetor.resetVetor();
            vetor.preencheVetor();

            // Selection
            startTime = System.currentTimeMillis();
            vetor.selectionSort();
            endTime = System.currentTimeMillis();
            tempo = endTime-startTime;
            System.out.println("Selection " + i + ": \t" + tempo);
            csvSelection += i + "," +  tempo + "\n";

            vetor.resetVetor();
            vetor.preencheVetor();
        }
        String bubblePath = "BubbleSortResultados" + tamanho + ".csv";
        String insertionPath = "InsertionSortResultados" + tamanho + ".csv";
        String selectionPath = "SelectionSortResultados" + tamanho + ".csv";

        if (escreverArquivo(csvBubble, bubblePath) == false){
			System.out.println("Erro ao criar arquivo CSV do bubbleSort");
            System.out.println("################## Arquivo Bubble #################");
            System.out.print(csvBubble);
            System.out.println("###################################################");
		}
        if (escreverArquivo(csvInsertion, insertionPath) == false){
			System.out.println("Erro ao criar arquivo CSV do insertionSort");
            System.out.println("################# Arquivo Insertion ################");
            System.out.print(csvInsertion);
            System.out.println("###################################################");
		}
        if (escreverArquivo(csvSelection, selectionPath) == false){
			System.out.println("Erro ao criar arquivo CSV do selectionSort");
            System.out.println("################ Arquivo Selection ################");
            System.out.print(csvSelection);
            System.out.println("###################################################");
		}
    }

    private static boolean escreverArquivo(String dados, String path){
        File file = new File(path);
        try{
            FileWriter fw = new FileWriter(file);
            fw.write(dados);
            fw.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
