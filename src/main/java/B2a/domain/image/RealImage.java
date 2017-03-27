package B2a.domain.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RealImage implements Image {

    private String fileName;
    private BufferedImage image;

    public RealImage(String fileName){
        this.fileName = fileName;
        image = loadFromDisk(fileName);
    }

    @Override
    public void display() {
        if(image != null) {
            // Do something later
        }
    }

    private BufferedImage loadFromDisk(String fileName){
        File file = new File(fileName);

        if((file.exists() && !file.isDirectory())) {
            try {
                FileInputStream fis = new FileInputStream(file);
                image = ImageIO.read(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}