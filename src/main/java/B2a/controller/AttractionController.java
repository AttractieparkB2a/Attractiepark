package B2a.controller;

import B2a.domain.Attraction.Attraction;
import B2a.domain.Attraction.AttractionBuilder;
import B2a.domain.Attraction.PendulumBuilder;

/**
 * Created by ferdinand on 12-3-2017.
 */
public class AttractionController {
    private AttractionBuilder builder;

    public AttractionController(){


    }

    public void buttonCreateNewAttractionPressed(String attractionType){
        if(attractionType == "Pendulum"){
            builder = new PendulumBuilder();
        }


        Attraction a = builder.buildAttraction("type");


    }

}
