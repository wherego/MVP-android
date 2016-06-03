package ac.cleanmvp.events;

import java.util.List;

import ac.cleanmvp.dagger.modules.pojo.CertainCar;

/**
 * Created by Alexy on 24.04.2016.
 */
public class CarEvent {

    List<CertainCar> certainCars;
    public CarEvent(List<CertainCar> certainCars) {
        this.certainCars = certainCars;
    }
    public List<CertainCar> getCertainCars() {
        return certainCars;
    }

}
