import java.util.*;

class Model implements Cloneable {
    String type;
    Model(String type) { this.type = type; }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class prototype {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String modelType = s.nextLine();
            Model original = new Model(modelType);
            Model copy = (Model) original.clone();
            System.out.println("Cloned object type: " + copy.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
