/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

/**
 * caractérise l'Humain appartenant à l'interface OutOfLaw
 *
 * @author Matias & Suarez
 */
public interface OutOfLaw {

      /**
       * permet de kidnapper une fille
       *
       * @param girl Lady qui est kidnappé
       */
      void kidnappedLady(Lady girl);

      /**
       * met le personnage en prison
       *
       * @param boy sherif qui met en prison le personnage
       * @param places liste de places disponibles
       */
      void getInJail(Cowboy boy, Places[] places);

      /**
       * ajoute de l'argent à la récompense
       *
       * @param money int correspondant à l'argent ajouter à la récompense
       */
      void addReward(int money);
      
      String getReward();
      String whatIsYourName();
      /**
       * le personnage s'echappe de prison
       */
      void escape();

}
