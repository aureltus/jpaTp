package co.simplon.tpjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class DossierAdministration {
	private String tuteurNom;
	private String tuteurEmail;
	@ManyToOne
	private Apprenant apprenant;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

}
