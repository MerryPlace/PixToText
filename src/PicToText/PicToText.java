package PicToText;

import java.util.*; 
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PicToText {
    PicToText(File file)
    {
        imageFile = file;
    }
    
    String translation = "";
    private File imageFile = null;
    private BufferedImage image = null;
    ArrayList<Integer> colors = new ArrayList<>();
    ArrayList<Character> symbols = new ArrayList<>();
    int curColor = 0;
    int width = 0;
    int height = 0;
    
    
    /*
    Some code borrowed from: 
    https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
    */
    void fetchColors() throws IOException
    {
        image = ImageIO.read(imageFile);
        
        width = image.getWidth();
        height = image.getHeight();
        
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                int pixel = image.getRGB(w,h);
                if(!colors.contains(pixel))
                {
                    colors.add(pixel);
                }
            }
        }
    }
    
    String translateImage()
    {
        translation = "";
        int i;
        for (int h = 0; h < height; h++) {
            translation += "\"";
            for (int w = 0; w < width; w++) {
                int pixel = image.getRGB(w,h);
                i = 0;
                while(pixel != colors.get(i)) i++;
                translation += symbols.get(i);
                if (w + 1 != width) {
                    translation += ",";
                }
            }
            translation += "\"\n";
        }
        return translation;
    }
    
    String translateImageWing()
    {
        translation = "";
        translation += "\tparticleLayout:\n";
        int i;
        for (int h = 0; h < height; h++) {
            translation += "\t\t" + (h + 1) +":  \"";
            for (int w = 0; w < width; w++) {
                int pixel = image.getRGB(w,h);
                i = 0;
                while(pixel != colors.get(i)) i++;
                translation += symbols.get(i);
                if (w + 1 != width) {
                    translation += ",";
                }
            }
            translation += "\"\n";
        }
        
        for (int particle = 0; particle < symbols.size(); particle++) {
            if(symbols.get(particle) != '-')
            {
                translation += "\tparticles:\n";
                translation += "\t\t" + symbols.get(particle) + ":\n";
                translation += 
"          \t\t  particle:\n" +
"          \t\t  distance:\n" +
"          \t\t  height:\n" +
"          \t\t  angle:\n" +
"          \t\t  speed:\n\n" +
"          \t\t  blockType:\n" +
"          \t\t  color: " + colors.get(particle) + "\n\n";
            }
        }
        return translation;
    }
}
