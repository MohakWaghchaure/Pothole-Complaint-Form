package app.lambda;

import app.dependency.DaggerServiceComponent;
import app.dependency.ServiceComponent;
import app.models.requests.CreateComplaintsRequest;
import app.models.results.CreateComplaintsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class CreateComplaintsProvider implements RequestHandler<CreateComplaintsRequest, CreateComplaintsResult> {
    public CreateComplaintsProvider() {
    }

    @Override
    public CreateComplaintsResult handleRequest(final CreateComplaintsRequest createComplaintsRequest, Context context) {
        ServiceComponent dagger = DaggerServiceComponent.create();
        return dagger.provideCreateComplaintsActivity().handleRequest(createComplaintsRequest, context);
    }
}
