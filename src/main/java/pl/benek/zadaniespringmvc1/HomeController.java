package pl.benek.zadaniespringmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
