/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.util.ArrayList;
import java.util.Scanner;
import static westernjava.WesternJava.printList;
import static westernjava.WesternJava.displayPerson;

/**
 * allows you to make choices in the console
 *
 * @author Matias & Suarez
 */
public class Choice {

      Person person = new Person();
      Action action = new Action();

      /**
       * allows to choose a type so the console returns a random character or chooses in  choice function
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param list liste des characters disponibles
       * @return un character de type Human
       */
      public Human human(int choice,
               ArrayList<ArrayList<ArrayList<Human>>> list) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a type:\n1:lady\n2:cowboy\n3:bandit\n"+ "4:indian\n");
            String input;
            do {
                  input = scanner.nextLine();
                  switch (input) {
                        case "1":
                              return person(choice, 0, list);

                        case "2":
                              return person(choice, 1, list);

                        case "3":
                              return person(choice, 2, list);

                        case "4":
                              return person(choice, 3, list);
                        default:
                              return list.get(3).get(0).get(0);
                  }
            } while (!input.contains("quit"));

      }

      /**
        * after display of the available character according to there returns the character chooses according to the number in input
        *
        * @param choice 0 for random 1 to choose 2 for history
        * @param y int corresponding to the type to display (ex: 0 for Lady, 4 for Indian)
        * @param list list of available characters 
       * @return a character of type Human
       */
      public Human person(int choice, int y,
               ArrayList<ArrayList<ArrayList<Human>>> list) {

            Human character;
            Scanner scanner = new Scanner(System.in);
            printList(list.get(y));
            displayPerson(y);
            System.out.println("Enter the number of the character you have chosen.");

            String input;
            input = scanner.nextLine();
            int pos = Integer.parseInt(input);
            int n = pos / 10;
            int i = pos % 10;

            System.out.println("");

            character = list.get(y).get(n).get(i);
            return character;

      }

      /**
        * allows to choose in the console the desired mode for the progress of the project for 
        * each mode, allows to choose the character and the action in the console
        *
        * @param list list of available characters
        * @param list_places list of implemented places
       */
      public void mode(ArrayList<ArrayList<ArrayList<Human>>> list, Places[] list_places) {
            Human character;
            Scanner scanner = new Scanner(System.in);
            String input;
            do {
                  System.out.println("\nEnter 1 for random; 2 to choose; " +
                    "3 for history \n(type 'quit' to exit)");
                  input = scanner.nextLine();
                  int choice;
                  switch (input) {
                        case "1":
                              choice = 0;
                              character = person.randomHuman(0, 0, list);
                              action.human(choice, character, list_places, list);
                              break;

                        case "2":
                              choice = 1;
                              do {
                                    character = human(choice, list);

                                    do {
                                          action.human(choice, character, list_places, list);
                                          System.out.println("type 'other' for another character, if not type nothing");
                                          input = scanner.nextLine();
                                    } while (!input.contains("other"));
                                    input = scanner.nextLine();
                              } while (!input.contains("mode"));

                              break;

                        case "3":
                              choice = 2;
                              character = human(choice, list);

                              do {
                                    character = action.human(choice, character, list_places, list);

                              } while (!input.contains("quit"));
                              break;
                  }
            } while (!input.contains("quit"));
      }

}
