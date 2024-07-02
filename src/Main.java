import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void printMatrix(Long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String MatrixtoString(Long[][] matrix) {
        int k = 0;
        String text = "Tamanho do array | Bubble | Insertion | Selection | Heap | Shell | Merge | Quick\n";
        text = text.concat("--- | --- | --- | --- | --- | --- | --- | ---\n");
        for (int i = 0; i < matrix.length; i++) {
            int array_size = 128 * (int) Math.pow(2, k);
            text = text.concat(array_size + "|");
            k++;
            for (int j = 0; j < matrix[i].length; j++) {
                text = text.concat(matrix[i][j] + "|");
            }
            text = text.concat("\n");
        }
        return text;
    }


    public static long removeOutliers(long[] tests, int quantityTests, long sumTime) {
        long average = sumTime / quantityTests;
        long variance = 0;
        long stddev;
        long final_average = 0;
        int count = 0;

        for (int k = 0; k < quantityTests; k++) {
            variance += Math.pow((tests[k] - average), 2);
        }

        variance = variance / (quantityTests - 1);
        stddev = (long) Math.sqrt(variance);

        for (int k = 0; k < quantityTests; k++) {
            if (tests[k] < (average + stddev) && tests[k] > (average - stddev)) {
                final_average += tests[k];
                count++;
            } else {
            }
        }
        return final_average / count;
    }

    public static long runXTestsBubble(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.bubbleSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static long runXTestsInsertion(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.insertionSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static long runXTestsSelection(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.selectionSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static long runXTestsHeap(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.heapSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static long runXTestsShell(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.shellSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static long runXTestsMerge(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.mergeSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static long runXTestsQuick(Integer[] array, int quantityTests) {
        long sumTime = 0;
        long[] tests = new long[quantityTests];

        for (int k = 0; k < quantityTests; k++) {
            Integer[] array_clone = array.clone();
            long startTime = System.nanoTime();
            Sorting.quickSort(array_clone);
            long endTime = System.nanoTime();
            tests[k] = (endTime - startTime);
            sumTime += tests[k];
            System.out.println(tests[k]);
        }
        return removeOutliers(tests, quantityTests, sumTime);
    }

    public static void main(String[] args) throws IOException {

        //Bubble Sort, Insertion Sort,
        //Selection Sort, Heap Sort, Shell Sort, Merge Sort e Quick Sort.


        int lines = 10; // 10 lines in the table
        int Xtests = 10;

        Long[][] SortedUniqueRandomArrays = new Long[10][7];
        for (int i = 0; i < lines; i++) {
            int j = 0;
            int array_size = 128 * (int) Math.pow(2, i);
            Integer[] array = Random_Arrays.generateSortedUniqueRandomArray(array_size);
            SortedUniqueRandomArrays[i][j] = runXTestsBubble(array, Xtests);
            j++;
            SortedUniqueRandomArrays[i][j] = runXTestsInsertion(array, Xtests);
            j++;
            SortedUniqueRandomArrays[i][j] = runXTestsSelection(array, Xtests);
            j++;
            SortedUniqueRandomArrays[i][j] = runXTestsHeap(array, Xtests);
            j++;
            SortedUniqueRandomArrays[i][j] = runXTestsShell(array, Xtests);
            j++;
            SortedUniqueRandomArrays[i][j] = runXTestsMerge(array, Xtests);
            j++;
            SortedUniqueRandomArrays[i][j] = runXTestsQuick(array, Xtests);

        }


        Long[][] SortedUniqueDescendingArray = new Long[10][7];
        for (int i = 0; i < lines; i++) {
            int j = 0;
            int array_size = 128 * (int) Math.pow(2, i);
            Integer[] array = Random_Arrays.generateSortedUniqueDescendingArray(array_size);
            SortedUniqueDescendingArray[i][j] = runXTestsBubble(array, Xtests);
            j++;
            SortedUniqueDescendingArray[i][j] = runXTestsInsertion(array, Xtests);
            j++;
            SortedUniqueDescendingArray[i][j] = runXTestsSelection(array, Xtests);
            j++;
            SortedUniqueDescendingArray[i][j] = runXTestsHeap(array, Xtests);
            j++;
            SortedUniqueDescendingArray[i][j] = runXTestsShell(array, Xtests);
            j++;
            SortedUniqueDescendingArray[i][j] = runXTestsMerge(array, Xtests);
            j++;
            SortedUniqueDescendingArray[i][j] = runXTestsQuick(array, Xtests);
        }

        Long[][] RandomArrayWithDuplicates = new Long[10][7];
        for (int i = 0; i < lines; i++) {
            int j = 0;
            int array_size = 128 * (int) Math.pow(2, i);
            Integer[] array = Random_Arrays.generateRandomArrayWithDuplicates(array_size);
            RandomArrayWithDuplicates[i][j] = runXTestsBubble(array, Xtests);
            j++;
            RandomArrayWithDuplicates[i][j] = runXTestsInsertion(array, Xtests);
            j++;
            RandomArrayWithDuplicates[i][j] = runXTestsSelection(array, Xtests);
            j++;
            RandomArrayWithDuplicates[i][j] = runXTestsHeap(array, Xtests);
            j++;
            RandomArrayWithDuplicates[i][j] = runXTestsShell(array, Xtests);
            j++;
            RandomArrayWithDuplicates[i][j] = runXTestsMerge(array, Xtests);
            j++;
            RandomArrayWithDuplicates[i][j] = runXTestsQuick(array, Xtests);
        }


        Long[][] RandomUniqueArray = new Long[10][7];
        for (int i = 0; i < lines; i++) {
            int j = 0;
            int array_size = 128 * (int) Math.pow(2, i);
            Integer[] array = Random_Arrays.generateRandomUniqueArray(array_size);
            RandomUniqueArray[i][j] = runXTestsBubble(array, Xtests);
            j++;
            RandomUniqueArray[i][j] = runXTestsInsertion(array, Xtests);
            j++;
            RandomUniqueArray[i][j] = runXTestsSelection(array, Xtests);
            j++;
            RandomUniqueArray[i][j] = runXTestsHeap(array, Xtests);
            j++;
            RandomUniqueArray[i][j] = runXTestsShell(array, Xtests);
            j++;
            RandomUniqueArray[i][j] = runXTestsMerge(array, Xtests);
            j++;
            RandomUniqueArray[i][j] = runXTestsQuick(array, Xtests);
        }

        System.out.println("\nSortedUniqueRandomArrays");
        printMatrix(SortedUniqueRandomArrays);
        System.out.println("\nSortedUniqueDescendingArray");
        printMatrix(SortedUniqueDescendingArray);
        System.out.println("\nRandomArrayWithDuplicates");
        printMatrix(RandomArrayWithDuplicates);
        System.out.println("\nRandomUniqueArray");
        printMatrix(RandomUniqueArray);

        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter("output.md");

            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);

            // Writes the string to the file
            output.write("# Análise Comparativa dos Métodos de Ordenação - Trabalho Grau B Algoritmos Estruturas de dados\n");
            output.write("""
                    ## Nathália Ferrari
                    ## Para cada método de ordenação, foram realizados testes de desempenho em diferentes cenários. Os testes foram conduzidos em arrays de diferentes tamanhos e em quatro cenários distintos:<br />
                    - o Array ordenado em ordem crescente, sem valores repetidos;  <br />
                    - o Array ordenado em ordem decrescente, sem valores repetidos;<br />
                    - o Array aleatório sem valores repetidos; e<br />
                    - o Array aleatório com valores repetidos.<br />"""+
                    "Os resultados abaixo estão em nanosegundos e representam a média de todos os testes válidos\n\n");
            output.write("### SortedUniqueRandomArrays\n");
            output.write(MatrixtoString(SortedUniqueRandomArrays));
            output.write("\n### SortedUniqueDescendingArray\n");
            output.write(MatrixtoString(SortedUniqueDescendingArray));
            output.write("\n### RandomArrayWithDuplicates\n");
            output.write(MatrixtoString(RandomArrayWithDuplicates));
            output.write("\n### RandomUniqueArray\n");
            output.write(MatrixtoString(RandomUniqueArray));

            // Closes the writer
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
