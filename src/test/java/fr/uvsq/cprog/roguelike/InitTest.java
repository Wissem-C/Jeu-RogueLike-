package fr.uvsq.cprog.roguelike;


import org.junit.jupiter.api.Test;  
import asciiPanel.AsciiPanel;
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InitTest {
    private Init init ;
    private AsciiPanel terminal ;
    private Player p1;
    private Pnj pnj ;
    private Weapon wp;
    private Monster m1 ;

    @Test 
    public void testInitChoosenGetters() throws PjException,PnjException
    {
        init = new Init("src/test/resources/Maptest/test1.txt");
        assertEquals(7,init.getMonsters().size());
        char[][] matrix = init.getMatrix();
        p1 = init.getPlayer();
        pnj = init.getPnj();
        wp = init.getWeapon();
        boolean tmp = false;
        boolean tmp2 = false;
        if (wp.getDegat()>0)
            tmp = true;
        if(pnj.getBonusDegat()>=0)
            tmp2 =true;
        assertEquals('.',matrix[4][7]);
        assertEquals(7,p1.getX());
        assertEquals("epée",wp.getType());
        assertEquals(0,init.getGoldInit());
        assertEquals(1,pnj.getcoutBonusDegat());
        assertTrue(tmp);
        assertTrue(tmp2);
    }
    
    public void testInitChoosenverif() throws PjException,PnjException
    {
        init = new Init("src/test/resources/Maptest/test1.txt");
        assertTrue(init.verifCle());
        assertTrue(init.verifArme());
        assertTrue(init.verifPnj());
        assertTrue(init.verifGold());
    }
    
    @Test 
    public void testInitRand() throws PjException,PnjException
    {
        init = new Init(null);
        assertEquals(init.mapSave(),false);
        terminal = new AsciiPanel(80,40);
        init.printMap(terminal);
        assertEquals(false,init.verifGold());
        assertEquals(false,init.verifPnj());
        assertEquals(false,init.verifCle());
        assertEquals(false,init.verifArme());
        assertTrue(init.verifMur('R'));
        assertTrue(init.verifPnj('L'));
        assertTrue(init.verifPnj('D'));
    }
    @Test 
    public void testInitSave() throws PjException,PnjException
    {
        init = new Init("yourText.txt");
        terminal = new AsciiPanel(80,40);
        init.printMap(terminal);
        assertTrue(init.mapSave());
    }

    @Test
    public void testCollMonstre() throws PjException,PnjException
    {
        init = new Init("src/test/resources/Maptest/test1.txt");
        m1 = new Monster("oui",10,1,1,3,37);
        assertEquals(1, init.verifCollisionMonstre(m1));
        

    }
    @Test 
    public void testverifDep1() throws PjException,PnjException
    {
        init = new Init("src/test/resources/Maptest/test2.txt");
        assertEquals(false,init.verifMur('R'));
        assertTrue(init.verifMur('L'));
        assertEquals(false,init.verifPnj('L'));
        assertTrue(init.verifPnj('R'));
        assertTrue(init.verifArme());
        assertEquals(false,init.verifGold('D'));
        assertTrue(init.verifGold('U'));
        assertEquals(false,init.ecrasearme('U'));
        assertTrue(init.ecrasearme('D'));

     }
     @Test 
     public void testverifDep2() throws PjException,PnjException
     {
         init = new Init("src/test/resources/Maptest/test3.txt");
         assertEquals(false,init.verifMur('L'));
         assertTrue(init.verifMur('R'));
         assertEquals(false,init.verifPnj('R'));
         assertEquals(false,init.verifGold('U'));
         assertTrue(init.verifGold('D'));
         assertEquals(false,init.ecrasearme('D'));
         assertTrue(init.ecrasearme('U'));
      }
      
      @Test 
      public void testverifDep3() throws PjException,PnjException
      {
          init = new Init("src/test/resources/Maptest/test4.txt");
          assertEquals(false,init.verifMur('U'));
          assertTrue(init.verifMur('D'));
          assertEquals(false,init.verifPnj('D'));
          assertTrue(init.verifPnj('U'));
          assertEquals(false,init.verifGold('L'));
          assertTrue(init.verifGold('R'));
          assertEquals(false,init.ecrasearme('R'));
        assertTrue(init.ecrasearme('L'));
       }
 
       @Test 
       public void testverifDep4() throws PjException,PnjException
       {
           init = new Init("src/test/resources/Maptest/test5.txt");
           assertEquals(false,init.verifMur('D'));
           assertTrue(init.verifMur('U'));
           assertEquals(false,init.verifPnj('U'));
           assertTrue(init.verifPnj('D'));
           assertEquals(false,init.verifGold('R'));
           assertTrue(init.verifGold('L'));
           assertEquals(false,init.ecrasearme('L'));
           assertTrue(init.ecrasearme('R'));

           assertEquals(false,init.verifGold('W'));
           assertEquals(false,init.verifMur('W'));
           assertEquals(false,init.verifPnj('W'));
           assertEquals(false,init.ecrasearme('W'));
        }
        @Test 
        public void testVericleR() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testK1.txt");
            assertTrue(init.ecrasecle('L'));
            assertEquals(false,init.ecrasecle('R'));
            
        }
        @Test 
        public void testVericleL()throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testK2.txt");
            assertTrue(init.ecrasecle('R'));
            assertEquals(false,init.ecrasecle('L'));
            
        }
        @Test 
        public void testVericleU() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testK3.txt");
            assertTrue(init.ecrasecle('D'));
            assertEquals(false,init.ecrasecle('U'));
            
        }
        @Test 
        public void testVericleD() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testK4.txt");
            assertTrue(init.ecrasecle('U'));
            assertEquals(false,init.ecrasecle('D'));
            assertEquals(false,init.ecrasecle('W'));
        }
        @Test 
        public void testverifP() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testP.txt");
            assertTrue(init.verifporte());
            assertEquals(false,init.ecraseporte('D'));
            init = new Init("src/test/resources/Maptest/testK4.txt");
            assertEquals(false,init.verifporte());
          
        }
        @Test 
        public void testverifA() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testA.txt");
            assertTrue(init.verifA());
            init = new Init("src/test/resources/Maptest/testK4.txt");
            assertEquals(false,init.verifA());
        }
        @Test
        public void testPorteR() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testP1.txt");
            assertEquals(false,init.ecraseporte('R'));   
            assertTrue(init.ecraseporte('L'));

        }
        @Test
        public void testPorteU() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testP2.txt");
            assertEquals(false,init.ecraseporte('U'));   
            assertTrue(init.ecraseporte('D'));
        }
        @Test
        public void testPorteD() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testP3.txt");
            assertEquals(false,init.ecraseporte('D'));   
            assertTrue(init.ecraseporte('U'));
        }
        @Test
        public void testPorteL() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testP4.txt");
            assertEquals(false,init.ecraseporte('L'));   
            assertTrue(init.ecraseporte('R'));

            assertEquals(false,init.ecraseporte('W'));
        }

        @Test
        public void testMonster1() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testM1.txt");
            m1 = new Monster("gg",10,1,1,1,1);
           // assertEquals(m1.getName(),"gg");
            init.verifMurMonster('R',m1);
            assertEquals(m1.getName(),"#");
            init.verifMurMonster('L',m1);
            assertEquals(m1.getName(),"#");
            init.verifMurMonster('U',m1);
            assertEquals(m1.getName(),"#");
            init.verifMurMonster('D',m1);
            assertEquals(m1.getName(),"#");

            
            init = new Init("src/test/resources/Maptest/testM2.txt");
            m1 = new Monster("oui",10,1,1,1,2);
            init.verifMurMonster('R',m1);
            assertEquals(m1.getName(),"gg");

            init.verifMurMonster('L',m1);
            assertEquals(m1.getName(),"gg");
            
            init.verifMurMonster('U',m1);
            assertEquals(m1.getName(),"gg");
            init.verifMurMonster('D',m1);
            assertEquals(m1.getName(),"gg");
        
        }
        @Test
        public void testMonster2() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testM3.txt");
            m1 = new Monster("gg",10,1,1,1,1);
           // assertEquals(m1.getName(),"gg");
            init.verifCleMonster('R',m1);
            assertEquals(m1.getName(),"#");
            init.verifCleMonster('L',m1);
            assertEquals(m1.getName(),"#");
            init.verifCleMonster('U',m1);
            assertEquals(m1.getName(),"#");
            init.verifCleMonster('D',m1);
            assertEquals(m1.getName(),"#");

            
            init = new Init("src/test/resources/Maptest/testM4.txt");
            m1 = new Monster("oui",10,1,1,1,2);
            init.verifCleMonster('R',m1);
            assertEquals(m1.getName(),"gg");

            init.verifCleMonster('L',m1);
            assertEquals(m1.getName(),"gg");
            
            init.verifCleMonster('U',m1);
            assertEquals(m1.getName(),"gg");
            init.verifCleMonster('D',m1);
            assertEquals(m1.getName(),"gg");
        
        }


        @Test
        public void testMonster3() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testM5.txt");
            m1 = new Monster("gg",10,1,1,1,1);
           // assertEquals(m1.getName(),"gg");
            init.verifArmeMonster('R',m1);
            assertEquals(m1.getName(),"#");
            init.verifArmeMonster('L',m1);
            assertEquals(m1.getName(),"#");
            init.verifArmeMonster('U',m1);
            assertEquals(m1.getName(),"#");
            init.verifArmeMonster('D',m1);
            assertEquals(m1.getName(),"#");

            
            init = new Init("src/test/resources/Maptest/testM6.txt");
            m1 = new Monster("oui",10,1,1,1,2);
            init.verifArmeMonster('R',m1);
            assertEquals(m1.getName(),"gg");

            init.verifArmeMonster('L',m1);
            assertEquals(m1.getName(),"gg");
            
            init.verifArmeMonster('U',m1);
            assertEquals(m1.getName(),"gg");
            init.verifArmeMonster('D',m1);
            assertEquals(m1.getName(),"gg");
        
        }

        
        @Test
        public void testMonster4() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testM7.txt");
            m1 = new Monster("gg",10,1,1,1,1);
           // assertEquals(m1.getName(),"gg");
            init.verifGoldMonster('R',m1);
            assertEquals(m1.getName(),"#");
            init.verifGoldMonster('L',m1);
            assertEquals(m1.getName(),"#");
            init.verifGoldMonster('U',m1);
            assertEquals(m1.getName(),"#");
            init.verifGoldMonster('D',m1);
            assertEquals(m1.getName(),"#");

            
            init = new Init("src/test/resources/Maptest/testM8.txt");
            m1 = new Monster("oui",10,1,1,1,2);
            init.verifGoldMonster('R',m1);
            assertEquals(m1.getName(),"gg");

            init.verifGoldMonster('L',m1);
            assertEquals(m1.getName(),"gg");
            
            init.verifGoldMonster('U',m1);
            assertEquals(m1.getName(),"gg");
            init.verifGoldMonster('D',m1);
            assertEquals(m1.getName(),"gg");
        
        }


        @Test
        public void testMonster5() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testM9.txt");
            m1 = new Monster("gg",10,1,1,1,1);
           // assertEquals(m1.getName(),"gg");
            init.verifPorteMonster('R',m1);
            assertEquals(m1.getName(),"#");
            init.verifPorteMonster('L',m1);
            assertEquals(m1.getName(),"#");
            init.verifPorteMonster('U',m1);
            assertEquals(m1.getName(),"#");
            init.verifPorteMonster('D',m1);
            assertEquals(m1.getName(),"#");

            
            init = new Init("src/test/resources/Maptest/testM8.txt");
            m1 = new Monster("oui",10,1,1,1,2);
            init.verifPorteMonster('R',m1);
            assertEquals(m1.getName(),"gg");

            init.verifPorteMonster('L',m1);
            assertEquals(m1.getName(),"gg");
            
            init.verifPorteMonster('U',m1);
            assertEquals(m1.getName(),"gg");
            init.verifPorteMonster('D',m1);
            assertEquals(m1.getName(),"gg");
        
        }


        @Test
        public void testMonster6() throws PjException,PnjException
        {
            init = new Init("src/test/resources/Maptest/testM11.txt");
            m1 = new Monster("gg",10,1,1,1,1);
           // assertEquals(m1.getName(),"gg");
            init.verifPnjMonster('R',m1);
            assertEquals(m1.getName(),"#");
            init.verifPnjMonster('L',m1);
            assertEquals(m1.getName(),"#");
            init.verifPnjMonster('U',m1);
            assertEquals(m1.getName(),"#");
            init.verifPnjMonster('D',m1);
            assertEquals(m1.getName(),"#");

            
            init = new Init("src/test/resources/Maptest/testM12.txt");
            m1 = new Monster("oui",10,1,1,1,2);
            init.verifPnjMonster('R',m1);
            assertEquals(m1.getName(),"gg");

            init.verifPnjMonster('L',m1);
            assertEquals(m1.getName(),"gg");
            
            init.verifPnjMonster('U',m1);
            assertEquals(m1.getName(),"gg");
            init.verifPnjMonster('D',m1);
            assertEquals(m1.getName(),"gg");
        
        }
        
        @Test
        public void testAffrontement() throws PjException,PnjException
        {
          init = new Init("src/test/resources/Maptest/test1.txt");
          m1 = new Monster("oui",10,1,1,3,37);
          p1 = new Player("oui",11,0,null,3,37,true,0,false,0);
          terminal = new AsciiPanel(80,40);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);
          m1 = new Monster("oui",-1,1,1,3,37);
          p1 = new Player("oui",-1,0,null,3,37,true,0,false,0);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);

          m1 = new Monster("oui",10,1,1,3,38);
          p1 = new Player("oui",11,0,null,3,37,true,0,false,0);
          terminal = new AsciiPanel(80,40);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);
          m1 = new Monster("oui",-1,1,1,3,38);
          p1 = new Player("oui",-1,0,null,3,37,true,0,false,0);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);

          m1 = new Monster("oui",10,1,1,2,37);
          p1 = new Player("oui",11,0,null,3,37,true,0,false,0);
          terminal = new AsciiPanel(80,40);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);
          m1 = new Monster("oui",-1,1,1,2,37);
          p1 = new Player("oui",-1,0,null,3,37,true,0,false,0);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);


          
          m1 = new Monster("oui",10,1,1,3,36);
          p1 = new Player("oui",11,0,null,3,37,true,0,false,0);
          terminal = new AsciiPanel(80,40);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);
          m1 = new Monster("oui",-1,1,1,3,36);
          p1 = new Player("oui",-1,0,null,3,37,true,0,false,0);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);

          m1 = new Monster("oui",10,1,1,4,37);
          p1 = new Player("oui",11,0,null,3,37,true,0,false,0);
          terminal = new AsciiPanel(80,40);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);
          m1 = new Monster("oui",-1,1,1,4,37);
          p1 = new Player("oui",-1,0,null,3,37,true,0,false,0);
          init.verifCollisionMonstreJoueur(m1,p1,terminal);
          

        }
 
  @Test
public void testPjexception() {

    PjException thrown = assertThrows(
           PjException.class, 
           () -> init = new Init("src/test/resources/MapException/Sanspj.txt"),
           "Expected initialisation to throw, but it didn't"
    );

    assertTrue(thrown.getMessage().contentEquals("Le nombre de personnage joueur n'est pas bon "));

}


@Test
public void testPnjexception() {

    PnjException thrown = assertThrows(
           PnjException.class, 
           () -> init = new Init("src/test/resources/MapException/Sanspnj.txt"),
           "Expected initialisation to throw, but it didn't"
    );

    assertTrue(thrown.getMessage().contentEquals("Le nombre de personnage non joueur n'est pas bon "));

}


}