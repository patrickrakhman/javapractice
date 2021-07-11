package builder;

interface PhoneBuilder {
    Phone build();
    PhoneBuilder setScreen(final int screen);
    PhoneBuilder setColor(final String color);
    PhoneBuilder setPrice(final int price);

}
