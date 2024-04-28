package com.example06.load;
import com.example06.entity.*;

import java.util.List;

public class Loading {
    public static cargoship loadService(cargoship ship, List<container>containers)throws overweightException{
        for(container container1:containers)
            ship.cargoLoadContainer(container1);
        return ship;
    }
}
