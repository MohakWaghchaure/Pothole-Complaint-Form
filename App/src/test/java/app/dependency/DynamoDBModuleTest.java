package app.dependency;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;

public class DynamoDBModuleTest {
    private DynamoDBModule dynamoDBModule;
    private AmazonDynamoDB amazonDynamoDB;

    public AmazonDynamoDB provideAmazonDynamoDBClient() {
        return new AmazonDynamoDBClient();
    }

    public DynamoDBMapper provideDynamoDBMapper() {
        AmazonDynamoDB client = provideAmazonDynamoDBClient();
        client.setRegion(Region.getRegion(Regions.US_WEST_2));
        return new DynamoDBMapper(client);
    }

    @BeforeEach
    public void setup() {
        dynamoDBModule = new DynamoDBModule();
        amazonDynamoDB = Mockito.mock(AmazonDynamoDB.class);
    }

    @Test
    public void provideDynamoDBMapper_returnsNonNullMapper() {
        doNothing().when(amazonDynamoDB).setRegion(Mockito.any());
        DynamoDBMapper dynamoDBMapper = dynamoDBModule.provideDynamoDBMapper();
        assertNotNull(dynamoDBMapper);
    }


    @Test
    public void provideDynamoDBMapper_createsNewMapper() {
        doNothing().when(amazonDynamoDB).setRegion(Mockito.any());
        DynamoDBMapper dynamoDBMapper1 = dynamoDBModule.provideDynamoDBMapper();
        DynamoDBMapper dynamoDBMapper2 = dynamoDBModule.provideDynamoDBMapper();
        assertNotEquals(dynamoDBMapper1, dynamoDBMapper2);
    }


}