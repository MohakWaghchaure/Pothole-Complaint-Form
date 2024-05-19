package app.models.results;

import app.models.PotholeComplaintsModel;

import java.util.List;

public class GetComplaintsResult {
    private List<PotholeComplaintsModel> potholeComplaintsList;
    private int currentPage;

    public GetComplaintsResult(Builder builder) {
        this.potholeComplaintsList = builder.potholeComplaintsList;
        this.currentPage = builder.currentPage;
    }

    public List<PotholeComplaintsModel> getPotholeComplaintsList() {
        return potholeComplaintsList;
    }

    public void setPotholeComplaintsList(List<PotholeComplaintsModel> potholeComplaintsList) {
        this.potholeComplaintsList = potholeComplaintsList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<PotholeComplaintsModel> potholeComplaintsList;
        private int currentPage;

        public Builder withComplaintsList(List<PotholeComplaintsModel> complaintListToUse) {
            this.potholeComplaintsList = complaintListToUse;
            return this;
        }

        public Builder withCurrentPage(int currentPageToUse) {
            this.currentPage = currentPageToUse;
            return this;
        }

        public GetComplaintsResult build() {
            return new GetComplaintsResult(this);
        }
    }
}

