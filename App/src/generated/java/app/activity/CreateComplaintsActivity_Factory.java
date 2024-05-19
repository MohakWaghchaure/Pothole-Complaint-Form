package app.activity;

import app.dynamodb.PotholeComplaintDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateComplaintsActivity_Factory implements Factory<CreateComplaintsActivity> {
  private final Provider<PotholeComplaintDao> potholeComplaintDaoProvider;

  public CreateComplaintsActivity_Factory(
      Provider<PotholeComplaintDao> potholeComplaintDaoProvider) {
    this.potholeComplaintDaoProvider = potholeComplaintDaoProvider;
  }

  @Override
  public CreateComplaintsActivity get() {
    return new CreateComplaintsActivity(potholeComplaintDaoProvider.get());
  }

  public static CreateComplaintsActivity_Factory create(
      Provider<PotholeComplaintDao> potholeComplaintDaoProvider) {
    return new CreateComplaintsActivity_Factory(potholeComplaintDaoProvider);
  }
}
