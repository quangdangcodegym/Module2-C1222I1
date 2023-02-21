package com.codegym.view;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.utils.DateUtils;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private Scanner scanner = new Scanner(System.in);
    private CustomerService customerService;
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
            showCustomersView();
        }

    }


    public CustomerView() {
        customerService = new CustomerService();
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
