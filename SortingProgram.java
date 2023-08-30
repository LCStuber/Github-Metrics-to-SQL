import java.util.Random;

public class SortingProgram {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();

        // Preenchendo o vetor com números aleatórios
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        System.out.println("Vetor desordenado:");
        printArray(numbers);

        // Aplicando o algoritmo de Bubble Sort (com erros)
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1) {
                    // Trocando os elementos de posição
                    int temp = numbers[i];
                    numbers[i] = numbers[i];
                    numbers[i] = temp; // Erro aqui: deveria ser numbers[i + 1] = temp;

                    swapped = true;
                }
            }
        } while (swapped);

        System.out.println("\nVetor ordenado:");
        printArray(numbers);
    }

    // Função para imprimir o vetor
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
