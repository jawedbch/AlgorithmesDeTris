# 📊 Algorithmes de Tri en Java

Projet réalisé dans le cadre de l’UE d’algorithmique à l’Université du Havre (UFR Sciences et Techniques).  
Ce projet porte sur l’analyse expérimentale et théorique de la complexité de trois algorithmes de tri implémentés en Java.

## 👨‍💻 Auteurs

- **Baouche Mohamed Djaouad**
- **Bennabi Ghiles Rayane**

---

## 🧠 Objectif du projet

Comparer les performances (temps d'exécution, nombre de comparaisons/affectations) de différents algorithmes de tri en fonction de la taille des données à trier.

---

## 🔍 Algorithmes implémentés

### 1. Tri par sélection du maximum
- Complexité : O(n²) dans tous les cas.
- Simple à implémenter, mais peu efficace pour les grands tableaux.

### 2. Tri rapide (QuickSort)
- Complexité :
  - Meilleur et cas moyen : O(n log n)
  - Pire cas : O(n²) (si mauvais pivot)
- Très rapide pour des données aléatoires.

### 3. Tri par dénombrement
- Complexité :
  - O(n + k), où `n` est la taille du tableau, `k` la plage des valeurs.
- Ultra performant si les clés sont dans une plage étroite.
- Non basé sur des comparaisons.

---

## ⚙️ Fonctionnement

- Le programme prend en entrée des tableaux contenant des objets avec une **clé entière** et une **valeur réelle**.
- Des tests sont réalisés sur des tableaux :
  - de **petite taille** (saisie manuelle),
  - de **grande taille** (générés aléatoirement).
- Chaque algorithme affiche :
  - Le **nombre de comparaisons et d’affectations**
  - Le **temps d’exécution**
  - Un **graphique des performances** selon la taille

---

## 📈 Analyse des performances

- 🔵 **Tri par sélection** : très lent dès que le tableau dépasse quelques milliers d’éléments.
- 🟢 **Tri rapide** : très bon compromis, rapide même sur 100 000+ éléments.
- 🟣 **Tri par dénombrement** : imbattable tant que `k` reste petit.

---

## 📂 Structure du projet

- `TriAlgo.java` : implémentation des tris 
- `Main.java` : exécution, mesures, affichage
- `Element.java` : classe représentant un élément à trier (clé entière + valeur float)
- `Bennabi_Baouche.pdf` : rapport PDF qui explique en le projet entier 
- `README.md` : ce fichier
- `LICENSE` : licence du projet (MIT)

---

## 🚀 Exécution

Ce projet s’exécute avec n’importe quel environnement Java :

```bash
javac Main.java
java Main
