package fr.uvsq.cprog.roguelike;

/** Classe player gerant la creation du joueur. */
public class Player {
  private int degat;
  private String name;
  private int life;
  private int level;
  private int magic;
  private Weapon stuff;
  private int coordx;
  private int coordy;
  private boolean cle;
  private boolean arme;
  private int gold;

  /** . Constructeur. */
  public Player(
      String nom,
      int vie,
      int niveau,
      Weapon stuff,
      int coordx,
      int coordy,
      boolean possedecle,
      int degat,
      boolean possedearme,
      int gold) {
    this.name = nom;
    this.life = vie;
    this.level = niveau;
    this.stuff = stuff;
    this.coordx = coordx;
    this.coordy = coordy;
    this.cle = possedecle;
    this.degat = degat;
    this.arme = possedearme;
    this.gold = gold;
  }

  public void set_arme_to_true() {
    this.arme = true;
  }

  public void set_cle_to_true() {
    this.cle = true;
  }

  public boolean getCle() {
    return this.cle;
  }

  public void setCle(boolean cle) {
    this.cle = cle;
  }

  public boolean getArme() {
    return this.arme;
  }

  public void setY(int coordy) {
    this.coordy = coordy;
  }

  public void setX(int coordx) {
    this.coordx = coordx;
  }

  public int getX() {
    return this.coordx;
  }

  public int getY() {
    return this.coordy;
  }

  public int getGold() {
    return this.gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

  /**
   * . Cette fonction renvoie la quantit├® de degat joueur.
   *
   * @return Retourne la quantit├® de degat du joueur.
   */
  public int getDegat() {
    return this.degat;
  }

  /**
   *  Cette fonction change les degats du joueur .
   */
  public void setDegat(int degat) {
    this.degat = degat;
  }

  /**
   * . Cette fonction renvoie le nom du joueur.
   *
   * @return Retourne le nom du joueur.
   */
  public String getName() {
    return this.name;
  }

  /**
   * . Cette fonction renvoie la vie du joueur.
   *
   * @return Retourne la vie du joueur.
   */
  public int getLife() {
    return this.life;
  }

  /**
   * . Cette fonction renvoie le niveau du joueur.
   *
   * @return Retourne le niveau du joueur.
   */
  public int getLevel() {
    return this.level;
  }

  /**
   * . Cette fonction renvoie l'ensemble de l'équipement du joueur.
   *
   * @return Retourne l'equipement du joueur.
   */
  public Weapon getStuff() {
    return this.stuff;
  }

  /**
   *  Cette fonction change le nom du joueur .
   */
  public void setName(String nam) {
    this.name = nam;
  }

  /**
   *  Cette fonction change la vie du joueur .
   */
  public void setLife(int life) {
    this.life = life;
  }

  /**
   * Cette fonction change le niveau du joueur .
   */
  public void setLevel(int level) {
    this.level = level;
  }
}
