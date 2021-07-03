package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** JPA 기본편 실전예제
 * 엔티티 설계와 매핑
 * Member, Order, OrderItem, Item
 */

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    /** Member의 주문목록.
     * Member -> Order  관계는 드물다. Order->Member 관계로 충분. 하지만, 이건 예제니까 양방향 연관관계를 보여주기 위해. */

    @OneToMany(mappedBy = "member") // 반대편 Order 엔티티의 member 필드가 이 orders를 참조한다!
    private List<Order> orders = new ArrayList<>();

    /** Getter는 만들면 편하고, Setter는 고민할 필요가 있다.
     * 아무데서나 값을 변경하게 하면 안되기 때문이다. 코드 추적에 불편하다.
     * 가급적 생성자에서 값을 정하도록 하여 유지보수성을 높이자.
     * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
