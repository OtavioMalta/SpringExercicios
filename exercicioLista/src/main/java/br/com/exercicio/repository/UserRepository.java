package br.com.exercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exercicio.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
    /*
    @Query("SELECT u from User u where u.id > :id")
    public List<User> findAllMT(@Param("id") Long id);

                OU
    */ 

    public List<User> findByIdGreaterThan(Long id); //Devolve uma lista de <User> que tiver o id maior que o passado como parâmetro

    public List<User> findByNameIgnoreCase(String name); //Devolve uma lista de <User> com o nome igual ao passado como parâmetro(ignorando maiúsculas e minúsculas)
}
