package B2a.domain.image;

import B2a.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_image")
public class UserImage implements Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Transient
    private MultipartFile file;

    @Lob()
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
