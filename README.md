# commons
A commons to help in plugin development.

## Installation

### Gradle
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.stooneg0mes:commons:-16e417d408-1'
}
```

### Maven
```
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.stooneg0mes</groupId>
    <artifactId>commons</artifactId>
    <version>-16e417d408-1</version>
</dependency>
```

## Examples

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

### Module examples

#### Module example
```
public class UserModule extends Module {

    private final UserCache userCache = ...
    
    @Override
    public void handleEnable() {
        userCache.load();
    }

    @Override
    public void handleDisable() {
        userCache.save();
    }
    
}
```

#### Main class example (registering modules)
```
public class MyPlugin extends CommonsPlugin {

    @Override
    public Module[] getModules() {
        return new Module[] {
            new UserModule(),
            new ProductModule()
        };
    }
    
}
```
