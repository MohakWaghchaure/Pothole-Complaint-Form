package app.dynamodb;

import app.dynamodb.model.PotholeComplaint;
import app.exceptions.ComplaintNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PotholeComplaintDaoTests {
    @Mock
    private DynamoDBMapper dynamoDBMapper;

    @InjectMocks
    private PotholeComplaintDao potholeComplaintDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getComplaintReturnsComplaintWhenExists() {
        String complaintId = "complaintId";
        PotholeComplaint complaint = new PotholeComplaint();
        when(dynamoDBMapper.load(PotholeComplaint.class, complaintId)).thenReturn(complaint);

        PotholeComplaint result = potholeComplaintDao.getComplaint(complaintId);

        assertEquals(complaint, result);
    }

    @Test
    public void getComplaintThrowsExceptionWhenNotExists() {
        String complaintId = "complaintId";
        when(dynamoDBMapper.load(PotholeComplaint.class, complaintId)).thenReturn(null);

        assertThrows(ComplaintNotFoundException.class, () -> potholeComplaintDao.getComplaint(complaintId));
    }

    @Test
    public void saveComplaintReturnsSavedComplaint() {
        PotholeComplaint complaint = new PotholeComplaint();
        potholeComplaintDao.saveComplaint(complaint);

        verify(dynamoDBMapper, times(1)).save(complaint);
    }


}
