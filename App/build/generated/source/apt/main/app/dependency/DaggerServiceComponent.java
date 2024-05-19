package app.dependency;

import app.activity.CreateComplaintsActivity;
import app.activity.GetComplaintsActivity;
import app.dynamodb.PotholeComplaintDao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponent implements ServiceComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  private PotholeComplaintDao getPotholeComplaintDao() {
    return new PotholeComplaintDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideDynamoDBMapperProvider =
        DoubleCheck.provider(
            DynamoDBModule_ProvideDynamoDBMapperFactory.create(builder.dynamoDBModule));
  }

  @Override
  public CreateComplaintsActivity provideCreateComplaintsActivity() {
    return new CreateComplaintsActivity(getPotholeComplaintDao());
  }

  @Override
  public GetComplaintsActivity provideGetComplaintsActivity() {
    return new GetComplaintsActivity(getPotholeComplaintDao());
  }


  public static final class Builder {
    private DynamoDBModule dynamoDBModule;

    private Builder() {}

    public ServiceComponent build() {
      if (dynamoDBModule == null) {
        this.dynamoDBModule = new DynamoDBModule();
      }
      return new DaggerServiceComponent(this);
    }

    public Builder dynamoDBModule(DynamoDBModule dynamoDBModule) {
      this.dynamoDBModule = Preconditions.checkNotNull(dynamoDBModule);
      return this;
    }
  }
}
