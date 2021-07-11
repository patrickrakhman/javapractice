package factory;

public class FactoryMethod {
    public static void main(String[] args) {
        Creator[] creators = {new AppleCreator(),new SamsungCreator()};
        for (Creator creator : creators){
            Phone phone = creator.factoryMethod();
            System.out.printf("Created {%s}\n",phone.getClass());
        }

    }
}
