package app;

import app.activity.GetComplaintsActivty;
import app.converters.ModelConverter;
import app.dynamodb.PotholeComplaintDao;
import app.dynamodb.model.PotholeComplaint;
import app.models.requests.GetComplaintsRequest;
import app.models.results.GetComplaintsResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GetComplaintsActivityTest {
    @Mock
    private PotholeComplaintDao potholeComplaintDao;

    private GetComplaintsActivty getComplaintsActivty;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        getComplaintsActivty = new GetComplaintsActivty(potholeComplaintDao);
    }

    @Test
    public void handleRequest_ListOfComplaintsFound_returnsListOfComplaintsModelInResult() {
        // GIVEN
        String expectedComplaintId = "expectedComplaintId";
        String expectedUserId = "expectedUserId";
        String expectedStreetName = "expectedStreetName";
        String expectedNearbyLandmark = "expectedNearbyLandmark";
        Double expectedLongitude = -60.123456;
        Double expectedLatitude = 45.123456;
        String expectedComments = "expectedComments";
        String expectedAddedOn = "expectedAddedOn";
        String expectedComplaintStatus = "expectedComplaintStatus";
        String base64Image = "base64Image";

        PotholeComplaint potholeComplaint = new PotholeComplaint();
        potholeComplaint.setComplaintId(expectedComplaintId);
        potholeComplaint.setUserId(expectedUserId);
        potholeComplaint.setStreetName(expectedStreetName);
        potholeComplaint.setNearbyLandmark(expectedNearbyLandmark);
        potholeComplaint.setLongitude(expectedLongitude);
        potholeComplaint.setLatitude(expectedLatitude);
        potholeComplaint.setComments(expectedComments);
        potholeComplaint.setAddedOn(expectedAddedOn);
        potholeComplaint.setStatus(expectedComplaintStatus);
        potholeComplaint.setBase64image(base64Image);

        List<PotholeComplaint> complaints = new ArrayList<PotholeComplaint>();
        complaints.add(potholeComplaint);

        when(potholeComplaintDao.getAllComplaints()).thenReturn(complaints);
        GetComplaintsRequest request = GetComplaintsRequest.builder()
                .withLimit(24)
                .build();
        // WHEN
        GetComplaintsResult result = getComplaintsActivty.handleRequest(request, null);
        // THEN
        assertEquals(new ModelConverter().toListOfPotholeComplaintsModel(complaints), result.getPotholeComplaintsList());
    }
}
