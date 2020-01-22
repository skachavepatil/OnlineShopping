Please follow the below steps to execute the Online Shopping App:

1) Install JRE (ex:1.8)

2) Install MySql DB (Version 8.0)

3) Unzip the folder 'Assignment_Online_Shopping'

4) Import the projects as Maven project in Eclipses

3) Run the Eureka Serivce from Eclipse (netflix-eureka-naming-server)
   Check Eureka server is running on or not (ex: Eureka Server on http://localhost:8761/)

4) Run the Zuul Server (Single API gateway) (zuul-service) from Eclipse 

Zuul Server (Single APi Gateway: http://localhost:8010/) 

5) Run the Customer Service

6) Run the Item Service

7) Run the Order Service
  
Customer Service: http://localhost:8010/customerservice/customers/
Item Service: http://localhost:8010/itemservice/items/
Order Service: http://localhost:8010/salesorderservice/orders/
