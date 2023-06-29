/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<Login,Integer>
{
      Optional<Login> findOneByNombreUsuarioAndPassword(String nombreUsuario, String password);
    Login findByNombreUsuario(String nombreUsuario);
}