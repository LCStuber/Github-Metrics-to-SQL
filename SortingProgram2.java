import java.util.Random;

public class SortingProgram2 {
    static int testsAmount = 0;

    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();

        // Preenchendo o vetor com números aleatórios
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        // Obter métricas
        int linesOfCode = getLinesOfCode();
        long startTime = System.nanoTime();
        bubbleSort(numbers);
        long endTime = System.nanoTime();
        int attemptFails = connectWithDatabase();

        System.out.println("Vetor ordenado:");
        printArray(numbers);

        // Criar tabela e inserir dados
        MetricsTableCreator.insertMetricsData(linesOfCode, attemptFails, endTime - startTime, ++testsAmount);

        // Executar Bubble Sort 100 vezes
        for (int i = 0; i < 100; i++) {
            bubbleSort(numbers);
        }
        main(args);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Função para imprimir o vetor
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Métrica: Linhas de código do programa
    public static int getLinesOfCode() {
        return 72;
    }

    // Métrica: Tentativas falhas de conexão com banco de dados
    public static int connectWithDatabase() {
        int attemptFails = 0;
        try {
            // Attempt to connect with the database
        } catch (Exception e) {
            attemptFails++;
        }
        return attemptFails;
    }
}
