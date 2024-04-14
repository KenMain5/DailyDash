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


# Takeaway (Things I've Learned)
I gained a better understanding of how everything interacts in a microservice architecture application. I've also learned a lot about JWT and authentication protocols. 

