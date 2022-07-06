package de.gie.tool.urltool.alias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

/*
    Bussiness logic
 */
@Service
public class AliasService {

    private final AliasRepository aliasRepository;

    @Autowired
    public AliasService(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    public List<Alias> getAliases(){
        return aliasRepository.findAll();
    }

    public boolean add(){
        return false;
    }

    public boolean delete(){
        return false;
    }

    public String getLongUrl(String shortName){
        List<Alias> foundedAliases = aliasRepository.findByAliasName(shortName);
        if (foundedAliases.size() != 1){
            return null;
        }

        return foundedAliases.get(0).getLongUrl();
    }

    public List<Alias> getName(String text){
        List<Alias> foundedAliases = aliasRepository.findByAliasName(text);
        if (foundedAliases.size() != 1){
            return null;
        }
        return foundedAliases;
    }

}
