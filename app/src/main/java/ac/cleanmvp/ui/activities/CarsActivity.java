package ac.cleanmvp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import ac.cleanmvp.R;
import ac.cleanmvp.dagger.DaggerInjector;
import ac.cleanmvp.dagger.components.AppComponent;
import ac.cleanmvp.dagger.modules.pojo.CertainCar;
import ac.cleanmvp.dagger.modules.pojo.ModelCar;
import ac.cleanmvp.events.CarEvent;
import ac.cleanmvp.events.ErrorEvent;
import ac.cleanmvp.ui.presenters.CarsPresenters;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;


public class CarsActivity extends AppCompatActivity {

    @Inject
    CarsPresenters carsPresenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_activity);

        AppComponent component = DaggerInjector.component(this);
        component.inject(this);
        ButterKnife.inject(this);

        carsPresenters.loadFromAPI();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    //event bus
    public void onEventMainThread(CarEvent carEvent) {
        for(CertainCar certainCar : carEvent.getCertainCars()) {
            Log.e("mark", certainCar.getMark());
            for(ModelCar modelCar : certainCar.getModel()) {
                Log.e(modelCar.getId(), modelCar.getName());
            }
        }
    }

    public void onEventMainThread(ErrorEvent errorEvent) {
        Log.e("error", "error");
    }

}
