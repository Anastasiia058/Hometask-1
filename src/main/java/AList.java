import java.util.*;
import java.util.stream.Collectors;

/** It is the realization of the ArrayList
 * @param <E>
 */
public class AList<E> implements List<E> {
    /**
     * In this array we store elements
     */
    private Object[] elements;
    /**
     * The number of elements in the array
     */
    private int size = 0;
    /**
     * Initial capacity of the array
     */
    private static int initialCapacity = 12;
    /**
     * Default capacity of the array
     */
    private static int defaultCapacity = 5;

    /**
     * @param initialCapacity (must be not zero)
     * @throws IllegalArgumentException
     */
    public AList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = (E[]) new Object[initialCapacity];
    }

    public AList() {
        elements = (E[]) new Object[defaultCapacity];
    }

    /**
     * @return size
     */
    public int size() {

        return size;
    }
    /**
     * @return true if the container is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * @param element The object with same type as E
     * @return true, if the collection contains the incoming object
     * Method uses the equals method
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
     * @see {@link Iter} There is Iter, which describes Iterator
     */
    public Iterator<E> iterator() {

        return new Iter<E>((E[]) elements);
    }
    /**
     * @return the new object E[]
     */
    public Object[] toArray() {
        return elements;
    }
    /**
     * @return null
     */
    public <E> E[] toArray(E[] a) {
        return (E[]) elements;
    }
    /**
     * Method deletes all elements of the array and reduce the capacity to the initial capacity
     */
    public void clear() {
        size = 0;
        elements = (E[]) new Object[defaultCapacity];

    }
    /**
     * @param index
     * @return the element by the index
     */
    public E get(int index) {

        return (E) elements[index];
    }
    /**
     * @param index
     * @return the element
     */
    public E set(int index, E element) {
        elements[index] = element;
        return element;
    }
    /**
     * @param element
     * @return false
     */
    public boolean add(E element) {
        if (elements.length == size) {
            resize();
        }
        elements[size] = element;
        size++;
        return true;
    }
    /**
     * @param index
     * @param element
     * Resize the array if the length of the array is full
     */
    public void add(int index, E element) {
        if (index >= elements.length) {
            resize();
        }
        elements[index] = element;
        size++;
    }
    /**
     * @param index of the element, which will be removed
     * @return element by index
     */
    public E remove(int index) {
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
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

    /**
     * Describes the way we can make a resize ot the array
     */
    private void resize() {
        if (elements.length == size) {
            Object[] temp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, size);
            elements = temp;
                }
            }

    /**
     * @return the new array E[] and it's size
     */
    @Override
    public String toString() {
        return "Наш массив: " + Arrays.toString(elements) +
                ", кол-во заполненных ячеек = " + size;
    }

    /**
     * Method realize bubbleSort algorithm
     *
     * @return The sorted array
     */
    public void bubbleSort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < this.size; i++) {
                if (((Comparable) this.get(i)).compareTo((Comparable) (this.get(i - 1))) < 0) {
                    Object temp = this.get(i);
                    this.set(i, this.get(i - 1));
                    this.set(i - 1, (E) temp);
                    isSorted = false;
                }
            }
            System.out.println(this.toString()); //Выводим значения массива
        }
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


