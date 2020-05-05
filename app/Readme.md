## Data Model
There are three main model used in the  Lead , Prospect and Customer. 

I have intentionally kept three separate model rather the having one Entity and adding some flag to denote Customer, prospect and Lead.
I do not like idea of having one Entity, as business relevance for three are different. Lead and prospect data are  archival in nature and also lead and prospect have higher degree of irrelevant data. Whereas it is not the case with the Customer. I would like to name Customer as Account as it is more apt and align with CRM terminology.

there is one common field call sales_guid this is carried forward from Lead -> Prospect -> Customer. This is important field as we can use this field for any tracebility purpose. I prefer and avoid to use the FK key of Lead and Prospect Entity to be used in the other Entity. Simple reason for that these entity are archival in nature and they had have purge policy. Using FK of such tables is not recommened.  

CustomExtraAttribute and CustomFieldDefination are model used to give flexibility to add extra fields to the Customer record and also give the admin ability to add the definition of CustomField. 

Please note this is note the multi-tenancy Datamodel. If we need to add multi-tenancy we need to add extra coulmn may be for each table.



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

Above is involves calculation. I would prefer to have the stored procedure doing this part rather than doing it in Java layer.   


Endpoint to get __Customer Sorted by firstname and pagination __

http://localhost:8080/customers?sortBy=firstName&pageNo=0&pageSize=10

```
[
  {
    "firstName": "Amit",
    "lastName": "Goyal",
    "company_name": "Vodaphone",
    "secondary_email": "amit.goyal@yahoo.com",
    "email": "amit.goyal@gmail.com"
  },
  {
    "firstName": "Jagbir",
    "lastName": "Singh",
    "company_name": "Mindnerves",
    "secondary_email": "jagbir_paul@yahoo.com",
    "email": "jagbir.paul@gmail.com"
  }
]
```
Please note __company_name__ and __secondary_email__ are __extra custom attributes__.

__Example of pagination with pageSize one__
http://localhost:8080/customers?sortBy=firstName&pageNo=0&pageSize=1
http://localhost:8080/customers?sortBy=firstName&pageNo=1&pageSize=1

###Do mvn install first 

### With Docker
docker build -t simplelead .
docker run -p 8080:8080 -t simplelead:latest

### With Docker Compose 
docker-compose up
 
### without docker
 
java -jar target/<name of jar file>.jar