package app.lambda;

import app.dependency.DaggerServiceComponent;
import app.dependency.ServiceComponent;
import app.models.requests.GetComplaintsRequest;
import app.models.results.GetComplaintsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetComplaintsProvider implements RequestHandler<GetComplaintsRequest, GetComplaintsResult> {
    public GetComplaintsProvider() {
    }

    @Override
    public GetComplaintsResult handleRequest(final GetComplaintsRequest getComplaintsRequest, Context context) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return dagger.provideGetComplaintsActivity().handleRequest(getComplaintsRequest, context);
    }
}

