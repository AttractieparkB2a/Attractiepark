package B2a.service;

import B2a.domain.Attraction.Attraction;
import B2a.domain.Attraction.AttractionBuilder;
import B2a.domain.Attraction.RollercoasterBuilder;

/**
 * Created by ferdinand on 14-3-2017.
 */
public class AttractionManager {

    public AttractionManager(){

        // Build an attraction
        AttractionBuilder aBuilder = new RollercoasterBuilder();
        Attraction attraction = aBuilder.buildAttraction( "rollercoaster");

        attraction.start();
        attraction.stop();


    }

}
