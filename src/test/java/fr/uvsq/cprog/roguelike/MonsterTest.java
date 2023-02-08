package fr.uvsq.cprog.roguelike;


import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals; 


public class MonsterTest {
    private Monster m1 ;
    @Test
    public void testAttMonster() {
        m1 = new Monster ("oui",0,1,1,2,3);
        m1.setName("non");
        m1.setX(1);
        m1.setY(1);
        m1.setLife(9);
        m1.setDegat(20);
        assertEquals(m1.getName(),"non");
        assertEquals(m1.getX(),1);
        assertEquals(m1.getY(),1);
        assertEquals(m1.getLife(),9);
        assertEquals(m1.getDegat(),20);


}

}