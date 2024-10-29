# TP Location

## Description

TP Location est une application qui permet de suivre et de partager des positions géographiques en utilisant une interface mobile. L'application se compose de deux parties : un frontend développé sur Android et un backend développé avec PHP.

## Fonctionnalités

- **Localisation en temps réel :** L'application récupère et affiche la position actuelle de l'utilisateur.
- **Affichage sur la carte :** Les positions enregistrées sont affichées sur une carte Google Maps.
- **Gestion des positions :** Les utilisateurs peuvent voir toutes les positions précédemment enregistrées.
- **Backend API :** Le backend fournit des endpoints pour l'enregistrement et la récupération des positions.

## Technologies Utilisées

### Frontend (Android)
- Android Studio
- Google Maps API
- Volley (pour la gestion des requêtes réseau)

### Backend (PHP)
- PHP avec PDO pour la gestion de la base de données
- MySQL pour le stockage des données

## Installation

### Backend

1. Clonez le dépôt du backend :
   ```bash
    git clone https://github.com/assia1905/TPLocation.git
2. Configurez votre serveur web (Apache, Nginx, etc.) pour pointer vers le dossier backend du projet.
3. Importez la base de données localisation.sql dans votre système de gestion de base de données MySQL.
### Frontend
- Ouvrez le projet Android dans Android Studio.
- Assurez-vous d'avoir les bonnes permissions dans le fichier AndroidManifest.xml.
- Ajoutez votre clé API Google Maps dans le projet.
## Utilisation
- Lancez le serveur backend.
- Ouvrez l'application Android sur votre appareil ou émulateur.
- Visualisez vos positions enregistrées sur la carte.
## Demonstration en video 
- https://github.com/user-attachments/assets/0dc923f9-99b1-47eb-b86d-e12b861db27d
## Auteur
- AsSia BOUJNAH

