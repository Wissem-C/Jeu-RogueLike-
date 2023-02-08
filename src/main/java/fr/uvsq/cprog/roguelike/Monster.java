package fr.uvsq.cprog.roguelike;

/** Classe monstre les PNJ qui attaque le PJ. */
public class Monster {
  /** . Constructor. */
  private String name;

  private int life;
  private int level;
  private int magic;
  private int degat;
  private int coord1;
  private int coord2;

  /**
   * . Constructeur du monstre.
   */

  public Monster(String nom, int vie, int niveau, int degat, int coord1, int coord2) {
    this.name = nom;
    this.life = vie;
    this.level = niveau;
    this.degat = degat;
    this.coord1 = coord1;
    this.coord2 = coord2;
  }

  public void setY(int coord2) {
    this.coord2 = coord2;
  }

  public void setX(int coord1) {
    this.coord1 = coord1;
  }

  public void setName(String s) {
    this.name = s;
  }

  public int getX() {
    return this.coord1;
  }

  public int getY() {
    return this.coord2;
  }

  /**
   * . Cette fonction renvoie le nom du monstre.
   *
   * @return Retourne le nom du monstre.
   */

  public String getName() {
    return this.name;
  }

  /**
   * . Cette fonction renvoie la vie du monstre.
   *
   * @return Retourne la vie du monstre.
   */
  public int getLife() {
    return this.life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public int getDegat() {
    return this.degat;
  }

  public void setDegat(int degat) {
    this.degat = degat;
  }
}