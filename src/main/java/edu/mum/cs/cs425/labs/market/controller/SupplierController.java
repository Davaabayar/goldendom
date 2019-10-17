package edu.mum.cs.cs425.labs.market.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.labs.market.model.Supplier;
import edu.mum.cs.cs425.labs.market.service.SupplierService;


@Controller
public class SupplierController {
	
	private SupplierService supplierService;
	
	

	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}



	@GetMapping(value = "/market/supplier/list")
	public ModelAndView listSuppliers(@RequestParam(defaultValue="0") int pageno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("suppliers", supplierService.getAllSuppliersPaged(pageno));
		mav.setViewName("supplier/list");
		return mav;		
	}
	
	@GetMapping(value = "/market/supplier/new")
	public String newSupplier(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "supplier/new";
	}
	
	
	@PostMapping(value = {"/market/supplier/new"})
    public String addNewBook(@Valid @ModelAttribute("supplier") Supplier supplier,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/new";
        }
        supplier = supplierService.saveSupplier(supplier);
        return "redirect:/market/supplier/list";
    }
}