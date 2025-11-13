# S3.2-Patterns_2
Task 1 from Sprint 3 of Itacademy's Java &amp; Spring Framework 

# </> Tasca S3.3 Patterns 2

**Durada:** 2 dies.

**LLuirament:** Envia la URL a un repositori Github que contingui la solució.

---

## 📝 Introducció
>Continuarem practicant l’ús de patrons de disseny per resoldre problemes habituals en el desenvolupament de programari. Veureu que hi ha molts patrons diferents i que cadascun s’aplica a casos d’ús específics. A mesura que els anem treballant, aprendràs a reconèixer quan i com utilitzar-los per escriure codi més net, flexible i fàcil de mantenir. Aquesta tasca et permetrà consolidar els coneixements adquirits i descobrir nous patrons que t’ajudaran a afrontar projectes més complexos amb seguretat i criteri professional.

---

# ⭐ Nivell 1

## 🧱 Patró Builder

### 📘 Què és?

El patró de disseny **Builder** és un **patró creacional** que ens **ajuda a construir objectes complexos pas a pas**, separant la construcció de l’objecte de la seva representació.
En altres paraules, **facilita la creació d’objectes que tenen molts paràmetres**, alguns d’ells opcionals o amb valors per defecte, sense que el codi del client quedi ple de constructors llargs o configuracions enrevessades.

### 🛠️ Utilitat

El patró Builder és útil quan:

- 🧱 L’objecte a **construir** té molts atributs opcionals o configuracions possibles.
- 🧩 Cal mantenir la **construcció clara, llegible i extensible**.
- 🚫 Es vol **evitar constructores massa llargues** o difícils de llegir.

### 🎯 Propòsit

- 🏚️ Fa que el procés de creació sigui més llegible i mantenible.
- ⛓️ Evita l’antipatró del constructor telescòpic (aquells constructors amb 5, 6, 7 paràmetres que ningú entén).
- 🌊 Ajuda a tenir un codi més clar i expressiu, sobretot quan es combina amb l’enfocament Fluent.

>Hi ha diferents formes d’implementar el Builder. En aquest exercici, utilitzaràs el Fluent Builder, que permet enllaçar les crides de manera fluida.
Exemple:

```java
Car car = new CarBuilder()
        .withModel("Sedan Premium")
        .withEngine("Hybrid", 180)
        .withColor("Metallic Black")
        .withInterior("Leather")
        .withNavigationSystem()
        .withDriverAssistance()
        .withSportPackage()
        .build();
```
---

## 🧠 Exercici:
> Implementació del patró Builder al menú d'un restaurant.

### 🏆 Objectiu
Dissenyar i implementar un sistema per construir diferents tipus de menús de restaurant aplicant el patró de disseny Builder amb estil **Fluent Builder**, i seguint els principis SOLID. A més, s’utilitzarà el concepte de **progressive interface**, que consisteix a limitar progressivament les opcions disponibles a l’usuari durant la construcció de l’objecte, assegurant així que **el procés es realitzi en l’ordre correcte i es compleixin les dependències entre passos**. Per exemple, no es podrà afegir postres abans d’afegir el plat principal, ni tampoc es podrà cridar el mètode d’afegir postres més d’una vegada.

### 📝 Descripció

🍜 **Als menús poden estar compostos per:**

- Entrants
- Plat Principal
- Postres
- Beguda
---

🍽️ **Aquests poden tenir característiques específiques:**

1. Qualsevol plat pot ser: **Vegà** y/o **Apropiat per a celíacs.**
2. El **plat principal** pot tenir un **suplement** (per exemple: guarnició extra).
3. A més, el client pot demanar només el mig menú, que inclou únicament el plat principal i la beguda.
4. El menú infantil inclou no mes plat principal, beguda y postre.
5. Els menus poden ser sense beguda.
6. Les postres són opcionals a tots els menus i poden ser postres o cafè.

---

### ✅ Requisits:

1. Modelar un **sistema flexible** per construir menús pas a pas, sense dependències de classes concretes, que garanteixi **l’ordre correcte i obligatori** en la construcció del menú. Per exemple, no es podrà afegir postres abans d’afegir el plat principal.
2. Implementar una restricció per la qual, si es tria postres, no es podrà afegir cafè, i viceversa. Aquesta regla s’ha de garantir gràcies al **disseny d’interfícies**.
3. Permetre configurar les propietats dels plats (vegà, apta per celíacs, suplement) amb mètodes fluents i expressius, evitant paràmetres booleanos.
4. Implementa tests unitaris on es mostri la creació diversos menús
---

