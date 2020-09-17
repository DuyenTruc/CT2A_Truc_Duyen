package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class HotelEntity { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HotelID")
    private int id;
    
    @Column(name="HotelName")
    private String name;
    
    @Column(name="HotelPhone")
    private String phone;
    
    @Column(name="HotelEmail")
    private String email;
    
    @Column(name="HotelImages")
    private String images;
    
    @Column(name="Rate")
    private Double rate;
    
    @Column(name="HotelAddress")
    private String address;
    
    @Column(name="Promotion")
    private String promotion;
    
    // n-1 voi bang City
    @ManyToOne
    @JoinColumn(name="CityID")//khóa ngoại 
    private CityEntity city;
    
    // 1-n voi bang RoomType
    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    List<RoomTypeEntity> roomTypeList;
    
    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    List<ServiceEntity> serviceList;
    
    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    List<CommentEntity> commentList;

    public HotelEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public List<ServiceEntity> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceEntity> serviceList) {
        this.serviceList = serviceList;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public List<RoomTypeEntity> getRoomTypeList() {
        return roomTypeList;
    }

    public void setRoomTypeList(List<RoomTypeEntity> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }
    
    
}
