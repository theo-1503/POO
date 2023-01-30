PARTIE 1 :

Étape 5 :

Description de chaque dépendance :

- Web : The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE (Enterprise Edition) platform.
- JPA : Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. This module deals with enhanced support for JPA based data access layers. It makes it easier to build Spring-powered applications that use data access technologies.
- Hibernate : Hibernate ORM (or simply Hibernate) is an object–relational mapping tool for the Java programming language. It provides a framework for mapping an object-oriented domain model to a relational database. Hibernate handles object–relational impedance mismatch problems by replacing direct, persistent database accesses with high-level object handling functions.
- H2 : H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode. The software is available as open source software Mozilla Public License 2.0 or the original Eclipse Public License.
- DevTools : We need to write lots of code for manually setting the configuration of the Spring Application. To overcome this tedium and cumbersome effort, Spring Boot which is built on top of Spring Framework was released in 2014. The main moto of the Spring Boot framework is its ‘Auto-Configuration‘ feature. This enables a developer to build applications faster. One more crucial feature of Spring Boot is its DevTools library.
- Thymeleaf : Thymeleaf is a Java XML/XHTML/HTML5 template engine that can work both in web (servlet-based) and non-web environments. It is better suited for serving XHTML/HTML5 at the view layer of MVC-based web applications, but it can process any XML file even in offline environments. It provides full Spring Framework integration.


Étape 13 :

1. Il s'agit de : @GetMapping("/greeting") situé dans  la classe HelloWorldController
2. Il s'agit de : return "greeting"; de la fonction greeting située dans la classe HelloWorldController
3. Grâce à : model.addAttribute("nomTemplate", nameGET); situé dans la fonction greeting de la classe HelloWorldController


Étape 17 :

La différence est que désormais nous avons la table ADDRESS.


Étape 18 :

Hibernate permet de créer une base de données à partir d'un modèle provenant d'un domaine orienté objet.
C'est donc ainsi que la table ADDRESS est apparue.

Étape 20 :

Je vois bien tout le contenu de data.sql.


Étape 22 :

Cela permet d'injecter AddressRepository quand AddressController est créé.


Étape 30 :

Tout d'abord, j'ai ajouté la dependency suivante dans le fichier pom.xml :

<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>4.1.1</version>
</dependency>

Ensuite, j'ai ajouté ce lien dans mon fichier header :

<link  href="webjars/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">

PARTIE 2 :

Étape 6 :

1. Oui il faut une clé. Pour cela, il faut se rendre sur le site de MeteoConcept et créer un compte pour générer un token.
2. Pour appeler l'API, il faut l'URL suivante : "https://api.meteo-concept.com/api/forecast/daily/0?token=" suivie du token. Il faut ensuite ajouter la latitude et la longitude à ce lien.
3. Il faut utiliser la méthode GET.
4. Les paramètres d'appels sont passés dans l'URL.
5. Les informations se trouvent un fichier XML ou JSON.
6. La température se situe dans le tableau observations du fichier observations.
7. Les prévisions se situent dans le tableau forecast.