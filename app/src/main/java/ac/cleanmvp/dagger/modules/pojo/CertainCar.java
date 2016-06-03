package ac.cleanmvp.dagger.modules.pojo;

import java.util.ArrayList;

/**
 * Created by Alexy on 12.04.2016.
 */
public class CertainCar {
    private String mark;
    private ArrayList<ModelCar> model;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public ArrayList<ModelCar> getModel() {
        return model;
    }

    public void setModel(ArrayList<ModelCar> model) {
        this.model = model;
    }
}
