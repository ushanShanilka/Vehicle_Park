package lk.ijse.vehiclepark.dao;

import java.util.List;

public interface CrudDAO<T ,ID>  {
    public boolean save(T t);
    public boolean delete( ID id);
    public boolean update(T t);
    public List<T> getAll();
    public T get(ID id);
    public List<T> loadAll();
}
