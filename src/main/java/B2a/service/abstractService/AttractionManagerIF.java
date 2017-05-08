package B2a.service.abstractService;

import B2a.domain.attraction.Attraction;
import B2a.domain.attractionState.State;

public interface AttractionManagerIF {

     Attraction createNewAttraction(String type);

    void saveAttraction(Attraction attraction);

    Iterable<Attraction> findAllAttractions();

     Attraction findAttraction(Long id);

    Iterable<String> findAllAttractionTypes();

    void changeState(Attraction attraction, String action);

    void CustomDeleteForDoubles(Long id, State state);

    void deleteState(Long id);

}
