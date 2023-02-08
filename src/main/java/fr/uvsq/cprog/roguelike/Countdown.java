package fr.uvsq.cprog.roguelike;

import asciiPanel.AsciiPanel;

/** Countdown pour rendre le jeu plus difficile . */
public class Countdown {
  private static int seconde = 0;

  /** Début du minuteur . */
  public static void start(int seconds, AsciiPanel terminal, Player p) {
    seconde = seconds;

    Thread thread =
        new Thread(
            new Runnable() {
              public void run() {

                while (seconde > 0) {
                  // Faites une pause de 1000 millisecondes (1 seconde)
                  try {
                    Thread.sleep(1000);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }

                  // Décrementez la variable seconde et affichez le temps restant
                  seconde--;
                  System.out.println(seconde);
                  Init.afficheTimer(terminal);
                  if (p.getLife() <= 0) {
                    break;
                  }
                  if (Lireclavier.getNum() == 1 && Lireclavier.viensB_trait() == false) {
                    seconde = seconds;
                    Lireclavier.setNum(0);
                    break;
                  }

                  if (Lireclavier.getNum() == 1 && Lireclavier.viensB_trait() == true) {
                    Lireclavier.setNum(0);
                    break;
                  }
                }

                if (seconde <= 0) {
                  System.out.println("fin du minuteur");
                  Init.affichage_looser(terminal);
                }
              }
            });

    thread.start();
  }

  public static int getSeconde() {
    return seconde;
  }
}