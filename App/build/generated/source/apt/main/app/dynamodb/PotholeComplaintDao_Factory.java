package app.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PotholeComplaintDao_Factory implements Factory<PotholeComplaintDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public PotholeComplaintDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public PotholeComplaintDao get() {
    return new PotholeComplaintDao(dynamoDBMapperProvider.get());
  }

  public static PotholeComplaintDao_Factory create(
      Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new PotholeComplaintDao_Factory(dynamoDBMapperProvider);
  }
}
