package app.models.requests;

import java.util.Objects;

public class GetComplaintsRequest {

    private Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetComplaintsRequest that)) return false;
        return Objects.equals(getLimit(), that.getLimit());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLimit());
    }

    @Override
    public String toString() {
        return "GetComplaintsRequest{" +
                "limit=" + limit +
                '}';
    }

    public GetComplaintsRequest(){

    }

    public GetComplaintsRequest(Builder builder) {
        this.limit = builder.limit;
    }

    public GetComplaintsRequest(Integer limit) {
        this.limit = limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        Integer limit;

        private Builder() {
        }

        public Builder withLimit(Integer limitToUse) {
            this.limit = limitToUse;
            return this;
        }

        public GetComplaintsRequest build() {
            return new GetComplaintsRequest(this);
        }
    }
}
