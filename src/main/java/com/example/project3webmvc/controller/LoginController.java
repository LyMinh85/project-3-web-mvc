package com.example.project3webmvc.controller;

import com.example.project3webmvc.entity.Customer;
import com.example.project3webmvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final CustomerRepository customerRepository;

    @Autowired
    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về tên của trang đăng nhập (login.html, login.jsp, ...).
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam("customerID") int customerID,
            @RequestParam("password") String password,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ) {
        // Xử lý đăng nhập
        Customer customer = customerRepository.findByCustomerIDAndPassword(customerID, password);
        if (customer != null) {
            request.getSession().setAttribute("customer", customer);
            return "redirect:/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            return "redirect:/login";
        }
    }
}
