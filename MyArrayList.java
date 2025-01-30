import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> {
    private Object[] array; // массив для хранения объектов
    private int size; // количество элементов в массиве

    // конструктор создает массив из количества элементов x
    public MyArrayList(int x) {
        array = new Object[x];
        size = 0;
    }

    // метод добавки элемента
    public void add(T element) {
        if (size == array.length) { // проверяем есть ли в массиве место
            array = Arrays.copyOf(array, array.length * 2); // копируем в новый массив элементы из старого массива
        }
        array[size] = element; // записываем новое значение
        size++; // увеличиваем значение количества элементов в массиве
    }


    public void add(int index, T element) {
        array[index] = element; // записываем новое значение

    }
    // Метод для получения размера списка

    public int getSize() {
        return size;
    }

    // Метод для получения элемента по индексу
    public void get(int index) {
        System.out.println(array[index]); // приведение типа
    }

    //метод для вывода списка на экран
    public void display() {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

    //метод для очистки списка
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    //метод удаления элемента по индексу
    public void remove(int index) {
        // System.arraycopy(array, 0, array, 0, index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        array[size] = null;
    }


    // QuickSort, принимает компаратор, если требуется пользовательская сортировка
    public void quickSort(Comparator<? super T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    // Вспомогательный метод для QuickSort
    private void quickSort(int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator); // сортируем элементы до опорного
            quickSort(pi + 1, high, comparator); // сортируем элементы после опорного
        }
    }

    // Метод разделения и перестановки элементов
    private int partition(int low, int high, Comparator<? super T> comparator) {
        T pivot = (T) array[high]; // используем последний элемент как опорный
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Используем компаратор для сравнения
            if (comparator.compare((T) array[j], pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high); // ставим опорный элемент на свое место
        return i + 1; // возвращаем индекс опорного элемента
    }

    // Метод для обмена двух элементов
    private void swap(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
