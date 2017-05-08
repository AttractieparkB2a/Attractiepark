package B2a.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionPark {

    private static AttractionPark instance = new AttractionPark();

    private String name;
    private String address;

    private AttractionPark() {}

    public static AttractionPark getInstance() {
        return instance;
    }
}