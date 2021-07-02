package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")// DB예약어 order by와 충돌나지 않도록, 테이블명 orders로.
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @Column(name="member_id")
    private Long memberId;

    private LocalDateTime orderDate; // DB에 timestamp 타입으로 매핑된다.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
