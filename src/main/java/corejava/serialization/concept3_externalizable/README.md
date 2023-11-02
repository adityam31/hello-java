# Java Serialization

## Enternalizable Interface
- If you notice the java serialization process, it’s done automatically. Sometimes we want to obscure the object data to maintain it’s integrity.
- Externalization serves the purpose of custom Serialization, where we can decide what to store in stream.
-  We can do this by implementing java.io.Externalizable interface and provide implementation of writeExternal() 
and readExternal() methods to be used in serialization process.


