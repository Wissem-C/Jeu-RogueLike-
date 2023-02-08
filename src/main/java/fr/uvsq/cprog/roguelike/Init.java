package fr.uvsq.cprog.roguelike;

import asciiPanel.AsciiPanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; 

/**
   *   Classe d'initialisation .
   */
public class Init {
  char[][] matrix = new char[100][100];
  int line = 0;
  int column = 0;
  int line1 = 1;
  String data = "";
  private File file;
  private Player player;
  private Weapon weapon;
  private Pnj pnj;
  private ArrayList<Monster> monstres = new ArrayList<Monster>();
  private Monster collision;
  String tst = "";
  int randomMap = (int) (Math.random() * (12 - 1));
  int randomDegat = (int) (Math.random() * (20 - 5));
  int randomLife = (int) (Math.random() * (20 - 5));
  String randomArme = "";

  private static boolean bloque;

  /**
   *   C'est le constructeur de l'initialisation .
   */
  public Init(String map) throws PjException, PnjException {
    try {
      bloque = false;
      Integer.toString(randomMap);
      tst = map;
      if (map == null) {
        file = new File("maps/lvl" + randomMap + ".txt");
      } else if (map.equals("yourText.txt")) {
        file = new File("yourText.txt");
      } else {
        file = new File(map);
      }

      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      int c = 0;
      int compteP = 0;
      int compteM = 0;
      int x = 0;
      int y = 0;
      int x1 = 0;
      int y1 = 0;
      while ((c = br.read()) != -1) {

        char character = (char) c;

        if (character == '\n') {

          line++;
          column = 0;
        } else if (character == '@') {
          compteP++;
          x = line;
          y = column;
          matrix[line][column] = character;

          column++;
        } else if (character == '$') {
          compteM++;
          x1 = line;
          y1 = column;
          matrix[line][column] = character;
          monstres.add(new Monster("hey", 1, 1, 20, x1, y1));

          column++;
        } else if (character == 'W') {

          x1 = line;
          y1 = column;
          matrix[line][column] = character;

          column++;
        } else {

          matrix[line][column] = character;

          column++;
        }
      }
      if (compteP == 1) {
        this.player = new Player("@", 50, 2, null, x, y, false, 5, false, 0);
     
      } else {

        throw new PjException("Le nombre de personnage joueur n'est pas bon ");
      }

      if (compteM == 0 && map.equals("yourText.txt") == false) {
        throw new PnjException("Le nombre de personnage non joueur n'est pas bon ");
      }

      if (randomDegat == 0) {
        randomDegat = randomDegat + 5;
      }

      this.weapon = new Weapon(randomDegat, "epée", 3);
      this.pnj = new Pnj(randomDegat, randomDegat, 1, 1);

    } catch (IOException ioe) {
      System.out.println("Trouble reading from the file: " + ioe.getMessage());
    }
  }

  /**
   *   Cette fonction utilise un boolean pour mémoriser l'état de la map .
   */
  public boolean mapSave() {
    if (this.tst == null) {
      return false;
    }
    return true;
  }

  public ArrayList<Monster> getMonsters() {
    return this.monstres;
  }

  public char[][] getMatrix() {

    return matrix;
  }

  public Player getPlayer() {
    return this.player;
  }

  public Pnj getPnj() {
    return this.pnj;
  }

  public Weapon getWeapon() {
    return this.weapon;
  }

