package net.stonegomes.commons.storage;

import net.stonegomes.commons.storage.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlReader<T> {

    T read(ResultSet resultSet) throws SQLException;

    Query buildReplaceQuery(T value);

    Query buildDeleteQuery(Object object);

}
