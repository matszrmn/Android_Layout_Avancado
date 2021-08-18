package br.com.moduloavancado.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.moduloavancado.model.Travel;

public class TravelDao {
    private static final List<Travel> travelList;
    static {
        travelList = new ArrayList<>();
    }

    public List<Travel> getAll() {
        return new ArrayList<>(travelList);
    }

    public void addItem(Travel travel) {
        travelList.add(travel);
    }

    private Travel find(UUID idTravel) {
        Travel foundTravel = null;
        for (Travel travel : travelList) {
            if (travel.getId() != null && travel.getId().equals(idTravel)) {
                foundTravel = travel;
                break;
            }
        }
        return foundTravel;
    }

    public boolean remove(UUID idTravel) {
        Travel rmTravel = find(idTravel);
        if (rmTravel != null) {
            travelList.remove(rmTravel);
            return true;
        }
        return false;
    }
}