  public int getGoldInit() {
    return this.player.getGold();
  }

  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean verifCle() {
    if (matrix[player.getX()][player.getY() + 1] == 'K'
        || matrix[player.getX()][player.getY() - 1] == 'K'
        || matrix[player.getX() - 1][player.getY()] == 'K'
        || matrix[player.getX() + 1][player.getY()] == 'K') {
      return true;
    }
    return false;
  }

  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean verifArme() {
    if (matrix[player.getX()][player.getY() + 1] == 'W'
        || matrix[player.getX()][player.getY() - 1] == 'W'
        || matrix[player.getX() - 1][player.getY()] == 'W'
        || matrix[player.getX() + 1][player.getY()] == 'W') {
      return true;
    }
    return false;
  }

  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean verifPnj() {
    if (matrix[player.getX()][player.getY() + 1] == 'I'
        || matrix[player.getX()][player.getY() - 1] == 'I'
        || matrix[player.getX() - 1][player.getY()] == 'I'
        || matrix[player.getX() + 1][player.getY()] == 'I') {
      return true;
    }
    return false;
  }

      
  /**
   *   Cette fonction analyse les coordonnées  .
   */
  public boolean verifPnj(char dep) {
    switch (dep) {
      case 'R':
        if (matrix[player.getX()][player.getY() + 1] == 'I') {
          return false;
        }
        return true;
      case 'L':
        if (matrix[player.getX()][player.getY() - 1] == 'I') {
          return false;
        }
        return true;
      case 'U':
        if (matrix[player.getX() - 1][player.getY()] == 'I') {
          return false;
        }
        return true;
      case 'D':
        if (matrix[player.getX() + 1][player.getY()] == 'I') {
          return false;
        }
        return true;
      default:
        return false; 
    }

  }

  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean verifGold() {
    if (matrix[player.getX()][player.getY() + 1] == 'G'
        || matrix[player.getX()][player.getY() - 1] == 'G'
        || matrix[player.getX() - 1][player.getY()] == 'G'
        || matrix[player.getX() + 1][player.getY()] == 'G') {
      return true;
    }
    return false;
  }

    
  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean verifGold(char dep) {
    switch (dep) {
      case 'R':
        if (matrix[player.getX()][player.getY() + 1] == 'G') {
          return false;
        }
        return true;
      case 'L':
        if (matrix[player.getX()][player.getY() - 1] == 'G') {
          return false;
        }
        return true;
      case 'U':
        if (matrix[player.getX() - 1][player.getY()] == 'G') {
          return false;
        }
        return true;
      case 'D':
        if (matrix[player.getX() + 1][player.getY()] == 'G') {
          return false;
        }
        return true;
      default:
        return false;
    }
  }

  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean verifMur(char dep) {
    switch (dep) {
      case 'R':
        if (matrix[player.getX()][player.getY() + 1] == '#') {
          return false;
        }
        return true;
      case 'L':
        if (matrix[player.getX()][player.getY() - 1] == '#') {
          return false;
        }
        return true;
      case 'U':
        if (matrix[player.getX() - 1][player.getY()] == '#') {
          return false;
        }
        return true;
      case 'D':
        if (matrix[player.getX() + 1][player.getY()] == '#') {
          return false;
        }
        return true;
      default:
        return false;
    }

  }


  
  /**
   *   Cette fonction analyse les coordonnées  .
   */
  
  public boolean ecrasearme(char dep) {
    switch (dep) {
      case 'R':
        if (matrix[player.getX()][player.getY() + 1] == 'W') {
          return false;
        }
        return true;
      case 'L':
        if (matrix[player.getX()][player.getY() - 1] == 'W') {

          return false;
        }
        return true;
      case 'U':
        if (matrix[player.getX() - 1][player.getY()] == 'W') {

          return false;
        }
        return true;
      case 'D':
        if (matrix[player.getX() + 1][player.getY()] == 'W') {

          return false;
        }
        return true;
      default:
        return false;
    }

  }

  /**
   *   Cette fonction analyse les coordonnées  .
   */

  public boolean ecrasecle(char dep) {
    switch (dep) {
      case 'R':
        if (matrix[player.getX()][player.getY() + 1] == 'K') {
          return false;
        }
        return true;
      case 'L':
        if (matrix[player.getX()][player.getY() - 1] == 'K') {
          return false;
        }
        return true;
      case 'U':
        if (matrix[player.getX() - 1][player.getY()] == 'K') {
          return false;
        }
        return true;
      case 'D':
        if (matrix[player.getX() + 1][player.getY()] == 'K') {
          return false;
        }
        return true;
      default: 
        return false;
    }

  }
  /**
   *   Cette fonction analyse les dep des monstres avec les murs  .
   */

  public void verifMurMonster(char dep, Monster m) {
    switch (dep) {
      case 'R':
        if (matrix[m.getX()][m.getY() + 1] == '#') {
          m.setName("#");
        } else {
          m.setName("gg");
        }
        break;
      case 'L':
        if (matrix[m.getX()][m.getY() - 1] == '#') {
          m.setName("#");
        } else {
          m.setName("gg");
        }
        break;
      case 'U':
        if (matrix[m.getX() - 1][m.getY()] == '#') {
          m.setName("#");
        } else {
          m.setName("gg");
        }
        break;
      case 'D':
        if (matrix[m.getX() + 1][m.getY()] == '#') {
          m.setName("#");
        } else {
          m.setName("gg");
        }
        break;
      default:
        break;
    }
  }
  /**
   *   Cette fonction analyse les dep des monstres avec la cle  .
   */

  public void verifCleMonster(char dep, Monster m) {
    switch (dep) {
      case 'R':
        if (matrix[m.getX()][m.getY() + 1] == 'K') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'L':
        if (matrix[m.getX()][m.getY() - 1] == 'K') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'U':
        if (matrix[m.getX() - 1][m.getY()] == 'K') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'D':
        if (matrix[m.getX() + 1][m.getY()] == 'K') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      default:
        break;
    }
  }

