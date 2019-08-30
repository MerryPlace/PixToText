/*  Code by Noah Ortega
    2019
*/

package PicToText;

import java.awt.Color;
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
        //image
        translation = "";
        translation += "    particleLayout:\n";
        int i;
        for (int h = 0; h < height; h++) {
            translation += "        " + (h + 1) +": ";
            if( h < 9)
                {
                    translation += " ";
                }
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
        //symbol info
        translation += "        \n    particles:\n";
        for (int particle = 0; particle < symbols.size(); particle++) {
            
            Color c = new Color(colors.get(particle));
            int rgbInt = (c.getRed()<<16)|(c.getGreen()<<8)|c.getBlue();
            
            if(symbols.get(particle) != '-')
            {
                translation += 
"        " + symbols.get(particle) + ":\n";
                translation += 
"          particle:\n" +
"          distance:\n" +
"          height:\n" +
"          angle:\n" +
"          speed:\n" + 
"          \n" +
"          blockType:\n" +
"          color: " + rgbInt + "\n" +
"          \n";
            }
        }
        return translation;
    }
}
