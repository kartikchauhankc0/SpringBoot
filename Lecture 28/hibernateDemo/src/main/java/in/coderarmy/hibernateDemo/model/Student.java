package in.coderarmy.hibernateDemo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="student_name",
            nullable = false,
            length = 100
    )
    private String name;
    @Column(unique = true,
            nullable = false,
            length = 150
    )
    private String email;
    private int age;

    @ElementCollection
    @CollectionTable(
            name="student_skills",
            joinColumns = @JoinColumn(name="student_id")
    )

    private Set<String> skills;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name="houseNo",
//                    column = @Column(name="current_house_no")
//            ),
//            @AttributeOverride(
//                    name="street",
//                    column = @Column(name="current_street")
//            ),
//            @AttributeOverride(
//                    name="city",
//                    column = @Column(name="current_city")
//            ),
//            @AttributeOverride(
//                    name="state",
//                    column = @Column(name="current_state")
//            ),
//            @AttributeOverride(
//                    name="pinCode",
//                    column = @Column(name="current_pin_code")
//            ),
//
//    })
//    private Address currentAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(
//                    name="houseNo",
//                    column = @Column(name="permanent_house_no")
//            ),
//            @AttributeOverride(
//                    name="street",
//                    column = @Column(name="permanent_street")
//            ),
//            @AttributeOverride(
//                    name="city",
//                    column = @Column(name="permanent_city")
//            ),
//            @AttributeOverride(
//                    name="state",
//                    column = @Column(name="permanent_state")
//            ),
//            @AttributeOverride(
//                    name="pinCode",
//                    column = @Column(name="permanent_pin_code")
//            ),
//    })
//    private Address permanentAddress;

//    @Column(precision = 5,scale = 2)
//    private BigDecimal percentage;
//
//    private LocalDate dateOfBirth;
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus status;
//
//    private LocalDateTime createdAt;
//
//    @Lob
//    private String profileDescription;
//
//    @Transient //if we want this don't go to database we use it as property
//    private String displayTime;
//
//    @Convert(converter = BooleanToStringConverter.class)
//    private Boolean isMonitor;

    public Student() {}

    public Student(Long id, Set<String> skills, int age, String email, String name) {
        this.id = id;
        this.skills = skills;
        this.age = age;
        this.email = email;
        this.name = name;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    //    public Address getCurrentAddress() {
//        return currentAddress;
//    }
//
//    public void setCurrentAddress(Address currentAddress) {
//        this.currentAddress = currentAddress;
//    }
//
//    public Address getPermanentAddress() {
//        return permanentAddress;
//    }
//
//    public void setPermanentAddress(Address permanentAddress) {
//        this.permanentAddress = permanentAddress;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
