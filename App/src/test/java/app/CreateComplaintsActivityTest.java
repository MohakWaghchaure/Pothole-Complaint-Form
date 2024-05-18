package app;

import app.activity.CreateComplaintsActivity;
import app.dynamodb.PotholeComplaintDao;
import app.dynamodb.model.PotholeComplaint;
import app.models.requests.CreateComplaintsRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CreateComplaintsActivityTest {
    @Mock
    private PotholeComplaintDao potholeComplaintDao;

    private CreateComplaintsActivity createComplaintsActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        createComplaintsActivity = new CreateComplaintsActivity(potholeComplaintDao);
    }

    @Test
    void handleRequest_validRequest_createsComplaint() {
        // GIVEN
        CreateComplaintsRequest request = new CreateComplaintsRequest();
        request.setStreetName("streetName");
        request.setNearbyLandmark("nearbyLandmark");
        request.setLongitude(1.0);
        request.setLatitude(1.0);
        request.setComments("comments");
        request.setBase64Image("base64Image");

        // Mock the saveComplaint method to return the same object when called
        when(potholeComplaintDao.saveComplaint(any(PotholeComplaint.class))).thenAnswer(i -> i.getArguments()[0]);

        // WHEN
        createComplaintsActivity.handleRequest(request, null);

        // THEN
        verify(potholeComplaintDao).saveComplaint(any(PotholeComplaint.class));
    }

}
