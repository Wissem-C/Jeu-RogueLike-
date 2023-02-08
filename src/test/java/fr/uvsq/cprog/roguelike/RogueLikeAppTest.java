package fr.uvsq.cprog.roguelike;


import org.junit.jupiter.api.Test;  
import javax.swing.JFrame;
import javax.swing.JTextField;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Robot;
import java.io.IOException;
import java.awt.AWTException;
import static org.junit.jupiter.api.Assertions.assertTrue; 


public class RogueLikeAppTest extends JFrame  {
    private Init initialisation;
    private char[][]matrix;
    private TraitementDeplacement dep;
    private AsciiPanel terminal ;
   
    @Test
    public void testRL() {
        RogueLikeApp app = new RogueLikeApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
}

 
    @Test
    public void testKeyEvent() {
        RogueLikeApp app = new RogueLikeApp();
        JTextField textField = new JTextField();
        KeyEvent k = new KeyEvent(
  textField,
  KeyEvent.KEY_PRESSED, 
  System.currentTimeMillis(), 
  0, 
  KeyEvent.VK_G, 
  KeyEvent.CHAR_UNDEFINED 
);

   app.keyPressed(k);
   KeyEvent k1 = new KeyEvent(
    textField,
    KeyEvent.KEY_PRESSED, 
    System.currentTimeMillis(), 
    0, 
    KeyEvent.VK_S, 
    KeyEvent.CHAR_UNDEFINED 
  );
  
     app.keyPressed(k1);

     KeyEvent k2 = new KeyEvent(
        textField,
        KeyEvent.KEY_PRESSED, 
        System.currentTimeMillis(), 
        0, 
        KeyEvent.VK_B, 
        KeyEvent.CHAR_UNDEFINED 
      );
      
         app.keyPressed(k2);

         KeyEvent k3 = new KeyEvent(
            textField,
            KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 
            0, 
            KeyEvent.VK_R, 
            KeyEvent.CHAR_UNDEFINED 
          );
          
             app.keyPressed(k3);

             KeyEvent k4 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_O, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k4);

                 KeyEvent k5 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_W, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k5);



                 KeyEvent k6 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_A, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k6);


                 KeyEvent k7 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_D, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k7);

                
                 KeyEvent k8 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_M, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k8);



                
                 KeyEvent k9 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_RIGHT, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k9);


                
                 KeyEvent k10 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_LEFT, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k10);

                 
                 KeyEvent k11 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_UP, 
                KeyEvent.CHAR_UNDEFINED 
              );
              
                 app.keyPressed(k11);

                 
                 KeyEvent k12 = new KeyEvent(
                textField,
                KeyEvent.KEY_PRESSED, 
                System.currentTimeMillis(), 
                0, 
                KeyEvent.VK_DOWN, 
                KeyEvent.CHAR_UNDEFINED 
              );
     

              
                 app.keyPressed(k12);
                
     
    }
    @Test
    public void testDown() throws PjException,PnjException,IOException
    {
    terminal = new AsciiPanel(80,40);
    initialisation = new Init("src/test/resources/Maptest/testA.txt");
    dep = new TraitementDeplacement(terminal,initialisation); 
    matrix = initialisation.getMatrix(); 
    Lireclavier l = new Lireclavier(matrix,initialisation,terminal,dep);
    JTextField textField = new JTextField();
    KeyEvent k12 = new KeyEvent(
      textField,
      KeyEvent.KEY_PRESSED, 
      System.currentTimeMillis(), 
      0, 
      KeyEvent.VK_DOWN, 
      KeyEvent.CHAR_UNDEFINED 
    );
    l.deplacer(k12);

    }
    @Test
    public void testUp() throws PjException,PnjException,IOException
    {
    terminal = new AsciiPanel(80,40);
    initialisation = new Init("src/test/resources/Maptest/testA.txt");
    dep = new TraitementDeplacement(terminal,initialisation); 
    matrix = initialisation.getMatrix(); 
    Lireclavier l = new Lireclavier(matrix,initialisation,terminal,dep);
    JTextField textField = new JTextField();
    KeyEvent k12 = new KeyEvent(
      textField,
      KeyEvent.KEY_PRESSED, 
      System.currentTimeMillis(), 
      0, 
      KeyEvent.VK_UP, 
      KeyEvent.CHAR_UNDEFINED 
    );
    l.deplacer(k12);

    }
    @Test
    public void testLeft() throws PjException,PnjException,IOException
    {
    terminal = new AsciiPanel(80,40);
    initialisation = new Init("src/test/resources/Maptest/testA.txt");
    dep = new TraitementDeplacement(terminal,initialisation); 
    matrix = initialisation.getMatrix(); 
    Lireclavier l = new Lireclavier(matrix,initialisation,terminal,dep);
    JTextField textField = new JTextField();
    KeyEvent k12 = new KeyEvent(
      textField,
      KeyEvent.KEY_PRESSED, 
      System.currentTimeMillis(), 
      0, 
      KeyEvent.VK_LEFT, 
      KeyEvent.CHAR_UNDEFINED 
    );
    l.deplacer(k12);

    }
    @Test
    public void testRight() throws PjException,PnjException,IOException
    {
    terminal = new AsciiPanel(80,40);
    initialisation = new Init("src/test/resources/Maptest/testA.txt");
    dep = new TraitementDeplacement(terminal,initialisation); 
    matrix = initialisation.getMatrix(); 
    Lireclavier l = new Lireclavier(matrix,initialisation,terminal,dep);
    JTextField textField = new JTextField();
    KeyEvent k12 = new KeyEvent(
      textField,
      KeyEvent.KEY_PRESSED, 
      System.currentTimeMillis(), 
      0, 
      KeyEvent.VK_RIGHT, 
      KeyEvent.CHAR_UNDEFINED 
    );
    l.deplacer(k12);

    }

 
}




