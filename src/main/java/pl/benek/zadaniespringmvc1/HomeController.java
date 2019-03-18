package pl.benek.zadaniespringmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;

@Controller
class HomeController {

    LinkedList<Product> products = new LinkedList<>();

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<Product> products) {
        this.products = products;
    }

    public HomeController() {
        this.products = products;
    }

    @RequestMapping("/lista")
    @ResponseBody
    public String add(@RequestParam String name, @RequestParam double price) {
        products.add(new Product(name, price));

        double sum = 0;
        for (Product product : products) {
            sum = sum + product.getPrice();
        }

        StringBuilder productsList = new StringBuilder();
        for (Product product : products) {
            productsList.append("<br>").append(product.toString());

        }
        return productsList + "<p>Suma cen: " + sum + " zł.";
    }

    @GetMapping("/lista")
    @ResponseBody
    public String add(Model model) {
        products.add(new Product());
        return "lista";
    }

    @GetMapping("/")
    public String vistHome(Model model) {
        model.addAttribute("newProduct", new Product());

        return "home";
    }

    @GetMapping("/tabela")
    public String vistTable(Model model) {
        model.addAttribute("products", products);
        double sum = 0;
        for (Product product : products) {
            sum = sum + product.getPrice();
        }

        model.addAttribute("sum",sum);

        return "tabela";
    }

//
//    @GetMapping("/")
//    public String hello(Model model, @RequestParam(required = false, defaultValue = "Anonim") String imie) {
//
//        //String imie = "Adam";
//
//        model.addAttribute("name", imie);
//
//        return "hello";
//    }
//
//    @RequestMapping("/")
//    @ResponseBody
//    public String home() {
//        return "Hello World";
//    }
//
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String helloW() {
//        return "Hello World 2";
//    }



}
