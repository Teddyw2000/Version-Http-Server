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
            /* Register a new handler here */
            List<AbstractRequestHandler> handlers = Arrays.asList(
                    new VersionHandler()
            );
      ...   
    }
}
```

- Methods: 
`SET`
`GET`


#### Example
URL | Context | Method | Version
------------ | ------------- | ------------- | -------------
http://localhost/ | version | ?method=SET | &version=2.0

