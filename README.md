
# ReadingIsGood



## Abstract

An online books retail webapp.

## Tech Stack

Java11, SpringBoot, Maven, Jpa, Hibernate, H2, Spring Security, Swagger, Intellij IDEA

## Installation

- First of all, you need to download the project on github to the machine we want to install.
- Then open the project in the IDEA (Intellij, Eclipse etc.). - Intellij is recommended as it is the IDEA it was built on.
- Clean-Install steps should be run with the Maven plugin so that the necessary jars can be downloaded. 
- If the error "Internal error in the mapping processor: java.lang.NullPointerException" is encountered in this step:
You can add `-Djps.track.ap.dependencies=false` at File | Settings (Preferences on macOS) | Build, Execution, Deployment | Compiler | Build process VM options as a workaround.
- After the Clean-Install is successful, the H2 DB should be created.
**DB configurations:**

`spring.datasource.url=jdbc:h2:file:./bookshop/library;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=TRUE    spring.datasource.username=sa`  
`spring.datasource.password=` 
`spring.datasource.driverClassName=org.h2.Driver`
`spring.jpa.show-sql=true`
`spring.jpa.hibernate.ddl-auto=update`
When the project is up, hibernate will automatically provide the DB connection

- To get the project up and running, we just need to run our main class.
- You can review the details of the project using the Swagger interface.
	 Swagger URL: http://localhost:8080/swagger-ui.html#/
	 UserName: root
	 Password: root
	
- Finally, with the help of Postman, you can test the project by making requests according to the instructions in swagger.



## Developer

Mehmet SANTOR

- https://www.linkedin.com/in/mehmet-santor/
- https://github.com/SANT0R/
