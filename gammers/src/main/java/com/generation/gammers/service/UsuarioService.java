package com.generation.gammers.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import com.generation.gammers.model.UsuarioG;
import com.generation.gammers.model.UsuarioGLogin;
import com.generation.gammers.repository.UsuarioRp;




@Service
public class UsuarioService {

	@Autowired
	private UsuarioRp repository;
	
	public Optional<UsuarioG>cadastraUsuario(UsuarioG usuario){
		
		if(repository.findByUsuario(usuario.getUsuario()).isPresent())
		
              return Optional.empty();
		
              usuario.setSenha(criptografarSenha(usuario.getSenha()));
              return Optional.of(repository.save(usuario));

		
	}
	private String criptografarSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senha);
	}
    public Optional<UsuarioGLogin> autenticaUsuario(Optional<UsuarioGLogin> usuarioLogin){
    	Optional<UsuarioG> usuario = repository.findByUsuario(usuarioLogin.get().getUsuario());

    	if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setFoto(usuario.get().getFoto());
				usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
				usuarioLogin.get().setSenha(usuario.get().getSenha());

				return usuarioLogin;
			}
}
    	
    	
    	return Optional.empty();
		
    
		
		

	}
private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(senhaDigitada, senhaBanco);

	}
private String gerarBasicToken(String usuario, String senha) {

	String token = usuario + ":" + senha;
	byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
	return "Basic " + new String(tokenBase64);

}
}
