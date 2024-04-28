package application;

public class Personne {
	private String prenom;
	private String nom;
	private String email;
	
	
	Personne(String prenom,String nom, String email){
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setEmail(email);
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", email=" + email + "]";
	}
	
	
	
	

}
