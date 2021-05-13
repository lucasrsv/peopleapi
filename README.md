# peopleapi-springboot
A simple Rest API with CRUD operations made using Java 11, SpringBoot 2.4.5 and Maven 3.8.1, during the Code Anywhere Bootcamp - DIO.

To run it, type the following command in your terminal:
```shell script
mvn spring-boot:run 
```

Then, you can do the requests using the following url:
```
http://localhost:8080/api/v1/people
```

Here are some examples of how the requests must be done:

* <h4>Create Person</h4>

You just need to pass the id in the URL
URL: ```http://localhost:8080/api/v1/people```

Body of the request:
```json
{
    "firstName": "Lucas",
    "lastName": "Rodrigues",
    "cpf": "574.251.940-07",
    "birthDate": "20-06-2000",
    "phones": [
        {
            "type": "MOBILE",
            "number": "(11)999999999" 
        }
    ]
}
```

* <h4>Get person by id</h4>
You just need to pass the id of the person in the URL, like that: ```http://localhost:8080/api/v1/people/1```

* <h4>Update person by id</h4>
You need to pass the id of the person in the URL (like in the GET method), as well as in the body. If you're updating a phone number, you also need to pass it's id in the body.

Body of the request:
```json
{
    "id": "2",
    "firstName": "Lucas",
    "lastName": "Valença",
    "cpf": "574.251.940-07",
    "birthDate": "20-06-2000",
    "phones": [
        {
            "id": "1",
            "type": "MOBILE",
            "number": "(11)999999919" 
        }
    ]
}
```

* <h4>Delete person by id</h4>
You just need to pass the id of the person, like in the GET method.

-----------------

This project is also available in heroku: ```https://peopleapi-lucas.herokuapp.com/api/v1/people```
