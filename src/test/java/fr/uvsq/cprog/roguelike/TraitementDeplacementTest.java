package fr.uvsq.cprog.roguelike;


import org.junit.jupiter.api.Test;  
import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static org.junit.jupiter.api.Assertions.assertTrue; 

public class TraitementDeplacementTest {
    private TraitementDeplacement dep;
    private Init init;
    private AsciiPanel terminal;


    public void testDepforCodeCoverage() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/testM12.txt");
        dep = new TraitementDeplacement(terminal,init);
        dep.deplacementD();
        dep.deplacementR();
        dep.deplacementL();
        dep.deplacementU();

    }

    public void testCle() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/testK1.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enlevercle();
        init = new Init("src/test/resources/Maptest/testK2.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enlevercle();
        init = new Init("src/test/resources/Maptest/testK3.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enlevercle();
        init = new Init("src/test/resources/Maptest/testK4.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enlevercle();

    }
    public void testPorte() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/testP1.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverporte();
        init = new Init("src/test/resources/Maptest/testP2.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverporte();
        init = new Init("src/test/resources/Maptest/testP3.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverporte();
        init = new Init("src/test/resources/Maptest/testP4.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverporte();

    }
    public void testArmeAndGold() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/test2.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverarme();
        dep.enlevergold();
        init = new Init("src/test/resources/Maptest/test3.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverarme();
        dep.enlevergold();
        init = new Init("src/test/resources/Maptest/test4.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverarme();
        dep.enlevergold();
        init = new Init("src/test/resources/Maptest/test5.txt");
        dep = new TraitementDeplacement(terminal,init);   
        dep.enleverarme();
        dep.enlevergold();

    }
    public void testaugmentestats() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/testPnj.txt");
        dep = new TraitementDeplacement(terminal,init);  
        dep.augmenteStatsPnjLife(); 
    }
    public void testaugmentestats2() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/testPnj.txt");
        dep = new TraitementDeplacement(terminal,init);  
        dep.augmenteStatsPnjDegats(); 
   
    }
    public void testlect() throws PjException,PnjException
    {
        terminal = new AsciiPanel(80,40);
        init = new Init("src/test/resources/Maptest/testA.txt");
        dep = new TraitementDeplacement(terminal,init);  
        Lireclavier l = new Lireclavier(null,null,terminal,dep);
        l.getInit();

    }



}