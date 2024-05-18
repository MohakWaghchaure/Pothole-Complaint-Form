package app.dependency;

import app.activity.CreateComplaintsActivity;
import app.activity.GetComplaintsActivty;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {DynamoDBModule.class})
@Singleton
public interface ServiceComponent {
    CreateComplaintsActivity provideCreateComplaintsActivity();
    GetComplaintsActivty provideGetComplaintsActivty();
}
