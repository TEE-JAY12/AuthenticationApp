
**This application allows for secure user authentication and profile management.**

To access the application, please use the following link: http://localhost:8080/. Once you have accessed the application, you will see that it contains three main endpoints. These endpoints can be found in the welcome controller and are as follows:

1.adduser (http://localhost:8080/adduser) - This endpoint is used to register a new user.
2.authenticate (http://localhost:8080/authenticate) - This endpoint is used to login and authenticate a user.
3.edituser (http://localhost:8080/edituser) - This endpoint is used to edit a user's profile information after authentication.

To set up the application, please follow these guidelines:

1. Clone the repository using the code provided.
2. Add your database configurations in the application.properties file.
3. Run the application.



**Usage Guidelines:**

1. To use the application, please follow these guidelines:

2. Start by cloning the repository using the code below.

3. Add your database configurations to the application.properties file.
Run the application. It should run by default on port 8080.

4. Open Postman and carry out a POST operation at http://localhost:8080/adduser to create an account. In the request body, supply the following parameters:

{
"userName": "Jesutobi",
"password" : "Femi",
"email" : "JT@gmail.com",
"phoneNumber" : "08165065551"
}

5. Move on to the next stage and try to authenticate into the application using a similar method. Supply your username and password in the request body and carry out a POST operation at http://localhost:8080/authenticate. In the request body, supply the following parameters:
{
"userName": "Jesutobi",
"password" : "Femi",
"email" : "JT@gmail.com",
"phoneNumber" : "08165065591"
}

6. To make any changes to your user details, you have to be authenticated. After being authenticated, copy the JWT Token and put it in the Authorization tab of Postman. Leave a space between "Bearer" and the token, as follows: "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKZXN1dG9iaSIsImV4cCI6MTY3NzA4OTAxNywiaWF0IjoxNjc3MDUzMDE3fQ.bnz8lurYopmcSDI6BO6kq6TxE4zKOoKzunT1nAoi9KU".

7. Then, use this link http://localhost:8080/authenticate to carry out a PUT operation. In the request body, supply the following parameters:

{
"email" : "JT@gmail.com",
"phoneNumber" : "08165065591"
}

.

**Thank for going through the application**

