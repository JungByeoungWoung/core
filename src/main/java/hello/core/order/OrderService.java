package hello.core.order;

public interface OrderService {
    //회원이 주문을 생성할때 회원id,상품명,상품가격 파라미터를 가지고 주문을 하고
    //return을 최종 Order 결과로 반환한다.
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
