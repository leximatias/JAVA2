
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
       * @param name place name
       * @param people list people in this places
       */
      public Places(String name, ArrayList<Human> people) {
            this.name = name;
            this.people = people;
      }

      /**
        * allows a character to enter in the places
        *
        * @param person who enters the place
       */
      public abstract void enter(Human person);

      /**
        * allows a character to leave the place
        *
        * @param person who leaves the place
       */
      public abstract void exit(Human person);

}
