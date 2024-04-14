This is my main project.. 
Each microservice application will have their own readme to prevent..
To be continued.. 


<h1 align='center'>
  DailyDash 
</h1>


<h2>Description</h2>

DailyDash is an all-in-One Daily Planner which would have the features users would need to start the day. Currently, this application would focus more on the backend to learn and improve my Java programming skills and show minimal React application skills. To see more of my frontend development skills, please see my other projects. This main README.md will feature the main architecture as a whole while if you click on the micro-services, you would see the details inside them. 

<div align='center'>
<img src="https://github.com/KenMain5/DailyDash/blob/main/githubResources/projectArchitecture.png?raw=true" height="400"> 
</div>

<h2>Flow</h2>
The first thing that happens is the client sends an HTTP request to the server
The API Gateway intercepts this HTTP Request and interacts with the Identity Provider to authenticate the user
The Identity provider will authenticate the user and give a JWT token
The user can now use the services inside the application
They will then be re-directed to the main page where the main page will interact with each microservice 





<h2>Features</h2>

<div>
  <ul>
    <li><strong>Weather:</strong> The application will check the weather to start your day and updates hourly </li>
    <li><strong>User Sign In:</strong> The application includes functionality for users to sign in. </li>  </ul>
</div>



# Endpoints
<details>
  <summary>GET /</summary>
  <br>
  <div>
	This is the endpoint that the client request gets sent to when initially access the website. The RestController will receive this client request and 
    at the moment will just send the daily weather information that we receive from the external API "https://openweathermap.org/". 
      - Planning to create a function that would only send back the necessary information, as well as a way to save this to the database.
      - Hourly checks so that it gets updated 
  </div>
  <br>
</details>


# Takeaway (Things I've Learned)
This is one of the projects I'm planning to put a lot of efforts on. I believe this is something I can use on my daily life and this would provide me a 
more thorough understanding of Java/Spring Framework. 
  
How to implement the MVC Design Pattern
	-Intestesting problem I've encountered and learned from was that my frontend kept receiving a 401 error when attempting to register a user. The problem came 		from the DTO property names are not matching up with the properties being sent via JSON. I initally thought that as long as they are in the same order, the 		@RequestBody annotation would automatically handle it. 
  
How to connect to a deployed Postgres database and send data. 
    
How to do an external API call via WebClient 

