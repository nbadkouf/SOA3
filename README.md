# SOA3
****************************PROJET********************************************
SOA-ESHOP-MS-BASKET
****************************COMMANDES DOCKER**********************************
****************************COMMANDES CURL TEST API***************************

Vérifier la validité du token JWT envoyé par eshop-ms-membership :
localhost:9191/v1/esipe/baskets/verify    + envoi du token dans le BODY en json  

Afficher la liste des paniers (seulement si le user possède les droits ADMIN et s'il s'est authentifié avec la méthode /authenticate de eshop-ms-membership") : 
localhost:9191/v1/esipe/baskets  + envoi du Bearer Token JWT après authentification dans "Authorization" de postman ou autre client...

Ajouter un panier (seulement si le user est authentifié précédemment avec la méthode /authenticate de eshop-ms-memebership) : 
localhost:9191/v1/esipe/baskets/admin@esipe.com + envoi du Bearer Token JWT après authentification dans "Authorization" de postman ou autre client...

Modifier un panier (seulement si le user est authentifié précédemment avec la méthode /authenticate de eshop-ms-memebership) : 
localhost:9191/v1/esipe/baskets/admin@esipe.com

Supprimer un panier (seulement si le user est authentifié précédemment avec la méthode /authenticate de eshop-ms-memebership) : 
localhost:9191/v1/esipe/baskets/admin@esipe.com
 
****************************COMMANDES GIT*************************************
Création du projet : git clone https://github.com/nbadkouf/SOA3.git
Création de la branche develop : git checkout -b develop 
Commit : 
   - git satatus
   - git add . 
   - git commit -m ""
   - git push 

****************************SCHEMA D'ARCHITECTURE*****************************

