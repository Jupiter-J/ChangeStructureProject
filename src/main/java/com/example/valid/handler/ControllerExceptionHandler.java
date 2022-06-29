package com.example.valid.handler;

import com.example.valid.response.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@RestController()
@Slf4j
public class ControllerExceptionHandler {


        @ExceptionHandler({
                NoSuchElementException.class,
                MissingServletRequestParameterException.class
        })
        public ResponseModel parameterError(HttpServletRequest request, HttpServletResponse response){
            ResponseModel responseModel = ResponseModel.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message("요청에 필요한 파라미터가 비어있거나 적절하지 않습니다.")
                    .build();
            response.setStatus(400);
            return responseModel;
        }


        @ExceptionHandler(Exception.class)
        public ResponseModel unExceptedError(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error(e.toString());
        e.printStackTrace();
        response.setStatus(500);
        return ResponseModel.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("서버 오류입니다. 관리자에게 문의하세요")
                .build();
    }


}
