package app.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

/**
 * Represents a complaint in the pothole_complaints table.
 */
@DynamoDBTable(tableName = "pothole_complaints")
public class PotholeComplaint {
    private String complaintId;
    private String userId;
    private String streetName;
    private String nearbyLandmark;
    private Double longitude;
    private Double latitude;
    private String comments;
    private String addedOn;
    private String status;
    private String base64image;

    @DynamoDBHashKey(attributeName = "complaintId")
    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "UserIdIndex", attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "streetName")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @DynamoDBAttribute(attributeName = "nearbyLandmark")
    public String getNearbyLandmark() {
        return nearbyLandmark;
    }

    public void setNearbyLandmark(String nearbyLandmark) {
        this.nearbyLandmark = nearbyLandmark;
    }

    @DynamoDBAttribute(attributeName = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @DynamoDBAttribute(attributeName = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @DynamoDBAttribute(attributeName = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @DynamoDBRangeKey(attributeName = "addedOn")
    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    @DynamoDBAttribute(attributeName = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute(attributeName = "base64image")
    public String getBase64image() {
        return base64image;
    }

    public void setBase64image(String base64image) {
        this.base64image = base64image;
    }
}
