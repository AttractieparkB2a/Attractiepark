package B2a.service.abstractService;

import B2a.domain.attraction.Attraction;

public interface AttractionManagerIF {

    public Attraction createNewAttraction(String type);

    public void saveAttraction(Attraction attraction);

    public Iterable<Attraction> findAllAttractions();
}
