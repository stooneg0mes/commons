# commons
A commons to help in plugin development.
Discontinued and not used project, public archive for those who wants to use or had this used through JitPack. But I will not be maintaining this anymore.

## Installation

### Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.stooneg0mes:commons:<TAG>'
}
```

### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.stooneg0mes</groupId>
    <artifactId>commons</artifactId>
    <version><TAG></version>
</dependency>
```

## Examples

### Storage examples

#### Connection
##### Preparing a SQLite connection
```java
SqlCredentials storageCredentials = SqlCredentials.builder()
    .parent(parentFile)
    .fileName("storage")
    .build();

SqlStorage storage = new SQLiteStorage();
```

##### Preparing a MySQL connection
```java
SqlCredentials storageCredentials = SqlCredentials.builder()
    .user("root")
    .database("test")
    .password("")
    .host("localhost")
    .build();

SqlStorage storage = new MySQLStorage();
```

##### Establishing connection
```java
storage.startConnection(storageCredentials);
```

#### Making a query
```java
Query deleteUserQuery = Query.builder()
    .query("DELETE FROM users WHERE UUID = ?")
    .values(UUID.randomUUID())
    .build();
        
storage.executeQuery(deleteUserQuery);
```

### Module examples

#### Module example
```java
public class ProductModule extends Module {

    private final ProductManager userManager = ...
    
    @Override
    public void handleEnable() {
        productManager.load();
    }

    @Override
    public void handleDisable() {
        productManager.save();
    }
    
}
```

#### Main class example (registering modules)
```java
public class MyPlugin extends CommonsPlugin {

    @Override
    public Module[] getModules() {
        return new Module[] {
            new ProductModule(),
            new UserModule()
        };
    }
    
}
```
