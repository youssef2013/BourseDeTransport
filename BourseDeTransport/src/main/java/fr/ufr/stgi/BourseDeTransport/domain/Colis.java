package fr.ufr.stgi.BourseDeTransport.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double poids;
	private int quantite;
	private String type;
	private int volume;
	private String adresse;

	// Constructeur par défaut
	public Colis() {
	}

	// Constructeur avec params
	public Colis(Long id, double poids, int quantite, String type, int volume, String adresse) {
		this.id = id;
		this.poids = poids;
		this.quantite = quantite;
		this.type = type;
		this.volume = volume;
		this.adresse = adresse;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	//hashCode and equals methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(poids);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantite;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + volume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colis other = (Colis) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(poids) != Double.doubleToLongBits(other.poids))
			return false;
		if (quantite != other.quantite)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}

	// Methode tostring
	@Override
	public String toString() {
		return "Colis [id=" + id + ", poids=" + poids + ", quantite=" + quantite + ", type=" + type + ", volume="
				+ volume + ", adresse=" + adresse + "]";
	}
	
	
}
