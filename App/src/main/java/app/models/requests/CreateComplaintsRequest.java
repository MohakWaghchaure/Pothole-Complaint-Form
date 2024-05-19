package app.models.requests;

import java.util.List;
import java.util.Objects;

public class CreateComplaintsRequest {

    private String streetName;
    private String nearbyLandmark;
    private Double longitude;
    private Double latitude;
    private String comments;
    private List<String> base64Images;

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

    public List<String> getBase64Images() {
        return base64Images;
    }

    public void setBase64Images(List<String> base64Images) {
        this.base64Images = base64Images;
    }

    public CreateComplaintsRequest() {
    }

    public CreateComplaintsRequest(String streetName, String nearbyLandmark, Double longitude, Double latitude, String comments, List<String> base64Images) {
        this.streetName = streetName;
        this.nearbyLandmark = nearbyLandmark;
        this.longitude = longitude;
        this.latitude = latitude;
        this.comments = comments;
        this.base64Images = base64Images;
    }

    public CreateComplaintsRequest(Builder builder) {
        this.streetName = builder.streetName;
        this.nearbyLandmark = builder.nearbyLandmark;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.comments = builder.comments;
        this.base64Images = builder.base64Images;
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
        List<String> base64Images;

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

        public Builder withBase64Images(List<String> base64Images) {
            this.base64Images = base64Images;
            return this;
        }

        public CreateComplaintsRequest build() {
            return new CreateComplaintsRequest(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateComplaintsRequest)) return false;
        CreateComplaintsRequest that = (CreateComplaintsRequest) o;
        return Objects.equals(streetName, that.streetName) &&
                Objects.equals(nearbyLandmark, that.nearbyLandmark) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(base64Images, that.base64Images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, nearbyLandmark, longitude, latitude, comments, base64Images);
    }

    @Override
    public String toString() {
        return "CreateComplaintsRequest{" +
                "streetName='" + streetName + '\'' +
                ", nearbyLandmark='" + nearbyLandmark + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", comments='" + comments + '\'' +
                ", base64Images=" + base64Images +
                '}';
    }
}
