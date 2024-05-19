package app.activity;

import app.dynamodb.PotholeComplaintDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetComplaintsActivity_Factory implements Factory<GetComplaintsActivity> {
  private final Provider<PotholeComplaintDao> potholeComplaintDaoProvider;

  public GetComplaintsActivity_Factory(Provider<PotholeComplaintDao> potholeComplaintDaoProvider) {
    this.potholeComplaintDaoProvider = potholeComplaintDaoProvider;
  }

  @Override
  public GetComplaintsActivity get() {
    return new GetComplaintsActivity(potholeComplaintDaoProvider.get());
  }

  public static GetComplaintsActivity_Factory create(
      Provider<PotholeComplaintDao> potholeComplaintDaoProvider) {
    return new GetComplaintsActivity_Factory(potholeComplaintDaoProvider);
  }
}
