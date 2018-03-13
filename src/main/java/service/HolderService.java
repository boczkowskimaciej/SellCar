package service;

import entity.HolderEntity;
import model.Holder;
import org.springframework.stereotype.Service;
import repository.HolderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HolderService {

    private HolderRepository holderRepository;

    public HolderService(HolderRepository holderRepository) {
        this.holderRepository = holderRepository;
    }

    public void addHolder(Holder holder){
        holderRepository.save(fromModelToEntity(holder));
    }

    public HolderEntity fromModelToEntity(Holder holder) {
        return new HolderEntity(holder.getId(),holder.getName(),holder.getSurname()
                ,holder.getPhone(), holder.getEmail());
    }

    public Holder fromEntityToModel(HolderEntity holderEntity){
        return new Holder(holderEntity.getId(),holderEntity.getName(),holderEntity.getSurname()
        ,holderEntity.getPhone(),holderEntity.getEmail());
    }

    public List<Holder> fromEntityToModel(List<HolderEntity> holderEntity){
        List<Holder> returnList = new ArrayList<>();
        for (int i = 0; i < holderEntity.size(); i++) {
            returnList.add(fromEntityToModel(holderEntity.get(i)));
        }
        return returnList;
    }

    }
