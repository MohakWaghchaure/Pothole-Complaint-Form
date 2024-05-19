package app.models.requests;

import java.util.Objects;

public class GetComplaintsRequest {

    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetComplaintsRequest that)) return false;
        return Objects.equals(getPage(), that.getPage());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPage());
    }

    @Override
    public String toString() {
        return "GetComplaintsRequest{" +
                "page=" + page +
                '}';
    }

    public GetComplaintsRequest() {
    }

    public GetComplaintsRequest(Integer page) {
        this.page = page;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        Integer page;

        private Builder() {
        }

        public Builder withPage(Integer pageToUse) {
            this.page = pageToUse;
            return this;
        }

        public GetComplaintsRequest build() {
            return new GetComplaintsRequest(this.page);
        }
    }
}
