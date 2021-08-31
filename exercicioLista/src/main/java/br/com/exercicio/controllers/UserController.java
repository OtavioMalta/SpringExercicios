// Controllers é por onde o browser, insomnia, etc acessam a aplicação
package br.com.exercicio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicio.model.User;
import br.com.exercicio.repository.UserRepository;

@RestController // Torna a classe um Rest (pacote Spring Web) artigo: encurtador.com.br/pqFHQ
@RequestMapping("/users") // Toda vez que é acessado o Path '/users' será redirecionado para esse controller
public class UserController {

    @Autowired // Faz a 'injeção' da interface UserRepository (OBS: já que interfaces não podem ser implementadas)
    private UserRepository userRepository;

    @GetMapping("/{id}") // Funciona como o RequestMapping (pacote Spring Web); {id} pega o parâmetro id do objeto na lista
    public User user(@PathVariable("id") Long id) { // PathVariable diz que o parâmetro é uma variável que será usada como Path
/*
        System.out.println("O id é " + id);

        //Usa uma função stream, no caso filter, para encontrar um usuário com o mesmo id passado na URL, pegando apenas o primeiro que achar 
        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        
        //isPresent trabalha junto com o Optional
        if(userFind.isPresent()){ //Se userFind achar algo, traz a partir do get
            return userFind.get();
        }else{
            return null;
        }
                            OU
        */
        Optional<User> userFind = this.userRepository.findById(id);

        if(userFind.isPresent()){
            return userFind.get();
        }else{
            return null;
        }
    }

    @PostMapping("/")
    public User user(@RequestBody User user) { // Recebe um User pelo Body
        return this.userRepository.save(user);
        //users.add(user); //Adiciona o usuário na lista users, por enquanto usando o Insomnia
    }

    @GetMapping("/list") // Toda vez que é acessado o Path '/list' será redirecionado para o método list()
    public List<User> list(){ // Cria o método list
        return this.userRepository.findAll(); // Retorna a lista de usuário
    }

    @GetMapping("/list/{id}") 
    public List<User> listMT(@PathVariable("id") Long id){ 
        return this.userRepository.findByIdGreaterThan(id); 
    }

    @GetMapping("/findByName/{name}") 
    public List<User> findByName(@PathVariable("name") String name){ 
        return this.userRepository.findByNameIgnoreCase(name); 
    }
}
