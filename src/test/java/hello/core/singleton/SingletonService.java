package hello.core.singleton;

public class SingletonService {
    //private static final로 선언을 하면서 다른 클래스에서 SingletonService객체를 생성하지 못하고
    //사용할 객체 하나인 instance 하나만 생성해 둔다.
    private static final SingletonService instance = new SingletonService();
    //instance 를 꺼내는 방법은 getInstance()를 이용하여 꺼내는 수 밖에 없다.
    //이렇게 되면 생성한 instance 하나만을 이용해서 여러 곳에서 참조가 가능하다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private으로 선언함으로써 외부에서 new를 이용한 객체생성을 못하게 막는 것이다.
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출출");
    }
}
