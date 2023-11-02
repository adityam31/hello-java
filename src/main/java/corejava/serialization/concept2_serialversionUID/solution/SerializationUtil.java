package corejava.serialization.concept2_serialversionUID.solution;

import java.io.*;

public class SerializationUtil {

    /**
     * Serialize the given object and save it in the file
     * @param   object      Object to be Serialized
     * @param   fileName    File Name to store the object
     * @throws IOException
     */
    public static void serialize(Object object, String fileName) throws IOException {
        FileOutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(object);

        fout.close();
        oout.close();
    }


    /**
     * Deserialize object from given file. It will also type cast and return the object of original class
     *
     * @param   fileName    File name where the object is serialized
     * @return  Object      Deserialized object
     * @param   <T>         Class of object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream oin = new ObjectInputStream(fin);
        Object object = oin.readObject();
        oin.close();
        fin.close();

        return (T) object;
    }
}
