package app.dependency;

import app.activity.CreateComplaintsActivity;
import app.activity.GetComplaintsActivity;
import app.dynamodb.PotholeComplaintDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

public class ServiceComponentTest {

    private ServiceComponent serviceComponent;
    private CreateComplaintsActivity createComplaintsActivity;
    private GetComplaintsActivity getComplaintsActivty;
    private PotholeComplaintDao potholeComplaintDao;

    @BeforeEach
    public void setup() {
        serviceComponent = Mockito.mock(ServiceComponent.class);
        potholeComplaintDao = Mockito.mock(PotholeComplaintDao.class);
        createComplaintsActivity = new CreateComplaintsActivity(potholeComplaintDao);
        getComplaintsActivty = new GetComplaintsActivity(potholeComplaintDao);

        when(serviceComponent.provideCreateComplaintsActivity()).thenReturn(createComplaintsActivity);
        when(serviceComponent.provideGetComplaintsActivity()).thenReturn(getComplaintsActivty);
    }

    @Test
    public void shouldProvideCreateComplaintsActivity() {
        CreateComplaintsActivity result = serviceComponent.provideCreateComplaintsActivity();
        assertNotNull(result);
        assertSame(createComplaintsActivity, result);
    }

    @Test
    public void shouldProvideGetComplaintsActivty() {
        GetComplaintsActivity result = serviceComponent.provideGetComplaintsActivity();
        assertNotNull(result);
        assertSame(getComplaintsActivty, result);
    }
}