**#Spring WebFlux<br/>**
&nbsp;&nbsp;Spring WebFlux is used to perform **CRUD operations** using Spring Reactive Web,Spring Data R2DBC and Postgres Dababase</br>
  
Tech Stack <br/>
&nbsp;&nbsp;&nbsp;1.**Java 11**<br/>
&nbsp;&nbsp;&nbsp;2.**Spring Reactive Web (Spring WebFlux)**<br/>
&nbsp;&nbsp;&nbsp;3.**Spring Data R2DBC**<br/>
&nbsp;&nbsp;&nbsp;4.**Postgres**<br/>
&nbsp;&nbsp;&nbsp;5.**Maven**<br/>

1.update DB properties in **src\main\resources\application.properties** according to your Database<br/>
&nbsp;**Sample**<br/>
&nbsp;&nbsp;&nbsp;server.port=8899<br/>
&nbsp;&nbsp;&nbsp;spring.r2dbc.url=r2dbc:postgresql://localhost/postgres<br/>
&nbsp;&nbsp;&nbsp;spring.r2dbc.username=postgres<br/>
&nbsp;&nbsp;&nbsp;spring.r2dbc.password=admin<br/>

2.change Content-Type : application/json  in Header (used **POSTMAN** for testing these API Endpoints)<br/>

3.**End Point(s) for API**<br/>
      &nbsp;&nbsp;1.Retrieve All Employees       	::: **http://localhost:8899/employees**             	| GET  Method  <br/>
      &nbsp;&nbsp;2.Retrieve Specific Employee  	::: **http://localhost:8899/employees/{employeeId}**   	| GET  Method  <br/> 
      &nbsp;&nbsp;3.Add New Employee            	::: **http://localhost:8899/employees**             	| POST Method  <br/> 
      &nbsp;&nbsp;4.Update Employee             	::: **http://localhost:8899/employees/{employeeId}**    | PUT Method   <br/>
      &nbsp;&nbsp;5.Delete Employee             	::: **http://localhost:8899/employees/{employeeId}**    | DELETE Method <br/>
  
  **Sample Employee Payload** <br/>
	&nbsp;&nbsp;[<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "PrasadVarma",<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"designation": "SSE"<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;},<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 2,<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Srikanth",<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"designation": "Architech"<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;},<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 3,<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "Narasimha",<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"designation": "Sr. QA Lead"<br/>
		&nbsp;&nbsp;&nbsp;&nbsp;}<br/>
	&nbsp;&nbsp;]  
  <br/>

**Sample Postgres DB Scripts** <br/>
&nbsp;**CREATE**<br/>
&nbsp;&nbsp;&nbsp;CREATE TABLE public.employee <br/>
&nbsp;&nbsp;&nbsp;(<br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id integer NOT NULL,<br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name text COLLATE pg_catalog."default",<br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;designation text COLLATE pg_catalog."default",<br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CONSTRAINT employee_pkey PRIMARY KEY (id)<br/>
&nbsp;&nbsp;&nbsp;)<br/>
&nbsp;&nbsp;**INSERT**<br/>
&nbsp;&nbsp;&nbsp;INSERT INTO public.employee(id, name, designation) 	VALUES (1, 'PrasadVarma', 'SSE');<br/>
&nbsp;&nbsp;&nbsp;INSERT INTO public.employee(id, name, designation) 	VALUES (2, 'Srikanth', 'Solution Architect');<br/>
&nbsp;&nbsp;&nbsp;INSERT INTO public.employee(id, name, designation) 	VALUES (3, 'Narasimha', 'QA Lead');<br/>
