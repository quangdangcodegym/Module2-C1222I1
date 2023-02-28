package com.codegym.view;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.file.FCustomerService;
import com.codegym.service.ICustomerService;
import com.codegym.utils.DateUtils;
import com.codegym.utils.ValidateUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private Scanner scanner = new Scanner(System.in);

    // IM viết tắt: immemory
    private ICustomerService customerService;
    public void launcher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý khách hàng");
            System.out.println("1. Xem danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showCustomersView();
                    break;
                case 2:
                    addCustomerView();
                    break;
                case 3:
                    editCustomerView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        break;
                    case "N":
                        checkActionMenu = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);

        } while (checkActionMenu);
    }

    private void addCustomerView() {
        Customer customer = new Customer();


        String name = inputNameValid();
        String phoneCustomer= inputPhoneValid();


        System.out.println(("Nhập địa chỉ khách hàng:"));
        String address = scanner.nextLine();


        Date dCreateAt = inputDateValid();


        customer.setPhone(phoneCustomer);
        customer.setAddress(address);
        customer.setName(name);
        customer.setCustomerType(CustomerType.NORMAL);
        customer.setConsumed(0);
        customer.setCreateAt(dCreateAt);

        customerService.addCustomer(customer);
    }

    private Date inputDateValid() {
        boolean checkDateValid = false;
        String createdAt;
        Date dCreateAt;
        do{
            System.out.println("Nhập ngày tạo:");
            System.out.println("Ngày tạo theo định dạng: 20-10-2023 08:10");
            createdAt = scanner.nextLine();
            dCreateAt = DateUtils.parseDate(createdAt);
            if (dCreateAt == null) {
                checkDateValid = true;
            }else{
                checkDateValid = false;
            }

        }while (checkDateValid);
        return dCreateAt;
    }

    private String inputPhoneValid() {
        boolean checkPhoneValid = false;
        String phone;
        do{
            System.out.println("Nhập số điện thoại: " );
            System.out.println("Số điện thoại có thể 10-11 số bắt đầu từ 0: Ví dụ: 0399578133");
            phone = scanner.nextLine();
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số điện thoại chưa đúng vui lòng nhập lại");
                checkPhoneValid = true;
            }else{
                checkPhoneValid = false;
            }
        }while (checkPhoneValid);
        return phone;
    }

    private String inputNameValid() {
        boolean checkNameValid = false;
        String name;
        do{
            System.out.println("Nhập tên khách hàng: " );
            System.out.println("Tên khách hàng từ 8-20 kí tự, bắt đầu bằng chữ cái: Ví dụ: Quang Dang");
            name = scanner.nextLine();
            if (!ValidateUtils.isNameValid(name)) {
                System.out.println("Tên khách hàng chưa đúng vui lòng nhập lại");
                checkNameValid = true;
            }else{
                checkNameValid = false;
            }
        }while (checkNameValid);
        return name;
    }

    private void editCustomerView() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Bạn muốn sửa thông tin nào");
            System.out.println("1. Sửa theo tên");
            System.out.println("2. Sửa theo số điện thoại");
            System.out.println("3. Cập nhật loại khách hàng");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    editCustomerByNameView();
                    break;
                case 3:
                    editCustomerByCustomerTypeView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        break;
                    case "N":
                        checkActionMenu = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);

        } while (checkActionMenu);
    }

    private void editCustomerByCustomerTypeView() {


    }

    private void editCustomerByNameView() {
        System.out.println("Nhập ID khách hàng bạn muốn sửa");
        long idCustomer = Long.parseLong(scanner.nextLine());

        Customer customer = customerService.findCustomerById(idCustomer);
        if (customer == null) {

        }else{
            System.out.println("Nhập tên mới: ");
            String nameCustomer = scanner.nextLine();

            customer.setName(nameCustomer);
            customerService.updateCustomer(customer.getId(), customer);
            showCustomersView();
        }

    }


    public CustomerView() {
        customerService = new FCustomerService();
    }
    private void showCustomersView() {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.printf("%5s | %10s | %10s | %10s | %25s | %10s | %10s\n",
                "ID", "Name", "Phone", "Address", "CreateAt", "Consumed", "Customer type");
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.printf("%5s | %10s | %10s | %10s | %25s | %10s | %10s\n",
                    c.getId(), c.getName(), c.getPhone(), c.getAddress(),
                    DateUtils.dateToString(c.getCreateAt()), c.getConsumed(), c.getCustomerType());
        }
    }
}
