package B2a.domain.image;

import B2a.domain.User;
import B2a.service.ImageService;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.transaction.Transactional;

@Getter
@Setter
@Entity
@Table(name = "user_image")
public class UserImage implements Image {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private MultipartFile file;

    @Lob()
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserImage() {}

    public UserImage(Long id) {
        this.id = id;
    }

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.getImage());
    }

    @Override
    public Long load() {
        return id;
    }
}
