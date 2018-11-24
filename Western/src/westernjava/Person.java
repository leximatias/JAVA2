/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Random;

/**
 * permet de choisir un character
 *
 * @author Matias & Suarez
 */
public class Person {

      /**
       * choisit une lady au hasard
       *
       * @param ladyTable liste contenant toutes les Lady
       * @return un character de type Lady
       */
      public Lady randomLady(ArrayList<ArrayList<Human>> ladyTable) {
            int col, line;
            Random random = new Random();
            Lady character;
            if (ladyTable.size() > 0) {
                  col = random.nextInt(ladyTable.size());
                  line = random.nextInt(ladyTable.get(col).size());
                  character = (Lady) ladyTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }
      /**
       * choisit une thuglady au hasard
       *
       * @param ladyTable liste contenant toutes les Lady
       * @return un character de type ThugLady
       */
      public BanditLady randomThugLady(ArrayList<ArrayList<Human>> ladyTable) {
            int col, line;
            Random random = new Random();
            BanditLady character;
            if (ladyTable.size() > 0) {
                  col = 1;
                  line = random.nextInt(ladyTable.get(col).size());
                  character = (BanditLady) ladyTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }

      /**
       * choisit un cowboy au hasard
       *
       * @param cowboyTable liste contenant toutes les Cowboy
       * @return un character de type Cowboy
       */
      public Cowboy randomCowboy(ArrayList<ArrayList<Human>> cowboyTable) {
            int col, line;
            Random random = new Random();
            Cowboy character;
            if (cowboyTable.size() > 0) {
                  col = random.nextInt(cowboyTable.size());
                  line = random.nextInt(cowboyTable.get(col).size());
                  character = (Cowboy) cowboyTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }

      /**
       * choisit un sherif au hasard
       *
       * @param cowboyTable liste contenant toutes les Cowboy
       * @return un character de type Sherif
       */
      public Sheriff randomSherif(
               ArrayList<ArrayList<Human>> cowboyTable) {
            int col, line;
            Random random = new Random();
            Sheriff character;
            if (cowboyTable.size() > 0) {
                  col = 1;
                  line = random.nextInt(cowboyTable.get(col).size());
                  character = (Sheriff) cowboyTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }

      /**
       * choisit un badcop au hasard
       *
       * @param cowboyTable liste contenant toutes les Cowboy
       * @return un character de type BadCop
       */
      public BadCop randomBadCop(
               ArrayList<ArrayList<Human>> cowboyTable) {
            int col, line;
            Random random = new Random();
            BadCop character;
            if (cowboyTable.size() > 0) {
                  col = 2;
                  line = random.nextInt(cowboyTable.get(col).size());
                  character = (BadCop) cowboyTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }

      /**
       * choisit un thug au hasard
       *
       * @param thugTable liste contenant toutes les Thug
       * @return un character de type Thug
       */
      public Bandit randomThug(ArrayList<ArrayList<Human>> thugTable) {
            int col, line;
            Random random = new Random();
            Bandit character;
            if (thugTable.size() > 0) {
                  col = random.nextInt(thugTable.size());
                  line = random.nextInt(thugTable.get(col).size());
                  character = (Bandit) thugTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }

      /**
       * choisit un indian au hasard
       *
       * @param indianTable liste contenant toutes les Indian
       * @return un character de type Indian
       */
      public Indian randomIndian(
               ArrayList<ArrayList<Human>> indianTable) {
            int col, line;
            Random random = new Random();
            Indian character;
            if (indianTable.size() > 0) {
                  col = random.nextInt(indianTable.size());
                  line = random.nextInt(indianTable.get(col).size());
                  character = (Indian) indianTable.get(col).get(line);
                  System.out.println(character.name);
                  return character;
            } else {
                  System.out.println("try again");
            }
            return (null);
      }

      /**
       * choisit un human au hasard si choice 0 sinon un character du type correspondant à num
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param num correspond au type voulu pour le character override si choice = 0
       * @param list liste contenant toutes les characters
       * @return un character de type Human
       */
      public Human randomHuman(int choice, int num,
               ArrayList<ArrayList<ArrayList<Human>>> list) {
            if (choice == 0) {
                  String[] type = {"Lady", "Cowboy", "Thug", "Indian"};
                  Random random = new Random();
                  num = random.nextInt(type.length);
            }

            switch (num) {
                  case 0:
                        return (randomLady(list.get(0)));
                  case 1:
                        return (randomThugLady(list.get(0)));
                  case 2:
                        return (randomCowboy(list.get(1)));
                  case 3:
                        return (randomSherif(list.get(1)));
                  case 4:
                        return (randomBadCop(list.get(1)));
                  case 5:
                        return (randomThug(list.get(2)));
                  case 6:
                        return (randomIndian(list.get(3)));

                  default:
                        System.out.println("unsupported bug");
                        return (null);
            }
      }

}
