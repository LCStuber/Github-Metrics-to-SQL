import java.util.Random;

public class SortingProgram2 {
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
        int testsAmount = getTotalTestsAmount();

        System.out.println("Vetor ordenado:");
        printArray(numbers);

        // Criar tabela e inserir dados
        MetricsTableCreator.createMetricsTable();
        MetricsTableCreator.insertMetricsData(linesOfCode, endTime - startTime, attemptFails, testsAmount);

        // Executar Bubble Sort 100 vezes
        for (int i = 0; i < 100; i++) {
            bubbleSort(numbers);
        }
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
        String code = // Read your code from files or other sources
        String[] lines = code.split("\n");
        return lines.length;
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

    // Métrica: Quantidade total de testes
    public static int getTotalTestsAmount() {
        int testsAmount = // Count your total tests
        return testsAmount;
    }
}
