/* Travail réalisé par :
Bennabi Ghiles Rayane et Baouche Mohamed Djaouad
*/

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean b = false;
        Element[] element = null;
        Scanner sc = new Scanner(System.in);
        //sc.useLocale(Locale.US);
        /* La methode ci-dessus change la manière dont les float sont interprétés
        au moment de l'éxecution quand le programme demande une valeur il faut l'écrire
        avec une virgule si le systeme est configuré en français au lieu d'un point pour
        séparer la partie décimal donc si on utilise cette méthode on pourra utiliser un point
        */

        while (!b) {
            System.out.println("1-> Génération automatique \n2-> Génération au clavier");
            int choix = sc.nextInt();

            if (choix == 1) { //Génération automatique
                b = true;
                Random random = new Random();
                int n = random.nextInt(100000) + 1;
                element = new Element[n];

                for (int i = 0; i < n; i++) {
                    int cle = random.nextInt(100000);
                    float val = random.nextFloat() * 100; //Génère une valeur flottante entre 0 et 100
                    element[i] = new Element(cle, val);
                }

            } else if (choix == 2) { //Génération manuelle
                b = true;
                System.out.println("Entrez la taille du tableau :");
                choix = sc.nextInt();
                element = new Element[choix];

                for (int i = 0; i < choix; i++) {
                    System.out.println("Élément " + (i + 1));
                    System.out.print("Entrez une clé : ");
                    int cle = sc.nextInt();

                    float val = 0;
                    boolean saisieValide = false;

                    //Boucle pour éviter les erreurs de saisie
                    while (!saisieValide) {
                        System.out.print("Entrez une valeur : ");
                        if (sc.hasNextFloat()) {
                            val = sc.nextFloat();
                            saisieValide = true;
                        } else {
                            System.out.println("Erreur : veuillez entrer un nombre valide !");
                            sc.next(); //Vide l'entrée incorrecte
                        }
                    }

                    element[i] = new Element(cle, val);
                }
            } else {
                System.out.println("Choix invalide");
            }
        }

        System.out.println("*********************** Tableau initial **********************");
        //TriAlgo.affiche(element);

        Element[] copy1 = new Element[element.length];
        Element[] copy2 = new Element[element.length];

        for (int p = 0; p < element.length; p++) {
            copy1[p] = element[p];
            copy2[p] = element[p];
        }

        System.out.println("\n***************************** TRI SELECTION MAX : ***********************\n");
        long debSelection = System.currentTimeMillis();
        TriAlgo.selectionMax(element);
        long finSelection = System.currentTimeMillis();
        System.out.println("Tri sélection max -> Temps d'exécution : " + (finSelection - debSelection) + " ms");
        //TriAlgo.affiche(element);

        System.out.println("\n***************************** TRI RAPIDE : ***********************\n");
        long debRapide = System.currentTimeMillis();
        TriAlgo.triRapide(copy1, 0, copy1.length - 1);
        long finRapide = System.currentTimeMillis();
        System.out.println("Tri rapide -> Temps d'exécution : " + (finRapide - debRapide) + " ms");
        //TriAlgo.affiche(copy1);

        System.out.println("\n***************************** TRI DENOMBREMENT : ***********************\n");
        long debDenombre = System.currentTimeMillis();
        TriAlgo.denombre(copy2);
        long finDenombre = System.currentTimeMillis();
        System.out.println("Tri par dénombrement -> Temps d'exécution : " + (finDenombre - debDenombre) + " ms");
        //TriAlgo.affiche(copy2);

        sc.close(); //Fermer le scanner pour éviter les fuites de mémoire
    }

    /* Pour les methodes affiche dans cette classe on les a mis en commentaire par ce que ça
       prenait trop de place si vous voulez voir chaque tableau après chaque tri veuillez juste
       supprimer les //
     */
}
