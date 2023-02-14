package com.backend.ernesto.repository;

import com.portfolio.SpringBoot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
    La anotación Spring @Repository se usa para indicar que la clase proporciona el mecanismo
    para las operaciones de: almacenamiento, recuperación, búsqueda, actualización y 
    eliminación de objetos.
*/
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    /*
        extends JpaRepository para heredar los métodos JPA y debemos poner entre "<>" la clase a 
        persistir, en éste caso "Persona" y el tipo de dato del Id de dicha clase.
    */
    
}

/*
La capa Repository maneja la conexión a la base de datos
*/
