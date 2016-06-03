package ac.cleanmvp.dagger;

import android.app.Application;
import android.content.Context;

import ac.cleanmvp.dagger.components.AppComponent;
import ac.cleanmvp.dagger.components.DaggerAppComponent;
import ac.cleanmvp.dagger.modules.AppModule;
import dagger.Component;

public class DaggerInjector extends Application {

    AppComponent component;

    public static AppComponent component(Context context) {
        return ((DaggerInjector) context.getApplicationContext()).component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
    }
}
