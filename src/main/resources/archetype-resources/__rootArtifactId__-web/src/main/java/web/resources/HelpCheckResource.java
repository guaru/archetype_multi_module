package ${groupId}.web.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import ${groupId}.service.HelpCheckService;

@AllArgsConstructor
@RequestMapping(value = "v1/help-check")
@RestController
public class HelpCheckResource {
	
	private final HelpCheckService helpCheckService;

	@Operation(method = "helpCheck", description = "Help check")
    @GetMapping
    public ResponseEntity<Boolean> helpCheck() {
        return new ResponseEntity<>(this.helpCheckService.helpCheck(), HttpStatus.OK);
     }

}
