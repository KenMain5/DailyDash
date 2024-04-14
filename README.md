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

<h2>Application Flow</h2>
<div>
  <ul>
    <li>The process starts when the client sends an HTTP request to the server.</li>
    <li>The API Gateway intercepts this HTTP Request. It then communicates with the Identity Provider to authenticate the user</li>
    <li>Upon successful completion, the Identity Provider issues a JWT token to the user</li>
    <li>After authentication, the user is redirected to the main page. </li>
    <li>This main page acts as a dashboard interacting witht various microserivces</li>
</div>



<h2>Features</h2>
<div>
  <ul>
    <li>
	<strong>Login and Authentication:</strong> The application provides a secure login mechanism. Upon successful authentication, the user is provided a Jason Web Token which ensures a secure access to the applications features
    </li>
    <li>
	<strong>Microservice Architecture</strong> The application is built using a microservice architecture, enabling scalable and flexible interactions across different applications.  
    </li>  
    <li>
	<strong>Weather Updates</strong> The application offers real time weather updates that refresh periodically, providering users with the latest weather information to start their day or plan their activities
    </li>  
    <li>
	<strong>To-Do List</strong> The application includes a to-do list feature, allowing  users to manage their task effectively. Users can add, edit or delete tasks as needed, helping them stay organized. 
    </li>  
  </ul>
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

