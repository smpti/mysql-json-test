# mysql-json-test

This is to test the MySQL 5.7.8 version Json Column support with Hibernate and JDBC Driver using Spring Boot.

Objective: Identify the cleanest way of using Json column type through Java Entity and decide whether to 
upgrade Hibernate to V5.2.10.Final from V4.3.10.Final.


Jumping to required configuration:
Checkout the corresponding tag to test it at that version.
1. v_with-attribute_converter-hibernate4.3.10-jdbc5.1.42
2. v_with-attribute_converter-hibernate4.3.10-jdbc6.0.6
3. v_with-attribute_converter-hibernate5.2.10-jdbc5.1.42
4. v_with-attribute_converter-hibernate5.2.10-jdbc6.0.6
5. v_with-type_descriptor-hibernate4.3.10-jdbc5.1.42
6. v_with-type_descriptor-hibernate4.3.10-jdbc6.0.6
7. v_with-type_descriptor-hibernate5.2.10-jdbc5.1.42
8. v_with-type_descriptor-hibernate5.2.10-jdbc6.0.6

Variables: 
1. mysql jdbc connector version - V5.1.42 , V6.0.6
2. hibernate version - V4.3.10, V5.2.10
3. approach of json-usage-through-application -
  a. Attribute Converter - based on https://www.thoughts-on-java.org/jpa-21-how-to-implement-type-converter/
  b. extending Hibernate's AbstractSingleColumnStandardBasicType - https://vladmihalcea.com/2016/06/20/how-to-map-json-objects-using-generic-hibernate-types/
  
  
Setup:

This is based from http://www.devglan.com/spring-boot/spring-boot-hibernate-5-example, for this test we modify a column 
to 'json' type and we have 4 endpoints to get the data back.
1. /list - results using Hibernate's criteria class - returns List<Food>
2. /foodByName - native Sql and .addEntity used - returns List<Food>
3. /foodByCalories - native Sql to select the json column as a whole - returns List<HashMap>
4. /foodCaloriesByPrice - native Sql to select value from the Json column - returns List<Integer>


SQL Script:

##### Create DB and table ######
CREATE DATABASE food_nutrition;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `nutrition` json DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

##### Insert Data ######
Insert into food values
('1', 'energy_bar', '{\"ingredients\": {\"Sodium\": \"90mg\", \"calories\": \"140\", \"Potassium\": \"179mg\", \"Cholesterol\": \"0mg\"}, \"priceInDollars\": 10}'
);

Insert into food values
('2', 'banana', '{\"ingredients\": {\"Sodium\": \"1mg\", \"calories\": \"105\", \"Potassium\": \"1422mg\", \"Cholesterol\": \"0mg\"}, \"priceInDollars\": 20}'
);

##### Drop Table and DB#######
Drop table food2;



Findings and Questions?:
1. The latest mysql jdbc connector 6.0.6 is needed instead of 5.1.42 (when we get the whole value 'json' column or 
value inside the Json's key, When we get the whole column we get it as a String)
2. In all the scenarios we are able to get the entity in the required format.



