# Serialization & Deserialization in Java

## Class Refactoring with Serialization and serialVersionUID Error
- Adding new variables to the class 
- Changing the variables from transient to non-transient, for serialization it’s like having a new field.
- Changing the variable from static to non-static, for serialization it’s like having a new field.



- Go to problem package in this directory
- First serialize the java object into a file let's say employee_data_2.txt
- The comment the serialize code in Driver class
- Add a new password field to the employee class
- Now only execute deserialize code.

You will get the following error

```txt
java.io.InvalidClassException: corejava.serialization.concept2_serialversionUID.problem.Employee; local class incompatible: stream classdesc serialVersionUID = 8545642147017977619, local class serialVersionUID = 313754870934763521
	at java.base/java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:728)
	at java.base/java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:2086)
	at java.base/java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1933)
	at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2259)
	at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1768)
	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:543)
	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:501)
	at corejava.serialization.concept2_serialversionUID.problem.SerializationUtil.deserialize(SerializationUtil.java:35)
	at corejava.serialization.concept2_serialversionUID.problem.Driver.main(Driver.java:26)
```

- The reason is clear that serialVersionUID of the previous class and new class are different. 
- Actually if the class doesn’t define serialVersionUID, it’s getting calculated automatically and assigned to the class. 
- Java uses class variables, methods, class name, package etc to generate this unique long number.

## Solution
__For all these changes to work, the java class should have serialVersionUID defined for the class.__
- We can use java utility “serialver” to generate the class serialVersionUID
- https://mkyong.com/intellij/how-to-generate-serialversionuid-in-intellij-idea/

Check the solution package and perform all the steps as mentioned above and the earlier
exception will not occur.
