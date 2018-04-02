package imooc.object;

import com.imooc.object.ContactInfo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by geely on 2015/11/22.
 */
public class User {

    private String name;
    private Integer age;
    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Set<com.imooc.object.User> u = new HashSet<com.imooc.object.User>();
        com.imooc.object.User u1 = new com.imooc.object.User();
        u1.setName("aa");
        com.imooc.object.User u2 = new com.imooc.object.User();
        u2.setName("aa");
        u.add(u1);
        u.add(u2);
        System.out.println("size:"+u.size());
        System.out.println(u);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
