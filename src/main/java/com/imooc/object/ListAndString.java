package com.imooc.object;

import com.imooc.common.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class ListAndString {

    private List<User> users;

    private String inputText;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public ListAndString() {
    }

    public ListAndString(List<User> users, String inputText) {
        this.users = users;
        this.inputText = inputText;
    }

    @Override
    public String toString() {
        return "ListAndString{" +
                "users=" + users +
                ", inputText='" + inputText + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        for(int i = 0; i < 2; i++){
            User user = new User();
            user.setName("tom" + i);
            user.setAge(i);
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setAddress("guangzhou" + i);
            contactInfo.setPhone("1380000000" + i);
            user.setContactInfo(contactInfo);
            users.add(user);
        }
        ListAndString listAndString = new ListAndString();
        listAndString.setUsers(users);
        listAndString.setInputText("hello");
        System.out.println(JsonUtil.objToString(listAndString));
    }
}
