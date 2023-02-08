package fr.uvsq.cprog.roguelike;


import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals; 


public class PlayerTest {


    private Player p1 ;


    @Test
    public void testCle(){

        p1 = new Player("oui",0,0,null,0,0,true,0,false,0);
        assertTrue(p1.getCle());
    }
    
    @Test
    public void testArme() {

        p1 = new Player("oui",0,0,null,0,0,false,0,true,0);
        assertTrue(p1.getArme());
    }
    


    @Test 
    public void testArmetotrue(){
        p1=new Player("oui",0,0,null,0,0,true,0,false,0);
        p1.set_arme_to_true();
        assertTrue(p1.getArme());
    }

    @Test 
    public void testCletotrue(){
        p1 = new Player("oui",0,0,null,0,0,false,0,true,0);
        p1.set_cle_to_true();
        assertTrue(p1.getCle());
    }
    @Test 
    public void testXandY(){
        p1 = new Player("oui",0,0,null,0,2,false,0,true,0);
        p1.setX(p1.getY());
        assertEquals(p1.getY(),p1.getX());
    }
    @Test 
    public void testYandX(){
        p1 = new Player("oui",0,0,null,2,0,false,0,true,0);
        p1.setY(p1.getX());
        assertEquals(p1.getY(),p1.getX());
        
    }
 
    @Test 
    public void testStuff(){
        p1 = new Player("oui",0,0,null,2,0,false,0,true,0);
        assertEquals(null,p1.getStuff());
        
    }

    @Test 
    public void testautresAtt(){
        p1 = new Player("oui",0,0,null,2,0,false,0,true,0);
        p1.setLife(1);
        p1.setLevel(1);
        p1.setName("ouii");
        p1.setDegat(1);
        p1.setGold(2);
        assertEquals(p1.getLevel(),p1.getLife());
        assertEquals(p1.getName(),"ouii");
        assertEquals(p1.getGold(),2);
        assertEquals(p1.getDegat(),1);
        
    }
    
    
}