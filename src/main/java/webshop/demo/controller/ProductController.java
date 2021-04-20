package webshop.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import webshop.demo.model.Company;
import webshop.demo.model.Description;
import webshop.demo.model.Product;
import webshop.demo.service.CompanyService;
import webshop.demo.service.DescriptionService;
import webshop.demo.service.ProductService;


@Controller
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @Autowired
    CompanyService companyService;

    @Autowired
    DescriptionService descriptionService;


    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("products", productService.findAll());

        return "index";
    }

    @GetMapping("/createProduct")
    public String createChar() {
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createCharacter(WebRequest request) {
        Description description = new Description();
        Company company = new Company();

        String name = request.getParameter("productName");
        String price = request.getParameter("productPrice");
        String productDescription = request.getParameter("productDescription");
        String productCompany = request.getParameter("productCompany");

        description.setDescription(productDescription);
        company.setName(productCompany);

        Product product = new Product(name, Double.parseDouble(price), description, company);

        productService.createProduct(product);

        return "redirect:/";
    }


    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") long idProject, WebRequest request, Model model) {
        Product currentProduct = productService.getProductById(idProject);
        productSessionInfo(request, currentProduct);
        model.addAttribute("product", currentProduct);
        return "updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(WebRequest request) {
        Product product = (Product) request.getAttribute("product",WebRequest.SCOPE_SESSION);

        String name = request.getParameter("productName");
        String price = request.getParameter("productPrice");
        String productDescription = request.getParameter("productDescription");

        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.getDescription().setDescription(productDescription);

        productService.updateProduct(product);

        return "redirect:/";
    }

    public void productSessionInfo(WebRequest request, Product product) {
        request.setAttribute("product", product, WebRequest.SCOPE_SESSION);
    }
}
