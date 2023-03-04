import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.Arrays;

public class List<E> {
    private final int defaultCapacity = 10;
    private E[] array;
    private int initialCapacity;
    private int indis = 0;

    public int getIndis() {
        return indis;
    }

    public void setIndis(int indis) {
        this.indis = indis;
    }

    public List() {
        array = (E[]) new Object[defaultCapacity];
    }

    public List(E[] array, int initialCapacity) {
        setInitialCapacity(initialCapacity);
    }

    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        array = (E[]) new Object[initialCapacity];
    }

    public int size() {
        return indis;
    }

    public int getCapacity() {
        return this.array.length;
    }

    public void add(E data) {
        if (indis >= getCapacity()) {
            setInitialCapacity(getCapacity() * 2);
        }
        array[indis] = data;
        indis++;
    }

    public E get(int index) {
        return (E) this.array[index];
    }

    public void remove(int index) {
        if (index >= 0 && index < size()) {

            array[index] = null;
            for (int i = 0; i < size(); i++) {
                if (i >= index) {
                    array[i] = array[i + 1];
                }
            }
            this.indis--;
        }
    }

    public E set(int index, E data) {
        if (index >= 0 && index < size()) {
            array[index] = data;
            return array[index];
        }
        return null;
    }

    public String toString() {
        String out = "";
        if (size() > 0) {
            out += "[";
            for (int i = 0; i < size(); i++) {
                out += array[i];
                if (i != size() - 1) {
                    out += ",";
                }
            }
            out += "]";
            return out;
        }
        else {
            return "[]";
        }

    }

    public boolean isEmpty() {
        return size() < 1;
    }

    public int indexOf(E data) {
        for (int i = 0; i < size(); i++) {
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E data) {
        for (int i = size() - 1; i >= 0; i--) {
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public E[] toArray() {
        return array;
    }

    public List<E> sublist(int start, int finish) {
        List<E> sublists = new List<>();
        for (int i=start;i<=finish;i++){
            sublists.add(array[i]);
        }
        return sublists;
    }
    public void clear(){
        this.indis=0;
        this.array=(E[]) new Object[defaultCapacity];
    }
    public boolean contains(E data){
        for (int i = 0; i< size();i++){
            if (array[i]==data){
                return true;
            }
        }
        return false;
    }
}
