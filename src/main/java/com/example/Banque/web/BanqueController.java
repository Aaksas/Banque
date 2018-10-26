package com.example.Banque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Banque.Metier.IBanqueMetier;
import com.example.Banque.entities.Compte;
import com.example.Banque.entities.Opération;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping("/operations")
	
	public String index () {
		return "compte";
	}
	
    @RequestMapping("/consultercompte")
	
	public String ConsulterCompte (  String numCompte , Model model,
			@RequestParam(name="page" , defaultValue="0" ) int page ,
			@RequestParam(name="size" , defaultValue="5" ) int size   ) {
    	model.addAttribute("numCompte", numCompte);
    	try {
    		Compte cp =banqueMetier.ConsulterCompte(numCompte);
    		Page<Opération> pageOpération = banqueMetier.listOpération(numCompte, page, size);
    		int[] pages= new int[pageOpération.getTotalPages()];
    		model.addAttribute("pages", pages);
    		model.addAttribute("listOperation" , pageOpération.getContent());
    		model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
    	
		return "compte";
	}
    
    @RequestMapping( value ="/saveoperation" , method=RequestMethod.POST)
     public String saveoperation(Model model , String numCompte , String numCompte2 ,
    		 String typeOperation , double montant ) {
    	
    	try {

        	if ( typeOperation.equals("VERS")) {
        		banqueMetier.verser(numCompte, montant);
        	}
        	else if (typeOperation.equals("RETR")) {
        		banqueMetier.retirer(numCompte, montant);
        	}
        	if (typeOperation.equals("VIR")) {
        		banqueMetier.virement(numCompte, numCompte2, montant);
        	}
			
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consultercompte?numCompte="+numCompte+"&error="+e.getMessage() ;
		}
    	
    	
    	return "redirect:/consultercompte?numCompte="+numCompte ;
    }
     

}
