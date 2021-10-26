import java.util.*;
import java.util.stream.Collectors;

/** Даем нашему класу наследовать готовый список, объявляем массив, который содержит объекты и называем его.
//Кол-во объектов равно нулю. И говорим, что вместимость у нас 12 ячейек, куда можно записать данные
 */
public class AList<E> implements List<E> {
    public Object[] elements;
    public int size = 0;
    public static int defaultCapacity = 12;

    //Говорим, что в массиве лежат объекты
    public AList() {
        elements = (E[]) new Object[defaultCapacity];
    }
    /** А это еще один список. В этот раз мы не задаем емкость, просто вводим переменную. Если она меньше равно нуля,
    то пользователя попросит передать соответсвующий аргумент.
    */
    public AList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = (E[]) new Object[initialCapacity];
    }
    /** возвращает кол-во заполненных ячеек в массиве
    */
    public int size() {
        return size;
    }

    /** с помощью метода можем проверить пустой массив или нет.
    */
    public boolean isEmpty() {
        return size == 0;
        }
    /**Проверяем есть ли в массиве элементы, начиная от первого значения и до конца size (то есть все ячейки где есть
    значение). Если там что-то есть - значит в массиве содержаться элементы.
    */
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals((Object) elements[i])) {
                return true;
            }
        }
        return false;
    }
    /**
    У меня отдельным класом Итератор Итер, наследующий метод Итератор. Позволяет пройтись по массиву, и с помощью
    методов получить значение (next) и узнать есть ли следующее и не закончился ли массив (hasNext).
   */
     public Iterator <E> iterator() {
        return new Iter<E>((E[]) elements);
    }
    /** Возвращаем массив
    */
    public Object[] toArray() {
        return new Object[0];
    }

    public <E> E[] toArray(E[] a) {
        return null;
    }

    /**Удаляет элементы и у нас снова пустые ячейки.
    */
    public void clear() {
        size = 0;
        elements = (E[]) new Object[defaultCapacity];

    }
    /**Если нужно вытащить какое-то значение по индексу, просим сделать это.
    */
    public E get(int index) {
        return (E) elements [index];
    }

    /**Указываем новый индекс и замещаем один элемент другим.
    */
    public E set(int index, E element) {
        elements[index] = element;
        return element;
    }
    /**Проверяем можем ли дальше добавлять значния в массив.
    */
    public boolean add(E element) {
        elements[size] = element;
        size++;
        return false;
    }

    /**Добавление по индексу. Проверяем достаточно ли места для добавления нового значения в средину списка и делаем
    ресайз если нужно. Вырезаем значения начиная с нужного места и вставляем значение на ячейку дальше.
    */
    public void add(int index, E element) {
        if (index < 0 || index >= elements.length) {
            resize();
        }
        System.arraycopy(elements, index, elements, index+1, size-index);
        elements[index] = element;
        size++;
    }
    /**Удаляем элемент по индексу и смещаем все значение на место удаленного элемента.
    */public E remove(int index) {
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index+1, elements, index, size - index - 1);
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**Меняем длинну массива. В случае, если длинна (все ячейки) заполнена, то создаем новый масив temp,
    длинна которого в два раза больше нашего прежнего масива. Дальше закоментировано кусок кода - более простой путь.
    Так мы вызываем метод, который копирует наш массив (прежний масив, ячейка с которой начинаем копироватьб новый
    массив, опять значение с которого начинаем записывать и размер). И приравниваем прежний массив к новому.
    Или все то же самое через for. Пока любое значение меньше длинны массива - записываем в след. ячейку. Но если уже
    некуда (!= значит не равно), то берем новый массив, куда должны попасть все объекты c предыдущего.
    */
    private void resize () {
        if (elements.length == size) {
            Object[] temp = new Object[elements.length * 2];
            //System.arraycopy(elements, 0, temp, 0, size);
            // elements = temp;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null) {
                    temp[i] = elements[i];
                    elements = (E[]) temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Наш массив: " + Arrays.toString(elements) +
                ", кол-во заполненных ячеек = " + size;
    }

    /** Создаем и называем метод
     */
    public void bubbleSort() {
        /** Определяем, что для нас значит "отсортировано"
         * если список не отсортирован - приступаем к сортировке пока он не станет отсортирован
         * если хоть одна сортировка состоялась, сбрасываем в false (нижняя строка в цикле)
         */
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            /**определяем с чем работаем (значение, сравнение с кол-вом заполненных ячеек, переход в следующую)
             */
            for (int i = 1; i < this.size; i++) {

                /**если значение в ячейке меньше соседней, то берем временную инт и присваиваем ей меньшее значение
                 * делаем замену: вместо одного порядка следования устанавливаем противоположный
                 */
                if (((Comparable)this.get(i)).compareTo((Comparable)(this.get(i - 1))) < 0){
                    Object temp = this.get(i);
                    this.set(i, this.get(i - 1));
                    this.set(i - 1, (E) temp);
                    isSorted = false;
                }
            }
            System.out.println(this.toString()); //Выводим значения массива
        }
    }


   /*
    public void quickSort () {
        Arrays.stream(elements)
                .filter(e -> e != null)
                .collect(Collectors.toList())
                .toArray();
        Arrays.sort(elements);
    }
   public void quickSort (Comparator comparator) {
        int low = 0;
        int high = elements.length -1;

        if (comparator == null) {
            throw new RuntimeException("Comparator can't be null");
        }

        if (elements.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Object pivot = elements [middle];

        int a = low, b = high;
        while (a <= b) {
            while (comparator.compare(elements[a], pivot) > 0) {
                a++;
            }

            while (comparator.compare(elements[b], pivot) < 0) {
                b--;
            }

            if (a <= b) {
                Object temp = elements[a];
                elements[a] = elements[b];
                elements[b] = temp;
                a++;
                b--;
            }
        }

        if (low < b) {
            quickSort(comparator);
        }

        if (high > a) {
            quickSort(comparator);
        }
    }*/

}
