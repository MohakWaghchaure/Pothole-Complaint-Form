package app.activity;

import app.converters.ModelConverter;
import app.dynamodb.PotholeComplaintDao;
import app.dynamodb.model.PotholeComplaint;
import app.models.requests.GetComplaintsRequest;
import app.models.results.GetComplaintsResult;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GetComplaintsActivityTest {
    @Mock
    private PotholeComplaintDao potholeComplaintDao;
    private GetComplaintsActivity getComplaintsActivty;
    private String expectedComplaintId;
    private String expectedUserId;
    private String expectedStreetName;
    private String expectedNearbyLandmark;
    private Double expectedLongitude;
    private Double expectedLatitude;
    private String expectedComments;
    private String expectedAddedOn;
    private String expectedComplaintStatus;
    private List<String> base64Images;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        getComplaintsActivty = new GetComplaintsActivity(potholeComplaintDao);
        expectedComplaintId = "expectedComplaintId";
        expectedUserId = "expectedUserId";
        expectedStreetName = "expectedStreetName";
        expectedNearbyLandmark = "expectedNearbyLandmark";
        expectedLongitude = -60.123456;
        expectedLatitude = 45.123456;
        expectedComments = "expectedComments";
        expectedAddedOn = "expectedAddedOn";
        expectedComplaintStatus = "expectedComplaintStatus";
        base64Images = new ArrayList<>();
        base64Images.add("base64Image");
    }

    @Test
    public void handleRequest_ListOfComplaintsFound_returnsListOfComplaintsModelInResult() {
        // GIVEN

        PotholeComplaint potholeComplaint = createPotholeComplaint();
        List<PotholeComplaint> complaints = new ArrayList<>();
        complaints.add(potholeComplaint);

        int page = 1;
        Map<String, AttributeValue> lastEvaluatedKey = null; // or provide a valid key

        when(potholeComplaintDao.getComplaintsForPage(page)).thenReturn(complaints);
        GetComplaintsRequest request = GetComplaintsRequest.builder()
                .withPage(1)
                .build();

        // WHEN
        GetComplaintsResult result = getComplaintsActivty.handleRequest(request, null);

        // THEN
        assertEquals(new ModelConverter().toListOfPotholeComplaintsModel(complaints), result.getPotholeComplaintsList());
    }

    private PotholeComplaint createPotholeComplaint() {
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
        potholeComplaint.setBase64Images(base64Images);
        return potholeComplaint;
    }
}