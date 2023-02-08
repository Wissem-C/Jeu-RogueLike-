package fr.uvsq.cprog.roguelike;


import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals; 

public class PnjTest {
    private Pnj pnj ;
    @Test
    public void testgetterBonus() {
        pnj = new Pnj(0,0,0,0);
        assertEquals(pnj.getBonusVie(),pnj.getcoutBonusVie());
}

}