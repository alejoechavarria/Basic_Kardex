# Cidenet_Test

_Este proyecto consta de un Kardex básico, también conocido como tarjeta de registro,
 usado para el control de inventario de un establecimiento que manipule mercancía.
 Se inicio con el fin de cumplir el requerimiento de una empresa de desarrollo, pero en vista de los retos que me 
 trajo a nivel de frontend (el cual no es mi fuerte), pienso darle continuidad con el fin de crear un proyecto mucho 
 mas amplio._  

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._




### Pre-requisitos 📋

_La siguiente lista corresponde a todas las herramientas que debes tener en tu entorno de trabajo para que el proyecto 
funcione correctamente_

* [JDK Java 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) - JDK de Java 8
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot version '2.2.5.RELEASE'
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Spring Data JPA
* [Angular CLI](https://cli.angular.io/) - Angular version '9.0.6' - Node JS version '12.16.1' 
* [Gradle 4+](https://gradle.org/install/) - Gradle 4

## Inicio de proyecto

_Lo primero que se debe hacer es ejecutar los servidores. Primero desde tu IDE favorito simplemente buscas el botón **"Run"**
y das clic sobre él, después de esto solo queda esperar que inicie el servidor. Luego abren una terminal y te diriges al 
directorio **“hulk-store”** ubicada dentro del directorio **“frontend”**, allí inicias el servidor con el siguiente comando: 
**“ng serve”**._

_Una vez inicien ambos servidores, te diriges a tu navegador favorito (recomiendo Chrome) y escribes la siguiente direccción:
**"http://localhost:4200"**, con lo cual podrás visualizar las pantallas._

### Navegación entre pantallas

#### Home

_En esta pantalla se visualizara el kardex, en este se podrán ver los elementos disponibles a través de su **id** y **nombre**.
También se podrá ver el **costo/unidad**, la **cantidad total** de elementos y el **saldo total** en pesos del inventario._

_**Nota:** el desarrollo del cálculo del kardex fue basado en el siguiente [video](https://www.youtube.com/watch?v=CU2cFYH3yMM)._

#### Sales

_En esta ventana usted podrá consultar por **id** el articulo que desea vender, además podrá realizar el registro de la venta._

_El campo **"total"** esta deshabilitado debido a que por lo general cuando se realiza una venta, se va sumando el valor 
unitario de cada producto hasta llegar a un valor total. Este campo **"total"** se calcula automáticamente al ingresar el
**"valor unitario"** y la **"cantidad"** de elementos a vender._

#### Purchases

_En esta ventana usted podrá registrar las compras de un determinado articulo, además de que este ingresa a invetario 
automáticamente_

_Al igual que en la ventana de **"Sales"**, hay un campo que esta deshabilitado y se calcula automáticamente con base 
en otros campos. Para este caso es en el campo **"valor unitario"** en donde se realiza el cálculo basado en el campo 
**”total”** y el campo **”cantidad”**. Esto debido a que cuando se realiza una compra generalmente se paga un valor
final y no por articulo comprado._

#### Stock

_En esta ventana se puede consutar por **"id"** el **"nombre"** y **"cantidad"** de un elemento determinado, además, 
se puede actualizar el **"nombre"**._

_Para eliminar un articulo de la base de datos, se tiene una validación que permite su eliminación si y solo si dicho 
elemento no posee unidades dispobibles en stock, de lo contrario el sistema lanza una alerta que notifica al usuario 
que aún hay unidades disponibles por lo que no se puede proceder con la eliminación del elemento._



## Construido con 🛠️


* [Angular CLI](https://cli.angular.io/) - El framework web usado para frontend
* [Spring](https://spring.io/) - El framework web usado para backend
* [Bootstrap 4](https://getbootstrap.com/) - El framework de diseño web
* [Gradle 4+](https://gradle.org/) - Manejador de dependencias


## Autor ✒️



* **Alejandro Echavarria** - *Trabajo Inicial* - [alejoechavarria](https://github.com/alejoechavarria)




---

