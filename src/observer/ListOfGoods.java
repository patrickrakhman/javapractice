package observer;

public class ListOfGoods {
    public static void main(String[] args) {
        PhonesSite phonesSite = new PhonesSite();
        phonesSite.addPhone("iPhone 12");
        phonesSite.addPhone("Samsung S21");

        Observer firstSubscriber = new Subscriber("Vasiliy Pupkin");
        Observer secondSubscriber = new Subscriber("Ivan Ivanov");

        phonesSite.addObserver(firstSubscriber);
        phonesSite.addObserver(secondSubscriber);

        phonesSite.addPhone("Samsung S22");

        phonesSite.removePhone("Samsung S21");



    }
}
