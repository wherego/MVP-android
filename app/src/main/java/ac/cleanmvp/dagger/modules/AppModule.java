package ac.cleanmvp.dagger.modules;

import javax.inject.Inject;
import javax.inject.Singleton;

import ac.cleanmvp.model.Api;
import ac.cleanmvp.model.pojo.Links;
import dagger.Module;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


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
