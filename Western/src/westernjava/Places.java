/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Matias & Suarez
 */
public abstract class Places {

      String name;
      ArrayList<Human> people = new ArrayList();

      /**
       * constructor
       *
       * @param name nom du lieux
       * @param people liste des gens dans ce lieux
       */
      public Places(String name, ArrayList<Human> people) {
            this.name = name;
            this.people = people;
      }

      /**
       * permet à un personnage d'enter dans le lieux
       *
       * @param person personnage qui entre dans le lieu
       */
      public abstract void enter(Human person);

      /**
       * permet a un personnage de quitter le lieu
       *
       * @param person personnage qui quitte le lieu
       */
      public abstract void exit(Human person);

}
