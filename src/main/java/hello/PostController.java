package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; //  typiquement /posts
import org.springframework.web.bind.annotation.GetMapping; // typiquement /all ---> /post/all
import org.springframework.web.bind.annotation.RequestParam; // pour recuperer les parametres envoye par la requete
import org.springframework.web.bind.annotation.ResponseBody; // pour envoyer la reponse a la requete
import org.springframework.web.bind.annotation.CrossOrigin; // Pour gerer communication entre les serveurs front et back

import hello.Post;
import hello.PostRepository;

@Controller // This clas is a controller
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping(path = "/posts")
public class PostController {
	@Autowired // genere automatiquement les methodes CRUD sur post
	private PostRepository postRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewPost (@RequestParam String title) {
		Post p = new Post();
		p.setTitle(title);
		postRepository.save(p);
		return "Success";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Post> getAllPosts () {
		return postRepository.findAll();
	}
}
