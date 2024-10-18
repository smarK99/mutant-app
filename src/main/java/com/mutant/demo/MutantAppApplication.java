package com.mutant.demo;

import com.mutant.demo.entities.Humano;
import com.mutant.demo.services.HumanoServiceImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MutantAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(MutantAppApplication.class);

	@Autowired
	private HumanoServiceImpl humanoServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(MutantAppApplication.class, args);
	}

	//Separo responsabilidades con el main
	@Bean
	@Transactional
	CommandLineRunner init(HumanoServiceImpl humanoServiceImpl){
		return args -> {
			//Creo algunos humanos
			Humano h1 = Humano.builder()
					.dna(List.of("ACGTA", "CATAC", "CTAAC", "TAGAC", "AAACA"))
					.isMutant(false)
					.build();
			Humano h2 = Humano.builder()
					.dna(List.of("ACG", "CAT", "CAG"))
					.isMutant(false)
					.build();
			Humano h3 = Humano.builder()
					.dna(List.of("ACG", "CGT", "CTG", "TAG"))
					.isMutant(false)
					.build();
			Humano h4 = Humano.builder()
					.dna(List.of("ACGA", "CGTA", "CTGA", "TAGA"))
					.isMutant(false)
					.build();
			Humano h5 = Humano.builder()
					.dna(List.of("ACGG", "CCTA", "CCGA", "TCGT"))
					.isMutant(false)
					.build();
			Humano h6 = Humano.builder()
					.dna(List.of("ACGT", "GGGG", "CTGA", "TAGC"))
					.isMutant(false)
					.build();
			Humano h7 = Humano.builder()
					.dna(List.of("ACGTC", "GGTTG", "CTGTT", "TAGTA", "AAATG"))
					.isMutant(false)
					.build();
			Humano h8 = Humano.builder()
					.dna(List.of("AGT"))
					.isMutant(false)
					.build();
			Humano h9 = Humano.builder()
					.dna(List.of("AGT","GCT","A"))
					.isMutant(false)
					.build();

			humanoServiceImpl.saveAndCheck(h1);
			humanoServiceImpl.saveAndCheck(h2);
			humanoServiceImpl.saveAndCheck(h3);
			humanoServiceImpl.saveAndCheck(h4);
			humanoServiceImpl.saveAndCheck(h5);
			humanoServiceImpl.saveAndCheck(h6);
			humanoServiceImpl.saveAndCheck(h7);
			humanoServiceImpl.saveAndCheck(h8);
			humanoServiceImpl.saveAndCheck(h9);

		};
	};
}
