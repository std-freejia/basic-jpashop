package jpabook.jpashop.domain;

import javax.persistence.*;

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
