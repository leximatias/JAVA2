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
        * @param out MainStreet type object corresponding to the street in front of the prison
        * @param name name of the prison
        * @param people list of people inside
       */
      public Jail(MainStreet out, String name, ArrayList<Human> people) {
            super(name, people);
            this.out = out;
      }

      /**
       * allows a character to leave the place
        *
        * @param person character leaving the place
       */
      @Override
      public void exit(Human person) {
            people.remove(person);
            out.enter(person);
      }

      /**
       * allows a character to enter in places
        *
        * @param person character who enters the place
       */
      @Override
      public void enter(Human person) {
            person.place = this;
            people.add(person);
      }

}
