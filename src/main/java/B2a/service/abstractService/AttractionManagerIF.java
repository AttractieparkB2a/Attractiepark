package B2a.service.abstractService;

import B2a.domain.attraction.Attraction;

public interface AttractionManagerIF {

     Attraction createNewAttraction(String type);

    void saveAttraction(Attraction attraction);

    Iterable<Attraction> findAllAttractions();

     Attraction findAttraction(long id);

    Iterable<String> findAllAttractionTypes();

   void changeState(Attraction attraction, String action);

   }
