package br.com.developers.developersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.developers.developersapi.dto.UserDataTransferObject;
import br.com.developers.developersapi.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserControler {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDataTransferObject> save(@Validated @RequestBody UserDataTransferObject userDTO) {
		userService.save(userDTO);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/api/user/find/{identifier}").buildAndExpand(userDTO.getIdentifier()).toUri()).build();
	}

	@GetMapping("/{identifier}")
	public ResponseEntity<UserDataTransferObject> find(@PathVariable(name = "identifier") String identifier) {
		return ResponseEntity.ok(userService.find(identifier));
	}

	@GetMapping("/")
	public ResponseEntity<Page<UserDataTransferObject>> findAll(Pageable pageable) {
		return ResponseEntity.ok(userService.findAll(pageable));
	}

	@DeleteMapping("/{identifier}")
	public ResponseEntity<Void> delete(@PathVariable(name = "identifier") String uuid) {
		userService.delete(uuid);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{identifier}")
	public ResponseEntity<Void> update(@PathVariable(name = "identifier", required = true) String uuid,
			@Validated @RequestBody UserDataTransferObject userDTO) {
		userService.update(uuid, userDTO);
		return ResponseEntity.noContent().build();
	}

}
