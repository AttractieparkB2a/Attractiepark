package B2a.domain.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RealImage implements Image {

    private String fileName;
    private BufferedImage image;
    private static final Logger log = Logger.getLogger(RealImage.class.getName());

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
               log.log(Level.WARNING,"Exception: " + e);
            }
        }
        return image;
    }
}