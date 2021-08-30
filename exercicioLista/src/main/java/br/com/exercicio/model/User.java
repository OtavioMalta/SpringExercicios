package br.com.exercicio.model;

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
public class User {

  private Long id;
  private String name;
  private String username;

}