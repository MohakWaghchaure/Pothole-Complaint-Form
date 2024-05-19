package app.models;

import java.util.List;
import java.util.Objects;

public class PotholeComplaintsModel {
    private String complaintId;
    private String userId;
    private String streetName;
    private String nearbyLandmark;
    private Double longitude;
    private Double latitude;
    private String comments;
    private String addedOn;
    private String status;
    private List<String> base64Images;

    public PotholeComplaintsModel() {
    }

    public PotholeComplaintsModel(Builder builder) {
        this.complaintId = builder.complaintId;
        this.userId = builder.userId;
        this.streetName = builder.streetName;
        this.nearbyLandmark = builder.nearbyLandmark;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.comments = builder.comments;
        this.addedOn = builder.addedOn;
        this.status = builder.status;
        this.base64Images = builder.base64Images;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNearbyLandmark() {
        return nearbyLandmark;
    }

    public void setNearbyLandmark(String nearbyLandmark) {
        this.nearbyLandmark = nearbyLandmark;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getBase64image() {
        return base64Images;
    }

    public void setBase64image(List<String> base64image) {
        this.base64Images = base64Images;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private String complaintId;
        private String userId;
        private String streetName;
        private String nearbyLandmark;
        private Double longitude;
        private Double latitude;
        private String comments;
        private String addedOn;
        private String status;
        private List<String> base64Images;

        public Builder withComplaintId(String complaintId) {
            this.complaintId = complaintId;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder withNearbyLandmark(String nearbyLandmark) {
            this.nearbyLandmark = nearbyLandmark;
            return this;
        }

        public Builder withLongitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder withLatitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder withComments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder withAddedOn(String addedOn) {
            this.addedOn = addedOn;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withbase64images(List<String> base64Images) {
            this.base64Images = base64Images;
            return this;
        }

        public PotholeComplaintsModel build() {
            return new PotholeComplaintsModel(this);
        }
    }

    @Override
    public String toString() {
        return "ComplaintsModel{" +
                "complaintId='" + complaintId + '\'' +
                ", userId='" + userId + '\'' +
                ", streetName='" + streetName + '\'' +
                ", nearbyLandmark='" + nearbyLandmark + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", comments='" + comments + '\'' +
                ", addedOn='" + addedOn + '\'' +
                ", status='" + status + '\'' +
                ", base64Images='" + base64Images + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PotholeComplaintsModel that = (PotholeComplaintsModel) o;
        return complaintId.equals(that.complaintId) &&
                userId.equals(that.userId) &&
                streetName.equals(that.streetName) &&
                nearbyLandmark.equals(that.nearbyLandmark) &&
                longitude.equals(that.longitude) &&
                latitude.equals(that.latitude) &&
                comments.equals(that.comments) &&
                addedOn.equals(that.addedOn) &&
                status.equals(that.status) &&
                base64Images.equals(that.base64Images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complaintId, userId, streetName, nearbyLandmark, longitude, latitude, comments, addedOn, status, base64Images);
    }
}
