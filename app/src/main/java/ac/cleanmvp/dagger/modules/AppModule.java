package ac.cleanmvp.dagger.modules;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ac.cleanmvp.dagger.modules.pojo.CertainCar;
import ac.cleanmvp.dagger.modules.pojo.Links;
import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;


@Module
public class AppModule {

    @Inject
    public AppModule() {}

    @Inject
    @Singleton
    public Api provideApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Links.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(Api.class);
    }

}
