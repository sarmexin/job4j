package stream;


import java.util.ArrayList;
import java.util.List;

public class Collect<T> {
    List<T> list = new ArrayList();

    public void listAdd(T a, T b, T c, T d) {
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
    }

    public void listDelete() {
        list.clear();
    }

}
