# Version-Http-Server
A Server to configure your program version

### Code Examples

- Register new handlers
```java     
/* Go to VersionServer.java */
public class VersionServer
{
    private final LicenseSystem licenseSystem;

    /* Go to the run() method */
    public void run()
    {
      ...
            /* Register here a new handler */
            List<AbstractRequestHandler> handlers = Arrays.asList(
                    new VersionHandler()
            );
      ...   
    }
}
```

- Methods
``SET``
``GET``

- See in Web
```
Syntax: http://localhost:PORT/CONTEXT/?method=METHOD [...]
Example: http://localhost:3030/version?method=SET&version=1.4
```
