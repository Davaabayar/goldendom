package edu.mum.cs.cs425.labs.market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.labs.market.model.Product;
import edu.mum.cs.cs425.labs.market.model.Supplier;
import edu.mum.cs.cs425.labs.market.service.ProductService;
import edu.mum.cs.cs425.labs.market.service.SupplierService;

@Controller
public class ProductController {
	
	private ProductService productService;
	private SupplierService supplierService;
	
	public ProductController(ProductService productService, SupplierService supplierService) {
		this.productService = productService;
		this.supplierService = supplierService;
	}

	@GetMapping(value = "/market/product/list")
	public ModelAndView listProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", productService.getAllProducts());
		mav.setViewName("product/list");
		return mav;		
	}
	
	@GetMapping(value = "/market/product/new")
	public String newSupplier(Model model) {
		List<Supplier> suppliers = supplierService.getAllSupplier();
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("product", new Product());
		return "/product/new";
	}
	
	
	@PostMapping(value = {"/market/product/new"})
    public String addNewBook(@Valid @ModelAttribute("product") Product product,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	List<Supplier> suppliers = supplierService.getAllSupplier();
    		model.addAttribute("suppliers", suppliers);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/new";
        }
        product = productService.addProduct(product);
        return "redirect:/market/product/list";
    }
}
