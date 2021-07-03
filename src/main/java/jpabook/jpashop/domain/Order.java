package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")// DB예약어 order by와 충돌나지 않도록, 테이블명 orders로.
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order") //OrderItems엔티티의 order 필드가 orderItems를 참조한다.
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate; // DB에 timestamp 타입으로 매핑된다.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    /** 연관관계 편의 메소드 - 양방향 연관관계를 위함.*/
    public void addOrderItems(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
