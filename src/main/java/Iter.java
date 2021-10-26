
import java.util.Iterator;
import java.util.function.Consumer;

public class Iter<E> implements Iterator <E> {
    private int index = 0;
    private E[] elements;

    Iter(E[] values) {
        this.elements= values;
    }

    @Override
    public boolean hasNext() {
        return index < elements.length;
    }

    @Override
    public E next() {
        index++;
        return elements [index];
    }

    public void remove() {

    }

    public void forEachRemaining(Consumer<? super E> action) {
    }

}
