/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package westernjava;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Matias & Suarez
 */
public class WesternJava {

      static ArrayList<ArrayList<ArrayList<Human>>> list = new ArrayList();
      static Choice choice = new Choice();

      /**
       * affiche le numéro ainsi que le nom des character de la liste entré en paramètre
       *
       * @param list liste de character à afficher
       */
      public static void printList(ArrayList<ArrayList<Human>> list) {

            for (int n = 0; n < list.size(); n++) {
                  for (int i = 0; i < list.get(n).size(); i++) {
                        System.out.println(n + "" + i + " " + list.get(n).get(i).name);
                  }
            }
      }

      /**
       * affiche le numéro le nom des character de la liste entré en paramètre ainsi que certain
       * paramètre en fonction du type de character
       *
       * @param c int correspondant au type à afficher (ex:0 pour Lady , 4 pour Indien)
       */
      public static void displayPerson(int c) {
            for (int n = 0; n < list.get(c).size(); n++) {
                  for (int i = 0; i < list.get(c).get(n).size(); i++) {
                        Human man = list.get(c).get(n).get(i);
                        System.out.println("\n" + n + "" + i + " " + man.name);
                        System.out.println("Favorite drink: " + man.favoriteDrink);

                        if (man instanceof Lady) {
                              Lady character = (Lady) man;
                              System.out.println("Dress color: " + character.dressColor);
                              System.out.println("Class: " + character.getClass());
                        }

                        if (man instanceof Cowboy) {
                              Cowboy character = (Cowboy) man;
                              System.out.println("Popularity: " + character.popularity);
                              System.out.println("Class: " + character.getClass());
                        }

                        if (man instanceof Bandit) {
                              Bandit character = (Bandit) man;
                              System.out.println("Look: " + character.look);
                              System.out.println("Class: " + character.getClass());
                        }

                        if (man instanceof Indian) {
                              Indian character = (Indian) man;
                              System.out.println("Totem: " + character.totem);
                              System.out.println("Class: " + character.getClass());
                        }

                  }
            }
      }

