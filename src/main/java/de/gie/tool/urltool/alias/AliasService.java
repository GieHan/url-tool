package de.gie.tool.urltool.alias;

import de.gie.tool.urltool.alias.model.Alias;
import de.gie.tool.urltool.alias.model.AliasDTO;
import de.gie.tool.urltool.alias.model.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void add(AliasDTO aliasDTO){
        Alias newAlias = new Alias(aliasDTO.getLongUrl(), aliasDTO.getAliasName(), aliasDTO.getDuration());
        aliasRepository.save(newAlias);
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
