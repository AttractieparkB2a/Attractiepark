package B2a.domain.image;

public class ProxyImage implements Image {

    private UserImage userImage;
    private Long id;

    public ProxyImage(Long id){
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public Long load() {
        if(userImage == null){
            userImage = new UserImage(id);
        }
        return userImage.load();
    }
}