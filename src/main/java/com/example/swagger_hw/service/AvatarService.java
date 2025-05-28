package com.example.swagger_hw.service;

import com.example.swagger_hw.model.Avatar;
import com.example.swagger_hw.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AvatarService {
    private final AvatarRepository avatarRepository;

    Logger logger = Logger.getLogger(AvatarService.class.getName());

    @Autowired
    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public Page<Avatar> findAllAvatars(int page, int size) {
        logger.info("Was invoked method for get avatars");
        Pageable pageable = PageRequest.of(page, size);
        return avatarRepository.findAll(pageable);
    }
}