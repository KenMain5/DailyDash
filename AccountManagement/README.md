<h1 align='center'>
  DailyDash - Login Service
</h1>


<h2>Description</h2>
<p>
  This is the Daily Dash Login Service that provides the user with authentication, role management, and access control functionalities. It is designed to securely manage user identities and facilitate seamless access to various components of the Daily Dash ecosystem. By leveraging robust security protocols and modern authentication mechanisms, this service ensures that user credentials are handled safely and that access is granted according to predefined roles and permissions. Please refer to the parent component DailyDash to access and read all other components.
</p>




<h2>Key Features</h2>
<ul>
  <li><strong>JWT Authentication:</strong> Implements JSON Web Tokens (JWT) to handle authentication and token management securely. This system provides a stateless authentication mechanism where the server does not need to keep user authentication sessions. The token includes encrypted data that can be validated each time a request is made.</li>
    <li><strong>Comprehensive Test Coverage:</strong> Achieved 100% unit test coverage using Mockito for mocking dependencies and H2 in-memory database for DAO testing. This rigorous testing validates the application's reliability and robustness, ensuring that all components function as intended under various scenarios.</li>
  <li><strong>Password Hashing:</strong> Utilizes advanced hashing algorithms to store user passwords securely. By hashing passwords, the login service ensures that actual passwords are not stored in the database, thus enhancing security against data breaches.</li>
  <li><strong>User Registration and Login System:</strong> Offers a robust registration system that allows new users to create accounts securely. The login system then validates user credentials against stored hashes to grant access. This feature includes mechanisms to handle password resets, account verification, and multi-factor authentication (MFA) options.</li>
</ul>

