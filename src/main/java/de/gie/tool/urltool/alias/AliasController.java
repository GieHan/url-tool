package de.gie.tool.urltool.alias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        String longUrl  = aliasService.getLongUrl(name);

        if (longUrl != null){
            try {
                URI redirectionURI      = new URI(longUrl);
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setLocation(redirectionURI);
                return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping
    public String addAliases(){
        aliasService.add();
        return "200";
    }
}
