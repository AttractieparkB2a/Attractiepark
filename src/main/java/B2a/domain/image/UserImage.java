package B2a.domain.image;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserImage {

    @Id
    @GeneratedValue
    protected int id;
    protected String name;

  //  @Column( name = "FILEIMAGE" )
    @Lob()
    protected byte[] image;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.getImage());
    }
}
