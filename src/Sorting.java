import java.util.Arrays;

//  Bubble Sort, Insertion Sort,
//Selection Sort, Heap Sort, Shell Sort, Merge Sort e Quick Sort.

public class Sorting {

    public static Integer[] bubbleSort(Integer[] array_unsorted){
        Integer[] array = array_unsorted.clone();
        boolean changed;
        do{
            changed = false;
            for (int i = 0; i < array.length - 1; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    changed = true;
                }
            }
        }while(changed);
        return array;
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        sort(a, 0, a.length - 1);
    }
    private static <T extends Comparable<? super T>> void sort(T[] a, int low,
                                                               int high) {
        if (low >= high) return;
        int p = partition(a, low, high);
        sort(a, low, p - 1);
        sort(a, p + 1, high);
    }
    private static <T extends Comparable<? super T>> int partition(T[] a, int low, int high) {
        int middle = low + (high - low) / 2;
        T pivot = a[middle];
        exchange(a, middle, high); // Move the pivot to the end for partitioning
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                exchange(a, ++i, j);
            }
        }
        exchange(a, i + 1, high);
        return i + 1;
    }


    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1].compareTo(a[j]) > 0; j--) {
                exchange(a, j - 1, j);
            }
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
        for (int min, i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            exchange(a, min, i);
        }
    }

    // Método heapify para manter a propriedade do heap máximo
    public static <T extends Comparable<? super T>> void heapify(T[] a, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // Se o filho da esquerda é maior que a raiz
        if (leftChild < heapSize && a[leftChild].compareTo(a[largest]) > 0) {
            largest = leftChild;
        }

        // Se o filho da direita é maior que o maior até agora
        if (rightChild < heapSize && a[rightChild].compareTo(a[largest]) > 0) {
            largest = rightChild;
        }

        // Se o maior não é a raiz
        if (largest != rootIndex) {
            exchange(a, rootIndex, largest);
            // Recursivamente heapificar a subárvore afetada
            heapify(a, heapSize, largest);
        }
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] a) {
        int n = a.length;

        // Construir o heap (reorganizar o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // Extrair um elemento de cada vez do heap
        for (int i = n - 1; i > 0; i--) {
            exchange(a, 0, i);

            // Chamar heapify na heap reduzida
            heapify(a, i, 0);
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int h = 1;
        while (3 * h + 1 < a.length) h = 3 * h + 1;
        while (h > 0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j - h].compareTo(a[j]) > 0; j -= h) {
                    exchange(a, j - h, j);
                }
            }
            h /= 3;
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        // Mescla os subarrays left e right em array
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copia os elementos restantes de left, se houver
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copia os elementos restantes de right, se houver
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Método mergeSort genérico
    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Divide o array em dois subarrays
            T[] left = Arrays.copyOfRange(array, 0, mid);
            T[] right = Arrays.copyOfRange(array, mid, array.length);

            // Recursivamente ordena os subarrays
            mergeSort(left);
            mergeSort(right);

            // Mescla os subarrays ordenados
            merge(array, left, right);
        }
    }



}
