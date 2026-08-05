package com.escobar.marketplace.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;




public class UsuarioDAO {
    private static UsuarioDAO instancia;
    private Set<Usuario> bdUsusarios = new HashSet<>();
    public UsuarioDAO(){
        bdUsusarios = new HashSet<>();
        cadastrarUsuario(new Usuario("iago","123"));
    }
    public static UsuarioDAO getInstance(){
        if ( instancia == null){
            instancia = new UsuarioDAO();
        }
        return instancia;
    }
    public Set<Usuario> getBdUsusarios(){
        return bdUsusarios;
    }
    public Optional<Usuario> buscarPorEmail(String email){
        return bdUsusarios.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
    }
    public void cadastrarUsuario(Usuario usuario){
        bdUsusarios.add(usuario);
    }


}
