package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Matias & Suarez
 */
public class Jail extends Places {

      MainStreet out;

      /**
       * constructor
       *
       * @param out objet de type MainStreet correspondant à la rue devant la prison
       * @param name nom de la prison
       * @param people liste des gens à l'intérieur
       */
      public Jail(MainStreet out, String name, ArrayList<Human> people) {
            super(name, people);
            this.out = out;
      }

      /**
       * permet a un character de quitter le place
       *
       * @param person character qui quitte le place
       */
      @Override
      public void exit(Human person) {
            people.remove(person);
            out.enter(person);
      }

      /**
       * permet à un character d'enter dans le places
       *
       * @param person character qui entre dans le place
       */
      @Override
      public void enter(Human person) {
            person.place = this;
            people.add(person);
      }

}
