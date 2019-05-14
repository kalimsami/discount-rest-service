# Discount REST API
This modules samples out discount based REST API.

Following scenarios have been covered with this API.

On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.


This module exposes an API such that given a bill, it finds the net payable amount.
It also contains unit test cases.

Module also lists screenshot of unit tests, code coverage, test coverage.


API is exposed on localhost on default port 8080.
Complete url to test on local machine is **http://localhost:8080/getdiscount**

Please not that this API requires following parameters in order to return correct results.

**userType -> (EMPLOYEE | AFFILIATE | CUSTOMER)**

**yearOfAssociation -> (Any integer number)**

**billType -> (GROSSORY | NON_GROSSORY)**

**billAmount -> (Any integer or double number)**

So the complete url to access the api will be similar to this
http://localhost:8080/getdiscount?userType=CUSTOMER&yearOfAssociation=3&billType=GROSSORY&billAmount=990


I used swagger to create the document for this API.
I added the required dependencies and then run below command:
**mvn clean spring-boot:run**

I have configured swagger tool to test the API. Please use below url on localhost.

**http://localhost:8080/swagger-ui.html**

Please note that given the listed timeframe, this API covers only happy path scenario to meet the requirements. 
It is assumed that the request will be valid with all the required parameters to return the correct response.

Also, attached Project structure screenshot to show the files used.

IDE used: IntelliJ

Java version: 1.8

Spring framework: 5.1.6

Swagger Tool: 2.7.0
