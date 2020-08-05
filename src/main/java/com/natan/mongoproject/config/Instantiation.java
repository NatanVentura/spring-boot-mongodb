package com.natan.mongoproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.natan.mongoproject.domain.Post;
import com.natan.mongoproject.domain.User;
import com.natan.mongoproject.dto.AuthorDTO;
import com.natan.mongoproject.repository.PostRepository;
import com.natan.mongoproject.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("03/08/2020"),"Agua coca latao", "Mery mery pra gringo é mais caro",new AuthorDTO(bob));
		Post post2 = new Post(null, sdf.parse("02/08/2020"),"Sensata", "Essa Manu pisa nesses machos escrotos",new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().add(post2);
		bob.getPosts().add(post1);
		userRepository.saveAll(Arrays.asList(maria,bob));
		
	}
	
}
