/* Travail réalisé par :
Bennabi Ghiles Rayane et Baouche Mohamed Djaouad
*/


public class Element {
    private int cle; // Clé entière
    private float valeur; // Valeur en float

    public Element(int cle, float valeur) { // Constructeur
        this.cle = cle;
        this.valeur = valeur;
    }

    public int getCle() { // Getter clé
        return this.cle;
    }

    public float getValeur() { // Getter valeur
        return this.valeur;
    }

    public float setCle(int cle){ //Setter clé
        return this.cle =cle;
    }

    public void setValeur(float valeur) { // Setter valeur
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "(" + this.cle + ", " + this.valeur + ")";
    }
}
