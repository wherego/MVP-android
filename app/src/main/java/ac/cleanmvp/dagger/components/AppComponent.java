package ac.cleanmvp.dagger.components;

import javax.inject.Singleton;

import ac.cleanmvp.dagger.modules.AppModule;
import ac.cleanmvp.ui.activities.CarsActivity;
import ac.cleanmvp.ui.activities.MainActivity;
import dagger.Component;

/**
 * Created by Alexy on 12.04.2016.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(CarsActivity activity);
}
