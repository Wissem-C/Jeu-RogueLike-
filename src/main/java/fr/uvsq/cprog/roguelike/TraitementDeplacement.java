package fr.uvsq.cprog.roguelike;

import asciiPanel.AsciiPanel;
import java.util.ArrayList;

/**
     *Classe qui gère les déplacements du PJ et des PNJ.
     */

public class TraitementDeplacement {
  private AsciiPanel terminal;
  private Init init;
  private int height;
  private int width;
  int monstreheight;
  int monstrewidth;
  private RogueLikeApp app;
  ArrayList<Monster> monstres = new ArrayList<Monster>();
  ArrayList<Integer> listheight = new ArrayList<Integer>();
  ArrayList<Integer> listwidth = new ArrayList<Integer>();

  /**
     *Constructeur de la classe TraitementDeplacement.
     */

  public TraitementDeplacement(AsciiPanel terminal, Init init) {
    this.terminal = terminal;
    this.init = init;
    height = init.getPlayer().getY() + 1;
    width = init.getPlayer().getX() + 2;
    monstres = init.getMonsters();
  }

  /**
     *Fonction qui gère le déplacement à droite.
     */

  public void deplacementR() {

    if (this.init.verifMur('R') == true
        && this.init.getEtat() == false
        && this.init.ecrasecle('R')
        && this.init.ecraseporte('R')
        && this.init.ecrasearme('R')
        && this.init.verifPnj('R')
        && this.init.verifGold('R')) {
      this.terminal.write(".", height, width);
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY()] = '.';
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '@';
      for (Monster m : monstres) {
        this.init.verifMurMonster('L', m);
        this.init.verifCleMonster('L', m);
        this.init.verifGoldMonster('L', m);
        this.init.verifArmeMonster('L', m);
        this.init.verifPorteMonster('L', m);
        this.init.verifPnjMonster('I', m);
        if (m.getName() != "#") {
          monstrewidth = m.getX() + 2;
          monstreheight = m.getY() + 1;

          terminal.write(
              ".",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          this.init.getMatrix()[m.getX()][m.getY()] = '.';
          this.init.getMatrix()[m.getX()][m.getY() - 1] = '$';
        }
      }
      height++;

      for (Monster m : monstres) {
        if (m.getName() != "#") {
          listheight.add(m.getY());
        }
      }

      int i = 0;
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          monstreheight = listheight.get(i);
          monstrewidth = m.getX() + 2;
          terminal.write(
              "$",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          m.setY(listheight.get(i) - 1);
          m.setX(m.getX());
          i++;
        }
      }

      this.terminal.write(
          "@", height, width, AsciiPanel.red);
      this.init.getPlayer().setX(width - 2);
      this.init.getPlayer().setY(height - 1);
      listheight.clear();

      for (int j = 0; j < monstres.size(); j++) {
        this.init.verifCollisionMonstre(monstres.get(j));
        this.init.verifCollisionMonstreJoueur(monstres.get(j), this.init.getPlayer(), terminal);
      }
    }
  }

  /**
     *Fonction qui gère le déplacement à gauche.
     */

  public void deplacementL() {

    if (this.init.verifMur('L') == true
        && this.init.getEtat() == false
        && this.init.ecrasecle('L')
        && this.init.ecraseporte('L')
        && this.init.ecrasearme('L')
        && this.init.verifPnj('L')
        && this.init.verifGold('L')) {

      this.terminal.write(".", height, width);
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY()] = '.';
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '@';
      for (Monster m : monstres) {
        this.init.verifMurMonster('R', m);
        this.init.verifCleMonster('R', m);
        this.init.verifGoldMonster('R', m);
        this.init.verifArmeMonster('R', m);
        this.init.verifPorteMonster('R', m);
        this.init.verifPnjMonster('I', m);
        if (m.getName() != "#") {
          monstrewidth = m.getX() + 2;
          monstreheight = m.getY() + 1;
          terminal.write(
              ".",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          this.init.getMatrix()[m.getX()][m.getY()] = '.';
          this.init.getMatrix()[m.getX()][m.getY() + 1] = '$';
        }
      }
      height--;
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          listheight.add(m.getY() + 2);
        }
      }

      int i = 0;
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          monstreheight = listheight.get(i);
          monstrewidth = m.getX() + 2;
          this.terminal.write(
              "$",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          m.setY(listheight.get(i) - 1);
          m.setX(m.getX());
          i++;
        }
      }
      this.terminal.write("@", height, width, AsciiPanel.red);
      this.init.getPlayer().setX(width - 2);
      this.init.getPlayer().setY(height - 1);
      listheight.clear();

      for (int j = 0; j < monstres.size(); j++) {
        this.init.verifCollisionMonstre(monstres.get(j));
        this.init.verifCollisionMonstreJoueur(monstres.get(j), this.init.getPlayer(), terminal);
      }
    }
  }

  /**
     *Fonction qui gère le déplacement en haut.
     */

  public void deplacementU() {

    if (this.init.verifMur('U') == true
        && this.init.getEtat() == false
        && this.init.ecrasecle('U')
        && this.init.ecraseporte('U')
        && this.init.ecrasearme('U')
        && this.init.verifPnj('U')
        && this.init.verifGold('U')) {
      this.terminal.write(".", height, width);
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY()] = '.';
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '@';
      for (Monster m : monstres) {
        this.init.verifMurMonster('D', m);
        this.init.verifCleMonster('D', m);
        this.init.verifArmeMonster('D', m);
        this.init.verifGoldMonster('D', m);
        this.init.verifPorteMonster('D', m);
        this.init.verifPnjMonster('I', m);
        if (m.getName() != "#") {
          monstrewidth = m.getX() + 2;
          monstreheight = m.getY() + 1;

          this.terminal.write(
              ".",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          this.init.getMatrix()[m.getX()][m.getY()] = '.';
          this.init.getMatrix()[m.getX() + 1][m.getY()] = '$';
        }
      }
      width--;
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          listwidth.add(m.getX() + 3);
        }
      }

      int i = 0;
      this.terminal.write("@", height, width, AsciiPanel.red);
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          monstreheight = m.getY() + 1;
          monstrewidth = listwidth.get(i);
          this.terminal.write(
              "$",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          m.setY(m.getY());
          m.setX(listwidth.get(i) - 2);
          i++;
        }
      }
      this.init.getPlayer().setX(width - 2);
      this.init.getPlayer().setY(height - 1);
      listwidth.clear();
      for (int j = 0; j < monstres.size(); j++) {
        this.init.verifCollisionMonstre(monstres.get(j));
        this.init.verifCollisionMonstreJoueur(monstres.get(j), this.init.getPlayer(), terminal);
      }
    }
  }

  /**
     *Fonction qui gère le déplacement en bas.
     */


  public void deplacementD() {

    if (this.init.verifMur('D') == true
        && this.init.getEtat() == false
        && this.init.ecrasecle('D')
        && this.init.ecraseporte('D')
        && this.init.ecrasearme('D')
        && this.init.verifPnj('D')
        && this.init.verifGold('D')) {
      this.terminal.write(".", height, width);
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY()] = '.';
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '@';
      for (Monster m : monstres) {
        this.init.verifMurMonster('U', m);
        this.init.verifCleMonster('U', m);
        this.init.verifArmeMonster('U', m);
        this.init.verifGoldMonster('U', m);
        this.init.verifPorteMonster('U', m);
        this.init.verifPnjMonster('U', m);
        if (m.getName() != "#") {
          monstrewidth = m.getX() + 2;
          monstreheight = m.getY() + 1;
          this.terminal.write(
              ".",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          this.init.getMatrix()[m.getX()][m.getY()] = '.';
          this.init.getMatrix()[m.getX() - 1][m.getY()] = '$';
        }
      }
      width++;
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          listwidth.add(m.getX() + 1);
        }
      }

      this.terminal.write("@", height, width, AsciiPanel.red);
      int i = 0;
      for (Monster m : monstres) {
        if (m.getName() != "#") {
          monstreheight = m.getY() + 1;
          monstrewidth = listwidth.get(i);
          this.terminal.write(
              "$",
              monstreheight,
              monstrewidth,
              AsciiPanel.green);
          m.setY(m.getY());
          m.setX(listwidth.get(i) - 2);
          i++;
        }
      }

      this.init.getPlayer().setX(width - 2);
      this.init.getPlayer().setY(height - 1);
      listwidth.clear();
      for (int j = 0; j < monstres.size(); j++) {
        this.init.verifCollisionMonstre(monstres.get(j));
        this.init.verifCollisionMonstreJoueur(monstres.get(j), this.init.getPlayer(), terminal);
      }
    }
  }

  /**
     *Fonction qui enleve la cle de la map.
     */


  public void enlevercle() {
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1]
        == 'K') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '.';
      this.init.getPlayer().set_cle_to_true();
      this.terminal.write(".", height + 1, width, AsciiPanel.green);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1]
        == 'K') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '.';
      this.init.getPlayer().set_cle_to_true();
      this.terminal.write(".", height - 1, width, AsciiPanel.green);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()]
        == 'K') {
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '.';
      this.init.getPlayer().set_cle_to_true();
      this.terminal.write(".", height, width + 1, AsciiPanel.green);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()]
        == 'K') {
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '.';
      this.init.getPlayer().set_cle_to_true();
      this.terminal.write(".", height, width - 1, AsciiPanel.green);
    }
  }
  
  /**
     *Fonction qui permet enleve la porte de la map.
     */


  public void enleverporte() {

    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1]
        == 'P') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '.';
      this.terminal.write(".", height + 1, width, AsciiPanel.green);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1]
        == 'P') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '.';

      this.terminal.write(".", height - 1, width, AsciiPanel.green);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()]
        == 'P') {
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '.';

      this.terminal.write(".", height, width + 1, AsciiPanel.green);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()]
        == 'P') {
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '.';

      this.terminal.write(".", height, width - 1, AsciiPanel.green);
    }
  }

  /**
     *Fonction qui enleve l'arme de la map.
     */


  public void enleverarme() {
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1]
        == 'W') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '.';
      this.init.getPlayer().set_arme_to_true();
      this.terminal.write(".", height + 1, width, AsciiPanel.green);

      init.getPlayer().setDegat(5);
      init.getPlayer().setDegat(init.getWeapon().getDegat() + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);


    }
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1]
        == 'W') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '.';
      this.init.getPlayer().set_arme_to_true();
      this.terminal.write(".", height - 1, width, AsciiPanel.green);

      init.getPlayer().setDegat(5);
      init.getPlayer().setDegat(init.getWeapon().getDegat() + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);

    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()]
        == 'W') {
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '.';
      this.init.getPlayer().set_arme_to_true();
      this.terminal.write(".", height, width + 1, AsciiPanel.green);

      init.getPlayer().setDegat(5);
      init.getPlayer().setDegat(init.getWeapon().getDegat() + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()]
        == 'W') {
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '.';
      this.init.getPlayer().set_arme_to_true();
      this.terminal.write(".", height, width - 1, AsciiPanel.green);

      init.getPlayer().setDegat(5);
      init.getPlayer().setDegat(init.getWeapon().getDegat() + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);

    }
  }

  /**
     *Fonction qui enleve le gold de l'affichage .
     */

  public void enlevergold() {
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1]
        == 'G') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '.';

      this.terminal.write(".", height + 1, width, AsciiPanel.green);

      init.getPlayer().setGold(init.getPlayer().getGold() + 1);
      this.init.afficheStats(terminal);

    }
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1]
        == 'G') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '.';

      this.terminal.write(".", height - 1, width, AsciiPanel.green);

      init.getPlayer().setGold(init.getPlayer().getGold() + 1);
      this.init.afficheStats(terminal);

    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()]
        == 'G') {
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '.';

      this.terminal.write(".", height, width + 1, AsciiPanel.green);

      init.getPlayer().setGold(init.getPlayer().getGold() + 1);
      this.init.afficheStats(terminal);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()]
        == 'G') {
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '.';

      this.terminal.write(".", height, width - 1, AsciiPanel.green);

      init.getPlayer().setGold(init.getPlayer().getGold() + 1);
      this.init.afficheStats(terminal);


    }
  }
  
  /**
     *Fonction qui permet de changer les stats du Pnj.
     */


  public void augmenteStatsPnjDegats() {
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '.';

      this.terminal.write(".", height + 1, width, AsciiPanel.green);

      init.getPlayer().setDegat(init.randomDegat + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);

    }
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '.';

      this.terminal.write(".", height - 1, width, AsciiPanel.green);

      init.getPlayer().setDegat(init.randomDegat + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);

    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '.';
      this.terminal.write(".", height, width + 1, AsciiPanel.green);

      init.getPlayer().setDegat(init.randomDegat + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '.';
      this.terminal.write(".", height, width - 1, AsciiPanel.green);

      init.getPlayer().setDegat(init.randomDegat + init.getPlayer().getDegat());
      this.init.afficheStats(terminal);

    }
  }

  /**
     *Fonction qui permet de changer les stats du Pnj.
     */

  public void augmenteStatsPnjLife() {
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() + 1] = '.';

      this.terminal.write(".", height + 1, width, AsciiPanel.green);

      init.getPlayer().setLife(init.randomLife + init.getPlayer().getLife());
      this.init.afficheStats(terminal);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX()][this.init.getPlayer().getY() - 1] = '.';

      this.terminal.write(".", height - 1, width, AsciiPanel.green);

      init.getPlayer().setLife(init.randomLife + init.getPlayer().getLife());
      this.init.afficheStats(terminal);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX() + 1][this.init.getPlayer().getY()] = '.';
      this.terminal.write(".", height, width + 1, AsciiPanel.green);

      init.getPlayer().setLife(init.randomLife + init.getPlayer().getLife());
      this.init.afficheStats(terminal);
    }
    if (this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()]
        == 'I') {
      this.init.getMatrix()[this.init.getPlayer().getX() - 1][this.init.getPlayer().getY()] = '.';
      this.terminal.write(".", height, width - 1, AsciiPanel.green);

      init.getPlayer().setDegat(init.randomDegat + init.getPlayer().getLife());
      this.init.afficheStats(terminal);


    }
  }
}