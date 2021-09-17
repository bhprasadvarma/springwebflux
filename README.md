**#Spring WebFlux<br/>**
&nbsp;&nbsp;Spring WebFlux is used perform crud operations on emp table using Spring Reactive Web and Postgres Dababase</br>
  
Tech Stack <br/>
&nbsp;&nbsp;&nbsp;1.**Java 11**<br/>
&nbsp;&nbsp;&nbsp;2.**Spring Reactive Web (Spring WebFlux)**<br/>
&nbsp;&nbsp;&nbsp;3.**Spring Data R2DBC**<br/>
&nbsp;&nbsp;&nbsp;4.**Postgres**<br/>
&nbsp;&nbsp;&nbsp;5.**Maven**<br/>

1.update DB properties in **src\main\resources\application.properties** according to your Database<br/>
**Sample**<br/>
&nbsp;&nbsp;&nbsp;server.port=8899
&nbsp;&nbsp;&nbsp;spring.r2dbc.url=r2dbc:postgresql://localhost/postgres
&nbsp;&nbsp;&nbsp;spring.r2dbc.username=postgres
&nbsp;&nbsp;&nbsp;spring.r2dbc.password=admin

2.change Content-Type : application/json  in Header (used **POSTMAN** for testing these API Endpoints)

3.**End Point(s) for API**<br/>
      1.Retrieve All Employees       	::: **http://localhost:8899/employees**             	| GET  Method  <br/>
      2.Retrieve Specific Employee  	::: **http://localhost:8899/employees/{employeeId}**   	| GET  Method  <br/> 
      3.Add New Employee            	::: **http://localhost:8899/employees**             	| POST Method  <br/> 
      4.Update Employee             	::: **http://localhost:8899/employees/{employeeId}**    | PUT Method   <br/>
      5.Delete Employee             	::: **http://localhost:8899/employees/{employeeId}**    | DELETE Method <br/>
  
  **Sample Employee Payload** <br/>
	[<br/>
		{<br/>
			"id": 1,<br/>
			"name": "PrasadVarma",<br/>
			"designation": "SSE"<br/>
		},<br/>
		{<br/>
			"id": 2,<br/>
			"name": "Srikanth",<br/>
			"designation": "Architech"<br/>
		},<br/>
		{<br/>
			"id": 3,<br/>
			"name": "Narasimha",<br/>
			"designation": "Sr. QA Lead"<br/>
		}<br/>
	]  
  <br/>

**Sample Postgres DB Scripts** <br/>
**CREATE**
CREATE TABLE public.employee <br/>
(<br/>
    id integer NOT NULL,<br/>
    name text COLLATE pg_catalog."default",<br/>
    designation text COLLATE pg_catalog."default",<br/>
    CONSTRAINT employee_pkey PRIMARY KEY (id),<br/>
),<br/>
**INSERT**<br/>
INSERT INTO public.employee(id, name, designation) 	VALUES (1, 'PrasadVarma', 'SSE');<br/>
INSERT INTO public.employee(id, name, designation) 	VALUES (2, 'Srikanth', 'Solution Architect');<br/>
INSERT INTO public.employee(id, name, designation) 	VALUES (3, 'Narasimha', 'QA Lead');<br/>
