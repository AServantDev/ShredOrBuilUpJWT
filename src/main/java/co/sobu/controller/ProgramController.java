package co.sobu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sobu.model.ApiResponse;
import co.sobu.model.BuildProgram;
import co.sobu.model.ShredDto;
import co.sobu.model.ShredProgram;
import co.sobu.model.User;
import co.sobu.model.UserDto;
import co.sobu.service.BuildService;
import co.sobu.service.ShredService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/program")
public class ProgramController {
	
	@Autowired
	ShredService shredServ;
	
	@Autowired
	BuildService buildServ;
	
	@PostMapping("/newShred/{id}")
    public ApiResponse<ShredProgram> saveShred(@PathVariable(value="id") int id){
		
        return new ApiResponse<>(HttpStatus.OK.value(), "Shred Program saved successfully.",shredServ.save(id));
    }
	
	@PostMapping("/newBuild/{id}")
    public ApiResponse<BuildProgram> saveBuild(@PathVariable(value="id") int id){
		
        return new ApiResponse<>(HttpStatus.OK.value(), "Build program saved successfully.",buildServ.save(id));
    }
	
	@GetMapping("/getShred/{id}")
	public ResponseEntity<ShredProgram> getShred(@PathVariable(value="id") int id){
		System.out.println(id);
		ShredProgram shred = shredServ.findByIdShred(id);
		if(shred == null)
			 return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(shred);
	}
	
	@GetMapping("/getBuild/{id}")
	public ResponseEntity<BuildProgram> getBuild(@PathVariable(value="id") int id){
		
		BuildProgram build = buildServ.findByIdBuild(id);
		if(build == null)
			 return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(build);
	}
		
	}
	
	

			
