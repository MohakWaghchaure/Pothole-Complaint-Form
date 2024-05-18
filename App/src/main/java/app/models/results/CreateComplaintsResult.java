package app.models.results;

import app.models.PotholeComplaintsModel;

public class CreateComplaintsResult {

    private PotholeComplaintsModel potholeComplaint;

    public PotholeComplaintsModel getPotholeComplaint() {
        return potholeComplaint;
    }

    public void setPotholeComplaint(PotholeComplaintsModel potholeComplaint) {
        this.potholeComplaint = potholeComplaint;
    }

    public static Builder builder() {
        return new Builder();
    }
    public CreateComplaintsResult(Builder builder) {
        this.potholeComplaint = builder.potholeComplaintsModel;
    }

    public static final class Builder {
        private PotholeComplaintsModel potholeComplaintsModel;

        public Builder withPotholeComplaint(PotholeComplaintsModel potholeComplaintToUse) {
            this.potholeComplaintsModel = potholeComplaintToUse;
            return this;
        }

        public CreateComplaintsResult build() {
            return new CreateComplaintsResult(this);
        }
    }
}
