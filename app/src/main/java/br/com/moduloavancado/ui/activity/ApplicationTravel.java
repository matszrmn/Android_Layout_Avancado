package br.com.moduloavancado.ui.activity;

import android.app.Application;

import java.math.BigDecimal;
import java.math.BigInteger;

import br.com.moduloavancado.dao.TravelDao;
import br.com.moduloavancado.model.Travel;

public class ApplicationTravel extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Travel t1 = new Travel("Death Valley", new BigInteger("6"), BigDecimal.valueOf(55.67), "death_valley");
        Travel t2 = new Travel("Waters Flush", new BigInteger("1"), BigDecimal.valueOf(400.00), "hanging_leaf");
        Travel t3 = new Travel("Green Forest", new BigInteger("27"), BigDecimal.valueOf(78.12), "kauai");

        TravelDao travelDao = new TravelDao();

        travelDao.addItem(t1);
        travelDao.addItem(t2);
        travelDao.addItem(t3);
    }
}
