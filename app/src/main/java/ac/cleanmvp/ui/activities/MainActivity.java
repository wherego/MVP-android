package ac.cleanmvp.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import javax.inject.Inject;

import ac.cleanmvp.R;
import ac.cleanmvp.dagger.DaggerInjector;
import ac.cleanmvp.dagger.components.AppComponent;
import ac.cleanmvp.ui.presenters.MainPresenter;
import ac.cleanmvp.ui.screen_contacts.MainScreen;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainScreen{

    @Inject
    MainPresenter mainPresenter;

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppComponent component = DaggerInjector.component(this);
        component.inject(this);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.show_car_button)
    public void onListSamplesButton() {
        mainPresenter.onShowCarsButtonClick(MainActivity.this);
    }

    @Override
    public void launchCatActivity() {
        Intent intent = new Intent(MainActivity.this, CarsActivity.class);
        startActivity(intent);
    }
}
