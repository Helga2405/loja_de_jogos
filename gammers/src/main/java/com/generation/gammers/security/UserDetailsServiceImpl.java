package com.generation.gammers.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.gammers.model.UsuarioG;
import com.generation.gammers.repository.UsuarioRp;





@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRp userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
Optional<UsuarioG> usuario = userRepository.findByUsuario(userName);

usuario.orElseThrow(()-> new UsernameNotFoundException(userName + "Usuario não encontrado"));

return usuario.map(UserDetailsImpl::new).get();

}

}
