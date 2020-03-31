# SOA3
***************************************************************************PROJET*********************************************************************************************************
SOA-ESHOP-MS-BASKET
**************************************************************************COMMANDES DOCKER************************************************************************************************

docker login --username="nbadkouf" --password="Nawel&2020"
docker build -t nbadkouf/eshop-ms-basket:1.0.0 .
docker tag 9ae3abf48657 nbadkouf/eshop-ms-basket:1.0.0
docker run -d -p 9191:9191 34c57f2453d7
docker push nbadkouf/eshop-ms-basket:1.0.0

***********************************************************************COMMANDES CURL TEST API********************************************************************************************

Vérifier la validité du token JWT envoyé par eshop-ms-membership :
https://192.168.99.100/v1/esipe/baskets/verify    + envoi du token dans le BODY en json 

curl -X POST -H "Content-Type: application/json" -d '{"token": "eyJraWQiOiJlNDA1YjUzMS00NjY1LTQ1MmMtOTYxZS0zOTg5NGFkYWZhNWYiLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlc2lwZS
5jb20iLCJhdWQiOiJXRUIiLCJBVVRIT1JJVElFUyI6WyJBRE1JTiIsIlVTRVIiXSwiaXNzIjoiRVNJUEVfQkFDSyIsImV4cCI6MTU4NjI2OTYwMCwiaWF0IjoxNTg1NjY0ODAwLCJrZXkiOiJ2YWx1ZSJ9.G_JYpzGqW876PAVzNcOGAgxybJ1NdtTPlc
JunkNTsV77imAz_91283klWKx2NojHxIwzY3W3DPBuASzKzdCLpG6fzHSO6EyvO8rqeaPvgRNNAeaUS3UTT-4Mh987BlxzRJGDlGzpHcwo7ycGNynyOcArNRYPS7RyTPsLA55eD34NaIwlTdVzEuL8z5UXZ8FswHcObmLuTe7Z2nERVuwRpbY2ytHn9eC
lyrga7_L-5cYQxhAYajF4Im2qLrngqqTGmzq8PELzqlTpSto99vWTNkIn1lDIFMRqoBCllSxyoRallISRf-xm_cluspQm-67PggiNhRlxs7M8QS-GNW01L6MLDK_MJXLS4JEx3lvdDFxG_8sHxyCT37_-1UHIR-88q5t3bMXDOgXAapYV30ZAZBwQvWjd
99GJ0dlqcCeFaUemPurJL5oqkTGYXZzCV6obMn2k9DYXQm1_VH3INN8EnMZ5nB4koIu9-yvtqEylO3LCP9YFUV1GIdgeTBp34Rc4"}' https://192.168.99.100:9191/v1/esipe/baskets/verify


Afficher la liste des paniers (seulement si le user possède les droits ADMIN et s'il s'est authentifié avec la méthode /authenticate de eshop-ms-membership") : 
https://192.168.99.100:9191/v1/esipe/baskets  + envoi du Bearer Token JWT après authentification dans "Authorization" de postman ou autre client...

Ajouter un panier (seulement si le user est authentifié précédemment avec la méthode /authenticate de eshop-ms-memebership) : 
https://192.168.99.100:9191/v1/esipe/baskets/admin@esipe.com + envoi du Bearer Token JWT après authentification dans "Authorization" de postman ou autre client...

Modifier un panier (seulement si le user est authentifié précédemment avec la méthode /authenticate de eshop-ms-memebership) : 
https://192.168.99.100:9191/v1/esipe/baskets/admin@esipe.com

Supprimer un panier (seulement si le user est authentifié précédemment avec la méthode /authenticate de eshop-ms-memebership) : 
https://192.168.99.100:9191/v1/esipe/baskets/admin@esipe.com
 
**********************************************************************************COMMANDES GIT*********************************************************************************************

Création du projet : git clone https://github.com/nbadkouf/SOA3.git
Création de la branche develop : git checkout -b develop 
Commit : 
   - git satatus
   - git add . 
   - git commit -m ""
   - git push 

*****************************************************************************SCHEMA D'ARCHITECTURE******************************************************************************************
Voir Schéma d'architechture à la racine (au meme niveau que le readme)
