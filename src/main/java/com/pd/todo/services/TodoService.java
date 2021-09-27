/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pd.todo.services;

import com.pd.todo.dto.ResponseDTO;
import com.pd.todo.entity.TodoEntity;
import com.pd.todo.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amelia Chairunnisa
 */
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    ResponseDTO responseDTO;

    public ResponseDTO findAll() {
        try {
            responseDTO = responseDTO.defaultResponse();
            List data = todoRepository.findAll();
            if (data.size() == 0) {
                responseDTO = responseDTO.noDataFoundResponse();
            }
            responseDTO.setData(data);
            return responseDTO;

        } catch (Exception e) {
            return responseDTO.failedResponse("500", e.getMessage());

        }
    }

    public ResponseDTO findOneById(Long id) {
        try {
            responseDTO = responseDTO.defaultResponse(id);
            TodoEntity data = todoRepository.findById(id).get();
            if (data == null) {
                responseDTO = responseDTO.noDataFoundResponse();
            }
            List listData = new ArrayList();
            listData.add(data);
            responseDTO.setData(listData);

            return responseDTO;
        } catch (Exception e) {
            return responseDTO.failedResponse("500", e.getMessage());
        }
    }

    public ResponseDTO post(TodoEntity entity) {
        try {
            responseDTO = responseDTO.defaultResponse();
            TodoEntity data = todoRepository.save(entity);
            List listData = new ArrayList();
            listData.add(data);
            responseDTO.setData(listData);

            return responseDTO;
        } catch (Exception e) {
            return responseDTO.failedResponse("500", e.getMessage());
        }
    }

    public ResponseDTO deleteOne(Long id) {
        try {
            responseDTO = responseDTO.defaultResponse();
            todoRepository.delete(todoRepository.findById(id).get());

            return responseDTO;
        } catch (Exception e) {
            return responseDTO.failedResponse("500", e.getMessage());
        }
    }
}
