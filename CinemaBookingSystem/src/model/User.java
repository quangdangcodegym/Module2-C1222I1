package model;

import repository.IModel;
import service.OrderService;

import java.util.Date;
import java.util.List;

import static utils.DateUtils.convertDateToString;
import static utils.DateUtils.parseDate;

public class User implements IModel<User> {
    private long id;
    private String nameAccount;
    private String password;
    private String name;
    private int age;
    private EGender gender;
    private String address;
    private String phoneNumber;
    private Date create;
    private ERole role;
    public List<Order> orderList;
    public static OrderService orderService = new OrderService();

    public User() {
    }

    public User(long id, String nameAccount, String password, String name, int age, EGender gender, String address, String phoneNumber, Date create, ERole role) {
        this.id = id;
        this.nameAccount = nameAccount;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.create = create;
        this.role = role;
    }

    public User(long id, String nameAccount, String password, String name, int age, EGender gender, String address, String phoneNumber, Date create, ERole role, List<Order> orderList) {
        this.id = id;
        this.nameAccount = nameAccount;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.create = create;
        this.role = role;
        this.orderList = orderList;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(User obj) {
        //long id, String nameAccount, String password, String name, int age, EGender gender, String address, String phoneNumber, Date create, erole
        this.id = obj.id;
        this.nameAccount = obj.nameAccount;
        this.password = obj.password;
        this.name = obj.name;
        this.age = obj.age;
        this.gender = obj.gender;
        this.address = obj.address;
        this.phoneNumber = obj.phoneNumber;
        this.role = obj.role;
        this.orderList = obj.orderList;
    }

    @Override
    public User parseData(String line) {
        User user = new User();

        //long id, String nameAccount, String password, String name, int age, EGender gender, String address, String phoneNumber, Date create, erole
        String[] userInfo = line.split(",");
        long id = Long.parseLong(userInfo[0]);
        String username = userInfo[1];
        String pass = userInfo[2];
        String name = userInfo[3];
        int age = Integer.parseInt(userInfo[4]);
        EGender gender = EGender.getEGenderByName(userInfo[5]);
        String address = userInfo[6];
        String phone = userInfo[7];
        Date createDate = parseDate(userInfo[8]);
        ERole role = ERole.getRoleByName(userInfo[9]);

        user.setId(id);
        user.setNameAccount(username);
        user.setPassword(pass);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setAddress(address);
        user.setPhoneNumber(phone);
        user.setCreate(createDate);
        user.setRole(role);
        user.setOrderList(orderService.findOrderListByIdCustomer(id));

        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String viewUser() {
        String genderName = this.gender.getName();
        String date = convertDateToString(create);
        return String.format("            ║%7s║%-30s║ %-7s║ %-15s║ %-20s║ %-20s║ %-20s║", id, name, age, genderName, address, phoneNumber, date);
    }

    @Override
    public String toString() {
        //long id, String nameAccount, String password, String name, int age, EGender gender, String address, String phoneNumber, Date create, role
        String date = convertDateToString(create);
        String genderName = this.gender.getName();
        String eRole = this.role.getValue();
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", id, nameAccount, password, name, age, genderName, address, phoneNumber, date, eRole);
    }
}
