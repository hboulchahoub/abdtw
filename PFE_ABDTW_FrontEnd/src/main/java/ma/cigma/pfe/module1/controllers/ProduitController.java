package ma.cigma.pfe.module1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.cigma.pfe.module1.models.ProduitDTO;

@Controller
@RequestMapping("/ps")
public class ProduitController {
	
	@Value("${url.backend.api}")
	private String urlBackendAPI;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/list")
	public String consulterTousLesProduits(Model m,@ModelAttribute("produit") ProduitDTO p)
	{
		String url_all_products = urlBackendAPI+"/produits/all";
		List<ProduitDTO> list = restTemplate.getForObject(url_all_products, List.class);
		
		if (p==null) {
			m.addAttribute("produit",new ProduitDTO());
		}else {
			m.addAttribute("produit",p);
		}
		
		m.addAttribute("l", list);
		return "index"; 
	}
	
	@RequestMapping(path="/crud",params="add")
	public String add(Model m,@ModelAttribute("produit") ProduitDTO prd)
	{
		String url_add= urlBackendAPI+"/produits/create";
		restTemplate.postForObject(url_add, prd, ProduitDTO.class);
		return "redirect:/ps/list";
	}
	
	@RequestMapping(path="/crud",params="update")
	public String update(Model m,@ModelAttribute("produit") ProduitDTO p,RedirectAttributes ra)
	{
		String url_update= urlBackendAPI+"/produits/update";
		restTemplate.put(url_update, p);
		ra.addFlashAttribute("produit", p);
		return "redirect:/ps/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String supprimerProduit(@PathVariable("id") int id ) {
		String url_delete=urlBackendAPI+"/produits/"+id;
		restTemplate.delete(url_delete);
		return "redirect:/ps/list";
	}
	
	@RequestMapping("/load/{id}")
	public String loadProduit(@PathVariable("id") int id, RedirectAttributes ra) {
		String url_one=urlBackendAPI+"/produits/"+id;
		ProduitDTO p = restTemplate.getForObject(url_one,ProduitDTO.class);
		ra.addFlashAttribute("produit", p);
		return "redirect:/ps/list";
	}

}
