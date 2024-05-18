package app.models.requests;

import java.util.Objects;

public class CreateComplaintsRequest {

    private String streetName;
    private String nearbyLandmark;
    private Double longitude;
    private Double latitude;
    private String comments;
    private String base64Image;


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

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }


    public CreateComplaintsRequest() {
    }

    public CreateComplaintsRequest(String streetName, String nearbyLandmark, Double longitude, Double latitude, String comments, String base64Image) {
        this.streetName = streetName;
        this.nearbyLandmark = nearbyLandmark;
        this.longitude = longitude;
        this.latitude = latitude;
        this.comments = comments;
        this.base64Image = base64Image;
    }

    public CreateComplaintsRequest(Builder builder) {
        this.streetName = builder.streetName;
        this.nearbyLandmark = builder.nearbyLandmark;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.comments = builder.comments;
        this.base64Image = builder.base64Image;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        String streetName;
        String nearbyLandmark;
        Double longitude;
        Double latitude;
        String comments;
        String base64Image;

        public Builder() {

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

        public Builder withBase64Image(String base64Image) {
            this.base64Image = base64Image;
            return this;
        }

        public CreateComplaintsRequest build() {
            return new CreateComplaintsRequest(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateComplaintsRequest that)) return false;
        return Objects.equals(getStreetName(), that.getStreetName()) && Objects.equals(getNearbyLandmark(), that.getNearbyLandmark()) && Objects.equals(getLongitude(), that.getLongitude()) && Objects.equals(getLatitude(), that.getLatitude()) && Objects.equals(getComments(), that.getComments()) && Objects.equals(getBase64Image(), that.getBase64Image());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreetName(), getNearbyLandmark(), getLongitude(), getLatitude(), getComments(), getBase64Image());
    }

    @Override
    public String toString() {
        return "AddComplaintsRequest{" +
                "streetName='" + streetName + '\'' +
                ", nearbyLandmark='" + nearbyLandmark + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", comments='" + comments + '\'' +
                ", base64Image='" + base64Image + '\'' +
                '}';
    }


}
