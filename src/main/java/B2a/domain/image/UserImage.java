package B2a.domain.image;

import B2a.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserImage implements Image {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private MultipartFile file;

    @Transient
    private RealImage realImage;

    @Lob()
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.getImage());
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(name);
        }
        realImage.display();
    }
}
