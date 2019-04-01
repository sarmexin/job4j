package hire;

class Client {
    private String name;
    private String surname;
    private int passport;

    LambdaInterface lambdaInterface;
    LambdaInterface2 lambdaInterface2;
    LambdaInterface2 lambdaInterface3;
    SomeFunc<Integer> someFunc;

    public Client(String name, String surname, int passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPassport() {
        return passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public void lambdaMethod() {
        System.out.println("Применение лямбда");
        lambdaInterface = () -> "Вызов через лямбда";
        System.out.println(lambdaInterface.getClient());
    }

    public void LambdaMethod2() {
        System.out.println("Применение лямбда2");
        lambdaInterface2 = (n) -> ++n;
        System.out.println(lambdaInterface2.getClient(10));
    }

    public void LambdaMethod3() {
        System.out.println("Применение лямбда3");
        lambdaInterface3 = (n) -> {
            int x = n + 10;
            return x;
        };
        System.out.println(lambdaInterface3.getClient(10));
    }

    public void funcInterface() {
        someFunc = (n) -> n + 1000;
        System.out.println("Применение лямбда4");
        System.out.println(someFunc.func(55));
    }

    static String stringOp(StringFunc sf, String s) {
        System.out.println("sf.func = " + sf.func(s));
        return sf.func(s);
    }

    public void method() {
        String inStr = "Лямбда выражение в качестве аргумента";
        String outStr = stringOp((tr) -> tr.toUpperCase(), inStr);
        System.out.println("Эта строка в верхнем регистре " + outStr);
    }
    static String getInt() {
        return "10";
    }
    public void inMethod() {
        System.out.println("Ссылка на метод " + Client.getInt());

    }
}
