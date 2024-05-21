# Pothole-Complaint-Form

This is a serverless web application that allows users to report potholes in their area. The application is built using AWS services such as AWS Lambda, Amazon API Gateway, Amazon DynamoDB, etc.

The application allows users to fill out a form with information about the pothole and submit it. The information is stored in a DynamoDB table and can be viewed by an administrator. The application also allows users to view a map of potholes in their area.

The backend of the application is written in Java and the frontend is written in JavaScript, HTML, and CSS.

## Project Structure
The project is structured as follows:
- 'App' folder contains the backend code.
- 'Frontend' folder contains the frontend code.
- 'Prework' folder contains the sequence diagrams and other prework documents.
- 'Prototype-Testing' folder contains the Python scripts for testing the Lambda functions.
- 'README.md' file contains the project description and other information.

## Features
The application has the following features:
- Users can fill out a form with information about a pothole and submit it.
- While filling out the form, users can provide the location of the pothole using a map.
- While filling out the form, users can click a button to automatically detect their current location.
- While filling out the form, users can upload a photo of the pothole.
- Users can view a map of potholes in their area.
- Users can toggle between different map views based on the status of the potholes.(e.g., PENDING, IN PROGRESS, COMPLETED)
- Users can view a list of potholes reported by users.
- Users can page through the paginated list of potholes using previous and next buttons.

## Tech Stack
- Java for the backend
- Dagger for dependency injection in the backend
- JavaScript for the frontend
- HTML for the frontend
- CSS for the frontend
- AWS Lambda for the backend
- Amazon API Gateway for the backend
- Amazon DynamoDB for the backend
- AWS CloudFormation for the infrastructure
- AWS SAM CLI for deployment
- OpenAPI Specification for the API Gateway
- Postman for API testing
- Google Maps API for the maps on the complaint submission form
- AWS SDK for Java for interacting with AWS services
- OpenMapTiles for the map of potholes in the area
- Gradle for building the Java code
- Junit for testing the backend
- Mockito for mocking in the backend tests
- Git for version control
- GitHub for hosting the code
- IntelliJ IDEA for the Java code
- Visual Studio Code for the frontend code
- Trello for project management
- PlantUML for sequence diagrams
- Axios for making HTTP requests in the frontend
- Luxon for date and time manipulation in the frontend


## Backend Architecture
The application is built using the following AWS services:
- AWS Lambda: The application logic is implemented as Lambda functions.
- Amazon API Gateway: The API Gateway is used to expose the Lambda functions as RESTful APIs.
- Amazon DynamoDB: The pothole information is stored in a DynamoDB table.
- AWS CloudFormation: The infrastructure is defined as code using CloudFormation templates.

![Sequence Diagram to create new complaint](/Prework/Create-Complaint-Create_Pothole_Complaint_Sequence_Diagram.png)
[Sequence Diagram to create new complaint](Prework/Create-Complaint.puml)

![Sequence Diagram to get all complaints](/Prework/Get-Complaints-Get_Pothole_Complaints_Sequence_Diagram.png)
[Sequence Diagram to get all complaints](Prework/Get-Complaints.puml)


## Deployment
The application is deployed using the Serverless Application Model (SAM) CLI. The deployment process involves the following steps:
1. In the 'App' folder, run the build.gradle script to build the Java code and create the JAR file.
2. Create the DynamoDB table using the CloudFormation template from the 'Configurations' folder. 
3. Upload the Generated ZIP file of build distribution to a S3 bucket. 
4. Deploy the Lambda functions using the code uploaded to the S3 bucket. 
5. Carry out Prototype testing of the Lambda functions using the Python scripts to test the performance and the integration of the Lambda functions. 
6. Create the API Gateway using the OpenAPI specification from the 'Configurations' folder. 
7. Make changes in the integration request and response mapping templates in the API Gateway console to customize the behavior of the application. 
8. Carry out prototype testing of the API Gateway using the Postman tool or other API testing tool. 
9. Carry out end-to-end testing of the application using the frontend application. 
10. In the frontend application, make changes in the JavaScript code to call the correct API Gateway endpoints using Axios. 
11. In the frontend application, make changes in the Google Maps API key to use the Geolocation API and Maps JavaScript API.


## Future Enhancements
The application can be enhanced in the following ways:
- Add user authentication and authorization to restrict access to certain features.
- Add an administrator dashboard to view and manage pothole complaints.
- Add a feature to notify users when their pothole complaint is resolved.
- Add a feature to automatically assign pothole complaints to city workers based on their location.
- Add a feature to remove duplicate pothole complaints from the system.
- Add a feature to remove invalid pothole complaints from the system.
- Adda feature to remove pothole complaints that are resolved (COMPLETED) and are older than a certain date.
- Add a feature for users to lookup specific pothole complaints based on complaint ID.
- Add a feature for users to lookup specific pothole complaints based on userID.
- Add a feature for users to lookup specific pothole complaints based on location proximity.
- Put Restrictions on the number of complaints that can be submitted by a user in a day.
- Put Restrictions on the number of complaints that can be submitted by a user in a week.
- Put Restrictions on the number of complaints that can be submitted by a user in a month.
- Put Restrictions on the number of complaints that can be submitted by a user in a year.
- Put Restrictions on the number of complaints that can be submitted by a user in a lifetime.
- Add a feature to allow users to edit their pothole complaints.
- Add a feature to allow users to delete their pothole complaints.
- Put Restrictions on the location of the pothole complaints to be within the city limits.
