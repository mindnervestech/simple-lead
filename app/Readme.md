Endpoint of get __group customer by tags__
 
http://localhost:8080/customers/tag/group

```
{
  "CXO": [
    {
      "lastName": "Goyal",
      "email": "amit.goyal@gmail.com",
      "firstName": "Amit"
    }
  ],
  "Management": [
    {
      "lastName": "Singh",
      "email": "jagbir.paul@gmail.com",
      "firstName": "Jagbir"
    }
  ],
  "Vip": [
    {
      "lastName": "Singh",
      "email": "jagbir.paul@gmail.com",
      "firstName": "Jagbir"
    },
    {
      "lastName": "Goyal",
      "email": "amit.goyal@gmail.com",
      "firstName": "Amit"
    }
  ]
}
```

Endpoint to see __sales ageing for Lead to Prospect and Prospect to Customer__ 
http://localhost:8080/customers/sales/ageing

```
{
"Average days Ageing of Prospect":"6.4",
"Average days Ageing of Lead":"45.5"
}
```
Endpoint to get __Customer Sorted by firstname and pagination __

http://localhost:8080/customers?sortBy=firstName&pageNo=0&pageSize=10

__Example of pagination with pageSize one__
http://localhost:8080/customers?sortBy=firstName&pageNo=0&pageSize=1
http://localhost:8080/customers?sortBy=firstName&pageNo=1&pageSize=1
