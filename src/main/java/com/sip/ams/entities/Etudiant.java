package com.sip.ams.entities;

public class Etudiant {
private String nom;

private String email;
private int age;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public  Etudiant(
		) {
}
public  Etudiant(String n,String mail,int ag)

		 {
	nom=n;
	email=mail;
	age=ag;
}
}