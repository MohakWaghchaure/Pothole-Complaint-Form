package app.models.results;

import app.models.PotholeComplaintsModel;

import java.util.List;

public class GetComplaintsResult {
    private List<PotholeComplaintsModel> potholeComplaintsList;

    public GetComplaintsResult(Builder builder) {
        this.potholeComplaintsList = builder.potholeComplaintsList;
    }

    public List<PotholeComplaintsModel> getPotholeComplaintsList() {
        return potholeComplaintsList;
    }

    public void setPotholeComplaintsList(List<PotholeComplaintsModel> potholeComplaintsList) {
        this.potholeComplaintsList = potholeComplaintsList;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private List<PotholeComplaintsModel> potholeComplaintsList;

        public Builder withComplaintsList(List<PotholeComplaintsModel> complaintListToUse) {
            this.potholeComplaintsList = complaintListToUse;
            return this;
        }

        public GetComplaintsResult build() {return new GetComplaintsResult(this);}
    }
}
