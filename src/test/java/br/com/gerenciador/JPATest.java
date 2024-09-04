package br.com.gerenciador;

import javax.persistence.Persistence;

public class JPATest {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("gerenciador");
	}
}
