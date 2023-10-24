package animal;

import java.io.*;
import java.util.Objects;

public class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            Animal[] a = new Animal[ois.readInt()];
            for (int i = 0; i < a.length; i++) {
                a[i] = (Animal) ois.readObject();
            }
            return a;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
