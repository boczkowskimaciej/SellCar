package service;

import entity.HolderEntity;
import entity.PasswordEntity;
import model.Holder;
import model.Password;
import org.springframework.stereotype.Service;
import repository.PasswordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    private PasswordRepository passwordRepository;

    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

//    public void addIdHolderAndPassword(Long HolderId, String password){
//        passwordRepository.save();
//    }

    public void addPassword(Password password){
        passwordRepository.save(fromModelToEntity(password));

    }
    public PasswordEntity fromModelToEntity(Password password) {
        HolderEntity holderEntity = new HolderEntity();
        return new PasswordEntity(password.getId(), password.getValue(), holderEntity);
    }

    public Password fromEntityToModel(PasswordEntity passwordEntity) {
        Holder holder = new Holder();
        return new Password(passwordEntity.getId(),passwordEntity.getValue(),holder);
    }

//    public List<Password> fromEntityToModel(List<PasswordEntity> passwordEntity){
//        List<Password> returnList = new ArrayList<>();
//        for (int i = 0; i < passwordEntity.size(); i++) {
//            returnList.add(fromEntityToModel(passwordEntity.get(i)));
//        }
//        return returnList;
//    }

    }