      /**
       * @param args the command line arguments
       * @throws java.io.IOException
       */
      public static void main(String[] args) throws IOException {

            //Creation places
            ArrayList<Human> bar_people = new ArrayList();
            ArrayList<Human> street_people = new ArrayList();
            ArrayList<Human> jail_people = new ArrayList();

            MainStreet street = new MainStreet("Oak Street", street_people);

            Bartender pierre = new Bartender("Pierre", "eau", street);
            Bar saloon = new Bar(false, street, pierre, "Saloon", bar_people);

            Jail prison = new Jail(street, "prison", jail_people);
            Places[] places = {saloon, prison};

            saloon.opening();

            //Creation liste character
            ArrayList<ArrayList<Human>> ladylist = new ArrayList();
            ArrayList<Human> simpleladylist = new ArrayList();
            ladylist.add(simpleladylist);
            ArrayList<Human> thugladylist = new ArrayList();
            ladylist.add(thugladylist);

            ArrayList<ArrayList<Human>> cowboylist = new ArrayList();
            ArrayList<Human> simplecowboylist = new ArrayList();
            cowboylist.add(simplecowboylist);
            ArrayList<Human> sheriflist = new ArrayList();
            cowboylist.add(sheriflist);
            ArrayList<Human> badcoplist = new ArrayList();
            cowboylist.add(badcoplist);

            ArrayList<ArrayList<Human>> thuglist = new ArrayList();
            ArrayList<Human> simplethuglist = new ArrayList();
            thuglist.add(simplethuglist);

            ArrayList<ArrayList<Human>> indianlist = new ArrayList();
            ArrayList<Human> simpleindianlist = new ArrayList();
            indianlist.add(simpleindianlist);

            ArrayList<ArrayList<Human>> barmanlist = new ArrayList();
            ArrayList<Human> simplebarmanlist = new ArrayList();
            barmanlist.add(simplebarmanlist);

            //Creation character par lecture fichier
            String fileName = "initialisation.txt";
            FileReader inp = new FileReader(fileName);
            int nb_line = 0;
            int r;
            while ((r = inp.read()) != 47) {
                  if (r == 59) {
                        nb_line++;
                  }

            }

            inp.close();
            FileReader in = new FileReader(fileName);

            //System.out.println("nombre de ligne" + result);
            int i, c, n;

            String type = "";
            String para = "";
            ArrayList<String> parameter = new ArrayList();

            for (int m = 0; m < nb_line; m++) {

                  while ((c = in.read()) != 44) {

                        String t = Character.toString((char) c);
                        type = type + t;
                  }

                  //System.out.println("\ntype " + type);
                  switch (type) {
                        case "Lady":
                              parameter.clear();
                              for (i = 0; i < 5; i++) {
                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;
                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              boolean bo = parameter.get(0).equals("true");
                              Places li;
                              if (parameter.get(4).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }

                              simpleladylist.add(new Lady(bo, parameter.get(1), parameter.get(2), parameter.get(3), li));
                              type = "";
                              break;
                        case "Sherif":
                              parameter.clear();
                              for (i = 0; i < 7; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              if (parameter.get(6).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }
                              sheriflist.add(new Sheriff(Integer.parseInt(parameter.get(0)),
                                       Integer.parseInt(parameter.get(1)), parameter.get(2),
                                       Integer.parseInt(parameter.get(3)), parameter.get(4),
                                       parameter.get(5), li));
                              type = "";
                              break;
                        case "Thug":
                              parameter.clear();
                              for (i = 0; i < 7; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              bo = parameter.get(3).equals("true");
                              if (parameter.get(6).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }
                              simplethuglist.add(new Bandit(Integer.parseInt(parameter.get(0)),
                                       Integer.parseInt(parameter.get(1)), parameter.get(2),
                                       bo, parameter.get(4), parameter.get(5), li));
                              type = "";
                              break;
                        case "ThugLady":
                              parameter.clear();
                              for (i = 0; i < 9; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;
                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              bo = parameter.get(3).equals("true");
                              boolean bo2 = parameter.get(4).equals("true");
                              if (parameter.get(8).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }
                              thugladylist.add(new BanditLady(Integer.parseInt(parameter.get(0)),
                                       Integer.parseInt(parameter.get(1)), parameter.get(2),
                                       bo, bo2, parameter.get(5), parameter.get(6), parameter.get(7), li));
                              type = "";
                              break;
                        case "Cowboy":
                              parameter.clear();
                              for (i = 0; i < 6; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              if (parameter.get(5).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }
                              simplecowboylist.add(new Cowboy(Integer.parseInt(parameter.get(0)),
                                       parameter.get(1), Integer.parseInt(parameter.get(2)),
                                       parameter.get(3), parameter.get(4), li));
                              type = "";
                              break;
                        case "Indian":
                              parameter.clear();
                              for (i = 0; i < 5; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;

                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              if (parameter.get(4).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }
                              simpleindianlist.add(new Indian(Integer.parseInt(parameter.get(0)),
                                       parameter.get(1), parameter.get(2),
                                       parameter.get(3), li));
                              type = "";
                              break;
                        case "BadCop":
                              parameter.clear();
                              for (i = 0; i < 11; i++) {

                                    while ((n = in.read()) != 44 && n != 59) {
                                          String p = Character.toString((char) n);
                                          para = para + p;
                                    }
                                    parameter.add(para);
                                    para = "";
                                    //System.out.println(parameter.get(i));
                              }

                              bo = parameter.get(3).equals("true");

                              if (parameter.get(9).equalsIgnoreCase(places[0].name)) {
                                    li = places[0];
                              } else {
                                    li = street;
                              }
                              badcoplist.add(new BadCop(Integer.parseInt(parameter.get(0)),
                                       Integer.parseInt(parameter.get(1)), parameter.get(2),
                                       bo, Integer.parseInt(parameter.get(4)), parameter.get(5),
                                       Integer.parseInt(parameter.get(6)), parameter.get(7),
                                       parameter.get(8), li,Integer.parseInt(parameter.get(10)))); //,Integer.parseInt(parameter.get(10)
                              type = "";
                              break;

                  }

            }

            list.add(ladylist);
            list.add(cowboylist);
            list.add(thuglist);
            list.add(indianlist);
            list.add(barmanlist);

            choice.mode(list, places);
      }

}
