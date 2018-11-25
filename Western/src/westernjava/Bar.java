package westernjava;

import java.util.ArrayList;

/**
 *
 * @author Matias & Suarez
 */
public class Bar extends Places {

      Boolean open;
      MainStreet out;
      Bartender barman;
      Jail jail;

      /**
       *
        * @param open true if the bar is open
        * @param out MainStreet type object corresponding to the street in front of the bar
        * @param barman Human type Barman serving
        * @param name name of the prison
        * @param people list of people inside
        * /
       */
      public Bar(Boolean open, MainStreet out, Bartender barman, String name, ArrayList people) {
            super(name, people);
            this.open = open;
            this.out = out;
            this.barman = barman;
      }

      /**
       * permet de récuperer le personnage qui sert
       *
       * @return le barman de type Barman
       */
      public Bartender getBarman() {
            return barman;
      }

      /**
        * open the bar  
        */
      public void opening() {
            barman.place.exit(barman);
            open = true;
            enter(barman);
      }

      /**
        * allows a character to leave the place
        *
        * @param perso character who leaves the place
       */
      @Override
      public void exit(Human perso) {
            people.remove(perso);
            out.enter(perso);
      }

      /**
        * allows a character to enter in the places
        *
        * @param perso character who enters the place
       */
      @Override
      public void enter(Human perso) {
            perso.place = this;
            people.add(perso);
      }

}
