package builder;

import builder.Phone;
import builder.PhoneBuilder;

class PhoneBuilderImpl implements PhoneBuilder {
    private Phone phoneTmp;
    public PhoneBuilderImpl(){
        phoneTmp = new Phone();
    }
    @Override
    public Phone build(){
        Phone phone = new Phone();
        phone.setScreen(phoneTmp.getScreen());
        phone.setColor(phoneTmp.getColor());
        phone.setPrice(phoneTmp.getPrice());
        return phone;
    }
    @Override
    public PhoneBuilder setScreen (final int screen){
        phoneTmp.setScreen(screen);
        return this;
    }

    @Override
    public PhoneBuilder setColor (final String color){
        phoneTmp.setColor(color);
        return this;
    }

    @Override
    public PhoneBuilder setPrice (final int price){
        phoneTmp.setPrice(price);
        return this;
    }






}
