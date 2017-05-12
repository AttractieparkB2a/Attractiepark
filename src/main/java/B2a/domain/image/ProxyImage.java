package B2a.domain.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProxyImage implements Image {

    private UserImage userImage;
    private String name;

    public ProxyImage(String name){
        this.name = name;
    }

    @Override
    public void load() {
        if(userImage == null){
            userImage = new UserImage(name);
        }
        userImage.load();
    }
}