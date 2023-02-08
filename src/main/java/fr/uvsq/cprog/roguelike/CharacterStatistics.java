package fr.uvsq.cprog.roguelike;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/** Classe gérant les stats en sauvegarde . */
public class CharacterStatistics {
  private int healthPoints;
  private int damagePoints;
  private int gold;
  private boolean key;

  private int countdown;

  /** Constructeur de la classe des statistiques quand on tape S . */
  public CharacterStatistics(
      int healthPoints, int damagePoints, int gold, boolean key, int countdown) {
    this.healthPoints = healthPoints;
    this.damagePoints = damagePoints;
    this.gold = gold;
    this.key = key;
    this.countdown = countdown;
  }

  /** Fonction qui remplit le property file . */
  public static void saveToPropertiesFile(
      int healthPoints, int damagePoints, int gold, int countdown, boolean key) throws IOException {
    Properties properties = new Properties();
    properties.setProperty("healthPoints", Integer.toString(healthPoints));
    properties.setProperty("damagePoints", Integer.toString(damagePoints));
    properties.setProperty("gold", Integer.toString(gold));
    properties.setProperty("key", Boolean.toString(key));
    properties.setProperty("countdown", Integer.toString(countdown));

    FileOutputStream fileOutputStream = new FileOutputStream(".properties");
    properties.store(fileOutputStream, "Character statistics");
    fileOutputStream.close();
  }

  /** Fonction qui lit ├á partir du fichier properties . */
  public static CharacterStatistics loadFromPropertiesFile(String fileName) throws IOException {
    Properties properties = new Properties();
    FileInputStream fileInputStream = new FileInputStream(".properties");
    properties.load(fileInputStream);
    int healthPoints = Integer.parseInt(properties.getProperty("healthPoints"));
    int damagePoints = Integer.parseInt(properties.getProperty("damagePoints"));
    int gold = Integer.parseInt(properties.getProperty("gold"));
    boolean key = Boolean.parseBoolean(properties.getProperty("key"));
    int countdown = Integer.parseInt(properties.getProperty("countdown"));

    fileInputStream.close();
    return new CharacterStatistics(healthPoints, damagePoints, gold, key, countdown);
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public int getDamagePoints() {
    return damagePoints;
  }

  public void setDamagePoints(int damagePoints) {
    this.damagePoints = damagePoints;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

  public boolean getKey() {
    return key;
  }

  public void setKey(boolean key) {
    this.key = key;
  }

  public int getCountdown() {
    return countdown;
  }

  public void setCountdown(int countdown) {
    this.countdown = countdown;
  }
}