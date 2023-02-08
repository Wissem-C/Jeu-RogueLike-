package fr.uvsq.cprog.roguelike;

/**
   *Classe pour gérer les armes .
     */

public class Weapon {
  private int degat;
  private String type;
  private int coutmana;

  /**
     *Constructeur de la classe Weapon .
     */
  public Weapon(int degat, String type, int coutmana) {
    this.degat = degat;
    this.type = type;
    this.coutmana = coutmana;
  }

  public int getDegat() {
    return this.degat;
  }

  public String getType() {
    return this.type;
  }
}