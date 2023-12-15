package lk.ijse.vehicle_rental.dao;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO{
    public T search(String id) throws SQLException, ClassNotFoundException;
    public boolean add(T entity) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean update(T entity) throws SQLException, ClassNotFoundException;
}
