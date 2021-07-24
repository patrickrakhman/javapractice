package builder;

public class PhoneBuildDirector {
    private PhoneBuilder builder;

    public PhoneBuildDirector(final PhoneBuilder builder){
        this.builder = builder;

    }

    public Phone construct(){
        return builder.setScreen(6)
                      .setColor("Space Gray")
                      .setPrice(75)
                      .build();
    }


    public static void main(final String[] arguments){
        final PhoneBuilder builder = new PhoneBuilderImpl();

        final PhoneBuildDirector phoneBuildDirector = new PhoneBuildDirector(builder);

        System.out.println(phoneBuildDirector.construct());
    }
}
