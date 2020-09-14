package com.lxk.springjpa.jpa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Person的jpa操作")
@RequestMapping("person")
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @ApiOperation(value = "save",notes = "tttt")
    @PostMapping("/save")
    public Person save(@RequestBody Person person) {

        Person person1 = personRepository.save(person);
        return person1;
    }
    @ApiOperation(value = "findByAddress")
    @PostMapping("/findByAddress")
    public List<Person> q1(@RequestParam("address") String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }
    @ApiOperation(value = "/findByNameAndAddress")
    @PostMapping("/findByNameAndAddress")
    public Person q2(@RequestParam("name") String name,@RequestParam("address") String address) {
        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }
    @ApiOperation(value = "/withNameAndAddressQuery")
    @PostMapping("/withNameAndAddressQuery")
    public Person q3(@RequestParam("name") String name,@RequestParam("address") String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }
    @ApiOperation(value = "/withNameAndAddressNamedQuery")
    @PostMapping("/withNameAndAddressNamedQuery")
    public Person q4(@RequestParam("name") String name, @RequestParam("address") String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }

    @ApiOperation(value = "/all")
    @PostMapping("/all")
    public List<Person> all(){
        return personRepository.findAll();
    }

    @ApiOperation(value = "/deleteById")
    @PostMapping("/deleteById")
    public void deleteById(@RequestParam("id") Long id){
        personRepository.deleteById(id);
    }


//    @RequestMapping("/sort")
//    public List<Person> sort() {
//        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
//        return people;
//    }
//    @RequestMapping("/page")
//    public Page<Person> page(int page,int size){
//        Page<Person> all = personRepository.findAll(new PageRequest(page, size));
//        return all;
//    }

}
