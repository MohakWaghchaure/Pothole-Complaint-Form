package app.converters;

import app.dynamodb.model.PotholeComplaint;
import app.models.PotholeComplaintsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModelConverterTest {
    private ModelConverter converter;

    @BeforeEach
    public void setup() {
        converter = new ModelConverter();
    }

    @Test
    public void shouldConvertPotholeComplaintToModel() {
        PotholeComplaint complaint = new PotholeComplaint();
        complaint.setComplaintId("123");
        complaint.setUserId("456");
        complaint.setStreetName("Test Street");
        complaint.setNearbyLandmark("Test Landmark");
        complaint.setLongitude(12.3435346);
        complaint.setLatitude(56.4645678);
        complaint.setComments("Test Comment");
        complaint.setAddedOn("2022-01-01");
        complaint.setStatus("Open");
        complaint.setBase64Images(Arrays.asList("image1", "image2"));

        PotholeComplaintsModel model = converter.toPotholeComplaintsModel(complaint);

        assertEquals("123", model.getComplaintId());
        assertEquals("456", model.getUserId());
        assertEquals("Test Street", model.getStreetName());
        assertEquals("Test Landmark", model.getNearbyLandmark());
        assertEquals(12.3435346, model.getLongitude());
        assertEquals(56.4645678, model.getLatitude());
        assertEquals("Test Comment", model.getComments());
        assertEquals("2022-01-01", model.getAddedOn());
        assertEquals("Open", model.getStatus());
        assertEquals(Arrays.asList("image1", "image2"), model.getBase64image());
    }

    @Test
    public void shouldConvertEmptyPotholeComplaintToModel() {
        PotholeComplaint complaint = new PotholeComplaint();

        PotholeComplaintsModel model = converter.toPotholeComplaintsModel(complaint);

        assertNotNull(model);
    }

    @Test
    public void shouldConvertListOfPotholeComplaintsToModels() {
        PotholeComplaint complaint1 = new PotholeComplaint();
        complaint1.setComplaintId("123");
        PotholeComplaint complaint2 = new PotholeComplaint();
        complaint2.setComplaintId("456");

        List<PotholeComplaintsModel> models = converter.toListOfPotholeComplaintsModel(Arrays.asList(complaint1, complaint2));

        assertEquals(2, models.size());
        assertEquals("123", models.get(0).getComplaintId());
        assertEquals("456", models.get(1).getComplaintId());
    }

    @Test
    public void shouldConvertEmptyListOfPotholeComplaintsToModels() {
        List<PotholeComplaintsModel> models = converter.toListOfPotholeComplaintsModel(Arrays.asList());

        assertEquals(0, models.size());
    }

    private PotholeComplaint createPotholeComplaint() {
        String expectedComplaintId = "123";
        String expectedUserId = "456";
        String expectedStreetName = "Test Street";
        String expectedNearbyLandmark = "Test Landmark";
        double expectedLongitude = 12.3435346;
        double expectedLatitude = 56.4645678;
        String expectedComments = "Test Comment";
        String expectedAddedOn = "2022-01-01";
        String expectedComplaintStatus = "Open";
        List<String> base64Images = Arrays.asList("image1", "image2");

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