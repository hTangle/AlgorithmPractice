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
  * #### The telescoping constructor pattern works, but it is hard to wirte client code when there are many parameters, and harder still to read it.
  * #### A second alternative when you are facing with many constructor parameters is the *JavaBeans* pattern, in which you call a parameterless constructor to create the object and then call setter methods to set each required paremeter and each optional parameter of interest.
  * #### A JavaBeans may be in an inconsistent state partway through its construction. A related disadvantage is that the JavaBeans pattern preculdes the possibility of making a class immutable, and requires added effort on the part of the programmer to ensure thread safety.
  * #### *Build Pattern* :The client calls a constructor(or static factory) with all of the required parameters and gets a builder object, then the client calls setter-like methods on the bulider object to set each optional parameter of interest. Finally, the client calls a parameterless build method to generate the object, which is immutable.  
  * #### A builder whose parameters have been set makes a fine *Abstract Factory* which means that a client can pass such a builder to a method to enable the method to create one or more objects for the client.
  * #### Class.newInstance breaks compile-time exception checking.
  * #### While the cost of creating the builder is unlikely to be noticeable in practice, it could be a problem in some performance-critical situations.
  * #### In addition, the Builder pattern is more verbose than the telescoping constructor pattern, so it should be used only if there are enough parameters.
  * #### In summary, the Builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters.
  
* ### Enforce the singleton property with a private constructor or an enum type
  > #### A Singleton is simply a class that is instantiated exactly once.
  > #### Making a class a singleton can make it difficult to test its clients, as it's impossible to substitute a mock implementation for a singleton unless it implements an interface that serves as its type.
  
* ### Enforce noninstantiability with with a private constructor
  > #### Attempting to enforce noninstantiablilty by making a class abstract does not work.
  > #### The AssertionError isn't strictly required, but it provides insurance in case the constructor is accidentally invoked from within the class.
  
* ### Avoid creating unnecessary objects

```
String s=new String("stringette");//Don't do this!
```

  > #### You can often avoid creating unnecessary objects by using *static factory methods* in preference to constructor on immutable classes that provide both.
  > #### Prefer primitives to boxed primitives, and watch out for unintentional autoboxing.
  > #### Creating objects unnecessarily merely affects style and performance.
  
* ### Eliminate obsolete object references
  * #### Nulling out object references should be the exception rather than the norm.
  * #### General speaking, whenever a class managers its own memory, the programmer should be alert for memory leaks.
  * #### Another common source of memory leaks is caches.
  * #### A third common source of memory leaks is listeners and other callbacks.
  
* ### Avoid finalizers
  > #### Don't use finalizers except as a safety net or to terminate noncritical native resources. In those rare instances where you do use a finalizers, remember to invoke super.finalize. If you use a finalizer as a safety net, remember to log the invalid usage from the finalizer. Lastly, if you need to associate a finalizer with a public, nonfinal class, consider using a finalizer guardian, so finalization can take place even if a subclass finalizer fails to invoke super.finalizer.
  
## 2. Methods Common on All Objects

* ### Obey the general contract when overriding equals
  1. #### Use the == operator to check if the argument is a reference to this object.
  2. #### Use the instanceof operator to check if the argument has the correct type.
  3. #### Cast the argument to the correct type.
  4. #### For each "significant" field in the class, check if that field of the argument matches the corresponding field of this object.
  5. #### When you are finished writing your equals method, ask yourself three questions: Is it symmetric? Is it transitive? Is it consistent?
  
* ### Always override hashCode when you override equals
  