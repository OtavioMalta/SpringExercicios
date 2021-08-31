package br.com.exercicio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Tag para criar o getter/setter dos atributos (pacote Lombok)
@Getter 
@Setter
//Tag para criar o construtor p/ passar todos os atributos(pacote Lombok)
@AllArgsConstructor 
//Tag para criar um construtor sem nenhum argumento
@NoArgsConstructor
//Define como uma entidade e suas tabelas
@Entity
@Table(name = "users")
public class User {
  
  //Gera um Id automaticamente
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String username;

}