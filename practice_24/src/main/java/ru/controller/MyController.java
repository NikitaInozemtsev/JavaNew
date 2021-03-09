package ru.controller;



import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.model.Item;
import ru.model.Order;
import ru.extraservices.EmailService;
import ru.model.User;
import ru.services.ItemService;
import ru.services.OrderService;
import ru.services.UserService;

import java.util.List;


@Controller
@AllArgsConstructor
public class MyController {

    @Autowired
    private EmailService m;

    @Autowired
    private ItemService a;

    @Autowired
    private OrderService b;

    @Autowired
    private UserService u;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(User user) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    String signUp(@ModelAttribute User user) {
        u.signUpUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "test";
    }

    @RequestMapping(value = "/home/createitem", method = RequestMethod.POST)
    @ResponseBody
    public void createItem(@RequestBody Item w) {
        m.sendEmailItem(w);
        a.insertItem(w);
    }

    @RequestMapping(value = "/home/createorder", method = RequestMethod.POST)
    @ResponseBody
    public void createOrder(@RequestBody Order w) {
        m.sendEmailOrder(w);
        b.insertOrder(w);
    }

    @RequestMapping(value = "/home/deleteitem", method = RequestMethod.POST)
    @ResponseBody
    public void delItem(@RequestBody Item w) {
        a.deleteItem(w);
    }

    @RequestMapping(value = "/home/deleteorder", method = RequestMethod.POST)
    @ResponseBody
    public void delOrder(@RequestBody Order w) {
        b.deleteOrder(w);
    }

    @RequestMapping(value = "/home/outitem", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> outItem() {
        return new ResponseEntity<List<Item>> (a.getItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/outorder", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> outOrder() {
        return new ResponseEntity<List<Order>> (b.getOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "home/order/{orderDate}/item", method = RequestMethod.GET)
    @ResponseBody
    public Item getOrderItem(@PathVariable("orderDate") String orderDate) {
        return b.getItemsByOrder(orderDate);
    }

    @RequestMapping(value = "/home/outitem/orderbyname", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> orderByName() {
        return new ResponseEntity<List<Item>>(a.orderByName() , HttpStatus.OK);
    }

    @RequestMapping(value = "/home/outitem/orderbydate", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> orderByDate() {
        return new ResponseEntity<List<Item>>(a.orderByDate() , HttpStatus.OK);
    }

    @RequestMapping(value = "/home/outitem/orderbyprice", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> orderByPrice() {
        return new ResponseEntity<List<Item>>(a.orderByPrice() , HttpStatus.OK);
    }

    @RequestMapping(value = "/home/outorder/orderbydate", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> orderByOrderDate() {
        return new ResponseEntity<List<Order>>(b.orderByOrderDate(), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/outorder/orderbyname", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> orderByItemName() {
        return new ResponseEntity<List<Order>>(b.orderByItemName(), HttpStatus.OK);
    }

}