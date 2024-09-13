API REST Forum - Spring Boot

Table des matières
1.	Description
2.	Prérequis
3.	Exécution
4.	Utilisation de l'API
5.	Contributeurs
   
I- Lien du repos git  https://github.com/ibrahimkoumare225/API-REST-FORUM.git 

II-	Description
L'API REST Forum permet aux utilisateurs de publier des messages, répondre aux discussions, et interagir sur une plateforme de forum en ligne. 

III-	Prérequis
Pour  démarrer, vous devez vous assurer d'avoir les éléments suivants installés sur votre machine :	                         
•	Java 17
• Un IDE (environnement de développement intégré) de préférence Intelij. 
•	PostgreSQL( et configurer la base de données (on vous demandera de définir un mot de passe et  un port par défaut le port utilisé est le 5432) ensuite créer une base de données et sélectionner l’utilisateur par défaut postgre ou autre si vous créez un utilisateur.)
•	Postman (pour tester les points d'API)
IV-	Utilisation de l'API
Voici quelques requêtes d'utilisation des principaux points d'API.  Pour le dossier forum :               
  Ouvrez le fichier ajout de nouveau élément et dans l’URL saisie  localhost:8080/api/forums ensuite sélectionnés la méthode Post
  Entrer dans body, sélectionner raw puis renseigner les différentes informations du forum 
  Ouvrez le fichier pour la liste des forums et dans l’URL saisie  localhost:8080/api/forums ensuite sélectionnés la méthode Get
  Faire de même et sélectionner la méthode Get pour la récupération des détails d’un forum.
  Pour le dossier sujet : faire les mêmes requêtes que celles de forum en vue de la création d’un nouveau sujet, la liste des sujets et pour la récupération des détails d’un sujet. 
  Pour le fichier message : Utiliser la méthode Post pour la création d’un nouveau message dans un sujet et utiliser la méthode Get pour lister les messages d’un sujet.

V-	Technologies utilisées
•	Java 17
•	Spring Boot
•	Spring Data JPA pour la persistance des données
•	PostgreSQL comme base de données
•	Postman

V-	Contributeurs
•	KOUMARE IBRAHIM
•	ACKOUN MAURICETTE
•	DIOMANDE SOULEYMANE
