package B2a.domain;

import B2a.controller.interfaces.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RealImage extends JFrame implements Image {

    private String fileName;
    private BufferedImage image;

    public RealImage(String fileName){
        this.fileName = fileName;
        image = loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);

        if(image != null) {
            System.out.println("image is not null");
            JFrame frame = new JFrame();
            JLabel picLabel = new JLabel(new ImageIcon(image));

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(picLabel);
            frame.add(mainPanel);
            frame.setSize(300, 400);
            frame.setVisible(true);
        }
    }

    private BufferedImage loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);

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