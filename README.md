# commons
A commons to help in plugin development.

## Storage examples

### Making a MySQL connection
```
        SqlCredentials sqlCredentials = SqlCredentials.builder()
            .user("root")
            .database("test")
            .password("")
            .host("localhost")
            .build();

        SqlStorage sqlStorage = new MySQLStorage();
        sqlStorage.startConnection(sqlCredentials);
```

### Making a query
```
        Query deleteUserQuery = Query.builder()
            .query("DELETE FROM users WHERE UUID = ?")
            .values(UUID.randomUUID())
            .build();
        
        sqlStorage.executeQuery(deleteUserQuery);
```
