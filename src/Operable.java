import java.util.List;

// T is the generic allowing reuse of same interface for different models

public interface Operable<T> {
    public List<T> findAll();
    public T find(int id);
    public void delete(int id);
    public void add(T obj);
    public void update(int id, T obj);
}
