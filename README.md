# Cidenet_Test

_Este proyecto consta de un Kardex básico, también conocido como tarjeta de registro, el cual es
 usado para el control de inventario de un establecimiento que manipule mercancía._  

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

_Lo primero que se debe hacer es ejecutar los servidores:_

### Servidor Backend

_Desde tu IDE preferido (en mi caso **Intellij Idea**), buscas el botón **"Run"** y das click sobre él. Después de esto solo queda esperar que inicie el servidor. En caso de que el botón **"Run"** no este habilitado puedes recurrir a dos alternativas:_
* La primera es dar click derecho sobre el archivo llamado **"HulkStoreApplication"** y seleccionar la opción **"Run"** (ver imagen)

![run-clickOnScript](https://user-images.githubusercontent.com/47234070/79490758-00720e80-7fe3-11ea-85f3-0e52f04cfbfd.png)

* La segunda costa de abrir el archivo llamado **"HulkStoreApplication"** y estando en este dar click derecho y seleccionar la opción **"Run"** (ver imagen)

![run-clickInScript](https://user-images.githubusercontent.com/47234070/79490754-fea84b00-7fe2-11ea-881f-06ccf98a2b47.png)

### Servidor de frontend


_Desde tu editor preferido (en mi caso **Visual Studio Code**), abres la carpeta donde se aloja el proyecto y abres una nueva terminal (ver imagen)_

![newTerminal](https://user-images.githubusercontent.com/47234070/79493329-f18d5b00-7fe6-11ea-8996-fdff45816f65.png)

_Con la terminal abierta, debes asegurarte que la ruta donde se aloja el proyecto es correcta, verifiando esto solo debe escribir **"ng serve"** y dar "enter" para que el servidor se ejecute._

![serve](https://user-images.githubusercontent.com/47234070/79493334-f2be8800-7fe6-11ea-9c39-527e8c92f1c4.png)

_Una vez inicien ambos servidores, te diriges a tu navegador favorito (recomiendo Chrome) y escribes la siguiente direccción:
**"http://localhost:4200"**, con lo cual podrás visualizar las pantallas._

### Navegación entre pantallas

#### Home

![home](https://user-images.githubusercontent.com/47234070/79420628-e7d00d00-7f7e-11ea-821a-599b6f2819c4.png)

_En esta pantalla se visualiza el kardex, en este se podrán ver los produtos disponibles a través de su **id** y **nombre**.
También se puede ver el **costo/unidad**, la **cantidad total** de unidades disponibles y el **saldo total** en pesos que se posee en el inventario._

_**Nota:** el desarrollo del cálculo del kardex fue basado en el siguiente [video](https://www.youtube.com/watch?v=CU2cFYH3yMM)._

_Siendo el **"Home"** la ventana principal, en esta se visualizan los diferentes "menús", entre ellos el **"Movements"**, donde se encuentran los diferentes enlaces que redireccionan a otras pantallas._

![movements-menu](https://user-images.githubusercontent.com/47234070/79420631-e868a380-7f7e-11ea-8242-b4b8d614593c.png)

#### Purchases

![purchase-noCost-unit](https://user-images.githubusercontent.com/47234070/79420632-e868a380-7f7e-11ea-9c9a-ed8033dd3625.png)

_En esta ventana se pueden registrar las compras de un determinado artículo, además de que este ingresa a invetario 
automáticamente. El campo **"cost/unit"** esta deshabilitado debido a que por lo general cuando se realiza una compra, se paga un valor final que representa el total de la compra, y no se tiene mucho en cuenta el valor unitario de cada producto, esto no quiere decir que se deba ignorar dicho valor, por lo que opte por hacer el cálculo interno y desahibilitar esta opción para el cliente._ 

_Cuando un usuario ingrese los datos de los campos **"Quantity"** y **"Total"**, el campo **"cost/unit"** se autocompletara mostrando el valor por unidad de cada elemento de la compra. Una vez ingresados todos los datos, se debe dar click en el botón **"Add"** y tanto la compra como el producto serán registrados, además, se notifica con un mensaje que dice que la compra fue registrada (**"Registered purchase"**)._

![savePurchase](https://user-images.githubusercontent.com/47234070/79497231-f228f000-7fec-11ea-8d2e-0befd4a96322.png)

_En caso de querer registrar una compra ya existente, el sistema arrojara un mensaje donde se notifica que el producto ya existe (**"Product already exist!"**)_

![savePurchase_alreadyExist](https://user-images.githubusercontent.com/47234070/79497820-f86b9c00-7fed-11ea-968e-ed9fa1d765b9.png)

He de aclarar que esto solo sucede cuando se intenta registrar una compra ya existente, si la **"Purchase Reference"** es diferente, el producto será registrado con normalidad, puesto que de un producto se pueden realizar cuantas compras se desee.

#### Sales

![sale](https://user-images.githubusercontent.com/47234070/79498586-2dc4b980-7fef-11ea-9243-9c0829aaa5b8.png)

_En esta ventana se puede consultar por **id** el articulo que se desea vender, además, se realiza el registro de la venta._

_Lo primero que se debe hacer es buscar el producto que se desea vender, esto se hace ingresando su **id** y dando click en el botón **Search**. Una vez realizado esto, se cargará el nombre del producto (campo que no se podrá modificar) junto con la cantidad de unidades disponibles para que el usuario no intente realizar una venta de unidades mayor a las disponibles y se cargará un precio sugerido (calculado con el kardex) para evitar pérdidas en la venta_

![sale-search](https://user-images.githubusercontent.com/47234070/79499662-ed663b00-7ff0-11ea-9f14-c349dcd66472.png)

_Si el prodcuto no se encuentra registrado en base de datos, el sistema arrojará un menaje de notificación de no existencia (**"Product Not Found"**)_


![sale-ProductNotFound](https://user-images.githubusercontent.com/47234070/79499656-ec350e00-7ff0-11ea-880e-3a8d86949a65.png)

_Al igual que en la pantalla **"Purchase"**, en esta pantalla hay un campo deshabilitado (campo **"Total"**), esto debido a que sucede algo parecido pero contrario en las ventas; cuando se realiza una venta se va ingresando elemento a elemento junto con su cantidad y valor unitario, mientras que el precio final o total se calcula un momento antes de registrar la venta, por lo que realizar este cálculo automático es de mucha ayuda para el usuario_

![sale-noTotal](https://user-images.githubusercontent.com/47234070/79499618-e2130f80-7ff0-11ea-9ccd-eae02d49ee5d.png)

_Una vez ingresados todos los datos, se debe dar click en el botón **"Add"** y la venta junto con la modificación del stock del producto será registrado, además, se notifica con un mensaje que dice que la venta fue registrada (**"Registered Sale"**)._

![sale-save](https://user-images.githubusercontent.com/47234070/79499659-eccda480-7ff0-11ea-8569-123f21de5fcd.png)

_A medida que se registran compras y/o ventas, el kardex de la pantalla **"Home"** cambiará._

![updated-home](https://user-images.githubusercontent.com/47234070/79499663-ed663b00-7ff0-11ea-9ea0-08c4f6141195.png)

#### Stock

![stock](https://user-images.githubusercontent.com/47234070/79502279-fe18b000-7ff4-11ea-98b6-5626d4200cc5.png)

_En esta ventana se puede consultar por **"id"** el nombre (**"name"**) y la canidad de unidades disponibles (**"Quantity"**) de un producto determinado, además, se pueden realizar operaciones básicas como actualizar el nombre y eliminar el registro del inventario._

_Para realizar una busqueda es muy simple, solo se ingresa el **id** de producto a consultar y se da click en el botón **Search**. Estos datos se verán reflejados en los campos de la parte superior derecha_

![stock-search](https://user-images.githubusercontent.com/47234070/79502281-ff49dd00-7ff4-11ea-9896-a7e8378c1919.png)

_Si el producto no existe en inventario, se notificará con un mensaje de error (**"Product Not Found"**)._

![stock-ProductNotFound](https://user-images.githubusercontent.com/47234070/79502290-ffe27380-7ff4-11ea-9e73-d1b03bb79cd3.png)

_Para actualizar el nombre del producto solo se debe de ingresar en nuevo nombre en el campo **"new name"** y dar click en el botón **Update**. El nombre se actualiza y se notifica con un mensaje._

![stock-updated](https://user-images.githubusercontent.com/47234070/79502286-ff49dd00-7ff4-11ea-89ac-f76d9cf5882a.png)

_Para eliminar un articulo de la base de datos, se tiene una validación que permite su eliminación si y solo si dicho 
elemento no posee unidades dispobibles en stock, de lo contrario el sistema lanza una alerta que notifica al usuario 
que aún hay unidades disponibles por lo que no se puede proceder con la eliminación del registro._

![stock-notDelete](https://user-images.githubusercontent.com/47234070/79502289-ffe27380-7ff4-11ea-8ba9-8caaaae0b262.png)

_En caso contrario, si no hay unidades en stock y el cliente desea eliminar el registro del producto, lo podrá hacer dando click en el botón **Delete**. Una vez realizada esta acción, se notificara con un mensaje de operación exitosa (**"Item removed"**)._
![stock-removed](https://user-images.githubusercontent.com/47234070/79502284-ff49dd00-7ff4-11ea-9d33-533a006a4149.png)


## Construido con 🛠️


* [Angular CLI](https://cli.angular.io/) - El framework web usado para frontend
* [Spring](https://spring.io/) - El framework web usado para backend
* [Bootstrap 4](https://getbootstrap.com/) - El framework de diseño web
* [Gradle 4+](https://gradle.org/) - Manejador de dependencias


## Autor ✒️



* **Alejandro Echavarria** - *Trabajo Inicial* - [alejoechavarria](https://github.com/alejoechavarria)




---

