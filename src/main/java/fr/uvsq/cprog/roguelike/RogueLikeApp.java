package fr.uvsq.cprog.roguelike;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;


/**
 * Cette classe est le programme principal du projet.
 */

public class RogueLikeApp extends JFrame implements KeyListener {
  /** Attribut pour gerer certains problemes de compilation. (Tuto de Trystan) */
  private static final long serialVersionUID = 1060623638149583738L;

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  private static AsciiPanel terminal;
  private static Init initialisation;
  char[][] matrix = new char[100][100];
  private TraitementDeplacement dep;
  private Lireclavier lc;

  /**
   * Constructeur du RogueLike .
   */

  public RogueLikeApp() {
    super();
    terminal = new AsciiPanel(80, 40);
    add(terminal);
    affichage();
    lc = new Lireclavier(matrix, initialisation, terminal, dep);
    
    addKeyListener(this);
    pack();
  }

  public void repaint() {
    super.repaint();
  }
  /**
   * Methode interne a KeyListener.
   *
   * @param e KeyEvent.
   */

  public void keyPressed(KeyEvent e) {
    repaint();
    try {
      lc.deplacer(e);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    repaint();
  }

  /**
   * Methode interne a KeyListener.
   *
   * @param e KeyEvent.
   */
  public void keyReleased(KeyEvent e) {}

  /**
   * Methode interne a KeyListener.
   *
   * @param e KeyEvent.
   */
  public void keyTyped(KeyEvent e) {}

  /**
   * Methode main permettant de jouer a Rogue Like.
   *
   * @param args null
   */
  public static void main(String[] args) {
    RogueLikeApp app = new RogueLikeApp();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
  }

  void affichage() {
    terminal.writeCenter("[G] pour crèer une nouvelle partie ", 10);
    terminal.writeCenter("[B] pour continuer la dernière partie que vous avez save ", 11);
    terminal.writeCenter(
        "Vous avez 50 secondes par partie pour sauver la princesse", 13, AsciiPanel.red);
  }
}