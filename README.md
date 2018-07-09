# URLShortener
### Overview

### Endpoints
#### GET /URLShortener/rest/{key}

#### POST /URLShortener/rest/shorten

```
{
  "url": "www.google.com"
}
```
Optionally, you can also provide the slug as part of the body.

```
{
  "url": "www.google.com",
  "slug": "123456789"  
}
```

### Deployment
This project makes use of maven for dependency management and build. Use the following command from the root directory of the project.

Compile
```mvn clean compile```

Run tests
```mvn clean test```

Build
```mvn clean install```


### Future Scope
1) Configure a DB for persistent storage and have the DAO communicate with the DB
2) The current key generator algorithm generates keys randomly.(We can update the algorithm to be more sophisticated i.e generate keys based of a counter using base 62 conversion).
3) Allow properties like domain, key length etc to be configurable using properties or some other mechanism. They are being used as constants.
4) Add more testing like rest client to test end points, integration testing etc



