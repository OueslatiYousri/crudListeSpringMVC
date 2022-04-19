package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sip.ams.entities.Etudiant;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
	
	public static List <Etudiant> students=new ArrayList<>();
	
    static {
		
		
		
		students.add(new Etudiant("zied","zied@yahoo.fr",21));
		students.add(new Etudiant("ali","ali@gmail.fr",23));
		students.add(new Etudiant("yousri","yousri@yahoo.fr",24));
		
		
	}
	@RequestMapping("/list")
	//@ResponseBody
public String ListeEtudiant(Model model)
{
		
		
		
		
		model.addAttribute("etudiant", students);
		return "etudiant/listetudiant";
}
	@GetMapping("/add")
	public String AddEtudiant(Model m)
	{
		Etudiant e = new Etudiant();
		m.addAttribute("etudiant", e);
		return "etudiant/addEtudiant";
			
			
			
	}
	
	/*@PostMapping("/add")
	
	public String saveEtudiant(@RequestParam("nom") String nom,@RequestParam("email") String email,@RequestParam("age") int age)
	{
			
			
			Etudiant e=new Etudiant(nom,email,age);
			students.add(e);
			return "redirect:list";
	}*/
	@PostMapping("/add")
	//@ResponseBody
	//public String saveEtudiant(@RequestParam("nom") String nom,@RequestParam("email") String email,@RequestParam("age") int age)
	public String saveEtudiant(Etudiant etudiant)
	{	
		//return "etudiant/saveEtudiant";
		Etudiant e = new Etudiant(etudiant.getNom(),etudiant.getEmail(),etudiant.getAge());
		//return nom +" "+email +" "+age;
		students.add(e);
		return "redirect:list";
		
	}
	
	@GetMapping("/delete/{email}")
	//@ResponseBody
	public String deleteEtudiant(@PathVariable("email") String mail)
	{	
		int index = 0;
		
		for(int i=0; i<students.size(); i++)
		{
			if(students.get(i).getEmail().equals(mail))
			{
				index = i;
				break;
			}
		}
		
		students.remove(index);
		//System.out.println(students);
		
		
		return "redirect:../list";
	}
	@GetMapping("/affiche/{email}")
	//@ResponseBody
	public String GetemailForUpdate(@PathVariable("email") String mail,Model m )
	{	
		int index = 0;
		
		for(int i=0; i<students.size(); i++)
		{
			if(students.get(i).getEmail().equals(mail))
			{
				index = i;
				break;
			}
		}
		
		
		System.out.println(students);
		Etudiant e = new Etudiant(students.get(index).getNom(),students.get(index).getEmail(),students.get(index).getAge());
		
		
		m.addAttribute("etudiant", e);
		students.remove(index);
		return "etudiant/updateEtudiant";
	}

	@PostMapping("/update")
	//@ResponseBody
	//public String saveEtudiant(@RequestParam("nom") String nom,@RequestParam("email") String email,@RequestParam("age") int age)
	public String updateEtudiant(Etudiant etudiant)
	{	
		//return "etudiant/saveEtudiant";
		Etudiant e = new Etudiant(etudiant.getNom(),etudiant.getEmail(),etudiant.getAge());
		//return nom +" "+email +" "+age;
		students.add(e);
		return "redirect:list";
		
	}
	
}
