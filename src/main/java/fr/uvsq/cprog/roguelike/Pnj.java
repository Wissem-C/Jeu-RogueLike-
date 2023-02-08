package fr.uvsq.cprog.roguelike;

/**
   * Classe qui gere les PNJ.
   */
public class Pnj {
  private int bonusVie = 0;
  private int bonusDegat = 0;
  private int coutBonusVie = 0;
  private int coutBonusDegat = 0;

  /**
   * Constructeur du PNJ .
   */

  public Pnj(int bonusVie, int bonusDegat, int coutBonusVie, int coutBonusDegat) {
    this.bonusVie = bonusVie;
    this.bonusDegat = bonusDegat;
    this.coutBonusVie = coutBonusVie;
    this.coutBonusDegat = coutBonusDegat;
  }

  public int getBonusVie() {
    return this.bonusVie;
  }

  public int getBonusDegat() {
    return this.bonusDegat;
  }

  public int getcoutBonusVie() {
    return this.coutBonusVie;
  }

  public int getcoutBonusDegat() {
    return this.coutBonusDegat;
  }
}