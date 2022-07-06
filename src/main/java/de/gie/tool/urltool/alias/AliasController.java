package de.gie.tool.urltool.alias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Alias> getAliases(){
        return aliasService.getAliases();
    }

    @PostMapping
    public String addAliases(){
        aliasService.add();
        return "200";
    }
}
