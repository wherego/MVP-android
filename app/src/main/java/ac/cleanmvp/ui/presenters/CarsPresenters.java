package ac.cleanmvp.ui.presenters;

import java.util.List;

import javax.inject.Inject;

import ac.cleanmvp.dagger.modules.Api;
import ac.cleanmvp.dagger.modules.AppModule;
import ac.cleanmvp.dagger.modules.pojo.CertainCar;
import ac.cleanmvp.events.CarEvent;
import ac.cleanmvp.events.ErrorEvent;
import de.greenrobot.event.EventBus;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CarsPresenters {

    @Inject
    AppModule api;

    @Inject
    public CarsPresenters(AppModule api) {
        this.api = api;
    }

    public void loadFromAPI() {
       api.provideApi().getCertainCarObservable()
               //code for bg
               //bg thread
               .subscribeOn(Schedulers.io())
               //code for ui
               //main thread
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<List<CertainCar>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        EventBus.getDefault().post(new ErrorEvent());
                    }

                    @Override
                    public void onNext(List<CertainCar> certainCars) {
                        EventBus.getDefault().post(new CarEvent(certainCars));
                    }
                });


    }
}
