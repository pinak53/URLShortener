# URLShortener
### Overview
This web service provides a mechanism for shortening URLs and retrieving them back based on the key.

### Endpoints
The following endpoint is used to retrieve the long url for which a short url has been generated. The short url contains a key as the path which can be used to retrieve the long url. This key is passed as the param to the GET request. 

Upon successful retrieval of the long url the request would be redirected appropriately.
#### GET /URLShortener/rest/{key}


The following endpoint is used to generate the short url for a given long url. 
#### POST /URLShortener/rest/shorten

You can pass the long url as part of the body in JSON format.
```
{
  "url": "www.amazon.com"
}
```

This is what the response body would look like 
```
{
  "shortUrl":"http://goldbely.us/xMBK1PkKR",
  "longUrl":"www.amazon.com"
}
```
Optionally, you can also provide the slug as part of the body as shown below.

```
{
  "url": "www.google.com",
  "slug": "123456789"  
}
```
This is what the response body would look like in this case
```
{
  "shortUrl":"http://goldbely.us/123456789",
  "longUrl":"www.google.com"
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
5) Provide endpoint to retrieve the long url based on short url. This can be done by passing the short url (url encoded) as a parameter to the get request.



