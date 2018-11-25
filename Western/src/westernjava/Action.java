package westernjava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 *
 * @author Matias & Suarez
 */
public class Action {

      Random random = new Random();
      Person person = new Person();

      /**
        * displays and executes available actions for the character => obj
        *
        * @param choice 0 for random 1 to choose 2 for history
        * @param obj the character doing the action
        * @param list_places list of implemented places
        * @param list list of available characters
        * @return a character of type Lady
       */
      public Lady lady(int choice, Lady obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {
            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = random.nextInt(3);
                              break;

                        case 1:
                              System.out.println("1 Kidnap a Lady");
                              System.out.println("2 Change Dress");
                              System.out.println("3 Speak with Someone");
                              System.out.print("Input the number of your choice: ");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 kidnap a girl");
                                    System.out.println("2 change your dress");
                                    System.out.println("3 talk to someone");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in  " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 exit");
                                    System.out.println("1 kidnap a lady");
                                    System.out.println("2 change the dress");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 order a drink");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (4):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    return obj;
                              }
                              break;
                  }

                  switch (num) {

                        case (1):

                              BanditLady badlady = new BanditLady(0, 0, "mysterious", false, obj.isKidnapped, obj.dressColor, obj.name, obj.favoriteDrink, obj.place, obj.state);
                              list.get(0).get(0).remove(obj);
                              Lady girl = person.randomLady(list.get(0));
                              while (girl == obj) {
                                    girl = person.randomLady(list.get(0));
                              }
                              badlady.kidnappedLady(girl);

                              if (random.nextInt(2) == 1) {
                                    Sheriff cop = person.randomSherif(list.get(1));
                                    cop.catchABandit(badlady, list_places);
                                    cop.freeTheLady(girl);
                              }
                              return badlady;

                        case (2):
                              obj.getChanged();
                              return obj;

                        case (3):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }
                              return obj;
                        default:
                              throw new Exception("unknown human");
                  }
            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Try again.");
                  System.out.println("If you want to quit type 'quit', otherwise type something else");
                  return obj;
            }
      }

      /**
        *displays and executes available actions for the character obj
        *
        * @param choice 0 for random 1 to choose 2 for history
        * @param obj the character doing the action
        * @param list_places list of implemented places
        * @param list list of available characters
        * @return a character of type banditLady
       */
      public BanditLady banditlady(int choice, BanditLady obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {
            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = random.nextInt(3);
                              break;

                        case 1:
                              System.out.println("Type the number of the action you want to make.");
                              System.out.println("1 kidnap a lady");
                              System.out.println("2 change the dress");
                              System.out.println("3 talk to someone");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want.");
                                    System.out.println("0 Go to the bar");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in  " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 exit");
                                    System.out.println("1 kidnap a lady");
                                    System.out.println("2 change the dress");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 order a drink");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (4):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                   System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 try to escape");
                                    System.out.println("1 stay for the execution");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);
                                    switch (num) {
                                          case (0):
                                                if (random.nextInt(2) == 0) {
                                                      obj.escape();
                                                } else {
                                                      System.out.println("You have been caught. You did not manage to escape.");
                                                }
                                                return obj;

                                          case (4):
                                                System.out.println("You were hung for kidnapping the sheriff's daughter.");
                                                return obj;
                                    }
                              }
                              break;

                  }

                  switch (num) {

                        case (1):
                              Lady girl = person.randomLady(list.get(0));
                              while (girl == obj) {
                                    girl = person.randomLady(list.get(0));
                              }
                              obj.kidnappedLady(girl);
                              if (random.nextInt(2) == 1) {
                                    Sheriff cop = person.randomSherif(list.get(1));
                                    cop.catchABandit(obj, list_places);
                                    cop.freeTheLady(girl);
                              }
                              return obj;

                        case (2):
                              obj.getChanged();
                              return obj;

                        case (3):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }
                              return obj;
                        default:
                              throw new Exception("unknown action");
                  }

            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Please try again.");
                  System.out.println("If you want to leave type 'quit' otherwise type something else");
                  return obj;
            }

      }

      /**
        * displays and executes available actions for the character obj
        *
        * @param choice 0 for random 1 to choose 2 for history
        * @param obj the character doing the action
        * @param list_places list of implemented places
        * @param list list of available characters
        * @return a character of type Cowboy
       */
      public Cowboy cowboy(int choice, Cowboy obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {

            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = random.nextInt(6);
                              break;

                        case 1:
                              System.out.println("Type the number of the action you want to make.");
                              System.out.println("1 free a girl");
                              System.out.println("2 kidnap a lady");
                              System.out.println("3 talk to someone");
                              System.out.println("4 shoot a villain");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 free a girl");
                                    System.out.println("2 kidnap a lady");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 shoot a villain");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in  " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 exit");
                                    System.out.println("1 free a girl");
                                    System.out.println("2 kidnap a lady");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 shoot a villain");
                                    System.out.println("5 order a drink");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (5):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                              }
                              break;

                  }

                  switch (num) {

                        case (1):
                              Lady girl = person.randomLady(list.get(0));
                              obj.freeTheLady(girl);
                              return obj;

                        case (2):
                              BadCop badcop = new BadCop(0, 0, "evil", false, obj.popularity, obj.adjective, obj.money, obj.name, obj.favoriteDrink, obj.place,0); // int
                              list.get(1).get(0).remove(obj);
                              girl = person.randomLady(list.get(0));
                              badcop.kidnappedLady(girl);

                              if (random.nextInt(2) == 1) {
                                    Sheriff cop = person.randomSherif(list.get(1));
                                    cop.catchABandit(badcop, list_places);
                                    cop.freeTheLady(girl);
                              }
                              return badcop;

                        case (3):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }
                              return obj;

                        case (4):
                              switch (random.nextInt(2)) {
                                    case 0:
                                          Bandit badboy = (Bandit) person.randomHuman(2, 5, list);
                                          System.out.println("Take this opportunity! If want to put him in jail and become sheriff type '1' if not type '2'");
                                          input = scanner.nextLine();
                                          int becoming = Integer.parseInt(input);

                                          switch (becoming) {
                                                case 1:
                                                      Sheriff cop = new Sheriff(0, obj.popularity, obj.adjective, obj.money, obj.name, obj.favoriteDrink, obj.place);
                                                      list.get(1).get(0).remove(obj);
                                                      cop.shoot(badboy, cop, list_places);
                                                      return cop;

                                                default:
                                                      cop = (Sheriff) person.randomHuman(2, 3, list);
                                                      obj.shoot(badboy, cop, list_places);
                                                      return obj;
                                          }

                                    default:
                                          BadCop badboy2 = (BadCop) person.randomHuman(2, 4, list);
                                          System.out.println("Take this opportunity! If want to put him in jail and become sheriff type '1' if not type '2'");
                                          input = scanner.nextLine();
                                          becoming = Integer.parseInt(input);

                                          switch (becoming) {
                                                case 1:
                                                      Sheriff cop = new Sheriff(0, obj.popularity, obj.adjective, obj.money, obj.name, obj.favoriteDrink, obj.place);
                                                      list.get(1).get(0).remove(obj);
                                                      cop.shoot(badboy2, cop, list_places);
                                                      return cop;

                                                default:
                                                      cop = (Sheriff) person.randomHuman(2, 3, list);
                                                      obj.shoot(badboy2, cop, list_places);
                                                      return obj;
                                          }
                              }

                        default:
                              throw new Exception("action unknown");
                  }
            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Please try again.");
                  System.out.println("If you want to leave type 'quit' otherwise type something else");
                  return obj;
            }

      }

      /**
       * affiche et exécute les actions disponible pour le character obj
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param obj le character qui effectue l'action
       * @param list_places liste des places implémentés
       * @param list liste des characters disponibles
       * @return un character de type Shérif
       */
      public Sheriff sherif(int choice, Sheriff obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {
            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = random.nextInt(6);
                              break;

                        case 1:
                              System.out.println("Type the number of the action you want to make.");
                              System.out.println("1 free a girl");
                              System.out.println("2 shoot a villain");
                              System.out.println("3 talk to someone");
                              System.out.println("4 state a reward for a villain's head");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " is at " + obj.place.name);
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 free a girl");
                                    System.out.println("2 shoot a villain");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 state a reward for a villain's head");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 free a girl");
                                    System.out.println("2 shoot a villain");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 order a drink");
                                    System.out.println("5 state a reward for a villain's head");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (4):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    return obj;
                              }
                  }

                  switch (num) {

                        case (1):
                              Lady girl = person.randomLady(list.get(0));
                              obj.freeTheLady(girl);
                              return obj;

                        case (2):
                              switch (random.nextInt(2)) {
                                    case 0:
                                          Bandit badboy = (Bandit) person.randomHuman(2, 5, list);
                                          obj.shoot(badboy, obj, list_places);
                                          return obj;

                                    default:
                                          BadCop badboy2 = (BadCop) person.randomHuman(2, 4, list);
                                          obj.shoot(badboy2, obj, list_places);
                                          return obj;
                              }

                        case (3):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }

                              return obj;
                        case (5):
                              int money = random.nextInt(1234)*100;
                              switch (random.nextInt(2)) {
                                    case 0:
                                          Bandit badboy = (Bandit) person.randomHuman(2, 5, list);
                                          obj.searchABandit(badboy,money);
                                          return obj;

                                    default:
                                          BadCop badboy2 = (BadCop) person.randomHuman(2, 4, list);
                                          obj.searchABandit(badboy2, money);
                                          return obj;
                              }

                              

                        default:
                              throw new Exception("action inconnu");
                  }
            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Please try again.");
                  System.out.println("If you want to leave type 'quit' otherwise type something else");
                  return obj;
            }
      }

      /**
       * affiche et exécute les actions disponible pour le character obj
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param obj le character qui effectue l'action
       * @param list_places liste des places implémentés
       * @param list liste des characters disponibles
       * @return un character de type BadCop
       */
      public BadCop badcop(int choice, BadCop obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {
            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = random.nextInt(6);
                              break;

                        case 1:
                             System.out.println("Type the number of the action you want to make.");
                              System.out.println("1 free a girl");
                              System.out.println("2 kidnap a lady");
                              System.out.println("3 talk to someone");
                              System.out.println("4 shoot a villain");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 free a girl");
                                    System.out.println("2 kidnap a lady");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 shoot a villain");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in  " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 free a girl");
                                    System.out.println("2 kidnap a lady");
                                    System.out.println("3 talk to someone");
                                    System.out.println("4 shoot a villain");
                                    System.out.println("5 order a drink");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (5):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " est en " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 try to escape");
                                    System.out.println("1 stay for the execution");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);
                                    switch (num) {
                                          case (0):
                                                if (random.nextInt(2) == 0) {
                                                      obj.escape();
                                                } else {
                                                      System.out.println("You have been caught. You did not manage to escape.");
                                                }
                                                return obj;

                                          case (4):
                                                System.out.println("You've been hung for kidnapping the sheriff's daughter.");
                                                return obj;
                                    }
                              }
                              break;

                  }

                  switch (num) {

                        case (1):
                              Lady girl = person.randomLady(list.get(0));
                              obj.freeTheLady(girl);
                              return obj;

                        case (2):

                              girl = person.randomLady(list.get(0));
                              obj.kidnappedLady(girl);

                              int gettojail = random.nextInt(2);
                              if (gettojail == 1) {
                                    Sheriff cop = person.randomSherif(list.get(1));
                                    cop.catchABandit(obj, list_places);
                                    cop.freeTheLady(girl);
                              }
                              return obj;

                        case (3):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }
                              return obj;

                        case (4):

                              switch (random.nextInt(2)) {
                                    case 0:
                                          Bandit badboy = (Bandit) person.randomHuman(2, 5, list);
                                          Sheriff cop = (Sheriff) person.randomHuman(2, 3, list);
                                          obj.shoot(badboy, cop, list_places);
                                          return obj;

                                    default:
                                          BadCop badboy2 = (BadCop) person.randomHuman(2, 4, list);
                                          cop = (Sheriff) person.randomHuman(2, 3, list);
                                          obj.shoot(badboy2, cop, list_places);
                                          return obj;
                              }

                        default:
                              throw new Exception("action inconnu");
                  }
            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Please try again.");
                  System.out.println("If you want to leave type 'quit' otherwise type something else");
                  return obj;
            }

      }

      /**
       * affiche et exécute les actions disponible pour le character obj
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param obj le character qui effectue l'action
       * @param list_places liste des places implémentés
       * @param list liste des characters disponibles
       * @return un character de type bandit
       */
      public Bandit bandit(int choice, Bandit obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {
            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = random.nextInt(6);
                              break;

                        case 1:
                              System.out.println("Type the number of the action you want to make.");
                              System.out.println("1 kidnap a lady");
                              System.out.println("2 talk to someone");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 kidnap a lady");
                                    System.out.println("2 talk to someone");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 exit");
                                    System.out.println("1 kidnap a lady");
                                    System.out.println("2 talk to someone");
                                    System.out.println("3 order a drink");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (3):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 try to escape");
                                    System.out.println("1 stay for the execution");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);
                                    switch (num) {
                                          case (0):
                                                if (random.nextInt(2) == 0) {
                                                      obj.escape();
                                                } else {
                                                      System.out.println("You have been caught. You did not manage to escape.");
                                                }
                                                return obj;

                                          case (1):
                                                System.out.println("You were hung for kidnapping the lady.");
                                                return obj;
                                    }
                              }
                              break;

                  }

                  switch (num) {

                        case (1):

                              Lady girl = person.randomLady(list.get(0));
                              obj.kidnappedLady(girl);

                              int gettojail = random.nextInt(2);
                              if (gettojail == 1) {
                                    Sheriff cop = person.randomSherif(list.get(1));
                                    cop.catchABandit(obj, list_places);
                                    System.out.println("You're in prison...");

                                    cop.freeTheLady(girl);
                              }
                              return obj;

                        case (2):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }
                              return obj;

                        default:
                              throw new Exception("unknown action");
                  }
            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Please try again..");
                  System.out.println("If you want to leave type 'quit' otherwise type something else");
                  return obj;
            }
      }

      /**
       * affiche et exécute les actions disponible pour le character obj
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param obj le character qui effectue l'action
       * @param list_places liste des places implémentés
       * @param list liste des characters disponibles
       * @return un character de type Indian
       */
      public Indian indian(int choice, Indian obj, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {

            try {
                  int num = 0;
                  System.out.println(obj.getClass());
                  Scanner scanner = new Scanner(System.in);
                  String input;
                  switch (choice) {
                        case 0:
                              num = 0;
                              break;

                        case 1:
                              System.out.println("Type the number of the action you want to make.");
                              System.out.println("1 talk to someone");
                              input = scanner.nextLine();
                              num = Integer.parseInt(input);
                              break;

                        default:
                              if (obj.place instanceof MainStreet) {
                                    //action dispo street
                                    System.out.println(obj.name + " est sur " + obj.place.name);
                                    System.out.println("Type the number of the action you want.");
                                    System.out.println("0 go to the bar");
                                    System.out.println("1 talk to someone");

                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goTo(list_places[0]);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Bar) {
                                    System.out.println(obj.name + " is in " + obj.place.name);
                                    System.out.println("Type the number of the action you want to make.");
                                    System.out.println("0 exit");
                                    System.out.println("1 talk to someone");
                                    System.out.println("2 order a drink");
                                    input = scanner.nextLine();
                                    num = Integer.parseInt(input);

                                    switch (num) {
                                          case (0):
                                                obj.goOut();
                                                return obj;
                                          case (2):
                                                obj.orderADrink(obj.favoriteDrink);
                                                return obj;
                                    }
                              } else if (obj.place instanceof Jail) {
                                    System.out.println(obj.name + " is in " + obj.place.name);

                                    return obj;
                              }
                              break;
                  }

                  switch (num) {

                        case (1):
                              if (!obj.place.people.isEmpty()) {
                                    Human someone = person.randomHuman(0, 0, list);
                                    while (someone == obj) {
                                          someone = person.randomHuman(0, 0, list);
                                    }
                                    obj.talkToSomeone(someone);
                              } else {
                                    System.out.println("You are currently alone. You cannot speak to anyone else.");
                              }
                              return obj;

                        default:
                              throw new Exception("unknown action");
                  }
            } catch (Exception ex) {
                  System.err.println(ex.getMessage());
                  System.out.println("You did not enter a number corresponding to an action.");
                  System.out.println("Try again.");
                  System.out.println("If you want to quit type 'quit', otherwise type something else");
                  return obj;
            }

      }

      /**
       * redirige vers la fonction correspondante au type de man
       *
       * @param choice 0 pour random 1 pour choisir 2 pour histoire
       * @param man le character qui effectue l'action
       * @param list_places liste des places implémentés
       * @param list liste des characters disponibles
       * @return un character de type Human
       */
      public Human human(int choice, Human man, Places[] list_places,
               ArrayList<ArrayList<ArrayList<Human>>> list) {

            if (man instanceof BanditLady) {
                  BanditLady character = (BanditLady) man;
                  character = banditlady(choice, character, list_places, list);
                  return character;
            }

            if (man instanceof Lady) {
                  Lady character = (Lady) man;
                  character = lady(choice, character, list_places, list);
                  return character;
            }

            if (man instanceof Sheriff) {
                  Sheriff character = (Sheriff) man;
                  character = sherif(choice, character, list_places, list);
                  return character;
            }

            if (man instanceof BadCop) {
                  BadCop character = (BadCop) man;
                  character = badcop(choice, character, list_places, list);
                  return character;
            }

            if (man instanceof Cowboy) {
                  Cowboy character = (Cowboy) man;
                  character = cowboy(choice, character, list_places, list);
                  return character;
            }

            if (man instanceof Bandit) {
                  Bandit character = (Bandit) man;
                  character = bandit(choice, character, list_places, list);
                  return character;
            }

            if (man instanceof Indian) {
                  Indian character = (Indian) man;
                  character = indian(choice, character, list_places, list);
                  return character;
            }

            return man;
      }
}
