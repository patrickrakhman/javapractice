package factory;

class AppleCreator extends Creator{
    @Override
    public Phone factoryMethod(){
        return new Apple();
    }
}
