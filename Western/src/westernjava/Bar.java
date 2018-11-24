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
       * @param open true si le bar est ouvert
       * @param out objet de type MainStreet correspondant à la rue devant le bar
       * @param barman Humain de type Barman qui sert
       * @param name nom de la prison
       * @param people liste des gens à l'intérieur
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
       * permet d'ouvrir le bar
       */
      public void opening() {
            barman.place.exit(barman);
            open = true;
            enter(barman);
      }

      /**
       * permet a un personnage de quitter le place
       *
       * @param perso personnage qui quitte le place
       */
      @Override
      public void exit(Human perso) {
            people.remove(perso);
            out.enter(perso);
      }

      /**
       * permet à un personnage d'enter dans le places
       *
       * @param perso personnage qui entre dans le place
       */
      @Override
      public void enter(Human perso) {
            perso.place = this;
            people.add(perso);
      }

}
