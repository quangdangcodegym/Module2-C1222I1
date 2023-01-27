package view;

import model.EGender;
import model.ERole;
import model.User;
import service.CustomerService;
import utils.ValidateUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private CustomerService customerService;
    Scanner scanner = new Scanner(System.in);

    public CustomerView() {
        customerService = new CustomerService();
    }

    public void renderCustomerMenu() {
        System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                                  CUSTOMER MANAGER MENU                            ║");
        System.out.println("                               ║                              [1] Display all customer                             ║");
        System.out.println("                               ║                              [2] Add new customer                                 ║");
        System.out.println("                               ║                              [3] Edit customer's profile                          ║");
        System.out.println("                               ║                              [4] Delete customer                                  ║");
        System.out.println("                               ║                              [5] Search customer by name                          ║");
        System.out.println("                               ║                              [6] Return Admin Dashboard                           ║");
        System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void launcher() {
        boolean checkAction = false;
        do {
            renderCustomerMenu();
            System.out.println("Please choose one");
            int actionMenuProduct = Integer.parseInt(scanner.nextLine());
            switch (actionMenuProduct) {
                case 1:
                    displayAllCustomer(customerService.getAllCustomer());
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    chooseUserToEdit();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    displaySearchName();
                    break;
                case 6:
                    AdminView adminView = new AdminView();
                    adminView.launcher();
                    break;
            }
            checkAction = checkActionContinue();
        } while (checkAction);
    }

    public void addNewCustomer() {
        User user = new User();
        //long id, String nameAccount, String password, String name, int age, EGender gender, String address, String phoneNumber, Date create, erole
        //càn kiểm tra nameAccount, phonenumber
        long id = System.currentTimeMillis() % 1000;
        String username = checkUserName();
        String password = checkPassword();
        System.out.println("Enter customer's name");
        String name = scanner.nextLine();
        System.out.println("Enter customer's age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter gender");
        for (EGender e : EGender.values()) {
            System.out.printf("%s enter %s ", e, e.getId());
            System.out.println();
        }
        int gender = Integer.parseInt(scanner.nextLine());
        EGender eGender = EGender.toGender(gender);
        System.out.println("Enter customer's address");
        String address = scanner.nextLine();
        Date createDate = new Date();
        String phone = checkExistPhoneNumber();
        ERole role = ERole.getRoleByName("customer");

        user.setId(id);
        user.setNameAccount(username);
        user.setPassword(password);
        user.setName(name);
        user.setAge(age);
        user.setGender(eGender);
        user.setAddress(address);
        user.setCreate(createDate);
        user.setRole(role);
        user.setPhoneNumber(phone);
        System.out.println("Please check new customer's information");
        displayUser(user);
        System.out.println("Do you want to save? Y/N");
        String choice = scanner.nextLine();
        choice = choice.trim().toUpperCase();
        switch (choice) {
            case "Y":
                customerService.addNewCustomer(user);
                break;
            case "N":
                System.out.println("If you want to edit, please enter 1");
                System.out.println("If you want to cancel, please enter any keys");
                String edit = scanner.nextLine().trim();
                if (edit.equals("1")) {
                    editCustomer(user);
                    customerService.addNewCustomer(user);
                } else break;
        }
    }

    public String checkPassword() {
        String pass;
        boolean checkPass;
        do {
            checkPass = true;
            System.out.println("Enter password (Password must not contain spaces, must be at least 5 characters )");
            pass = scanner.nextLine();
            pass = pass.trim();
            if (pass.contains(" ")) {
                System.out.println("Incorrect Password. Password must not contain spaces");
                checkPass = false;
            }
            if (pass.length() < 5) {
                System.out.println("Incorrect Password. Password must be at least 5 characters");
                checkPass = false;
            }
        } while (!checkPass);
        return pass;
    }

    public String checkUserName() {
        String username;
        boolean checkUsername;
        do {
            checkUsername = true;
            System.out.println("Enter username (Username must have at least 7 characters and 1 special character)");
            username = scanner.nextLine();
            username = username.trim();
            if (ValidateUtils.isUserName(username)) {
                System.out.println("Invalid Username. Username must have at least 7 characters and 1 special character");
                System.out.println("Please re-enter");
                checkUsername = false;
            }
            if (customerService.checkExistUsername(username)) {
                System.out.println("Username already exists. Please re-enter");
                checkUsername = false;
            }
        } while (!checkUsername);
        return username;
    }

    public String checkExistPhoneNumber() {
        String number;
        boolean checkNumber;
        do {
            checkNumber = true;
            System.out.println("Enter phone number: ");
            number = scanner.nextLine();
            if (!ValidateUtils.isPhoneNumber(number)) {
                System.out.println("Invalid phone number. Please re-enter");
                checkNumber = false;
            }
            if (customerService.checkExistPhoneNumber(number)) {
                System.out.println("Phone number already exists. Please re-enter");
                checkNumber = false;
            }
        } while (!checkNumber);
        return number;
    }

    public void chooseUserToEdit() {
        displayAllCustomer(customerService.getAllCustomer());
        System.out.println("Enter ID's customer you want to edit?");
        long idCustomer = Long.parseLong(scanner.nextLine());
        if (customerService.findById(idCustomer) == null) {
            System.out.println("Not found this ID");
            return;
        }
        editCustomer(customerService.findById(idCustomer));
    }

    public void editCustomer(User customer) {
        System.out.println("                                                ┌----------------------EDIT------------------┐");
        System.out.println("                                                |         [1] Edit customer's name           |");
        System.out.println("                                                |         [2] Edit customer's age            |");
        System.out.println("                                                |         [3] Edit customer's gender         |");
        System.out.println("                                                |         [4] Edit customer's address        |");
        System.out.println("                                                |         [5] Edit customer's phone number   |");
        System.out.println("                                                └--------------------------------------------┘");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Enter customer's name");
                customer.setName(scanner.nextLine());
                displayUser(customer);
                break;
            case 2:
                System.out.println("Enter customer's age");
                customer.setAge(Integer.parseInt(scanner.nextLine()));
                displayUser(customer);
                break;
            case 3:
                System.out.println("Enter customer's address");
                customer.setAddress(scanner.nextLine());
                displayUser(customer);
                break;
            case 4:
                System.out.println("Enter customer's address");
                customer.setAddress(scanner.nextLine());
                displayUser(customer);
                break;
            case 5:
                customer.setPhoneNumber(checkExistPhoneNumber());
                displayUser(customer);
                break;
            default:
                break;
        }
        customerService.updateById(customer.getId(), customer);
    }

    public void deleteCustomer() {
        displayAllCustomer(customerService.getAllCustomer());
        System.out.println("Enter ID's customer you want to edit?");
        long idCustomer = Long.parseLong(scanner.nextLine());
        if (customerService.findById(idCustomer) == null) {
            System.out.println("Not found this ID");
            return;
        }
        customerService.deleteById(customerService.findById(idCustomer).getId());
        displayAllCustomer(customerService.getAllCustomer());
    }

    public List<User> searchByName(String name) {
        return customerService.searchByName(name);
    }

    public void displaySearchName() {
        System.out.println("Enter name you want to search");
        String name = scanner.nextLine();
        List<User> result = searchByName(name.trim().toLowerCase());
        if (result == null) {
            System.out.println("Not found this name");
            return;
        }
        displayAllCustomer(result);
    }

    public void displayUser(User user) {
        System.out.println("            ╔═══════╦══════════════════════════════╦════════╦════════════════╦═════════════════════╦═════════════════════╦═════════════════════╗");
        System.out.printf("            ║%7s║%-30s║ %-7s║ %-15s║ %-20s║ %-20s║ %-20s║", "ID", "Customer's name", "Age", "Gender", "Address", "Phone", "Create Date").println();
        System.out.println("            ╠═══════╬══════════════════════════════╬════════╬════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣");
        System.out.println(user.viewUser());
        System.out.println("            ╚═══════╩══════════════════════════════╩════════╩════════════════╩═════════════════════╩═════════════════════╩═════════════════════╝");
    }

    public void displayAllCustomer(List<User> customerList) {
        System.out.println("            ╔═══════╦══════════════════════════════╦════════╦════════════════╦═════════════════════╦═════════════════════╦═════════════════════╗");
        System.out.printf("            ║%7s║%-30s║ %-7s║ %-15s║ %-20s║ %-20s║ %-20s║", "ID", "Customer's name", "Age", "Gender", "Address", "Phone", "Create Date").println();
        System.out.println("            ╠═══════╬══════════════════════════════╬════════╬════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣");
        for (int i = 0; i < customerList.size(); i++) {
            if (i == (customerList.size() - 1)) {
                System.out.println(customerList.get(i).viewUser());
                System.out.println("            ╚═══════╩══════════════════════════════╩════════╩════════════════╩═════════════════════╩═════════════════════╩═════════════════════╝");
            } else {
                System.out.println(customerList.get(i).viewUser());
                System.out.println("            ╠═══════╬══════════════════════════════╬════════╬════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣");
            }
        }
    }

    public boolean checkActionContinue() {
        boolean checkActionContinue = false;
        do {
            System.out.println("Continue? Y/N");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    checkActionContinue = true;
            }
        } while (checkActionContinue);
        return false;
    }
}
