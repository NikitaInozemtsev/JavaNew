package ru.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.model.Item;
import ru.model.Order;
import ru.services.ItemService;
import ru.services.OrderService;

import java.util.List;


@Controller
public class MyController {

    @Autowired
    private ItemService a;

    @Autowired
    private OrderService b;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "test.html";
    }

    @RequestMapping(value = "/home/createitem", method = RequestMethod.POST)
    @ResponseBody
    public void createItem(@RequestBody Item w) {
        a.insertItem(w);
    }

    @RequestMapping(value = "/home/createorder", method = RequestMethod.POST)
    @ResponseBody
    public void createOrder(@RequestBody Order w) {
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



}