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
