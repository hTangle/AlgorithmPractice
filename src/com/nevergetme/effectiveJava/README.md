# Effective Java

## 1. Create and Destroy objects
* ### Consider static factory methods instead of constructors
  1. #### One advantage of static factory methods is that, unlike constructors, they have name.
  2. #### A second advantage of static factroy methods is that, unlike constructors, they are not required to create a new objects each time they are invoked.
  3. #### A third advantage of static factory methods is that, unlike constructors, they can return an object of any subtype of their return type.
  4. #### A fourth advantage of static factory methods is that they reduce the verbosity of creating parameterized type instances.
  5. #### The main disadvantage of providing only static factory methods is that classes without public or protected constructors cannot be subclassed.
  6. #### A second disadvantage of static factory methods is that they are not readily distinguishable from other static methods.
