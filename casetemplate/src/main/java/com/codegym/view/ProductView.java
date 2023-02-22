package com.codegym.view;

import com.codegym.service.inmemory.IMProductService;
import com.codegym.comparator.ComparatorByPrice;
import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.util.*;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private IProductService productService;



    public void launcher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý sản phẩm");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Cập nhật sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá");
            System.out.println("6. Sắp xếp sản phẩm theo tên");         // bài 1
//            System.out.println("7. Sắp xếp sản phẩm theo ngày");
            System.out.println("8. Tìm kiếm sản phẩm theo tên");
            System.out.println("9. Tìm kiếm sản phẩm theo khoảng giá  (từ giá mấy đến giá mấy đó)");     // bài 2
            System.out.println("9. Tìm kiếm sản phẩm theo tên hoặc giá hoặc theo mô tả");   // bài 3
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showProductsView();
                    break;
                case 3:
                    deleteProductView();
                    break;
                case 5:
                    sortProductByPriceView();
                    break;
                case 6:
                    sortProductByNameView();
                    break;
                case 8:
                    searchProductView();
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

    public ProductView() {
        productService = new IMProductService();
    }
    public void showProductsView() {
        List<Product> products = productService.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }
    public void showResultProductsView(List<Product> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
    public void deleteProductView() {
        System.out.println("Nhập id cần xóa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        productService.deleteProductById(idProduct);
        showProductsView();
    }

    public void sortProductByPriceView() {
        System.out.println("Sắp xếp sản phẩm theo giá");
        Comparator comparator = new ComparatorByPrice();

        List<Product> productSorts = productService.getAllProducts();
        productSorts.sort(comparator);
        showResultProductsView(productSorts);
    }

    public void searchProductView() {
        System.out.println("Tìm kiếm theo tên: ");
        String nameSearch = scanner.nextLine();

        List<Product> products = productService.getAllProducts();
        List<Product> results = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(nameSearch)) {
                results.add(products.get(i));
            }
        }
        if (results.size() == 0) {
            System.out.println("Sorry bạn! Tui không tìm thấy sản phẩm nào");
        }
        showResultProductsView(results);
    }

    public void sortProductByNameView() {
        System.out.println("Sắp xếp sản phẩm theo tên");
        /**
        Comparator comparatorByName = new ComparatorByName();
        products.sort(comparatorByName);

         // Cách dùng lớp nặc danh: anonymous class
         Comparator comparatorByName1 = new Comparator<Product>(){
        @Override
        public int compare(Product o1, Product o2) {
                if (o1.getName().compareTo(o2.getName()) > 0) {
                    return 1;
                } else if (o1.getName().compareTo(o2.getName())==0) {
                    return 0;
                }else{
                    return -1;
                }
                }
        };
         products.sort(comparatorByName1);
         **/



        List<Product> productSortNames  = productService.getAllProducts();
        productSortNames.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getName().compareTo(o2.getName()) > 0) {
                    return 1;
                } else if (o1.getName().compareTo(o2.getName())==0) {
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        showResultProductsView(productSortNames);
    }
}
