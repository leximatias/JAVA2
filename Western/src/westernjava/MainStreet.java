package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Matias & Suarez
 */
public class MainStreet extends Places {

      Jail jail;

      /**
       * constructor
       *
       * @param name nom de la rue
       * @param people liste des gens dans la rue
       */
      public MainStreet(String name, ArrayList<Human> people) {
            super(name, people);
            this.jail = jail;
      }

      /**
       * permet a un personnage de quitter le place
       *
       * @param person personnage qui quitte le place
       */
      @Override
      public void exit(Human person) {
            people.remove(person);
      }

      /**
       * permet à un personnage d'enter dans le places
       *
       * @param person person personnage qui entre dans le place
       */
      @Override
      public void enter(Human person) {
            person.place = this;
            people.add(person);
      }

}
