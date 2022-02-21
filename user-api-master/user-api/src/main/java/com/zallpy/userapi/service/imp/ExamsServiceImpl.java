package com.zallpy.userapi.service.imp;

import com.zallpy.userapi.dto.request.ExamsDTO;
import com.zallpy.userapi.dto.response.ExamsFindByRg;
import com.zallpy.userapi.dto.response.ExamsRelat;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.ExamsEntity;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.ExamsRepository;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.utils.Interface.Mappable;
import exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExamsServiceImpl implements Mappable {

    ExamsRepository examsRepository;
    UserRepository userRepository;

    public List<ExamsRelat> getAll() {
        return examsRepository.findAllDTO();
    }

    public MessageResponseDTO create(ExamsDTO examsDTO) {
        ExamsEntity createExamsEntity = map(examsDTO, ExamsEntity.class);
        UserEntity userEntity = userRepository.findById(examsDTO.getUserId()).get();
        if (Objects.nonNull(userEntity)) {
            createExamsEntity.setUserEntity(userEntity);
            ExamsEntity createform = examsRepository.save(createExamsEntity);
            return createMessageResponse(map(createform, ExamsDTO.class).getExamName()
                    , "Registered exam----");
        } else {
            throw new UserNotFoundException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public void delete(Long id)  {
        verifyIfExists(id);
        examsRepository.deleteById(id);
    }

    public MessageResponseDTO updatebyId(Long id, ExamsDTO examsDTO) {
        verifyIfExists(id);
        ExamsEntity createExamsEntity = map(examsDTO, ExamsEntity.class);
        UserEntity userEntity = userRepository.findById(examsDTO.getUserId()).get();
        if (Objects.nonNull(userEntity)) {
            createExamsEntity.setUserEntity(userEntity);
            ExamsEntity createform = examsRepository.save(createExamsEntity);
            return createMessageResponse(map(createform, ExamsDTO.class).getExamName()
                    , "Exam update---");
        } else {
            throw new UserNotFoundException(HttpStatus.NOT_FOUND, "User not found");
        }

    }


    public ExamsEntity verifyIfExists(Long id) throws UserNotFoundException {
        return examsRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND, "ID NOT FOUND"));
    }

    private MessageResponseDTO createMessageResponse(String id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();

    }

    public List<ExamsFindByRg> findByRg(String rg) {

        return examsRepository.examsFindByRg(rg);
    }
}
