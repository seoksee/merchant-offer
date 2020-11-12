# Spring Boot, MySQL, Hibernate RESTful API application
Build RESTful CRUD API for a simple merchants-offers application using Spring Boot, MySQL and Hibernate.

## Requirements
Java - 1.8 or later <br>
Maven - 3.0.0 or later <br>
MySQL - 5.0.0 or later <br>

## Setup
<ol>
  <li>Clone the application <br>
    
      git clone https://github.com/seoksee/merchant-offer.git 
  </li>
  <li>Create MySQL database <br>
      
      create database merchant-offer
  </li>
  <li>Change MySQL username and password as per your installation
      <ul>
          <li>open <code>src/main/resources/application.properties</code></li> 
          <li>change <code>spring.datasource.username</code> and <code>spring.datasource.password</code> as per your MySQL installation</li>
      </ul>
  </li><br>
  <li>Build and run the application using maven <br>
  
        mvnw spring-boot:run
  
  The app will start running at http://localhost:8080
  </li>
</ol>

## Exploring RESTful APIs
1. Import and use the `Merchant Offer.postman_environment` attached in the email.
2. Explore the CRUD APIs with the attached `merchant-offer.postman_collection`.