### 💻 Exemple d’ús esperat:

```java
Menu executiveMenu = new MenuBuilder()
    .withEntrant("Amanida Mediterrània")
        .isVegan()
        .isGlutenFree()
    .withMainCourse("Filet de Vedella")
        .withSuplement("Guarnició extra")
    .withDessert("Mousse de xocolata")
    .withDrink("Vi Negre")
    .build();

Menu kidsMenu = new MenuBuilder()
    .withMainCourse("Macarrons amb tomàquet")
    .withDessert("Gelat de Vainilla")
    .withDrink("Suc de taronja")
    .build();

Menu halfMenu = new MenuBuilder()
    .withMainCourse("Risotto de bolets")
        .isVegan()
    .withCoffee("Espresso")
    .withDrink("Aigua")
    .build();

```
---
## 📌 Recurs recomanat
- [Fluent Builder and Progressive Interface](https://thkarropoulos.hashnode.dev/fluent-builder)

----

# ⭐⭐ Nivell 2

## 👀 Patró Observer

### 📘 Què es?
El patró **Observer** és un patró de **disseny comportamental** que defineix una relació de dependència **un-a-molts** entre objectes, de manera que quan un objecte canvia d’estat, tots els seus dependents són notificats automàticament.

En altres paraules, permet definir un **mecanisme de subscripció per notificar diversos objectes** sobre qualsevol esdeveniment que li succeeixi a l'objecte que estan observant.

### 🛠️ Utilitat
El patró Observer és útil quan:
- 🔔 Necessitem **notificar automàticament** diversos components quan es produeix un canvi d’estat.
- 🔃 **Els canvis en l’estat d’un objecte poden afectar a altres**, però no sabem quins ni quants objectes en el moment de la codificació.
- 🔬 Necessitem que altres objectes **s’afegeixin o eliminin dinàmicament com a observadors**, segons el context.
- ✉️ Volem implementar sistemes tipus **pub-sub** (publicador / subscriptor).

### 🎯 Propòsit
- 📢 Permetre que tots els observadors siguin notificats automàticament quan l’Observable canvia d’estat.
- 🧩 Pots introduir noves classes subscriptores sense haver de modificar el codi de la classe notificadora (i viceversa si hi ha una interfície notificadora).
- 🕒 Establir relacions entre objectes durant el temps d’execució, afegint o eliminant observadors segons sigui necessari.
- 🗄️ Permetre mantenir els components desacoblats, ja que l’Observable no ha de conèixer la lògica interna dels seus observadors.

----
## 🧠 Exercici:
>Implementació del patró **Observer** en un **sistema de notificació** de canvis de la Borsa

### 🏆 Objectiu
Construir un sistema en què un **Agent de Borsa (Observable)** notifiqui automàticament a diverses **agències de Borsa (Observers)** cada vegada que es produeix un canvi de l’estat de la Borsa (pujada o baixada).

### 📝 Descripció
1. Dissenya una classe `StockAgent` que:
	1. Permeti als observadors subscriure’s i cancel·lar la subscripció.
	2. Tingui mètodes per simular quan la borsa puja o baixa el valor de les accions.
	3. Quan la borsa puja o baixa, notifiqui automàticament a tots els observadors amb un missatge que indiqui el canvi i el nou valor de les accions.

2. Dissenya també diverses classes concretes **d’observadors** que:
	1. S’inscriguin al `StockAgent`.
	2. Quan siguin notificats, mostrin per pantalla el missatge de la notificació indicant si la borsa ha pujat o baixat i el valor actual.

### ✅ Requisits

- L’objecte Observable ha de mantenir referències als seus observadors.
- Ha de ser possible afegir i eliminar observadors dinàmicament.
- Quan l’AgentBorsa canviï d’estat (puja o baixa), ha de cridar a `notifyObservers()`.
- Cada observador ha de mostrar el missatge rebut.
- El programa s’ha de provar mitjançant **tests unitaris** la:
	- subscripció de diversos observadors a l’agent de borsa.
	- simulació de pujades i baixades de la borsa.
	- serificació que els observadors reben i mostren correctament els missatges esperats.

### 💻 Exemple de test esperat (simplificat):

```java
@Test
public void testStockAgentNotifications() {
   StockAgent agent = new StockAgent();

   Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");
   Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");

   agent.addObserver(alphaBrokers);
   agent.addObserver(zenithInvestments);

   agent.stockMarketUp(150.75);
   // Expected console output:
   // Alpha Brokers received notification: Stock market went UP to 150.75
   // Zenith Investments received notification: Stock market went UP to 150.75

   agent.stockMarketDown(145.50);
   // Expected console output:
   // Alpha Brokers received notification: Stock market went DOWN to 145.50
   // Zenith Investments received notification: Stock market went DOWN to 145.50
}
```
---

## 📌 Recurs recomanat
- [Observer Pattern](https://www.baeldung.com/java-observer-pattern)

---

# ⭐⭐⭐ Nivell 3

## 🎨 Patró Decorator

### 📘 Què és?

El patró **Decorator** és un patró de **disseny estructural** que permet **afegir funcionalitats addicionals** a un objecte de manera flexible i dinàmica, sense modificar-ne la classe original.

En lloc de crear subclasses per cada combinació de funcionalitats, el patró Decorator utilitza una jerarquia d'objectes que embolcallen **(decoren) l’objecte original per afegir comportament nou**.

### 🛠️ Utilitat

El patró Decorator és útil quan:

- 🧩 Volem afegir **funcionalitats de manera flexible**, sense inflar la jerarquia de classes.
- 👽 **Resulti estrany** o no sigui possible **estendre el comportament** d’un objecte utilitzant l'herència.
- 🕸️ Tenim **moltes opcions** de personalització o combinació de característiques i volem **evitar una quantitat excessiva de subclasses**.

S’empra freqüentment en frameworks d’interfície d’usuari, sistemes d’entrada/sortida de fitxers, frameworks de registre i per a la personalització de productes.

### 🎯 Propòsit

El propòsit principal del patró Decorator és:

- 🧱 **Afegir funcionalitats** a objectes de manera dinàmica.
- ❌ **Evitar la creació de múltiples subclasses** per cada combinació de comportaments.
___

## 🧠 Exercici:
> Implementació del patró **Decorator** per a una aplicació de `Bubble Tea`

### 🏆 Objectiu

Implementar un disseny de classes que simuli la personalització d’un `Bubble Tea`, utilitzant el patró de disseny **Decorator** per afegir ingredients com perles, gel, sucre, etc.

---

### 📝 Descripció:

Es vol construir una aplicació que permeti crear Bubble Teas:

Pots començar amb una base com:

- 🥛 `Latte` → 3.50 €
- 🍵 `Matcha` → 3.20 €
- 🌿 `Tea` → 3.00 €

i cal afegir diferents decoracions com:

- 🧊 Gel (`Ice`) → +0.25 €
- 🍬 Sucre (`Sugar`) → +0.30 €
- 🥥 Tapioca (`Tapioca`) → +0.50 €
- 🍓 Sabors afegits (`Flavor`) → +0.60 € per cada sabor afegit.

> ℹ️ Si s’afegeixen dos sabors, el cost total augmenta en +1.20€.

Cada afegit modifica el cost i la descripció de la beguda. L’objectiu és fer servir el patró **Decorator** per poder **composar les begudes dinàmicament**, sense haver de crear subclasses per cada combinació possible.

---

### ✅ Requisits:

1. Crea una interfície `BubbleTea` amb els mètodes:
	- `String getDescription();`
	- `double getCost();`
2. Implementa les classes base (`LatteBase`, `MatchaBase`, `TeaBase`) que implementin `BubbleTea`. Cada base ha de tenir un cost inicial diferent i una descripció pròpia.
3. Crea decoradors concrets (ex: `Ice`, `Sugar`, `Tapioca`, `Flavor`) que heretin de `BubbleTeaDecorator`.
4. Cada decorador ha d'afegir al cost i a la descripció del Bubble Tea.
5. Implementa tests unitaris on es mostri la creació d’un Bubble Tea amb diverses combinacions..

---

### 💻 Exemple d’ús esperat:

```java
      BubbleTea tea = new LatteBase(); // base Latte
      tea = new Tapioca(tea);
      tea = new Sugar(tea);
      tea = new Flavor(tea, "Maduixa");
      tea = new Flavor(tea, "Mango");
   }
}
```
---
## 📌 Recurs recomanat
- [Decorator Design Pattern](https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/)

---
