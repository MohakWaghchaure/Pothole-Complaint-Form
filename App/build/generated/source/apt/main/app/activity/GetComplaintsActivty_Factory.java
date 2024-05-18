package app.activity;

import app.dynamodb.PotholeComplaintDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetComplaintsActivty_Factory implements Factory<GetComplaintsActivty> {
  private final Provider<PotholeComplaintDao> potholeComplaintDaoProvider;

  public GetComplaintsActivty_Factory(Provider<PotholeComplaintDao> potholeComplaintDaoProvider) {
    this.potholeComplaintDaoProvider = potholeComplaintDaoProvider;
  }

  @Override
  public GetComplaintsActivty get() {
    return new GetComplaintsActivty(potholeComplaintDaoProvider.get());
  }

  public static GetComplaintsActivty_Factory create(
      Provider<PotholeComplaintDao> potholeComplaintDaoProvider) {
    return new GetComplaintsActivty_Factory(potholeComplaintDaoProvider);
  }
}
