package de.gie.tool.urltool.alias;

import de.gie.tool.urltool.alias.model.AliasDTO;
import de.gie.tool.urltool.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/alias")
public class AliasController {

    private final AliasService aliasService;

    @Autowired
    public AliasController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @GetMapping
    public ResponseEntity<Object> redirect(@RequestParam String name){
        HttpHeaders httpHeaders = new HttpHeaders();
        String longUrl          = aliasService.getLongUrl(name);


        if (longUrl == null){
            throw new ApiRequestException("No alias for " + name, HttpStatus.NOT_FOUND);
        }

        try {
            URI redirectionURI      = new URI(longUrl);
            httpHeaders.setLocation(redirectionURI);
        } catch (URISyntaxException e) {
            throw new ApiRequestException("Something wrong with URI", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @PostMapping
    public ResponseEntity<AliasDTO> addAliases(@Validated @RequestBody AliasDTO aliasDTO){
        if (!aliasService.add(aliasDTO)){
            throw new ApiRequestException("Alias name (" + aliasDTO.getAliasName() + "), is already taken", HttpStatus.BAD_REQUEST);
        };

        return new ResponseEntity<>(aliasDTO, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Object> runtimeID(){
        return new ResponseEntity<>(aliasService.getRuntimeIdentifier(), HttpStatus.OK);
    }

}
