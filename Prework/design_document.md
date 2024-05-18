## *Pothole Complaint Management* Design

## 1. Problem Statement

Potholes on roads and highways are a major inconvenience and safety hazard for drivers, cyclists, and pedestrians alike. They can cause damage to vehicles, lead to accidents, and create an unpleasant driving experience.

Traditionally, the process of identifying, reporting, and repairing potholes has been manual, inefficient, and reactive, often resulting in delays and prolonged periods of disrepair.

The Pothole Management System (PMS) aims to revolutionize the way potholes are managed by leveraging modern technologies such as mobile applications, geographic information systems (GIS), and data analytics. The system is designed to streamline the entire pothole management lifecycle, from detection and reporting to the complaints Repository and resolution.


## 2. Top Questions to Resolve in Review

1.   How will data accuracy and quality be ensured, particularly for citizen-reported potholes?
2.   What data standards and formats will be used to ensure interoperability and consistent data representation?
3.  How do you change the status of the complaint?

## 3. Use Cases
U1. *As a Pothole Management System customer, I want to submit a new complaint when I complete filling the necessary data on the complaint submission form.*

U2. *As a Pothole Management System customer, I want to view my grocery list when I log into the
Complaints list page.*

U3. *When the Pothole Management System Administrator's change the status of the Pothole the customer should be notified.*

## 4. Project Scope

### 4.1. In Scope

* Creating a new Pothole complaints.
* Retriving a list of all active complaints.

### 4.2. Out of Scope

* Deleting old complaints which have been dealt with after a certain number of days.
* Updating the user when the complaint status has changed

# 5. Proposed Architecture Overview

This initial iteration will provide the basic Pothole Management System where new complaints can be added by the users as well as the ability to view all complaints submitted and their status.

We will use API Gateway and AWS Lambda
to create two endpoints (GetRegistry, AddComplaintsToRegistry) that will handle the creation of new complaints and retrieval of complaints to the registry

We will store complaints in DynamoDB. All complaints will be added to a table called Registry
# 6. API

## 6.1. Public Models
```
// ComplaintModel

String complaintId;     automatically generated
String userId;          automatically generated
String streetName;        required
String nearbyLandMark;
double longitude;       required
double latitude;        required
String comments;
String addedOn;         automatically generated ISO 8601 dateTime
String status;          automatically generated based on the enum values
String s3BucketAddress; automatically generated based on the images uploaded
```

## 6.2. *Get Registry Endpoint*

* Accepts `GET` requests to `/complaints`
* Return list of all complaints

## 6.3 *Add Complaints to Registry Endpoint*

* Accepts `POST` requests to 'complaints'
* Accepts data to create a new complaint with the provided user ID,location data, and an optional list of images. Returns the new complaint including a unique complaint ID assigned by the Complaint Management System.
* If the data provided in the `POST` requests IS INVALID, we will throw an `InvalidAttributeValueException`

# 7. Tables

*Complaints Table*

{
userId: ,
complaintId: partition Key,
roadName,
nearbyLandMark,
longitude,
latitude,
comments,
addedOn, :sort key
status,
s3BucketAddress
}

*


# 8. Pages

Complaint Submission Page Mockup
![image.png](image.png)

Complaints List Page Mockup
![image-1.png](image-1.png)