  /**
   *   Cette fonction analyse les dep des monstres avec les armes  .
   */
  public void verifArmeMonster(char dep, Monster m) {
    switch (dep) {
      case 'R':
        if (matrix[m.getX()][m.getY() + 1] == 'W') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'L':
        if (matrix[m.getX()][m.getY() - 1] == 'W') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'U':
        if (matrix[m.getX() - 1][m.getY()] == 'W') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'D':
        if (matrix[m.getX() + 1][m.getY()] == 'W') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      default:
        break;  
    }
  }

  /**
   *   Cette fonction analyse les dep des monstres avec les golds  .
   */
  public void verifGoldMonster(char dep, Monster m) {
    switch (dep) {
      case 'R':
        if (matrix[m.getX()][m.getY() + 1] == 'G') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'L':
        if (matrix[m.getX()][m.getY() - 1] == 'G') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'U':
        if (matrix[m.getX() - 1][m.getY()] == 'G') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'D':
        if (matrix[m.getX() + 1][m.getY()] == 'G') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      default:
        break;
    }
  }

  /**
   *   Cette fonction analyse les dep des monstres avec la porte  .
   */
  public void verifPorteMonster(char dep, Monster m) {
    switch (dep) {
      case 'R':
        if (matrix[m.getX()][m.getY() + 1] == 'P') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'L':
        if (matrix[m.getX()][m.getY() - 1] == 'P') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'U':
        if (matrix[m.getX() - 1][m.getY()] == 'P') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'D':
        if (matrix[m.getX() + 1][m.getY()] == 'P') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      default:
        break;
    }
  }
  /**
   *  Cette fonction analyse les dep des monstres avec le PNJ.
   */

  public void verifPnjMonster(char dep, Monster m) {
    switch (dep) {
      case 'R':
        if (matrix[m.getX()][m.getY() + 1] == 'I') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'L':
        if (matrix[m.getX()][m.getY() - 1] == 'I') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'U':
        if (matrix[m.getX() - 1][m.getY()] == 'I') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      case 'D':
        if (matrix[m.getX() + 1][m.getY()] == 'I') {
          m.setName("#");
        } else {
          if (m.getName() != "#") {
            m.setName("gg");
          }
        }
        break;
      default:
        break;  
    }
  }

  /**
   *  Cette fonction analyse les coordonnées des monstres quand ils collisionnent .
   */
  public int verifCollisionMonstre(Monster m) {

    int cpt = 0;

    for (int i = 0; i < this.monstres.size(); i++) {

      if (this.monstres.get(i).getX() == m.getX() && this.monstres.get(i).getY() == m.getY()) {

        cpt++;
      }
    }
    if (cpt == 2) {

      this.monstres.remove(m);
    }

    return cpt;
  }

  /**
   *  Cette fonction analyse les coordonnées .
   */

  public void verifCollisionMonstreJoueur(Monster m, Player p, AsciiPanel terminal) {

    if (m.getX() == p.getX() && m.getY() == p.getY()) {

      p.setLife(p.getLife() - m.getDegat());
      m.setLife(m.getLife() - p.getDegat());

      if (m.getLife() <= 0) {
        terminal.write(".", m.getY() + 1, m.getX() + 2, AsciiPanel.red);

        this.monstres.remove(m);
        matrix[m.getX()][m.getY()] = '.';
      }
      if (p.getLife() <= 0) {
        affichage_looser(terminal);
      }

      afficheStats(terminal);
    }

    if (m.getX() + 1 == p.getX() && m.getY() == p.getY()) {

      p.setLife(p.getLife() - m.getDegat());
      m.setLife(m.getLife() - p.getDegat());

      if (m.getLife() <= 0) {
        terminal.write(".", m.getY() + 1, m.getX() + 2, AsciiPanel.red);

        this.monstres.remove(m);
        matrix[m.getX()][m.getY()] = '.';
      }

      if (p.getLife() <= 0) {
        affichage_looser(terminal);
      }

      afficheStats(terminal);
    }

    if (m.getX() - 1 == p.getX() && m.getY() == p.getY()) {

      p.setLife(p.getLife() - m.getDegat());
      m.setLife(m.getLife() - p.getDegat());

      if (m.getLife() <= 0) {
        terminal.write(".", m.getY() + 1, m.getX() + 2, AsciiPanel.red);

        this.monstres.remove(m);
        matrix[m.getX()][m.getY()] = '.';
      }
      if (p.getLife() <= 0) {
        affichage_looser(terminal);
      }

      afficheStats(terminal);
    }

    if (m.getX() == p.getX() && m.getY() + 1 == p.getY()) {

      p.setLife(p.getLife() - m.getDegat());
      m.setLife(m.getLife() - p.getDegat());

      if (m.getLife() <= 0) {
        terminal.write(".", m.getY() + 1, m.getX() + 2, AsciiPanel.red);

        this.monstres.remove(m);
        matrix[m.getX()][m.getY()] = '.';
      }
      if (p.getLife() <= 0) {
        affichage_looser(terminal);
      }

      afficheStats(terminal);
    }

    if (m.getX() == p.getX() && m.getY() - 1 == p.getY()) {

      p.setLife(p.getLife() - m.getDegat());
      m.setLife(m.getLife() - p.getDegat());

      if (m.getLife() <= 0) {
        terminal.write(".", m.getY() + 1, m.getX() + 2, AsciiPanel.red);

        this.monstres.remove(m);
        matrix[m.getX()][m.getY()] = '.';
      }
      if (p.getLife() <= 0) {
        affichage_looser(terminal);
      }

      afficheStats(terminal);
    }
  }

