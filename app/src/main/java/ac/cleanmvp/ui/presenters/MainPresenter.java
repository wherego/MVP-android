package ac.cleanmvp.ui.presenters;

import javax.inject.Inject;

import ac.cleanmvp.ui.screen_contacts.MainScreen;

/**
 * Created by Alexy on 12.04.2016.
 */
public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    public void onShowCarsButtonClick(MainScreen mainScreen) {
        mainScreen.launchCatActivity();
    }

}
