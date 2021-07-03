package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // EntityManagerFactory 를 1개 생성한다. 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex1jpashop");

        // 트렌젝션 단위 처리마다 EntityManager가 1개씩 필요하다. 고객의 요청 한 개에 대해 동작
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Order order = new Order();
            //order.addOrderItems(new OrderItem());
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);

            /** 중요한건, 단방향 연관관계만 잘 해도 애플리케이션 개발에 크게 문제가 없다는 것이다!
             개발 상의 편의 또는 특별히 조회가 필요한 경우에만 양방향 연관관계 설정이 필요하다.
             JPQL을 복잡하게 짤 때 양방향 연관관계가 필요할 때도 있다.  */

            tx.commit(); // DB에 insert SQL 실행
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
