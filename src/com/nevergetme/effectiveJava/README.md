# Effective Java

## 1. Create and Destroy objects
* ### Consider static factory methods instead of constructors
  1. #### One advantage of static factory methods is that, unlike constructors, they have name.
  2. #### A second advantage of static factroy methods is that, unlike constructors, they are not required to create a new objects each time they are invoked.
  3. #### A third advantage of static factory methods is that, unlike constructors, they can return an object of any subtype of their return type.
  4. #### A fourth advantage of static factory methods is that they reduce the verbosity of creating parameterized type instances.
  5. #### The main disadvantage of providing only static factory methods is that classes without public or protected constructors cannot be subclassed.
  6. #### A second disadvantage of static factory methods is that they are not readily distinguishable from other static methods.
  
* ### Consider a bulider when faced with many constructor parameters
  * #### The telescopeing constructor pattern works, but it is hard to wirte client code when there are many parameters, and harder still to read it.
  * #### A second alternative when you are facing with many constructor parameters is the *JavaBeans* pattern, in which you call a parameterless constructor to create the object and then call setter methods to set each required paremeter and each optional parameter of interest.
  * #### A JavaBeans may be in an inconsistent state partway through its construction. A related disadvantage is that the JavaBeans pattern preculdes the possibility of making a class immutable, and requires added effort on the part of the programmer to ensure thread safety.
  * #### *Build Pattern* :The client calls a constructor(or static factory) with all of the required parameters and gets a builder object, then the client calls setter-like methods on the bulider object to set each optional parameter of interest. Finally, the client calls a parameterless build method to generate the object, which is immutable.  
