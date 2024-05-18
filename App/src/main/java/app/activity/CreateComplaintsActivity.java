package app.activity;

import app.converters.ModelConverter;
import app.dynamodb.PotholeComplaintDao;
import app.dynamodb.model.PotholeComplaint;
import app.exceptions.InvalidAttributeValueException;
import app.models.PotholeComplaintsModel;
import app.models.Status;
import app.models.requests.CreateComplaintsRequest;
import app.models.results.CreateComplaintsResult;
import app.util.PotholeComplaintServiceUtils;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateComplaintsActivity implements RequestHandler<CreateComplaintsRequest, CreateComplaintsResult> {
    private final Logger log = LogManager.getLogger();
    private final PotholeComplaintDao potholeComplaintDao;

    @Inject
    public CreateComplaintsActivity(PotholeComplaintDao potholeComplaintDao) {
        this.potholeComplaintDao = potholeComplaintDao;
    }

    @Override
    public CreateComplaintsResult handleRequest(final CreateComplaintsRequest createComplaintsRequest, Context context) {
        log.info("Received CreateComplaintsRequest {}", createComplaintsRequest);

        if (!PotholeComplaintServiceUtils.isValidLatitude(String.valueOf(createComplaintsRequest.getLatitude()))
                || !PotholeComplaintServiceUtils.isValidLongitude(String.valueOf(createComplaintsRequest.getLongitude()))) {
            throw new InvalidAttributeValueException("Invalid latitude or longitude");
        }

        String complaintId = PotholeComplaintServiceUtils.generateComplaintId();
        String userId = PotholeComplaintServiceUtils.generateUserId();

        PotholeComplaint potholeComplaint = new PotholeComplaint();
        potholeComplaint.setComplaintId(complaintId);
        potholeComplaint.setUserId(userId);
        potholeComplaint.setStreetName(createComplaintsRequest.getStreetName());
        potholeComplaint.setNearbyLandmark(createComplaintsRequest.getNearbyLandmark());
        potholeComplaint.setLongitude(createComplaintsRequest.getLongitude());
        potholeComplaint.setLatitude(createComplaintsRequest.getLatitude());
        potholeComplaint.setComments(createComplaintsRequest.getComments());
        potholeComplaint.setAddedOn(PotholeComplaintServiceUtils.getIsoDateTimeString());
        potholeComplaint.setStatus(Status.PENDING.toString());
        potholeComplaint.setBase64image(createComplaintsRequest.getBase64Image());

        potholeComplaintDao.saveComplaint(potholeComplaint);
        PotholeComplaintsModel potholeComplaintsModel = new ModelConverter().toPotholeComplaintsModel(potholeComplaint);
        return CreateComplaintsResult.builder()
                .withPotholeComplaint(potholeComplaintsModel)
                .build();

    }




}
