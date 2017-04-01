package B2a.domain.image;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserImage {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    MultipartFile file;

  //  @Column( name = "FILEIMAGE" )
    @Lob()
    private byte[] image;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.getImage());
    }
}
