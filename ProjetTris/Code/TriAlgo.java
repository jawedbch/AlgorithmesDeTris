/* Travail réalisé par :
Bennabi Ghiles Rayane et Baouche Mohamed Djaouad
*/


public class TriAlgo {
    private static long totalComparaisons = 0;
    private static long totalAffectations = 0;

    // Tri par sélection du maximum
    public static void selectionMax(Element[] tab) {
        int indice_max;
        int indice_fin = tab.length - 1;

        for (int j = 1; j < tab.length; j++) {
            indice_max = 0;

            // Trouver l'élément avec la clé maximale
            for (int i = 1; i <= indice_fin; i++) {
                totalComparaisons++;
                if (tab[i].getCle() > tab[indice_max].getCle()) {
                    indice_max = i;
                }
            }

            // Échanger l'élément maximum avec la fin de la partie non triée
            echanger(tab, indice_max, indice_fin);
            totalAffectations += 3;

            indice_fin--; // Réduire la partie non triée
        }

        System.out.println("Comparaisons tri sélection max : " + totalComparaisons);
        System.out.println("Affectations tri sélection max : " + totalAffectations);
        System.out.println("Opérations élémentaires tri sélection max : " + (totalComparaisons + totalAffectations));
    }

    // Tri rapide (QuickSort)
    public static void triRapide(Element[] tab, int debut, int fin) {
        if (debut < fin) {
            int pivotIndex = partition(tab, debut, fin);
            triRapide(tab, debut, pivotIndex - 1);
            triRapide(tab, pivotIndex + 1, fin);
        }

        // Affichage des résultats après le dernier appel récursif
        if (debut == 0 && fin == tab.length - 1) {
            System.out.println("***************************** TRI RAPIDE : ***********************");
            System.out.println("Comparaisons tri rapide : " + totalComparaisons);
            System.out.println("Affectations tri rapide : " + totalAffectations);
            System.out.println("Opérations élémentaires tri rapide : " + (totalComparaisons + totalAffectations));
        }
    }

    private static int partition(Element[] tab, int debut, int fin) {
        int pivot = tab[debut].getCle();
        int i = debut + 1;
        int j = fin;

        while (i <= j) {
            // Trouver un élément plus grand que le pivot à gauche
            while (i <= fin && tab[i].getCle() <= pivot) {
                i++;
                totalComparaisons++;
            }

            // Trouver un élément plus petit ou égal au pivot à droite
            while (tab[j].getCle() > pivot) {
                j--;
                totalComparaisons++;
            }

            // Échanger si i < j
            if (i < j) {
                echanger(tab, i, j);
                totalAffectations += 3;
            }
        }

        // Placer le pivot à sa position finale
        echanger(tab, debut, j);
        totalAffectations += 3;

        return j;
    }

    private static void echanger(Element[] tab, int i, int j) {
        Element temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }



    // Tri par dénombrement (conservé)
    public static void denombre(Element[] tab) {
        int comp = 0; //nombre de comparaisons

        if (tab == null || tab.length == 0) {
            return;
        }

        int max = tab[0].getCle();//On compte pas ces initialisation(choix conventionnelle)
        int aff = 0; //nombre d'affectations
        for (int i = 1; i < tab.length; i++) {
            comp++;
            if (tab[i].getCle() > max) {
                max = tab[i].getCle();
                aff++;
            }
        }

        int[] counts = new int[max + 1]; //Création du tableau d'occurrences

        for (int i=0;i<counts.length;i++) {
            counts[i]=0;
            aff++;
        }

        for(int j = 0; j < tab.length; j++) { //Calcule des occurrences
            counts[tab[j].getCle()]++;
        }

        for(int k = 1; k <= max; k++) { //mise à jour du tableau
            counts[k] = counts[k] + counts[k-1];
            aff++;
        }
        // On crée le tableau
        Element[] res = new Element[tab.length];

        for(int p = tab.length - 1; p >= 0; p--) { //le tableau trié
            res[--counts[tab[p].getCle()]] = tab[p];
            aff++;
        }

        for(int i = 0; i < tab.length; i++) { //On copie les élèments dans notre tableau de base
            tab[i] = res[i];
            aff++;
        }

        System.out.println("Le nombre de comparaisons dans le tri par dénombrement est  approximativement  de : " + comp); //le nombre de comparaisons
        System.out.println("Le nombre d'affectations dans le tri par dénombrement est  approximativement  de : " + aff);//le nombre d'affectations
        System.out.println("Le nombre d'opérations élèmentaires dans le tri par dénombrement est  approximativement  de : " + (comp + aff));//le nombre d'opérations élémentaires
    }

    // Affichage du tableau
    public static void affiche(Element[] element) {
        for (Element el : element) {
            System.out.println("(" + el.getCle() + "," + el.getValeur() + ")  ");
        }
        System.out.println();
    }
}
