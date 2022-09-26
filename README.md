### This is the currency service for Gamehub application

This service uses an external api from https://apilayer.com/ to get the total price after converted

example usage:
http://localhost:8100/currency-converter/from/eur/to/idr/quantity/100

will return:
```
{
    "success": true,
    "query": {
        "from": "EUR",
        "to": "IDR",
        "amount": 100
},
    "info": {
        "timestamp": 1664204404,
        "rate": 14607.745427
},
    "date": "2022-09-26",
    "result": 1460774.5427
}
```


### To build the currency service and run in docker containers
```mvn clean package && docker compose up --build currency-service```  
