package B2a.domain;

import java.io.File;
import java.io.FileInputStream;

public class LoadFile {

    public byte[] load(String name) {
        File file = new File("src/main/resources/static/img/"+ name +".png");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }
}
