import java.util.Arrays;
import java.util.Random;

public class Random_Arrays {

    static int maximum_value = 100000;

    //Array ordenado em ordem crescente, sem valores repetidos;

    public static Integer[] generateSortedUniqueRandomArray(int n) {
        Random random = new Random();
        Integer[] array = new Integer[n];

        // Preencher o array com números únicos
        for (int i = 0; i < n; i++) {
            int randomNumber;
            // Gerar um número aleatório e verificar se já existe no array
            do {
                randomNumber = random.nextInt(maximum_value); // Números aleatórios entre 0 e 99 (ajustável conforme necessário)
            } while (contains(array, i, randomNumber)); // Verificar se o número já está no array

            array[i] = randomNumber;
        }

        // Ordenar o array em ordem crescente
        Arrays.sort(array);

        return array;
    }

    // Método auxiliar para verificar se um número está presente no array
    private static boolean contains(Integer[] array, int length, int number) {
        for (int i = 0; i < length; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }
// Array ordenado em ordem decrescente de tamanho n, sem valores repetidos;
public static Integer[] generateSortedUniqueDescendingArray(int n) {
    Random random = new Random();
    Integer[] array = new Integer[n];

    // Preencher o array com números únicos
    for (int i = 0; i < n; i++) {
        int randomNumber;
        // Gerar um número aleatório e verificar se já existe no array
        do {
            randomNumber = random.nextInt(maximum_value); // Números aleatórios entre 0 e 99 (ajustável conforme necessário)
        } while (contains(array, i, randomNumber)); // Verificar se o número já está no array

        array[i] = randomNumber;
    }

    // Ordenar o array em ordem decrescente
    Arrays.sort(array);
    reverseArray(array);

    return array;
}

    // Método auxiliar para inverter a ordem do array
    private static void reverseArray(Integer[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Trocar elementos left e right
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Mover os índices para o próximo par de elementos
            left++;
            right--;
        }
    }

    // Array aleatória sem valores repetidos de tamanho n
    // Método para gerar um array de inteiros aleatórios únicos
    public static Integer[] generateRandomUniqueArray(Integer n) {
        Random random = new Random();
        Integer[] array = new Integer[n];

        // Preencher o array com números únicos
        for (int i = 0; i < n; i++) {
            int randomNumber;
            // Gerar um número aleatório e verificar se já existe no array
            do {
                randomNumber = random.nextInt(maximum_value); // Números aleatórios entre 0 e 99 (ajustável conforme necessário)
            } while (contains(array, i, randomNumber)); // Verificar se o número já está no array

            array[i] = randomNumber;
        }

        return array;
    }

    //Array aleatória com valores repetidos
    public static Integer[] generateRandomArrayWithDuplicates(int n) {
        Random random = new Random();
        Integer[] array = new Integer[n];

        // Preencher o array com números aleatórios
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(maximum_value); // Números aleatórios entre 0 e 99 (ajustável conforme necessário)
        }

        return array;
    }


}
