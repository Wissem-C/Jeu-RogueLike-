package fr.uvsq.cprog.roguelike;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
   * Classe LireClavier pour alléger le main .
   */
public class Lireclavier {

  static boolean first_time = true;
  static boolean viensB = false;
  private char[][] matrix;
  private Init initialisation;
  private AsciiPanel terminal;
  private TraitementDeplacement dep;
  private static int num_cd = 0;

  /**
   * Constructeur de la lecture du clavier.
   */
  public Lireclavier(char[][] matrix, Init init, AsciiPanel terminal, TraitementDeplacement dep) {

    this.matrix = matrix;
    this.terminal = terminal;
    this.initialisation = init;
    this.dep = dep;
  }

  public Init getInit() {
    return this.initialisation;
  }

  /**
   * Méthode pour répondre aux touches du clavier .
   */

  public void deplacer(KeyEvent e) throws IOException {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_S:
        try {
          
          String name = "yourText.txt";
          int p = 0;
          PrintWriter outFile = new PrintWriter(new FileWriter(name));

          for (int i = 0; i < matrix.length; i++) {
            if (i != 0) {
              outFile.write("\n");
            }
            if ((int) matrix[i][p] == 0) {
              break;
            }

            for (p = 0; p < matrix[i].length; p++) {

              if (matrix[i][p] == '\n') { 
                outFile.write("\n");
              }

              outFile.write(matrix[i][p] + "");

              if ((int) matrix[i][p + 1] == 0) {
                break;
              }
            }
          }

          outFile.close();
          CharacterStatistics.saveToPropertiesFile(
              initialisation.getPlayer().getLife(),
              initialisation.getPlayer().getDegat(),
              initialisation.getPlayer().getGold(),
              Countdown.getSeconde(),
              initialisation.getPlayer().getCle());
      
        } catch (IOException ioe) {
          System.out.println("Trouble reading from the file: " + ioe.getMessage());
        }
        break;
      case KeyEvent.VK_B:
        first_time = false;

        try {
          terminal.clear();
          this.initialisation = new Init("yourText.txt");

        } catch (PjException | PnjException ie) {
          System.err.println("Exception: " + ie.getMessage());
        }
        matrix = initialisation.getMatrix();
        CharacterStatistics stats = CharacterStatistics.loadFromPropertiesFile(".properties");
        initialisation.getPlayer().setDegat(stats.getDamagePoints());
        initialisation.getPlayer().setLife(stats.getHealthPoints());
        initialisation.getPlayer().setGold((stats.getGold()));
        initialisation.getPlayer().setCle((stats.getKey()));

        initialisation.printMap(terminal);

        terminal.write("                                     ", 1, 34);
        terminal.write("Points de vie : " + (initialisation.getPlayer().getLife()), 1, 34);

        terminal.write("                                     ", 1, 35);
        terminal.write("Points de dégat : " + (initialisation.getPlayer().getDegat()), 1, 35);
        terminal.write("                                     ", 1, 36);
        terminal.write("Nombre de gold : " + (initialisation.getPlayer().getGold()), 1, 36);
        

        dep = new TraitementDeplacement(terminal, initialisation);
        Countdown.start(stats.getCountdown(), terminal, initialisation.getPlayer());
        viensB = true;
        break;
      case KeyEvent.VK_R:
        if (initialisation.verifCle() == true) {
          dep.enlevercle();
        }
        break;
      case KeyEvent.VK_O:
        if (initialisation.verifporte() == true) {
          dep.enleverporte();
        }
        break;

      case KeyEvent.VK_W:
        if (initialisation.verifArme() == true) {
          dep.enleverarme();
        }
        break;

      case KeyEvent.VK_A:
        if (initialisation.verifPnj() == true) {
          if (initialisation.getPlayer().getGold() == 3) {
            terminal.write("Voici une potion de vie. Je disparais bonne chance.", 1, 30);
            dep.augmenteStatsPnjLife();

          } else {
            terminal.write("Reviens quand tu auras + de gold.", 1, 33);
          }
        }
        break;

      case KeyEvent.VK_D:
        if (initialisation.verifPnj() == true) {
          if (initialisation.getPlayer().getGold() == 3) {
            terminal.write("Voici une potion de degats. Je disparais bonne chance.", 1, 30);
            dep.augmenteStatsPnjDegats();

          } else {
            terminal.write("Reviens quand tu auras + de gold.", 1, 33);
          }
        }
        break;

      case KeyEvent.VK_M:
        if (initialisation.verifGold() == true) {
          dep.enlevergold();
        }
        break;

      case KeyEvent.VK_G:
        if (first_time == true) {
          try {
            first_time = false;
            this.initialisation = new Init(null);
          } catch (PjException | PnjException ie) {
            System.err.println("Exception: " + ie.getMessage());
          }
          matrix = initialisation.getMatrix();
          initialisation.printMap(terminal);
          initialisation.getPlayer().setDegat(5);
          initialisation.getPlayer().setGold(0);
          initialisation.afficheStats(terminal);

          Countdown.start(50, terminal, initialisation.getPlayer());

          dep = new TraitementDeplacement(terminal, initialisation);
        }

        break;

      case KeyEvent.VK_RIGHT:
        if (initialisation.verifA() == true) {
          try {
            num_cd++;

            Countdown.start(50, terminal, initialisation.getPlayer());

            this.initialisation = new Init(null);
          } catch (PjException | PnjException ie) {
            System.err.println("Exception: " + ie.getMessage());
          }
          matrix = initialisation.getMatrix();
          initialisation.printMap(terminal);
          initialisation.getPlayer().setDegat(5);
          initialisation.getPlayer().setGold(0);
          initialisation.afficheStats(terminal);

          dep = new TraitementDeplacement(terminal, initialisation);
        }

        terminal.write("[S] pour save la partie", 40, 34);
        dep.deplacementR();
        if (initialisation.verifCle() == true) {
          terminal.write("[R] pour ramasser la clé", 1, 26);
        }

        if (initialisation.verifPnj() == true) {
          terminal.write("Tapez A pour une potion de degats", 1, 27);
          terminal.write("Tapez D pour une potion de vie", 1, 28);
        }

        terminal.write("                                     ", 1, 33);

        if (initialisation.verifPnj() == false) {
          terminal.write("                                     ", 1, 27);
          terminal.write("                                     ", 1, 28);
        }

        if (initialisation.verifArme() == true) {
          terminal.write("[W] pour ramasser l'arme", 1, 30);
        }
        if (initialisation.verifArme() == false) {
          terminal.write("                                     ", 1, 30);
        }

        if (initialisation.verifGold() == true) {
          terminal.write("[M] pour ramasser l'or", 1, 31);
        }
        if (initialisation.verifGold() == false) {
          terminal.write("                                     ", 1, 31);
        }

        if (initialisation.verifCle() == false) {
          terminal.write("                                     ", 1, 26);
        }
        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == true) {
          terminal.write("[O] pour ouvrir la porte", 1, 32);
        }
        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == false) {
          terminal.write("Reviens avec la clé !", 1, 32);
        }

        if (initialisation.verifporte() == false) {
          terminal.write("                                     ", 1, 32);
        }

        break;

      case KeyEvent.VK_LEFT:
        if (initialisation.verifA() == true) {
          try {
            num_cd++;

            Countdown.start(50, terminal, initialisation.getPlayer());
            this.initialisation = new Init(null);
          } catch (PjException | PnjException ie) {
            System.err.println("Exception: " + ie.getMessage());
          }
          matrix = initialisation.getMatrix();
          initialisation.printMap(terminal);
          initialisation.getPlayer().setDegat(5);
          initialisation.getPlayer().setGold(0);
          initialisation.afficheStats(terminal);

          dep = new TraitementDeplacement(terminal, initialisation);
        }

        terminal.write("[S] pour save la partie", 40, 34);
        dep.deplacementL();
        if (initialisation.verifCle() == true) {
          terminal.write("[R] pour ramasser la clé ", 1, 26);
        }
        if (initialisation.verifCle() == false) {
          terminal.write("                                     ", 1, 26);
        }
        terminal.write("                                    ", 1, 33);

        if (initialisation.verifGold() == true) {
          terminal.write("[M] pour ramasser l'or", 1, 31);
        }
        if (initialisation.verifGold() == false) {
          terminal.write("                                     ", 1, 31);
        }

        if (initialisation.verifPnj() == true) {
          terminal.write("Tapez A pour une potion de degat", 1, 27);
          terminal.write("Tapez D pour une potion de vie", 1, 28);
        }

        if (initialisation.verifPnj() == false) {
          terminal.write("                                     ", 1, 27);
          terminal.write("                                     ", 1, 28);
        }
        if (initialisation.verifArme() == true) {
          terminal.write("[W] pour ramasser l'arme", 1, 30);
        }
        if (initialisation.verifArme() == false) {
          terminal.write("                                     ", 1, 30);
        }

        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == true) {
          terminal.write("[O] pour ouvrir la porte", 1, 32);
        }
        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == false) {
          terminal.write("Reviens avec la clé !", 1, 32);
        }

        if (initialisation.verifporte() == false) {
          terminal.write("                                     ", 1, 32);
        }

        break;

      case KeyEvent.VK_UP:
        if (initialisation.verifA() == true) {
          try {
            num_cd++;

            Countdown.start(50, terminal, initialisation.getPlayer());

            this.initialisation = new Init(null);
          } catch (PjException | PnjException ie) {
            System.err.println("Exception: " + ie.getMessage());
          }
          matrix = initialisation.getMatrix();
          initialisation.printMap(terminal);
          initialisation.getPlayer().setDegat(5);
          initialisation.getPlayer().setGold(0);
          initialisation.afficheStats(terminal);

          dep = new TraitementDeplacement(terminal, initialisation);
        }
        terminal.write("[S] pour save la partie", 40, 34);
        dep.deplacementU();
        if (initialisation.verifCle() == true) {
          terminal.write("[R] pour ramasser la clé", 1, 26);
        }
        if (initialisation.verifCle() == false) {
          terminal.write("                                     ", 1, 26);
        }

        if (initialisation.verifGold() == true) {
          terminal.write("[M] pour ramasser l'or", 1, 31);
        }
        if (initialisation.verifGold() == false) {
          terminal.write("                                     ", 1, 31);
        }

        if (initialisation.verifPnj() == true) {
          terminal.write("Tapez A pour une potion de degat", 1, 27);
          terminal.write("Tapez D pour une potion de vie", 1, 28);
        }

        terminal.write("                                    ", 1, 33);

        if (initialisation.verifPnj() == false) {
          terminal.write("                                     ", 1, 27);
          terminal.write("                                     ", 1, 28);
        }

        if (initialisation.verifArme() == true) {
          terminal.write("[W] pour ramasser l'arme", 1, 30);
        }
        if (initialisation.verifArme() == false) {
          terminal.write("                                     ", 1, 30);
        }

        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == true) {
          terminal.write("[O] pour ouvrir la porte", 1, 32);
        }
        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == false) {
          terminal.write("Reviens avec la clé !", 1, 32);
        }

        if (initialisation.verifporte() == false) {
          terminal.write("                                     ", 1, 32);
        }

        break;

      case KeyEvent.VK_DOWN:
        if (initialisation.verifA() == true) {
          try {
            num_cd++;

            Countdown.start(50, terminal, initialisation.getPlayer());
            this.initialisation = new Init(null);
          } catch (PjException | PnjException ie) {
            System.err.println("Exception: " + ie.getMessage());
          }
          matrix = initialisation.getMatrix();
          initialisation.printMap(terminal);
          initialisation.getPlayer().setDegat(5);
          initialisation.getPlayer().setGold(0);
          initialisation.afficheStats(terminal);
          dep = new TraitementDeplacement(terminal, initialisation);
        }
        terminal.write("[S] pour save la partie", 40, 34);
        dep.deplacementD();
        if (initialisation.verifCle() == true) {
          terminal.write("[R] pour ramasser la clé", 1, 26);
        }
        if (initialisation.verifCle() == false) {
          terminal.write("                                     ", 1, 26);
        }

        if (initialisation.verifGold() == true) {
          terminal.write("[M] pour ramasser l'or", 1, 31);
        }
        if (initialisation.verifGold() == false) {
          terminal.write("                                     ", 1, 31);
        }
        terminal.write("                                    ", 1, 33);

        if (initialisation.verifPnj() == true) {
          terminal.write("Tapez A pour une potion de degat", 1, 27);
          terminal.write("Tapez D pour une potion de vie", 1, 28);
        }

        if (initialisation.verifPnj() == false) {
          terminal.write("                                     ", 1, 27);
          terminal.write("                                     ", 1, 28);
        }

        if (initialisation.verifArme() == true) {
          terminal.write("[W] pour ramasser l'arme", 1, 30);
        }
        if (initialisation.verifArme() == false) {
          terminal.write("                                     ", 1, 30);
        }

        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == true) {
          terminal.write("[O] pour ouvrir la porte", 1, 32);
        }
        if (initialisation.verifporte() == true && initialisation.getPlayer().getCle() == false) {
          terminal.write("Reviens avec la clé !", 1, 32);
        }

        if (initialisation.verifporte() == false) {
          terminal.write("                                     ", 1, 32);
        }

        break;
      default:
        System.out.println("Touche invalide");
    
    }
  }

  public static int getNum() {
    return num_cd;
  }

  public static void setNum(int n) {
    num_cd = n;
  }

  public static void first_timeG() {
    first_time = true;
  }

  public static boolean viensB_trait() {
    return viensB;
  }
}