# Brutus A/S application

## To run locally:

Run MongoDB server<br/>
Clone this repository<br/>
From frontend directory, run npm install and npm run build<br/>
Run the Java application SpringBootStarterDataMongodbApplication.java

In the project directory, you can run:
### npm start
Runs the app in the development mode.<br/>
Open http://localhost:3000 to view it in the browser.

The page will reload if you make edits.<br/>
You will also see any lint errors in the console.

## About the application
It is a simple application that takes user input based on which person they want to find from the database. If no input is given, the entire database will be fetched and printed out in the table (this will take TIME, as it is quite large). The input needs to be specific, whether you're looking for names, age etc. By clicking on the header names of the table, you can sort (by the type you click).

## Technology used
The application consists of a MongoDB database (NoSQL), Spring Boot backend (Java) and React.js (JavaScript/HTML) on the frontend.<br/>
Maven was also used.<br/>
Bootstrap was the main way of styling the site, with a little bit of extra CSS as well.<br/>
Postman was used to test the API with HTTP-requests.<br/>

## Further development
Some improvements could be made.<br/>
-Make delete button work as intended.<br/>
-Possibility to add/edit people.<br/>
-More statistics (as asked for).<br/>
-Make it possible to search for a range age, instead of specific age.
