package factory;

class SamsungCreator extends Creator{
    @Override
    public Phone factoryMethod(){
        return new Samsung();
    }

}
