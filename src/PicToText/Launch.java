/*  Code by Noah Ortega
    2019
*/
package PicToText;
import java.io.File;


public class Launch {
  
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuGUI().setVisible(true);
            }
        });
    }
}