  void printMap(AsciiPanel terminal) {
    try {
      File myObj;
      if (mapSave() == false) {
        myObj = new File("maps/lvl" + randomMap + ".txt");
      } else {
        myObj = new File("yourText.txt");
      }
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data = myReader.nextLine();
        line1++;
        terminal.write(data, 1, line1);
      }
      myReader.close();
      afficheStats(terminal);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  /**
   *  Cette fonction analyse les coordonnées .
   */

  public boolean verifA() {
    if (matrix[player.getX()][player.getY() + 1] == 'A'
        || matrix[player.getX()][player.getY() - 1] == 'A'
        || matrix[player.getX() - 1][player.getY()] == 'A'
        || matrix[player.getX() + 1][player.getY()] == 'A') {
      return true;
    }
    return false;
  }

  /**
   *  Cette fonction analyse les coordonnées .
   */

  public boolean verifporte() {
    if (matrix[player.getX()][player.getY() + 1] == 'P'
        || matrix[player.getX()][player.getY() - 1] == 'P'
        || matrix[player.getX() - 1][player.getY()] == 'P'
        || matrix[player.getX() + 1][player.getY()] == 'P') {
      return true; 
    }
    return false;
  }

  /**
   *  Cette fonction analyse les coordonnées .
   */

  public boolean ecraseporte(char dep) {
    switch (dep) {
      case 'R':
        if (matrix[player.getX()][player.getY() + 1] == 'P') {
          return false;
        }
        return true;
      case 'L':
        if (matrix[player.getX()][player.getY() - 1] == 'P') {
          return false;
        }
        return true;
      case 'U':
        if (matrix[player.getX() - 1][player.getY()] == 'P') {
          return false;
        }
        return true;
      case 'D':
        if (matrix[player.getX() + 1][player.getY()] == 'P') {
          return false;
        }
        return true;
      default:
        return false;
    }
  }


  /**
   *  Cette fonction change le terminal quand on perd .
   */
  public static void affichage_looser(AsciiPanel terminal) {
    bloque = true;
    Lireclavier.first_timeG();
    terminal.clear();
    terminal.writeCenter("__________________", 7, AsciiPanel.red);
    terminal.writeCenter("-- VOUS AVEZ PERDU --", 8, AsciiPanel.red);
    terminal.writeCenter("__________________", 9, AsciiPanel.red);
    terminal.writeCenter("[G] pour créer une nouvelle partie ", 12);
    terminal.writeCenter("[B] pour continuer la dernière partie que vous avez save ", 13);
  }

  /**
   *  Cette fonction affiche les stats.
   */

  public void afficheStats(AsciiPanel terminal) {
    terminal.write("                                     ", 1, 34);
    terminal.write("                                     ", 1, 35);
    terminal.write("                                     ", 1, 36);
    terminal.write("Points de vie : " + (this.getPlayer().getLife()), 1, 34);
    terminal.write("Points de degat : " + (this.getPlayer().getDegat()), 1, 35);
    terminal.write("Nombre de gold : " + (this.getPlayer().getGold()), 1, 36);
  }

  /**
   *  Cette fonction affiche le timer .
   */
  public static void afficheTimer(AsciiPanel terminal) {

    terminal.write("Temps restant :         ", 34, 1);
    terminal.write("Temps restant : " + Countdown.getSeconde(), 34, 1, AsciiPanel.red);
  }

  public boolean getEtat() {
    return bloque;
  }
}