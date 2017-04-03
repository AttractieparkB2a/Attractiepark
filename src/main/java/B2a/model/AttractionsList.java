package B2a.model;

import B2a.domain.attraction.Attraction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AttractionsList {


    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    private List<Attraction> attractions = new ArrayList<>();

    public void add(Attraction a) {
        attractions.add(a);
    }

    public Attraction find(Long id) {
        for(Attraction a : attractions) {
            if(a.getId() == id)
                return a;
        }
        return null;
    }
}
