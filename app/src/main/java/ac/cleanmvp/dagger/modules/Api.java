package ac.cleanmvp.dagger.modules;

import java.util.List;

import ac.cleanmvp.dagger.modules.pojo.CertainCar;
import ac.cleanmvp.dagger.modules.pojo.Links;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Alexy on 12.04.2016.
 */
public interface Api {

    @GET(Links.URL_GET_CAR)
    Observable<List<CertainCar>> getCertainCarObservable();

}
