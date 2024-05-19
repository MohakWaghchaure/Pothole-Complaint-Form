package app.converters;

import app.dynamodb.model.PotholeComplaint;
import app.models.PotholeComplaintsModel;

import java.util.List;
import java.util.stream.Collectors;

public class ModelConverter {
    public PotholeComplaintsModel toPotholeComplaintsModel(PotholeComplaint potholeComplaint) {
    return PotholeComplaintsModel.builder().withComplaintId(potholeComplaint.getComplaintId())
            .withUserId(potholeComplaint.getUserId())
            .withStreetName(potholeComplaint.getStreetName())
            .withNearbyLandmark(potholeComplaint.getNearbyLandmark())
            .withLongitude(potholeComplaint.getLongitude())
            .withLatitude(potholeComplaint.getLatitude())
            .withComments(potholeComplaint.getComments())
            .withAddedOn(potholeComplaint.getAddedOn())
            .withStatus(potholeComplaint.getStatus())
            .withbase64images(potholeComplaint.getBase64Images())
            .build();

    }

    public List<PotholeComplaintsModel> toListOfPotholeComplaintsModel(List<PotholeComplaint> potholeComplaints) {
        return potholeComplaints.stream().map(this::toPotholeComplaintsModel).collect(Collectors.toList());
    }



}
