package app.activity;

import app.converters.ModelConverter;
import app.dynamodb.PotholeComplaintDao;
import app.dynamodb.model.PotholeComplaint;
import app.models.PotholeComplaintsModel;
import app.models.requests.GetComplaintsRequest;
import app.models.results.GetComplaintsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetComplaintsActivity implements RequestHandler<GetComplaintsRequest, GetComplaintsResult> {
    private final Logger log = LogManager.getLogger();
    private final PotholeComplaintDao potholeComplaintDao;

    @Inject
    public GetComplaintsActivity(PotholeComplaintDao potholeComplaintDao) {
        this.potholeComplaintDao = potholeComplaintDao;
    }

    @Override
    public GetComplaintsResult handleRequest(final GetComplaintsRequest getComplaintsRequest, Context context) {
        log.info("Received GetComplaintsRequest {}", getComplaintsRequest);
        int page = getComplaintsRequest.getPage();
        List<PotholeComplaint> complaints = potholeComplaintDao.getComplaintsForPage(page);
        List<PotholeComplaintsModel> complaintsModel = new ArrayList<>();

        for (PotholeComplaint complaint : complaints) {
            complaintsModel.add(new ModelConverter().toPotholeComplaintsModel(complaint));
        }

        return GetComplaintsResult.builder()
                .withComplaintsList(complaintsModel)
                .build();
    }
}
