package com.chan.mybatis_hrd.controller;

import com.chan.mybatis_hrd.model.APIRespone;
import com.chan.mybatis_hrd.model.Author;
import com.chan.mybatis_hrd.model.AuthorRequest;
import com.chan.mybatis_hrd.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
   private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    private APIRespone setAPIResponeAtrribute(String message,Object playload , HttpStatus status){

        APIRespone respone=new APIRespone();
        respone.setMessage(message);
        respone.setTime(LocalDateTime.now());
        respone.setPayload(playload);
        respone.setStatus(status);

        return respone;
    }


   @GetMapping("/all")
    public ResponseEntity<APIRespone>findAllAuthors(){
       System.out.println(authorService.findAllAuthors().isEmpty());
       if(authorService.findAllAuthors().isEmpty()){
          APIRespone respone= setAPIResponeAtrribute("fail to fetch",null,HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(respone,HttpStatus.NOT_FOUND);
       }else {
           APIRespone respone= setAPIResponeAtrribute(
                   "Successfully added authors",
                   authorService.findAllAuthors(),HttpStatus.OK);

           return new ResponseEntity<>(respone,HttpStatus.OK);
       }

    }

    @GetMapping("/find/{id}")
    public Author findAuthorById(@PathVariable int id){
        return authorService.findAuthorById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIRespone> deleteById(@PathVariable int id){

        boolean status=authorService.delteAuthorById(id);
        System.out.println(status);

        if(status){
            APIRespone respone=setAPIResponeAtrribute(
                    "Successfully delete the record",
                     null,HttpStatus.OK
                    );

            return new ResponseEntity<>(respone,HttpStatus.OK);
        }else {
            APIRespone respone=setAPIResponeAtrribute(
                    "fail to delete",
                    null,HttpStatus.NOT_FOUND
            );
            return new ResponseEntity<>(respone,HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIRespone> updateAuthorById(@PathVariable int id,@RequestBody AuthorRequest author){

       int status=authorService.updateAuthor(author,id);
        if(status==1){
         APIRespone respone=   setAPIResponeAtrribute(
                    "Succesfully update author",
                    null,HttpStatus.OK
            );
            return new ResponseEntity<>(respone,HttpStatus.OK);
        }else {
            APIRespone respone=setAPIResponeAtrribute("Fail to update author",
                    null,HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(respone,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<APIRespone> createAuthor(@RequestBody AuthorRequest author){
        int status=authorService.createAuthor(author);
        if(status==1){

            APIRespone respone=setAPIResponeAtrribute("Add author successfully",
                    null,HttpStatus.OK);
            return new ResponseEntity<>(respone,HttpStatus.OK);
        }else {
            APIRespone respone=setAPIResponeAtrribute("Fail to get data",
                    null,HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(respone,HttpStatus.NOT_FOUND);
        }

    }

}
