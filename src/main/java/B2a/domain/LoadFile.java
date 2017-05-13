package B2a.domain;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadFile {

    private static final Logger logger = Logger.getLogger(LoadFile.class.getName());

    public byte[] load(String name) {
        File file = new File("src/main/resources/static/img/"+ name +".png");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error in converting file to byte[]");
        }
        return bFile;
    }
}
