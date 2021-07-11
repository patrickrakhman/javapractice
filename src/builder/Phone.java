package builder;

class Phone {
    private int screen;
    private int price;
    private String color;

    public Phone(){

    }

    public void  setScreen(final int screen){
        this.screen = screen;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public void setPrice(final int price) {
        this.price = price;
    }
    @Override
    public String toString(){

        return "Phone [screen = " + screen + ", color = " + color + ", price = " + price + "]";
    }

    public int getScreen() {
        return screen;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }
}
