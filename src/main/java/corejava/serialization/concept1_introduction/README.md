# Serialization & Deserialization in Java

## Introduction
- Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file 
or store in DB for later usage. 
- Deserialization is the process of converting Object stream to actual Java Object to be used in our program.

## Serializable in Java
- If you want a class object to be serializable, all you need to do it implement the java.io.Serializable interface. 
- Serializable in java is a marker interface and has no fields or methods to implement. 
- It’s like an Opt-In process through which we make our classes serializable. 
- Serialization in java is implemented by ObjectInputStream and ObjectOutputStream.

## Transient Keyword in Java
- At the time of serialization, if we don’t want to save value of a particular variable in a file, then we use transient keyword. 
- When JVM comes across transient keyword, it ignores original value of the variable and save default value of that variable data type.
- Similarly static variable values are also not serialized since they belongs to class and not object.

## Explaining the implementation
- Here we have a simple Employee Class implement Serializable interface.
- We have a SerializationUtil class created in which two methods are implemented that contains code to serialize and 
deserialize a Java object to & from a file.
- We also have the salary field which is a transient field that will not get stored in the file.
- Run the Driver class main method to see the result.
